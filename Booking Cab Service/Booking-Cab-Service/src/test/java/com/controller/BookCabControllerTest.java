package com.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;

import com.entity.BookCab;
import com.service.BookCabService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jakarta.servlet.http.HttpServletRequest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BookCabControllerTest {
    
    @Mock
    BookCabService bookCabService;
    
    @InjectMocks
    BookCabController bookCabController;

    @Test
    void testBookCab() {
        //Mock testing
        MockHttpServletRequest req = new MockHttpServletRequest();
        req.setParameter("cname","SS");
        req.setParameter("cnumber","012");
        req.setParameter("source","A");
        req.setParameter("destination","B");
        req.setParameter("typeofcab","T1");
        req.setParameter("numberofseats","2");
        req.setParameter("time","21/02");
        
        BookCab bc = new BookCab();
        
        Mockito.when(bookCabService.bookCab(bc)).thenReturn("success");
        bc.setCname("SS");
        bc.setCnumber("012");
        bc.setSource("A");
        bc.setDestination("B");
        bc.setTypeofcab("T1");
        bc.setNumberofseats(2);
        bc.setTime("21/02");
        String result = bookCabController.bookCab(req, bc);
        assertEquals("cab_book_success", result);
    }

    @Test
    void testCabFare() {
        MockHttpServletRequest req = new MockHttpServletRequest();
        req.setParameter("source","A");
        req.setParameter("destination","B");
        req.setParameter("typeofcab","T1");
        req.setParameter("numberofseats","2");
        
        BookCab bc = new BookCab();
        bc.setSource("A");
        bc.setDestination("B");
        bc.setTypeofcab("T1");
        bc.setNumberofseats(2);
        Mockito.when(bookCabService.checkFare(bc)).thenReturn("fail");
            
        String result = bookCabController.cabFare(req, bc);
        assertEquals("cab_fail", result);
    }

}


