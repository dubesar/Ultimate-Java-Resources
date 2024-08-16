import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;




class DataOperation
{
	Scanner scan=new Scanner(System.in);

	void show()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("\n DRIVER REGISTERED SUCCESFULLY");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
			
			System.out.println("\n DATABASE FOUND SUCCESFULLY ");
			
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("select * from mytab");
			
			ResultSetMetaData rsm=rs.getMetaData();
			System.out.println("\n TABLE : "+rsm.getColumnCount());
			
			System.out.println(" COLUMN :"+rsm.getColumnCount());
			
			for(int i=1;i<=rsm.getColumnCount();i++)
			{
				System.out.println(" "+rsm.getColumnName(i)+" : "+rsm.getColumnTypeName(i));
			}
			
			
			
			
			while(rs.next())
			{
				int a=rs.getInt("sid");
				String b=rs.getString("sna");
				int c=rs.getInt("sag");
				System.out.println(" "+a+" , "+b+" , "+c);
			}
			rs.close();
			st.close();
			con.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR : "+e.getMessage());
		}
		
	}
	void insert()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("\n DRIVER REGISTERED SUCCESFULLY");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
			System.out.println("\n DATABASE FOUND SUCCESFULLY ");
			
			Statement st=con.createStatement();
			
			System.out.println("\nENTER ID : ");
			int id=scan.nextInt();
			System.out.println("\n ENTER NAME :");
			String name=scan.next();
			System.out.println("\n ENTER AGE:");
			int age=scan.nextInt();
		
			st.executeUpdate("insert into mytab value("+id+",'"+name+"',"+age+")");
			
			st.close();
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR:"+e.getMessage());
		}
		
		
	
}
	void update()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
			
			Statement st=con.createStatement();
			
			System.out.println("ENTER EMP_AGE-NAME : ID OF THE EMPLOYEE FOT UPDATION");
			int age=scan.nextInt();
			String name=scan.next();
			int id=scan.nextInt(); 
		
			st.executeUpdate("update mytab set sag = "+age+", sna = '"+name+"'  where sid = "+id);
			
			st.close();
			con.close();
			System.out.println("RECORED UPDATED SUCCESFULLY");
		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR:"+e.getMessage());
		}
		
		
	}
	void  delete()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
			
			Statement st=con.createStatement();
		
			System.out.println("ENTER ID FOR DELETION");
			int id=scan.nextInt();
			
			st.executeUpdate("delete from mytab where sid = "+id);
			
			st.close();
			con.close();
			System.out.println("RECORED DELETED SUCCESFULLY");
		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR:"+e.getMessage());
		}
	}
	
	void updatable()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
			
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs=st.executeQuery("select * from emp");
			
			rs.absolute(3);//jump to record having id 2
			rs.updateString("ena","bbb");
			rs.updateInt("eag",30);
			rs.updateRow();
			
			rs.absolute(6);//jump to record having id 5
			rs.updateString("ena","MSU");
			rs.updateRow();

			rs.absolute(1);//jump to record having 1
			rs.updateString("ena", "Amin");
			rs.updateRow();
			
			rs.first();
			rs.previous();
			
			
			while(rs.next())
			{
				int a=rs.getInt("eid");
				String b=rs.getString("ena");
				int c=rs.getInt("eag");
				
				System.out.println(" "+a+" , "+b+" , "+c);
			}
			rs.close();
			st.close();
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("\nShow Error"+e.getMessage());
		}
	}
	void prepareInsert()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
			
			//Statement st=con.createStatement();
			PreparedStatement pst=con.prepareStatement("insert into mytab values(?,?,?)");
			int id=1;
			
			while(id!=0)
			{
			
			System.out.print("\n  ENTER ID - NAME - AGE : ");
			id=scan.nextInt();
			String name=scan.next();
			int age=scan.nextInt();
			
				if(id!=0)
				{
					pst.setInt(1, id);
					pst.setString(2, name);
					pst.setInt(3, age);
				}
				pst.execute();
				//st.executeUpdate("insert into mytab value("+id+",'"+name+"',"+age+")");
			}

		
		pst.close();
		con.close();
		}
		catch(Exception e)
		{
			System.out.println("\n Show Error"+e.getMessage());
		}
	}
	
	void prepareUpdate()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
			
			//Statement st=con.createStatement();
			PreparedStatement pst=con.prepareStatement("update mytab set sag = ? ,sna = ? where sid = ?");
			
			System.out.println("ENTER AGE-NAME-ID");
				
				int age=scan.nextInt();
				String name=scan.next();
				int id=scan.nextInt();
				
				pst.setInt(1, age);
				pst.setString(2, name);
				pst.setInt(3, id);
				
				
				pst.execute();
			
				//st.executeUpdate("insert into mytab value("+id+",'"+name+"',"+age+")");
				System.out.println("\n RECORED UPDATED SUCCESFULLY");
				pst.close();
				con.close();
		}
		catch(Exception e)
		{
			System.out.println("\n Show Error"+e.getMessage());
		}
		
	}
	void prepareDelete()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
			
			//Statement st=con.createStatement();
			PreparedStatement pst=con.prepareStatement("delete from mytab where sid = ?");
			
			System.out.println("ENTER ID FOR DELETION");
				
		
				int id=scan.nextInt();
				pst.setInt(1, id);
				

				pst.execute();
			
				//st.executeUpdate("insert into mytab value("+id+",'"+name+"',"+age+")");
		
				System.out.println("RECORED DELETED SUCCESFULLY");
				pst.close();
				con.close();
		
		}
		catch(Exception e)
		{
			System.out.println("\n Show Error"+e.getMessage());
		}
	}
	
	
	void callableInsert()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("\n DRIVER REGISTERED SUCCESFULLY");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
			System.out.println("\n DATABASE FOUND SUCCESFULLY ");
			
			//Statement st=con.createStatement();
			CallableStatement cst=con.prepareCall(" { call insertQ(?,?,?) } ");
			
			
			
			System.out.println("\nENTER ID : ");
			int id=scan.nextInt();
			System.out.println("\n ENTER NAME :");
			String name=scan.next();
			System.out.println("\n ENTER AGE:");
			int age=scan.nextInt();
		
			cst.setInt(1,  id);
			cst.setString(2, name);
			cst.setInt(3, age);
			cst.execute();
			
			cst.close();
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR:"+e.getMessage());
		}
	}
	
	void callableOut()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("\n DRIVER REGISTERED SUCCESFULLY");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
			System.out.println("\n DATABASE FOUND SUCCESFULLY ");
			
			CallableStatement cst=con.prepareCall(" { call with_out(?,?) } ");
			
			System.out.println("\n ENTER ID:");
			int a=scan.nextInt();
			
			cst.setInt(1, a);
			cst.registerOutParameter(2, Types.VARCHAR);
			
			cst.execute();
			
			System.out.println("\n NAME:="+cst.getString(2));
			cst.close();
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR:"+e.getMessage());
		}
	}
	
	void callableHome()//homework takes name and return age(in Out example)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("\n DRIVER REGISTERED SUCCESFULLY");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
			System.out.println("\n DATABASE FOUND SUCCESFULLY ");
			
			CallableStatement cst=con.prepareCall(" { call homework(?,?) } ");
			
			System.out.println("\n ENTER NAME:");
			String a=scan.next();
			
			cst.setString(1, a);
			cst.registerOutParameter(2, Types.INTEGER);
			
			cst.execute();
			
			System.out.println("\n AGE:="+cst.getInt(2));
			cst.close();
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR:"+e.getMessage());
		}
		
	}
	void batchMethod()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("\n DRIVER REGISTERED SUCCESFULLY");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
		
			//	con.setAutoCommit(false);
			System.out.println("\n DATABASE FOUND SUCCESFULLY ");
			
			Statement st=con.createStatement();
			
			st.addBatch("insert into mytab values(50,'UTTRAYAN',120)");
			st.addBatch("delete from mytab where sid=3");
			st.addBatch("update mytab set sna='WHEN RESULT WILL COME' where sid=4");
			st.addBatch("insert into mytab values(13,'ROHIT',40)");
			
			
			st.executeBatch();
			//con.commit();
			//con.rollback();
			
			
			st.close();
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR:"+e.getMessage());
		}
	}
	
	void uploadFile()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
		
			PreparedStatement pst=con.prepareStatement("insert into imgtable values(?,?)");
			
			pst.setInt(1, 1);
			
			
			File file=new File("src//images/2.jpg");
		
		FileInputStream fis=new FileInputStream(file);
		
		pst.setBinaryStream(2, fis);
			
		pst.execute();
		
		pst.close();
			
			
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println("\n SHOW ERROR:"+e.getMessage());
		}
	}

}




