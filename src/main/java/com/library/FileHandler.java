package com.library;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import java.util.List;

import java.io.ObjectOutputStream;

public class FileHandler {
	
	private List<Book> books;
	private List<Member> members;
	private List<Transaction> transactions;
	private FileHandler fileHandler;

	public FileHandler(List<Book> books,List<Member> members,List<Transaction> transactions) {
		this.books =books;
		this.members=members;
		this.transactions=transactions;
	}
	public void saveData() throws IOException{
		try(
		FileOutputStream fos= new FileOutputStream("library.data");
		ObjectOutputStream oos =new ObjectOutputStream(fos)){
	
		
		oos.writeObject(books);
		oos.writeObject(members);
		oos.writeObject(transactions);
		}
	}
	
	public void loadData()  throws IOException,ClassNotFoundException{
		try(
		FileInputStream fis = new FileInputStream("library.data");
		ObjectInputStream ois = new ObjectInputStream(fis)){
		
		 books.clear();	
		 books.addAll((List<Book>)ois.readObject());
		 
		 members.clear();
		 members.addAll((List<Member>)ois.readObject());
		 
		 transactions.clear();
		 transactions.addAll((List<Transaction>)ois.readObject());
		}
		
		 
	}
	
}
