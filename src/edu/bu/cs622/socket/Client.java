package edu.bu.cs622.socket;

import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.net.ServerSocket; 
import java.net.Socket; 
public class Client { 
	public static void main(String[] args) { 
		 try {
			 Socket s = new Socket("localhost", 9000); 
			 DataOutputStream dout = new DataOutputStream(s.getOutputStream()); 
			 dout.writeUTF("Hello 4m Client"); 
			 dout.close(); 
			 dout.flush(); 
			 s.close(); 
		 } catch (IOException ex) { 
			 System.out.println("[Client] Error:" + ex.getMessage()); 
			 ex.printStackTrace(); 
		 } 
	} 
} 