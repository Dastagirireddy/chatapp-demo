import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Database {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException,ClassNotFoundException,IOException{
		int ch;
		do
		{
			ch=Integer.parseInt(JOptionPane.showInputDialog("Enter your choice:"));
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "dasta99");
			switch(ch)
			{
			case 1:
				PreparedStatement ps=con.prepareStatement("insert into netenrich values(?,?)");
				int rollno;
				String name;
				rollno=Integer.parseInt(JOptionPane.showInputDialog("Enter the rollno:"));
				name=JOptionPane.showInputDialog("Enter the name:");
				ps.setInt(1,rollno);
				ps.setString(2,name);
				ps.executeUpdate();
				break;
			case 2:
				File f=new File("e:/database2.txt");
				FileWriter fw=new FileWriter(f);
				f.getFreeSpace();
				//int rno=12;
				//String name1="dd";
				Statement s=con.createStatement();
				ResultSet rs=s.executeQuery("select * from netenrich");
				System.out.println("RNO NAME" );
				int count=0;
				while(rs.next())
				{
					System.out.println(rs.getInt(1) + " " + rs.getString(2));
					//System.out.println("\n");
					String str=rs.getInt(1) + "   " +rs.getString(2)+ "\n";
					fw.write(str);
					count++;
				}
				if(count==1)
					JOptionPane.showMessageDialog(null, "have");
				else
					JOptionPane.showMessageDialog(null, "dont have");
				fw.close();
				break;
			case 3:
				System.out.println("Invali Choice....");
				break;
			}
			con.close();
		}while(ch!=3);

	}

}
