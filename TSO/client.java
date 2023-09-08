import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        String host = "localhost"; // Dirección IP o nombre de host del servidor
        int puerto = 5; // Puerto del servidor

        try {
            // Crear un objeto Socket para establecer la conexión
            Socket socket = new Socket(host, puerto);

            // Obtener referencias al stream de entrada y al de salida del socket
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            // Realizar operaciones de lectura y escritura en los streams
            // Aquí deberías implementar la lógica específica del protocolo del servicio

            // Cerrar los streams
            outputStream.close();
            inputStream.close();

            // Cerrar el socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
