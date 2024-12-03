package exercice;

import java.io.*;
import java.net.*;

public class MThread extends  Thread{
	private Socket socket;  
    private PrintWriter out;  
    private String username;  

    public MThread(Socket socket) {  
        this.socket = socket;  
    }  
	public void run() {
		while(true) {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				 out = new PrintWriter(socket.getOutputStream(), true);  
                out.println("Enter username: ");  
                username = in.readLine(); 
                while (in.readLine() != null) {
                out.println("ecrire un message :");
               String  message = in.readLine();
               out.println(username +" dit : "+message);
                }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		}
