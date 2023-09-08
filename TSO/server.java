import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) {
        int puerto = 5; // Puerto del servidor

        try {
            // Crear un objeto ServerSocket para escuchar peticiones en el puerto asignado
            ServerSocket serverSocket = new ServerSocket(puerto);

            while (true) {
                // Esperar solicitudes de clientes
                System.out.println("Esperando conexión...");

                // Aceptar la conexión y obtener un objeto Socket
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado.");

                // Obtener referencias al stream de entrada y al de salida del socket
                OutputStream outputStream = socket.getOutputStream();
                InputStream inputStream = socket.getInputStream();

                // Realizar operaciones de lectura, procesamiento y escritura en los streams
                // Aquí deberías implementar la lógica específica del protocolo del servicio

                // Cerrar los streams
                outputStream.close();
                inputStream.close();

                // Cerrar el socket
                socket.close();
                System.out.println("Cliente desconectado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
