import java.sql.*;
import java.util.Scanner;

public class Customer {
	
	
	static void ecexcute(PreparedStatement ps,String Query) {
		try {
			String f2,f3;
			int f1,f4;
			System.out.println("------------------------------------------------");
			ResultSet rs=ps.executeQuery(Query);
			System.out.println("\n Customer Details \n");
			while(rs.next())
			{
				f1=rs.getInt(1);
				f4=rs.getInt(4);
				f2=rs.getString(2);
				f3=rs.getString(3);
				
				System.out.println(f1+"\t"+f2+"\t"+f3+"\t"+f4);
			}
			System.out.println("------------------------------------------------");
			System.out.println("\nDetails of the ResultSet by using ResultSetMetaData.\n");
			ResultSetMetaData rsmd=rs.getMetaData();  
			  int count=rsmd.getColumnCount();
			  
			System.out.println("Total columns: "+count);
			for(int i=1;i<=count;i++) {
				System.out.println("Column Name of "+i+ "st column: "+rsmd.getColumnName(i));  
				System.out.println("Column Type Name of "+i+"st column: "+rsmd.getColumnTypeName(i));
				
			}
			
		
		} catch (SQLException e) {
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
			
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into customer values(?,?,?,?)");
			
			Scanner sc=new Scanner(System.in);
			while(true) {
				
				System.out.println("Enter Customer ID");
				int C_id=sc.nextInt();
				System.out.println("Enter Customer Name :");
				 String C_Name=sc.next();
				System.out.println("Type Of Customer");
				String Type_of_Customer=sc.next();
				System.out.println("Amount Spent");
				int Amount_spent=sc.nextInt();
				ps.setInt(1,C_id);
				ps.setString(2,C_Name);
				ps.setString(3,Type_of_Customer);
				ps.setInt(4,Amount_spent);
				ps.executeUpdate();
				System.out.println("Values are inserted..... \nDo you want another Record(y/n)");
				String s=sc.next();
				if(s.equals("n"))
				{
					break;
				}
			}
			
			String Query="select * from customer";
				ecexcute(ps,Query);
				
		System.out.println("----------------------------------------------------");
		System.out.println(" \nDetails of the database by using DatabaseMetaData.\n");
		DatabaseMetaData dbmd=con.getMetaData();  
		  
		System.out.println("Driver Name: "+dbmd.getDriverName());  
		System.out.println("Driver Version: "+dbmd.getDriverVersion());  
		System.out.println("UserName: "+dbmd.getUserName());  
		System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
		System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
		System.out.println("Url:"+ dbmd.getURL());	
		
		
		
		
		con.close();
			System.out.println("Connection Closed....");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
