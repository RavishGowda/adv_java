import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {
	static void exe(Statement smt,String Query) {
		try {
			String f2,f3;
			int f1;
			
			
			ResultSet rs=smt.executeQuery(Query);
			
			while(rs.next())
			{
				f1=rs.getInt(1);
				double f5 = rs.getDouble(5);
				f2=rs.getString(2);
				f3=rs.getString(3);
				String f4 = rs.getString(4);
				System.out.println("------------------------------------------------");
				System.out.println("ID :"+f1+"\nName :"+f2+" "+f3+"\nProject :"+f4+"\nSalary :"+f5);
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
			Statement smt=con.createStatement();
			System.out.println("");
			System.out.println("\n Employee Details \n");
			String Query="select * from employee";
			exe(smt,Query);
			System.out.println("------------------------------------------------");
			
			System.out.println("Employee Details of who are Working in WEB Development");
			String Query1="select * from employee where Project='web-development'";
			exe(smt,Query1);
			System.out.println("------------------------------------------------");
			
			System.out.println(" 'Employee ID' of who are Working in WEB Development and Salary above 75000\n");
			String Query2="select ID from employee where Project='web-development' and salary>=75000";
			ResultSet rs=smt.executeQuery(Query2);
			while(rs.next())
			{
				int id = rs.getInt(1);
				System.out.println("Employee ID : "+id);
				
			}
			
			System.out.println("------------------------------------------------");
			System.out.println("Total no Employees who have salary less than 50000");
			ResultSet i=smt.executeQuery("select count(*) from employee where salary<50000 ");
			i.next();
			int count=i.getInt(1);
			System.out.println(count);
		
			con.close();
			System.out.println("Connection Close");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