public class MyMenuData 
{
	public static void main(String[] args)

	{
		Scanner scan=new Scanner(System.in);
		int ch=0;
		
		DataOperation d1=new DataOperation();
		
		while(ch!=14)
		
		{
			System.out.print("-----------------");
			System.out.println("\n: DATABASE MENU :");
			System.out.println("-----------------");
			System.out.println("1. SHOW");
			
			System.out.println("2. INSERT");
			System.out.println("3. DELETE");
			System.out.println("4. UPDATE");
			
			System.out.println("5. UPDATABLE");
			
			System.out.println("6. PREPARED INSERT");
			System.out.println("7. PREPARED UPDATE");
			System.out.println("8. PREPARED DELETE");
			
			System.out.println("9. CALLABLE INSERT");
			System.out.println("10.CALLABLE OUT");
			System.out.println("11.CALLABLE OUT HOMEWORK");
			System.out.println("12. BATCH METHOD");
			System.out.println("13. UPLOAD FILE");
			System.out.println("14. EXIT");
			System.out.println("\n SELECT YOUR OPTION:");
			
			ch=scan.nextInt();
			
			switch(ch)
			{
			case 1 : d1.show(); break;
			
			
			case 2: d1.insert();  break;
			
			case 3: d1.delete(); break;
			
			case 4: d1.update(); break;
			
			
			case 5: d1.updatable(); break;
			
			
			case 6: d1.prepareInsert(); break;
			
			case 7: d1.prepareUpdate(); break;
			
			case 8: d1.prepareDelete(); break;
			
			
			case 9: d1.callableInsert(); break;
			
			case 10: d1.callableOut(); break;
			
			case 11: d1.callableHome(); break;
			
			case 12: d1.batchMethod(); break;
			
			case 13: d1.uploadFile(); break;
			
			
			}
		}
	}
}

	
