package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.CabFare;
import com.repository.CabFareRepository;

@Service
public class CabFareService {

	@Autowired
	CabFareRepository cabFareRepository;
	
	public String storeCarFare(CabFare cb) {
		cabFareRepository.save(cb);
		return "Cab Fare Details stored";
	}
	
	public List<CabFare> findAllCabDetails() {
		return cabFareRepository.findAll();
	}
	
	public float findCabFare(String source, String destination, String typeofcab, int numberofseats) {
		try {
		return cabFareRepository.findCabFare(source, destination, typeofcab, numberofseats);	
		} catch (Exception e) {
			return 0;
		}
	}
	
}