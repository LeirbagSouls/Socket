import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
public class TCPServidorHolaMundo {
    public static void main(String[] args) {
        byte[] Mensaje = new byte[80];
        InputStream FlujoDeEntrada;
        DataInputStream Flujo;
        try{
            ServerSocket SocketServidor = new ServerSocket(8000);
            Socket ComunicaConCliente = SocketServidor.accept();
            System.out.println("Comunicacion Establecida0");
            FlujoDeEntrada = ComunicaConCliente.getInputStream();
            Flujo = new DataInputStream(FlujoDeEntrada);
            int bytesleidos = Flujo.read(Mensaje);
            System.out.println(new String(Mensaje));
            ComunicaConCliente.close();
            SocketServidor.close();
        }catch (IOException e) {
            System.out.println("Error en las comunicaciones");
            System.exit(0);
        }catch (SecurityException e) {
            System.out.println("Comunicacion no permitida por razones de seguridad");
            System.exit(0);
        }
    }
}