import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FrametoFrameMsg 
{
	JFrame frame1;
	JPanel panel1;
	JTextField textfeild;
	JButton button;
	JFrame frame2;
	JLabel label;
	public FrametoFrameMsg() 
	{
		framework();
	}
	void framework()
	{
		frame1=new JFrame("Frame Name");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1=new JPanel();
		panel1.setLayout(null);
		textfeild=new JTextField();
		textfeild.setBounds(10, 10, 150, 30);
		panel1.add(textfeild);
		button=new JButton("Click");
		button.addActionListener(new ActionListener() 
		{
			
			
			public void actionPerformed(ActionEvent arg0) 
			{
				String textfeildtext=textfeild.getText();
				frame2=new JFrame();
				label=new JLabel();
				label.setText(textfeildtext);
				frame2.add(label);
				frame2.setSize(250, 150);
				frame2.setVisible(true);
				
			}
		});
		button.setBounds(10, 50, 80, 30);
		panel1.add(button);
		frame1.add(panel1);
		frame1.pack();
		frame1.setSize(250, 150);
		frame1.setVisible(true);
	}
	public static void main(String[] args) 
	{
		
		new FrametoFrameMsg();

	}

}
