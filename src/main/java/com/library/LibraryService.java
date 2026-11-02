package com.library;
import java.util.List;

import java.util.Iterator;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.time.LocalDate;
import java.io.IOException;

public class LibraryService {

  private List<Book> books =new ArrayList<>();
  private List<Member> members = new ArrayList<>();
  private List<Transaction> transactions = new ArrayList<>();
  private FileHandler fileHandler;
  
  public LibraryService() {
	  fileHandler = new FileHandler(books,members,transactions);
  }
  
//  public void addBook(Book book) {
//	  books.add(book);
//  }
  
  
  //find dublicate bookId
  
  public void addBook(Book book) {
 	 
 	 for(Book existingBook :books) {
 		 if(existingBook.getBookId ()== book.getBookId()) {
 			 System.out.println("Dublicate BookId! Not valid");
 			 return;
 		 }
 		
  }
 	books.add(book);
 	System.out.println("Book Added Sucessfully!");
  }

  public void registerMember(Member member) {
	  
	  for(Member existingMember :members) {
		  if(existingMember.getMemberId() ==member.getMemberId()) {
			  System.out.println("Dublicate MemberId! Not valid");
			  return;
		  }
	  }
	  members.add(member);
	  System.out.println("MemberId Added Sucessfully!");
  }
  
  public void issueBook(int bookId,int memberId, int transactionId) {
		// find member found
		boolean memberFound= false;
		  for(Member member:members) {
			  if(member.getMemberId()==memberId) {
				  
				  memberFound=true;
				  break;
			  }
			  
		  }
		  if(!memberFound) {
			  System.out.println("Member Id not found");
			  return;
		  }
	  
	  
	  
	  
	  // find book available
	  
	  for(Book book:books) {
		  if(book.getBookId()== bookId) {
		if(book.isAvailable()) {
			LocalDate issueDate = LocalDate.now();
			LocalDate dueDate = issueDate.plusDays(14);
			
			Transaction transaction = new Transaction(
					transactionId,
					bookId,memberId,issueDate,dueDate); 
				transactions.add(transaction);
				
				book.setAvailable(false);
				System.out.println("Book issued succesfully!");
			}
			
		else {
			System.out.println("Book is already Issued!");
		}
		return;
		  }
		 
		 }
	System.out.println("Book Id not Found!");
	  
	 

	  
  }
  
 
  
  public void returnBook(int bookId) {
	  boolean bookFound = false;
	  for(Book book:books) {
		  if(book.getBookId() ==bookId) {
			 bookFound =true;
			 break;
		  }
	  }
	  if(!bookFound) {
		  System.out.println("BookId Not found");
		  return;
	  }
	  
	  for(Transaction transaction:transactions) {
		  if(transaction.getBookId() == bookId 
		 && transaction.getReturnDate()==null) {
			  
			  LocalDate returnDate =LocalDate.now();
			  transaction.setReturnDate(returnDate);
			  
			  if(returnDate.isAfter(transaction.getDueDate())) {
				  
				  long lateDays=ChronoUnit.DAYS.between(transaction.getDueDate(),
						  returnDate);
				  
				  double fine=lateDays *10;
				  
				  transaction.setFine(fine);
				  
				  System.out.println("Late Days: "+ lateDays);
				  System.out.println("Fine Amount: "+fine);
				 
				  
			  }
			for(Book book:books) {
				if(book.getBookId() ==bookId) {
					book.setAvailable(true);
					break;
				}
				
			}
			System.out.println("Book Returned Sucessfully!");
			return;
	  }
		  
  }
 
  System.out.println("No active Transaction found for this Book");
}
  
  
 public void viewBooks() {
	 for(Book book:books) {
		 System.out.println(book);
	 }
 }
 
 public void viewMembers() {
	 for(Member member:members) {
		 System.out.println(member);
	 }
 }
 
 public void viewTransaction() {
	 for(Transaction transaction:transactions) {
		System.out.println(transaction); 
	 }
 }
  
 public void saveLibraryData() {
	try {
		fileHandler.saveData();
		System.out.println("Library Data Saved Sucessfully!");
	}
	catch(IOException e) {
		System.out.println("Error While Saving Data: " +e.getMessage());
	}
 }
 
 
 public void loadLibraryData() {
	 try {
		 fileHandler.loadData();
		 System.out.println("Library Data Loaded sucessfully!");
	 }
	 catch(IOException |ClassNotFoundException e) {
		 System.out.println("Error While Loading Data " +e.getMessage());
	 }
 }
 
 //find Transaction 
 public boolean addTransaction(Transaction transaction) {

	    for(Transaction existingTransaction : transactions) {

	        if(existingTransaction.getTransactionId() == transaction.getTransactionId()) {

	            System.out.println("Transaction ID Already Exists!");
	            return false;
	        }
	    }

	    transactions.add(transaction);
	    System.out.println("Transaction Added Successfully!");
	    return true;
	}
 
 //search member details
 public void searchBook(int bookId) {
	 for(Book book:books) {
		if(book.getBookId() ==bookId) {
			System.out.println(book);
			return;
		} 
	}
	 System.out.println("Book Not Found");
 }
 
 //search member details
 public void searchMember(int memberId) {
	 for(Member member :members) {
		 if(member.getMemberId() ==memberId) {
			 System.out.println(member);
			 return;
		 }
	 }
	 
		 System.out.println("MmeberId not found");
	 
 }
 
 // update Book Details
 public void updateBook(int bookId,String newTitle , String newAuthor) {
	 for(Book book :books) {
		 if(book.getBookId() ==bookId) {
			book.setTitle(newTitle);
			book.setAuthor(newAuthor);
			
			System.out.println("Book Deatils Updated Succesfully !");
			return;
		 }
	 }
	 System.out.println("Book Not Found");
 }
 
 //delete book
 public void deleteBook(int bookId) {

	    Iterator<Book> iterator = books.iterator();

	    while(iterator.hasNext()) {

	        Book book = iterator.next();

	        if(book.getBookId() == bookId) {

	            if(!book.isAvailable()) {
	                System.out.println("Cannot Delete! Book is Currently Issued.");
	                return;
	            }

	            iterator.remove();

	            System.out.println("Book Deleted Successfully!");
	            return;
	        }
	    }

	    System.out.println("Book Not Found!");
	}
 
}
