package com.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import com.entity.BookCab;

@ExtendWith(SpringExtension.class)
@SpringBootTest 
class BookCabServiceTest {

    @Autowired
    BookCabService bookCabService;
    
    @Autowired
    RestTemplate restTemplate;
    
    @Test
    void testBookCab() {
        BookCab bc = new BookCab(); 
        bc.setCname("Chaitra");
        bc.setCnumber("09911223344");
        bc.setSource("Forrestfield");
        bc.setDestination("Wattlegroove");
        bc.setTypeofcab("Toyota");
        bc.setNumberofseats(7);
        bc.setTime("2024-02-21T11:26");
        
        String result = bookCabService.bookCab(bc);
        assertEquals("success",result);
    }

    @Test
    void testCheckFare() {
        BookCab bc = new BookCab(); 
        bc.setSource("Forrestfield");
        bc.setDestination("Wattlegroove");
        bc.setTypeofcab("Toyota");
        bc.setNumberofseats(7);
        
        String result = bookCabService.checkFare(bc);
        assertEquals("success",result);
    }

}


