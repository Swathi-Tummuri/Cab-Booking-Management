package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.BookCab;
import com.service.BookCabService;

@Controller
public class BookCabController {
	@Autowired
	BookCabService bookCabService;
	
	@RequestMapping(value = "bookCab",method = RequestMethod.POST)
	public String bookCab(HttpServletRequest req, BookCab bookcab) { 
		String cname = req.getParameter("cname");
		String cnumber = req.getParameter("cnumber");
		String source = req.getParameter("source");		
		String destination = req.getParameter("destination");	
		String typeofcab = req.getParameter("typeofcab");
		int numberofseats = Integer.parseInt(req.getParameter("numberofseats"));
		String time = req.getParameter("time");
		
		bookcab.setCname(cname);
		bookcab.setCnumber(cnumber);
		bookcab.setSource(source);
		bookcab.setDestination(destination);
		bookcab.setTypeofcab(typeofcab);
		bookcab.setNumberofseats(numberofseats);
		bookcab.setTime(time);
		
		String result = bookCabService.bookCab(bookcab);
		System.out.println(result);
		
		if(result == "fail")
            return "cab_fail";
    
        else
        {
        	BookCab bookCab = new BookCab();
        	return "cab_book_success"; 
        }      
		
	}
	@RequestMapping(value = "cabFare",method = RequestMethod.POST)
    public String cabFare(HttpServletRequest req, BookCab bookcab) { // DI for req and bookcab object 
        String source = req.getParameter("source");
        String destination = req.getParameter("destination");
        String typeofcab = req.getParameter("typeofcab");
        int numberofseats = Integer.parseInt(req.getParameter("numberofseats"));
        
        bookcab.setSource(source);
        bookcab.setDestination(destination);
        bookcab.setTypeofcab(typeofcab);
        bookcab.setNumberofseats(numberofseats);
        
        String result = bookCabService.checkFare(bookcab);
        System.out.println(result);
        
        if(result == "fail")
            return "cab_fail";
    
        else
        {
        	BookCab bookCab = new BookCab();
        	return "cab_fare_success";
        }          
    }
    
     @RequestMapping("/index")
     public String index() {
         return "index";
        }
     
     @RequestMapping("/cab_book")
     public String cab_book() {
         return "cab_book";
        }
     
     @RequestMapping("/cab_fare")
     public String cab_fare() {
         return "cab_fare";
        }
}


