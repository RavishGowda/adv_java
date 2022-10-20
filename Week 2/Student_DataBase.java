import java.sql.*;

public class Student_DataBase {
	
	static void exe(Statement smt,String Query) {
		
		try {
			ResultSet rs = smt.executeQuery(Query);
			while(rs.next())
			{
				String usn=rs.getString("USN");
				String name=rs.getString("Name");
				String sem=rs.getString("Sem");
				String cgpa=rs.getString("CGPA");
				
				System.out.println(usn+" "+name+" "+sem+" "+cgpa);
			}
			rs.close();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
	{
		Connection conn=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_java", "root", "gowda@406");
		System.out.println("Connection esblished...");
		Statement smt=conn.createStatement();	
		
		System.out.println("ALL students Detailes using statement object ");
		String Query="select * from student";
		exe(smt, Query);
		System.out.println("ALL students Detailes who are in 5th semester ");
		String Query2= "select * from student where Sem='5' " ;
		exe(smt, Query2);
		System.out.println("ALL students Detailes who CGPA Above 8.0 and are in 5th semester ");	
		String Query4="select * from student where Sem='5' and CGPA >8.0 ";
		exe(smt, Query4);
		System.out.println("Total no students in 5th sem and have CGPA above 8.0");
		ResultSet i=smt.executeQuery("select count(*) from student where CGPA>8.0 ");
		i.next();
		int count=i.getInt(1);
		System.out.println(count);i.close();smt.close();
		conn.close();
		System.out.println("Connection close...");
	}

}
