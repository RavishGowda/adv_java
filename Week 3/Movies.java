import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Movies {
	static void exe(ResultSet rs) 
	{
		try {
			
			
			
			System.out.println("\n Movies Details \n");
			System.out.println("------------------------------------------------");
			while(rs.next())
			{int a,e;
			float c;
				a=rs.getInt(1);
				c=rs.getFloat(4);
				e=rs.getInt(5);
				String b = rs.getString(2);
				String d = rs.getString(3);
				
				System.out.println(a+"\t"+b+"\t"+c+"\t"+d+"\t"+e);
				System.out.println("------------------------------------------------");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java","root","gowda@406");
			System.out.println("connection established..");
			System.out.println("------------------------------------------------");
			Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			
			String Query="select * from movies";
			
			String Query2="DELETE FROM movies WHERE IBM_Rating < 5 ";
			String Query3="UPDATE movies set Genre='Sci_fi' where M_ID=10";
			ResultSet rs=null;
			rs=smt.executeQuery(Query);
			exe(rs);
			System.out.println("------------------------------------------------");
			System.out.println("Display the 5th moive in Table");
			System.out.println("------------------------------------------------");
			rs=smt.executeQuery(Query);
			rs.absolute(5);
			int a,e;
			float c;
				a=rs.getInt(1);
				c=rs.getFloat(4);
				e=rs.getInt(5);
				String b = rs.getString(2);
				String d = rs.getString(3);
				
				System.out.println(a+"\t"+b+"\t"+c+"\t"+d+"\t"+e);
				System.out.println("------------------------------------------------");
			
			
		/*PreparedStatement ps=null;
			ps=con.prepareStatement("insert into movies values(?,?,?,?,?)");
			Scanner sc=new Scanner(System.in);
		while(true) {
				
				System.out.println("Enter Movie ID");
				int D_id=sc.nextInt();
				System.out.println("Enter Movie Name :");
				 String D_Name=sc.next();
				System.out.println("Enter Genre");
				String G=sc.next();
				System.out.println("IBM_Rating");
				float head=sc.nextFloat();
				System.out.println("Year of Release.");
				int no_emp=sc.nextInt();
				
				ps.setInt(1,D_id);
				ps.setString(2,D_Name);
				ps.setString(3, G);
				ps.setFloat(4,head);
				ps.setInt(5,no_emp);
				ps.executeUpdate();
				System.out.println("Values are inserted..... \nDo you want another Record(y/n)");
				String s=sc.next();
				if(s.equals("n"))
				{
					break;
				}
			}*/
			dele(con,Query2,Query3);
			
			rs=smt.executeQuery(Query);
			exe(rs);
			
			con.close();
			System.out.println("Connection Closed....");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void dele(Connection con, String query2, String query3) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=null;
			ps=con.prepareStatement(query2);
			ps.executeUpdate();
			
			ps=con.prepareStatement(query3);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
