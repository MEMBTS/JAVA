import java.io.*;  
import java.net.*;  

public class Client {  
	private static PrintWriter out;  
    private static BufferedReader in;  

    public static void main(String[] args) {  
        try (Socket socket = new Socket("localhost", 12345)) {  
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
            out = new PrintWriter(socket.getOutputStream(), true);  
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));  

          
            new Thread(new IncomingReader()).start();  

            String userInput;  
            while ((userInput = stdIn.readLine()) != null) {  
                out.println(userInput);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  

    private static class IncomingReader implements Runnable {  
        @Override  
        public void run() {  
            try {  
                String serverMessage;  
                while ((serverMessage = in.readLine()) != null) {  
                    System.out.println(serverMessage);  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
	}  