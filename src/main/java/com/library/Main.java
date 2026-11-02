package com.library;
import java.util.*;


public class Main {
 public static void main(String[] args) {
	 Scanner sc= new Scanner(System.in);
	 LibraryService service =new LibraryService();
	 
	 
	 while(true) {
		 System.out.println("1.add book");
		 System.out.println("2.Register Member");
		 System.out.println("3.Issue Book");
		 System.out.println("4.Return Book");
		 System.out.println("5.view books");
		 System.out.println("6.view Members");
		 System.out.println("7.view Transaction");
		 System.out.println("8.Load Library Data");
		 System.out.println("9.Search Book");
		 System.out.println("10.search Member");
		 System.out.println("11.delete Book");
		 System.out.println("12.Exit");
		 
		 int choice =sc.nextInt();
		 
		 switch(choice) {
		  
		 case 1:
			 System.out.println("Enter Book Id");
			 int bookId =sc.nextInt();
			 sc.nextLine();
			 
			 System.out.println("Enter Book Title");
			 String title =sc.nextLine();
			 
			 
			 System.out.println("Enter Author:");
			 String author =sc.nextLine();
			 
			 Book book = new Book( bookId,title , author );
				service.addBook(book);
				
			 break;
			 
		 case 2:
			System.out.println("Enter The Member Id");
			int memberId =sc.nextInt();
			sc.nextLine();
			 
			System.out.println("Enter name:");
			String name =sc.nextLine();
			
			System.out.println("Enter Phone Number");
			String phone =sc.nextLine();
			
			Member member = new Member(memberId,name,phone);
			service.registerMember(member);
			
			break;
			 
		
			 
		 case 3:
			    System.out.println("Enter MemberId");
			    int issueMemberId = sc.nextInt();

			    System.out.println("Enter BookId");
			    int issueBookId = sc.nextInt();

			    System.out.println("Enter TransactionId");
			    int transactionId = sc.nextInt();

			    service.issueBook(issueBookId, issueMemberId, transactionId);
			    break;
			 
		 case 4:
		 
		 
		 System.out.println("Enter BookId");
		 int returnBookId =sc.nextInt();
		 
		 service.returnBook(returnBookId);
		 break;
		 
		 
		 case 5:
			 System.out.println("=====BOOK DETAILS=====");
		    service.viewBooks();
		    break;
		    
		    
		 case 6:
		 System.out.println("=====MEMBER DETAILS=====");
		 service.viewMembers();
		 break;
		 
		 case 7:
			 System.out.println("====TRANSACTION DETAILS =====");
		     service.viewTransaction();
		     break;
		 
		 case 8:
			 service.loadLibraryData();
			 break;
			 
		 case 9:
			 System.out.println("Enter BookId");
			 int searchBookId = sc.nextInt();
			 service.searchBook(searchBookId);
			 break;
			 
			 
		 case 10:
			 System.out.println("Enter MemberId:");
			 int searchMemberId = sc.nextInt();
			 service.searchMember(searchMemberId);
			 break;
		
		 case 11:
			 
			 System.out.println("Enter BookID to Delete");
			 int deleteBookId =sc.nextInt();
			 service.deleteBook(deleteBookId);
			 break;
			 
			 
         case 12:
			 
			 service.saveLibraryData();
			 System.out.println("Thank you ! your Application closed");
			 sc.close();
			 return;
		 
			 
		  default:
			   System.out.println("Invalid Choice");
		 }
	 }
}
}
