
package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;


public class Client {
	
	
	public static void writetoClient() throws UnknownHostException, IOException {
		Socket s = new Socket("10.196.230.206",888);
		//1.send msg to server
		//read from console 
		System.out.println("enter mesg to pass to server");
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		String str = br.readLine();
		System.out.println(str);
		
		//write to socket
		OutputStream os = s.getOutputStream();
		PrintStream pr = new PrintStream(os);
		pr.println(str);
		
		//read from server
		InputStream ir1 = s.getInputStream();

		InputStreamReader isr = new InputStreamReader(ir1);
		BufferedReader br1 = new BufferedReader(isr);
		String msg = br1.readLine();

		// write to console
		System.out.println("msg received from client " + msg);
		
		
		
		s.close();
		
		
		
	}
	
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		writetoClient();
		//readFromConsole();
		
	}

}
