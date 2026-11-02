package com.library;
import java.io.Serializable;
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	private int bookId;
    private String title;
	private String author;
	private boolean isAvailable = true;


	public Book(int bookId,String title,String author) {
		
		this.bookId=bookId;
		this.title=title;
		this.author=author;
		
	}

	  // title and author
	  
	  public void setTitle(String title) {
		    this.title = title;
		}

		public void setAuthor(String author) {
		    this.author = author;
		}
	  
	
	public int getBookId() {
		return bookId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor () {
		return author;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void setAvailable(boolean available) {
		
		isAvailable =available;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", isAvailable=" + isAvailable
				+ "]";
	}
	
	
	
	
}
