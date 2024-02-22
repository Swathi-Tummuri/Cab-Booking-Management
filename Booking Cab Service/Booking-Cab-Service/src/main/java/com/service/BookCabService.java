package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import com.entity.BookCab;
import com.repository.BookCabRepository;

@Repository
public class BookCabService {
	@Autowired
	BookCabRepository bookCabRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
public String bookCab(BookCab bc) {
		
	String source = bc.getSource();
	String destination = bc.getDestination();
	String typeofcab = bc.getTypeofcab();
	int numberOfSeats = bc.getNumberofseats();
	
	float amount = restTemplate.getForObject("http://CAB-FARE-SERVICE/cabfare/findCabFare/"+source+"/"+destination+"/"+typeofcab+"/"+numberOfSeats, Float.class);		
	//float amount = restTemplate.getForObject("http://localhost:8181/cabfare/findCabFare/"+source+"/"+destination+"/"+typeofcab+"/"+numberOfSeats, Float.class);		

		if(amount==0) {
			return "fail!";
		}else {
			bc.setAmount(amount);
			bookCabRepository.save(bc);
			return "success";
		}
	}

public String checkFare(BookCab bc) {
    
    String source = bc.getSource();
    String destination = bc.getDestination();
    String typeofcab = bc.getTypeofcab();
    int numberOfSeats = bc.getNumberofseats();

//float amount = 
//restTemplate.getForObject("http://localhost:8282/cabfare/findCabFare/"+tolocation+"/"+fromlocation+"/"+typeofcab+"/"+numberOfSeats, Float.class);

float amount = 
restTemplate.getForObject("http://CAB-FARE-SERVICE/cabfare/findCabFare/"+source+"/"+destination+"/"+typeofcab+"/"+numberOfSeats, Float.class);        
    
    if(amount==0) {
        return "fail";
    }else {
        bc.setAmount(amount);
        return "success";
    }
	}
}
