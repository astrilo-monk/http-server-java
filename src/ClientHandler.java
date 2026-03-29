import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private final Socket socket; 

    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override

    public void run() {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
            StringBuilder rawRequest = new StringBuilder();
            String line;

            while((line = reader.readLine()) != null && !line.isEmpty()){
                rawRequest.append(line).append("\n");
            }

            System.out.println("---RAW HTTP REQUEST---");
            System.out.println(rawRequest.toString());

            socket.close();
        }catch (Exception e) {
            System.err.println("Error handling client: "+e.getMessage());
        }
    }
}
