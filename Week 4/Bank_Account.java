import java.sql.*;

import java.util.Scanner;

public class Bank_Account {
	static void exe(PreparedStatement ps,String Query) {
		try {
			String f2,f3;
			int f1;
			double f4;
			System.out.println("------------------------------------------------");
			ResultSet rs=ps.executeQuery(Query);
			System.out.println("\n Account Details \n");
			while(rs.next())
			{
				f1=rs.getInt(1);
				f4=rs.getDouble(4);
				f2=rs.getString(2);
				f3=rs.getString(3);
				
				System.out.println(f1+"\t"+f2+"\t"+f3+"\t"+f4);
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
			con.setAutoCommit(false); 
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into bank_account values(?,?,?,?)");
			
			Scanner sc=new Scanner(System.in);
			while(true) {
				
				System.out.println("Enter Account_NO");
				int B_id=sc.nextInt();
				System.out.println("Enter Account Name :");
				 String B_Name=sc.next();
				System.out.println("Type Of Account");
				String Type_of_Account=sc.next();
				System.out.println("Balance");
				Double  Balance=sc.nextDouble();
				
				//execute query 
				  
				ps.setInt(1,B_id);
				ps.setString(2,B_Name);
				ps.setString(3,Type_of_Account);
				ps.setDouble(4,Balance);
				ps.executeUpdate();
				
				//commit and rollback 
				System.out.println("Commit / RollBack");
				String answer=sc.next();
				if (answer.equals("commit"))
                 {
                      con.commit();
                      System.out.println("Values are inserted..... \\n");
                 }
                 if (answer.equals("rollback"))
                 {
                      con.rollback();
                      System.out.println("Values are Not inserted..... \\n");
                 }
				System.out.println("Do you want another Record(y/n)");
				String s=sc.next();
				if(s.equals("n"))
				{
					break;
				}
				
				
			}
			
			//Setting save point
			Savepoint savePoint = con.setSavepoint("mysavepoint");
		      System.out.println("  ");
		      
		      
			String Query="select * from bank_account";
			exe(ps,Query);
			
			ps.execute("Delete from bank_account where Type_of_account='current'");
			System.out.println("After deleting the who's account is current ");
			String Query2="select * from bank_account";
			exe(ps,Query2);
			
			//Rolling back to the save point
		      con.rollback(savePoint);

		      System.out.println(" ");
		      System.out.println("Contents of the table at the save point: ");

		      //Retrieving data
		      String Query3="select * from bank_account";
				exe(ps,Query3);
				con.close();
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}
}
