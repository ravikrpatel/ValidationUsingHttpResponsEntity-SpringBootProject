package com.validation.Services;



import java.util.List;

import com.validation.Controller.AllExceptioinHandling.BookNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validation.Model.BookClass;
import com.validation.Repository.BookRepository;

@Service
public class ServicesClass {
	
	@Autowired
	private BookRepository bookrepos;
	
	

	public BookClass getbyid(int id)  {
		BookClass bookClass=bookrepos.findById(id).get();
		return bookClass;

	}



	public BookClass booksave(BookClass bookclass) {
		//BookClass bookcla= BookClass.build(0, bookclass.getAuthorname(), bookclass.getIssueby());
		
		return bookrepos.save(bookclass);
	}



	public List<BookClass> getallbooksk() {
		
		return bookrepos.findAll();
	}



	public String deletebookbyid(int id) {
		bookrepos.deleteById(id);
		return "The Book is deleted by id:" + id;
		
	}



	



	

}
