import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Hilo extends Thread {
    private final int id;
    private final int inicio;
    private final int fin;
    private final int tiempoInactivoMaximo;
    private final List<Integer> valoresGenerados;
    public static int contador;

    public Hilo(int id, int inicio, int fin, int tiempoInactivoMaximo) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
        this.tiempoInactivoMaximo = tiempoInactivoMaximo;
        this.valoresGenerados = new ArrayList<>();
    }

    int posicion;

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {

                int valorGenerado = generarValor();
                agregarValor(valorGenerado);

                for (int j = 0; j < array.length; j++) {
                    if (array[j] == 0) {
                        posicion = j;
                        break;
                    }
                }
                System.out.println("Hilo " + id + " activo, genera valor " + valorGenerado +
                        " y lo almacena en la posición " + posicion);
                contador++;

                TimeUnit.MILLISECONDS.sleep(tiempoInactivo());
                System.out.println("Hilo " + id + " inactivo");
            } catch (InterruptedException e) {
                System.out.println("Hilo " + id + " interrumpido");
                return;
            }
        }
        System.out.println("Hilo " + id + " cerrado");
    }

    private int generarValor() {
        Random random = new Random();
        return random.nextInt(fin - inicio + 1) + inicio;
    }

    static int tiempoTotal;

    private int tiempoInactivo() {
        Random random = new Random();
        tiempoTotal = tiempoTotal + random.nextInt(tiempoInactivoMaximo);
        return random.nextInt(tiempoInactivoMaximo);
    }

    static int array[] = new int[30];

    public void agregarValor(int valor) {
        try {
            valoresGenerados.add(valor);
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    array[i] = valor;
                    break;
                }
            }

        } finally {
        }
    }

    public List<Integer> getValoresGenerados() {
        return valoresGenerados;
    }

    public Integer get(int i) {
        return valoresGenerados.get(i);
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Hilo hilo1 = new Hilo(1, 1, 20, 500);
        Hilo hilo2 = new Hilo(2, 50, 100, 1000);
        Hilo hilo3 = new Hilo(3, 150, 300, 2000);
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo1.join();
        hilo2.join();
        hilo3.join();
        System.out.println("Arreglo");
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + "  ");
        }
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "--");
        }
        System.out.println();
        System.out.println("Tiempo total de inactividad: ");
        System.out.println(tiempoTotal);
    }
}
