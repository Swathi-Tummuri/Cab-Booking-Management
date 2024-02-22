package com.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.entity.CabFare;
import com.repository.CabFareRepository;
import com.service.CabFareService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CabFareServiceTest {

	@Autowired
	CabFareService cabFareService;
	
	@Test
	void testStoreCarFare() {
		CabFare cf = new CabFare(9,"Midland", "Avely", "Mazda",5, 350);
		String result = cabFareService.storeCarFare(cf);
		assertEquals(result,"Cab Fare Details stored");
	}

	@Test
	void testFindAllCabDetails() {
		List<CabFare> listOfCabs= cabFareService.findAllCabDetails();
		assertEquals(9, listOfCabs.size());
	}

	@Test
	void testFindCabFare() {
		Float result = cabFareService.findCabFare("Forrestfield", "Midland", "Toyota",7);
		assertEquals(result, (float)1200);
	}

}
