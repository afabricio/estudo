package com.baeldung.rating;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class RatingApplication 
{
	

    @Autowired
    private RatingRepository ratingRepository;
	
    public static void main( String[] args )
    {
    	 SpringApplication.run(RatingApplication.class, args);
    }
    
    
    @PostConstruct
    public void init(){
        
        final Rating rating = new Rating();
        rating.setBookId(1L);
        rating.setStars(5);
        ratingRepository.save(rating);
    	
    	
    }
    
}