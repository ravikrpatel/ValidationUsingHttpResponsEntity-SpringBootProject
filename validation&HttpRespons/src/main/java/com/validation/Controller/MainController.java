package com.validation.Controller;

import java.util.List;

import com.validation.Controller.AllExceptioinHandling.BookNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.validation.Model.BookClass;
import com.validation.Services.ServicesClass;

import jakarta.validation.Valid;

@RestController
public class MainController {
	
	@Autowired
	private ServicesClass services;
	
	@RequestMapping("/books")
	public ResponseEntity<List<BookClass>> getallbooks(){
		return new  ResponseEntity<>(services.getallbooksk(), HttpStatus.OK);
		
	}
	
	@PostMapping("/savebook")
	public ResponseEntity<BookClass> savebook(@Valid @RequestBody BookClass bookclass) {
		
		return new ResponseEntity<>(services.booksave(bookclass),HttpStatus.OK) ;
		
	}
	
	@RequestMapping("/bookbyid/{id}")
	public ResponseEntity<BookClass> getbookbyid(@PathVariable("id") int id)  {
		BookClass getbookbyid= services.getbyid(id);

			return new ResponseEntity<>(getbookbyid,HttpStatus.OK);
		}
		

	@RequestMapping("/deletebyid/{id}")
	public ResponseEntity<String>  deletebyid(@PathVariable("id") int id) {

		return new ResponseEntity<>(services.deletebookbyid(id),HttpStatus.ACCEPTED);
	}
	

}
