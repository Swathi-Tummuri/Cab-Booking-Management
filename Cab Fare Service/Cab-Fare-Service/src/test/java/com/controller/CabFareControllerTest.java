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

import com.entity.CabFare;
import com.service.CabFareService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CabFareControllerTest {

	@Mock
    CabFareService cabFareService;
    
    @InjectMocks
    CabFareController cabFareController;
    @Test
    void testFindAllCabFareInfo() {
        //Mock testing
        CabFare c1 = new CabFare(1,"A", "B","Type1",1,100);
        CabFare c2 = new CabFare(2,"B", "C","Type1",2,200);
        List<CabFare> liCabFare = new ArrayList<>();
        liCabFare.add(c1);
        liCabFare.add(c2);
        Mockito.when(cabFareService.findAllCabDetails()).thenReturn(liCabFare);
        
        
        List<CabFare> listOfCabFareTest = cabFareController.findAllCabFareInfo();
        assertEquals(2, listOfCabFareTest.size());
    }

    @Test
    void testStoreCabFareInfo() {
        //Mock testing
        CabFare cfr = new CabFare(1,"A", "B","Type1",1,100);
        Mockito.when(cabFareService.storeCarFare(cfr)).thenReturn("Account created");
        
        String result = cabFareController.storeCabFareInfo(cfr);
        assertEquals("Account created", result);
    }

    @Test
    void testFindCabFare() {
        //Mock testing
        CabFare c1 = new CabFare(1,"A", "B","Type1",1,100);
        CabFare c2 = new CabFare(2,"B", "C","Type1",2,200);
        List<CabFare> liCabFare = new ArrayList<>();
        liCabFare.add(c1);
        liCabFare.add(c2);
        
        Mockito.when(cabFareService.findCabFare("A","C", "Type1",1)).thenReturn((float) 0); 
        float result = cabFareController.findCabFare("A","C", "Type1",1);
        assertEquals((float) 0, result);
        
        Mockito.when(cabFareService.findCabFare("B","C", "Type1",2)).thenReturn((float) 200);
        result = cabFareController.findCabFare("B","C", "Type1",2);
        assertEquals((float)200, result);
    }

}

