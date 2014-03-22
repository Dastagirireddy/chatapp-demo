import java.net.*;
import java.io.*;
public class SimpleClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		
		// Open your connection to a server, at port 1254
		Socket s1 = new Socket("192.168.1.7",8040);
		// Get an input file handle from the socket and read the input
		InputStream s1In = s1.getInputStream();
		DataInputStream dis = new DataInputStream(s1In);
		String st = new String (dis.readUTF());
		System.out.println(st);
		OutputStream s1out = s1.getOutputStream();	
		DataOutputStream dos = new DataOutputStream (s1out);
		dos.writeUTF("Client:Hello Server");
		// When done, just close the connection and exit
		dis.close();
		s1In.close();
		dos.close();
		s1out.close();
		s1.close();
	}

}
