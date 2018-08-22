package com.baeldung.book;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class BookApplication 
{
	

    @Autowired
    private BookRepository bookRepository;
	
    public static void main( String[] args )
    {
    	 SpringApplication.run(BookApplication.class, args);
    }
    
    
    @PostConstruct
    public void init(){
        
        final Book newBook = new Book();
        newBook.setTitle("Book Um");
        newBook.setAuthor("Author um");
        bookRepository.save(newBook);
    	
    	
    }
    
}