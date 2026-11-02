package com.library;
import java.time.LocalDate;
import java.io.Serializable;
public class Transaction implements Serializable{
	private static final long serialVersionUID = 1L;
	private int transactionId;
	private int bookId;
	private int memberId;
	private LocalDate issueDate;
	private LocalDate dueDate;
	private LocalDate returnDate;
	private double fine;
	
	public Transaction(int transactionId,int bookId,int memberId,
			LocalDate issueDate,LocalDate dueDate) {
	    
		this.transactionId=transactionId;
		this.bookId=bookId;
		this.memberId=memberId;
		this.issueDate=issueDate;
		this.dueDate=dueDate;
		this.returnDate =null;
		this.fine=0;
	}
	
	public int getTransactionId() {
		return transactionId;
	}
	public int getBookId() {
		return bookId;
	}
	public int getMemberId() {
		return memberId;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public double getFine() {
		return fine;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate=returnDate;
	}
	
	public void setFine(double fine) {
		this.fine=fine;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", bookId=" + bookId + ", memberId=" + memberId
				+ ", issueDate=" + issueDate + ", dueDate=" + dueDate + ", returnDate=" + returnDate + ", fine=" + fine
				+ "]";
	}
	
	
}

