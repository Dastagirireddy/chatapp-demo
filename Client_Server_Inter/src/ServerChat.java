import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class ServerChat 
{

	JFrame frame1;
	JPanel panel1;
	JTextField text1;
	JTextArea area1;
	ServerSocket server;
	Socket serversocket;
	ObjectOutputStream output;
	ObjectInputStream input;
	public ServerChat() throws IOException 
	{
		frame();
	}
	void frame() throws IOException
	{
		
		frame1=new JFrame("Server Chat");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1=new JPanel();
		panel1.setLayout(null);
		text1=new JTextField();
		text1.setBounds(10, 220, 260, 50);
		text1.setFocusable(true);
		text1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try {
					sendMessage(e.getActionCommand());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				text1.setText("");
				
			}
		});
		panel1.add(text1);
		area1=new JTextArea();
		area1.setFocusable(false);
		area1.setBounds(10, 10, 260, 200);
		panel1.add(area1);
		frame1.add(panel1);
		frame1.setLocation(200, 200);
		panel1.setBackground(Color.DARK_GRAY);
		frame1.pack();
		frame1.setSize(300, 320);
		frame1.setVisible(true);
		
	}
	
	public void startRunning() throws IOException, ClassNotFoundException
	{
		connect();
		while(true)
		{
			waitForConnection();
			messageStreams();
			whileChatting();
			closeConnection();
		}
	}
	
	public void connect() throws IOException
	{
		server=new ServerSocket(8070);
		
	}
	private void waitForConnection() throws IOException
	{
		serversocket=server.accept();
	}
	private void messageStreams() throws IOException
	{
		output=new ObjectOutputStream(serversocket.getOutputStream());
		output.flush();
		input=new ObjectInputStream(serversocket.getInputStream());
	}
	private void whileChatting() throws ClassNotFoundException, IOException
	{
		String message;
		//sendMessage(message);
		ableToType(true);
		do
		{
			message=(String)input.readObject();
			showMessage("\n"+""+message);
		}while(!message.equals("SERVER - END"));
	}
	private void closeConnection() throws IOException
	{
		ableToType(false);
		output.close();
		input.close();
	}
	private void sendMessage(String message) throws IOException
	{
		output.writeObject(message);
		output.flush();
		showMessage("\n"+message);
	}
	public void showMessage(final String text)
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			
			@Override
			public void run() 
			{
			
				area1.append(text);
				
			}
		});
	}
	public void ableToType(final boolean tof)
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			
			@Override
			public void run() 
			{
				text1.setEditable(tof);
				
			}
		});
	}
}
