package com.techelevator.dao;

import java.util.List;

import com.techelevator.classes.ParkDetails;

public interface ParkDetailsDao {

	public List<ParkDetails> getAllParkDetails();

	public Object getParkByParkCode(String parkCode);

}
