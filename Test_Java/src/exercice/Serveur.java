import java.io.*;  
import java.net.*;  
import java.util.*;  

public class Serveur {  

	    public static void main(String[] args) {  
	        System.out.println("Chat Server is running...");  
	        try (ServerSocket serverSocket = new ServerSocket(12345)) {  
	        	Socket s = serverSocket.accept();
	            while (true) {  
	                new MThread(s).start();  
	            }  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }  


	}