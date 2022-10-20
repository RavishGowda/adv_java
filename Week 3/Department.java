import java.sql.*;
import java.util.Scanner;


public class Department {
	
	static void exe(ResultSet rs) 
	{
		try {
			
			System.out.println("------------------------------------------------");
			
			System.out.println("\n Department Details \n");
			while(rs.next())
			{int a,c,e;
				a=rs.getInt(1);
				c=rs.getInt(3);
				e=rs.getInt(5);
				String b = rs.getString(2);
				String d = rs.getString(4);
				
				System.out.println(a+"\t"+b+"\t"+c+"\t"+d+"\t"+e);
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
			
			Statement smt=con.createStatement();
			
			PreparedStatement ps=null;
			ps=con.prepareStatement("insert into department values(?,?,?,?,?)");
			Scanner sc=new Scanner(System.in);
			while(true) {
				
				System.out.println("Enter Department ID");
				int D_id=sc.nextInt();
				System.out.println("Enter Department Name :");
				 String D_Name=sc.next();
				System.out.println("Year of establish");
				int year=sc.nextInt();
				System.out.println("Head Name");
				String head=sc.next();
				System.out.println("NO of Employees");
				int no_emp=sc.nextInt();
				
				ps.setInt(1,D_id);
				ps.setString(2,D_Name);
				ps.setInt(3, year);
				ps.setString(4,head);
				ps.setInt(5,no_emp);
				ps.executeUpdate();
				System.out.println("Values are inserted..... \nDo you want another Record(y/n)");
				String s=sc.next();
				if(s.equals("n"))
				{
					break;
				}
			}
			System.out.println("\n----------------------------------------------------");
			String Query="select * from department";
			ResultSet rs=null;
			rs=smt.executeQuery(Query);
			System.out.println("Details of all the Departments using Statement Object.");
			while(rs.next())
			{int a,c,e;
				a=rs.getInt(1);
				c=rs.getInt(3);
				e=rs.getInt(5);
				String b = rs.getString(2);
				String d = rs.getString(4);
				
				System.out.println(a+"\t"+b+"\t"+c+"\t"+d+"\t"+e);
			}
			
			String Q="select * from department where year_Established = ? ";
			System.out.println("----------------------------------------------------");
			ps=con.prepareStatement(Q);
			
			
			while(true)
			{	
				System.out.println("Enter  which Year  details you want see ");
				int year=sc.nextInt();
				ps.setInt(1, year);
				 rs=ps.executeQuery();
				exe(rs);
				
				System.out.println("\nDo you want Antother year record (y/n)");
				String s = sc.next();
				if(s.equals("n"))
				{
					break;
				}
				
			}
			
			
		//	exe1(Q,con);
			
			System.out.println("----------------------------------------------------");
			ps=con.prepareStatement("select * from department where D_ID = ? and D_Name = ? ");
			
			while(true)
			{	
				System.out.println("Enter  Department ID you want see the details  ");
				int d_id=sc.nextInt();
				System.out.println("Enter the Department Name");
				String d_name=sc.next();
				ps.setInt(1, d_id);
				ps.setString(2, d_name);
				 rs=ps.executeQuery();
				exe(rs);
				
				System.out.println("\nDo you want Antother year record (y/n)");
				String s = sc.next();
				if(s.equals("n"))
				{
					break;
				}
			
			}
			
			
			
			
					
			
			
			
			
			
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
