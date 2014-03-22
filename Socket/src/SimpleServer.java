import java.net.*;
import java.io.*;
public class SimpleServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Register service on port 1254
		ServerSocket s = new ServerSocket(8070);
		Socket s1=s.accept(); // Wait and accept a connection
		// Get a communication stream associated with the socket
		OutputStream s1out = s1.getOutputStream();	
		DataOutputStream dos = new DataOutputStream (s1out);
		// Send a string!
		//String str=JOptionPane.showInputDialog("Enter the text");
		dos.writeUTF("Server:Hello Client");
		//dos.writeUTF(str);
		// Close the connection, but not the server socket
		InputStream in=s1.getInputStream();
		DataInputStream instr = new DataInputStream(in);
		String st2 = new String (instr.readUTF());
		System.out.println(st2);
		dos.close();
		s1out.close();
		s1.close();
		instr.close();
		in.close();
		s.close();
	}

}
