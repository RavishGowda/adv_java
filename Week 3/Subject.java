import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.result.UpdatableResultSet;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class Subject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			
			String s_code="csl56";
			String update1="Advanced Java Programming Lab";
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java","root","gowda@406");
			System.out.println("connection established..");
			System.out.println("------------------------------------------------");
			
			
			String Query="select * from subject" ;
					
			Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			update(smt,Query,s_code,update1);
			
			System.out.println("------------------------------------------------");
			String Query1="DELETE FROM subject WHERE Sub_Name = ? ";
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter which Subject you want Delete");
			String del=sc.nextLine();
			exe(Query1,con,del);
		
			
			
			String Query2="select * from subject" ;
		
			prnt(smt,Query2);
		
		
			con.close();
			System.out.println("Connection closed..");
			} catch (ClassNotFoundException e) {
						
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}

	private static void update(Statement smt, String query, String s_code, String update1) {
		// TODO Auto-generated method stub
		ResultSet rs;
		try {
			rs = smt.executeQuery(query);
			while(rs.next())
			{
				String s_id=rs.getString("Sub_code");
				String s_name=rs.getString("Sub_Name");
				
				if(s_id.equals(s_code)) 
				{	
					rs.updateString("Sub_Name",update1);
					rs.updateRow();
					
					String s_name1=rs.getString("Sub_Name");
					System.out.println(s_name+"  change into "+s_name1);
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void prnt(Statement smt, String query2) {
		// TODO Auto-generated method stub
		
		try {
			ResultSet rs = smt.executeQuery(query2);
			while(rs.next())
			 {
				 String f1 = rs.getString(1);
				 String f2 = rs.getString(2);
				 String f4 = rs.getString(3);
				 int f5 = rs.getInt(4);
				 System.out.println("------------------------------------------------");
					
				 System.out.println("Code :"+f1+"\nName : "+f2+"\nDepartment : "+f4+"\nCredits : "+f5);
				 
				 
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		
		
		
	}

	private static void exe(String query1, Connection con, String del) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement ps=con.prepareStatement(query1);
			ps.setString(1,del);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
	}

}
