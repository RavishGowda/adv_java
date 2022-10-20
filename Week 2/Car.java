import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Car {
	static void exe(Statement smt,String Query) {
		try {
			
			ResultSet rs=smt.executeQuery(Query);
			 while(rs.next())
			 {
				 String f1 = rs.getString(1);
				 String f2 = rs.getString(2);
				 double f4 = rs.getDouble(3);
				 int f5 = rs.getInt(4);
				 System.out.println("------------------------------------------------");
					
				 System.out.println("Model :"+f1+"\nCompany : "+f2+"\nPrice : "+f4+"\nYear : "+f5);
				 
				 
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
			System.out.println("Caar Details ");
			String Query="select * from car";
			exe(smt,Query);
			
			// smt.executeUpdate("INSERT INTO car " +"VALUES('abc','BMW',175000,2010)");
			// smt.executeUpdate("INSERT INTO car " +"VALUES('F9','Ferrari',1500000,2022)");
			
			 System.out.println("After Inserting New Data");
			String Query1="select * from car";
			exe(smt,Query1);
			
			 System.out.println("Delete Car Details of Model='abc' and Year='2010'");
			 smt.executeUpdate("DELETE FROM car WHERE model='abc' and year='2010' ");
		
			 System.out.println("Update the Price of car 1,50,000 into 1,25,000");
			 smt.executeUpdate("UPDATE car SET price= CASE model when 'q3' then 125000 when 'xyz' then 125000 when 'F9' then 125000 ELSE price END where model IN('q3','xyz','F9'); ");
			 
			 String Query3="select * from car";
				exe(smt,Query3);
			 
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
