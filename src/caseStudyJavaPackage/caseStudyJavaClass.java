package caseStudyJavaPackage;

import java.util.Scanner;
import java.sql.*;

public class caseStudyJavaClass {
	
	
	public static void search() throws SQLException {
		 Scanner sc=new Scanner(System.in);
		System.out.println("Enter the BOOK NAME: ");
		String str=sc.nextLine();
		
		// TODO Auto-generated method stub
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdetails","root","");
					
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						 
					  Statement stmt =con.createStatement();
                      ResultSet rs=stmt.executeQuery("select * from bookinfo where bookName='"+str+"'");
					  
                      if(!rs.next()) {
                    	  System.out.println("Not found!!!");
                      }
                      
					  while(rs.next())
					  {
						  System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getString(3) + " " +rs.getInt(4));
						  
					  }
					  

					}
					
					catch(Exception e1)
					{
						e1.printStackTrace();
						
					}		
					finally {
						
						con.close();
						System.out.println("Searched the data");
						defaultProg();
						
					}
		
	}
	
	
	public static void addBook() throws SQLException {
		
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter the book name:");
		 String bookNamee=sc.nextLine();
		 System.out.println("Enter the book author:");
		 String bookAuthorr=sc.nextLine();
		 System.out.println("Enter the book price:");
		 int bookPricee=sc.nextInt();
		 
		 
		// TODO Auto-generated method stub
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdetails","root","");
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				 
			  Statement stmt =con.createStatement();
			  ResultSet rss=stmt.executeQuery("select * from bookinfo where bookName='"+bookNamee+"'");
			  if(!rss.next()) {
			  
				  boolean rs=stmt.execute("INSERT INTO bookinfo (bookName, bookAuthor, bookPrice) VALUES ('"+bookNamee+"','"+ bookAuthorr+"',"+ bookPricee+")");
			  
			  }
			  else {
				  
				  System.out.println("Book Already Exists!!!");
				  
			  }

			}
			
			catch(Exception e1)
			{
				e1.printStackTrace();
				
			}		
			finally {
				
				con.close();
				System.out.println("inserted the data");
				defaultProg();
				
			}
		 
		 
		 
		 
		 
		 
	}
	
	
	public static void listBook() throws SQLException  {
		
		System.out.println("List of books -->");
		
		// TODO Auto-generated method stub
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdetails","root","");
					
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						 
					  Statement stmt =con.createStatement();
					  ResultSet rs=stmt.executeQuery("select * from bookinfo");
					  
					  while(rs.next())
					  {
						  System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getString(3) + " " +rs.getInt(4));
						  
					  }
					  

					}
					
					catch(Exception e1)
					{
						e1.printStackTrace();
						
					}		
					finally {
						
						con.close();
						System.out.println("Read the data");
						defaultProg();
						
					}
		
	}

	public static void updateBook() throws SQLException {
		
		System.out.println("Enter the book name whose detail you want to update:");
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		System.out.println("Select what you want to update:");
		System.out.println("1.Book name");
		System.out.println("2.Book author");
		System.out.println("3.Book price");
		int option=sc.nextInt();
		String data="";
		switch(option) {
		
		case 1:{
			data="bookName";
			break;
		}
		case 2:{
			data="bookAuthor";
			break;
		}
		case 3:{
			data="bookPrice";
			break;
		}
		default:{
			System.out.println("wrong input");
			updateBook();
		}
		}
		
		System.out.println("Enter new value for "+ data+":");
		if(data=="bookName" || data=="bookAuthor") {
			String dataValue=sc.nextLine();
			
			
			
			
			if(dataValue=="")
			{
				 dataValue=sc.nextLine();
			}
			// TODO Auto-generated method stub
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdetails","root","");
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				 
			  Statement stmt =con.createStatement();
			  boolean rss=stmt.execute("UPDATE bookinfo SET "+data+"= '"+ dataValue +"' WHERE bookName = '"+str+"'");
			  ResultSet rs=stmt.executeQuery("select * from bookinfo");
			  
			  while(rs.next())
			  {
				  System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getString(3) + " " +rs.getInt(4));
				  
			  }
			  

			}
			
			catch(Exception e1)
			{
				e1.printStackTrace();
				
			}		
			finally {
				
				con.close();
				System.out.println("updated the data");
				defaultProg();
				
			}
			
			
			
			
			
			
		}
		else
		{	int dataValue=sc.nextInt();
		
		
		
		
		
		
		// TODO Auto-generated method stub
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdetails","root","");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			 
		  Statement stmt =con.createStatement();
		  boolean rss=stmt.execute("UPDATE bookinfo SET "+data+"= "+ dataValue +" WHERE bookName = '"+str+"'");
		  ResultSet rs=stmt.executeQuery("select * from bookinfo");
		  
		  while(rs.next())
		  {
			  System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getString(3) + " " +rs.getInt(4));
			  
		  }
		  

		}
		
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			con.close();
			System.out.println("updated the data");
			defaultProg();
			
		}
		
		
		
		
		
		
		
		}
	
		
	}
	
	public static void deleteBook() throws SQLException  {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the book name which you want to delete:");
		String bname=sc.nextLine();
		
		// TODO Auto-generated method stub
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdetails","root","");
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					 
				  Statement stmt =con.createStatement();
				  boolean rss=stmt.execute("DELETE FROM bookinfo WHERE bookName='"+ bname +"'");
				  ResultSet rs=stmt.executeQuery("select * from bookinfo");
				  
				  while(rs.next())
				  {
					  System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getString(3) + " " +rs.getInt(4));
					  
				  }
				  

				}
				
				catch(Exception e1)
				{
					e1.printStackTrace();
					
				}		
				finally {
					
					con.close();
					System.out.println("deleted the data");
					defaultProg();
					
				}
		
		
	}
	
	public static void exitApp() {
		
		 Scanner sc=new Scanner(System.in);
		System.out.println("Do you want to exit (y/n):");
		char ans=sc.next().charAt(0);
		if(ans=='y' || ans=='Y')
		{	System.exit(0);
		
		}
		else
		{	defaultProg();
		}
	}
	
	
	public static void selectOption(int option) {
		
		switch(option) {
		
		case 1:{
			
			try {
				search();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case 2:{
			
			try {
				listBook();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		}
		case 3:{
			try {
				addBook();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case 4:{
			try {
				updateBook();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case 5:{
			try {
				deleteBook();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}

		default: exitApp();
		
		}
		
		
	}
	
	
	public static void defaultProg() {
		
		 Scanner sc=new Scanner(System.in);
		 System.out.println();
			System.out.println("******Welcome to Central Book Centre******");
			System.out.println("1.Search Book");
			System.out.println("2.List Books");
			System.out.println("3.Add Book");
			System.out.println("4.Update Book");
			System.out.println("5.Delete Book");
			System.out.println("6.Exit");
	        System.out.println();
			System.out.println("Enter the number of operation you want to execute:");
			
			int option=sc.nextInt();
			selectOption(option);
		
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		defaultProg();
		
		
//		// TODO Auto-generated method stub
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdetails","root","");
//		
//		try {
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			 
//		  Statement stmt =con.createStatement();
//		  boolean rs=stmt.execute("");
//		  
////		  boolean rs=stmt.execute("CREATE TABLE bookinfo ( bookId int,bookName varchar(255),bookAuthor varchar(255),bookPrice int)");
////		  ResultSet rs=stmt.executeQuery("select * from empl");
////		  
////		  while(rs.next())
////		  {
////			  System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getString(3) + " " +rs.getInt(4));
////			  
////		  }
//		}
//		
//		catch(Exception e1)
//		{
//			e1.printStackTrace();
//			
//		}		
//		finally {
//			
//			con.close();
//			System.out.println("received the data");
//		}
		
		
		
	}

}
