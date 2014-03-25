import java.io.IOException;

import javax.swing.JOptionPane;


public class ClientServer 
{

	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		
		Object[] SelectionValues={"Server","Client"};
		String intialsection="Server";
		Object selection=JOptionPane.showInputDialog(null, "Login As:", "Chat Server", JOptionPane.QUESTION_MESSAGE,null,SelectionValues,intialsection);
		if(selection.equals("Server"))
		{
			ServerChat dastaserver=new ServerChat();
			//dastaserver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			dastaserver.startRunning();
		}
		else if (selection.equals("Client")) 
		{
			/*
			ClientChat dastaclient;
			dastaclient=new ClientChat();
			//dastaclient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			dastaclient.startRunning();
			
			
			*/
		}

	}

}
