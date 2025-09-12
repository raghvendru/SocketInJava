package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

	public static Socket getConnection() throws IOException {
		ServerSocket ss = new ServerSocket(888);
		Socket s = ss.accept();
		System.out.println("Got connection from client to server");
		return s;

	}

	public static void receiveFromClient() throws IOException {

		Socket s = getConnection();
		// receive message from client
		// read from socket
		InputStream ir = s.getInputStream();

		InputStreamReader isr = new InputStreamReader(ir);
		BufferedReader br = new BufferedReader(isr);
		String msg = br.readLine();

		// write to console
		System.out.println("msg received from client " + msg);
		
		//write to client
		System.out.println("enter mesg to pass to client");
		InputStreamReader ir1 = new InputStreamReader(System.in);
		BufferedReader br1 = new BufferedReader(ir1);
		String str = br1.readLine();
		System.out.println(str);
		
		//write to socket
		OutputStream os = s.getOutputStream();
		PrintStream pr = new PrintStream(os);
		pr.println(str);

		s.close();
		// ss.close();
		
		
		
	}

	
	

	public static void main(String[] args) throws IOException {
		receiveFromClient();
		//writeToClient();

	}

}
