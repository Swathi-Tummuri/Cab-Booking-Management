package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.CabFare;

@Repository
public interface CabFareRepository extends JpaRepository<CabFare, Integer>{
	
	@Query("select cf.amount from CabFare cf where cf.source = :source and cf.destination = :destination and "
			+ "cf.typeofcab=:typeofcab and cf.numberofseats=:numberofseats")
	public float findCabFare(@Param("source") String source,
	@Param("destination") String destination, 
	@Param("typeofcab") String typeofcab, 
	@Param("numberofseats") int numberofseats);	
	
}