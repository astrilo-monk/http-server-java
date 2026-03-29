import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    private final int port;

    public Server(int port){
        this.port = port;
    }

    public void start() throws IOException{
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port "+port);

        while(true){
            Socket clienSocket = serverSocket.accept();
            System.out.println("Connection accepted from: "+clienSocket.getInetAddress());
            clienSocket.close();
        }
    }
}

