package com.techelevator.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.classes.ParkDetails;
import com.techelevator.dao.ParkDetailsDao;

@Component
public class JdbcParkDetailsDao implements ParkDetailsDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcParkDetailsDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<ParkDetails> getAllParkDetails() {
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM park");

		List<ParkDetails> allDetails = new ArrayList<>();
		while (results.next()) {
			allDetails.add(mapRowToParkDetails(results));
		}

		return allDetails;
	}

	private ParkDetails mapRowToParkDetails(SqlRowSet results) {
		ParkDetails details = new ParkDetails();
		details.setParkCode(results.getString("parkcode"));
		details.setParkName(results.getString("parkname"));
		details.setState(results.getString("state"));
		details.setAcreage(results.getInt("acreage"));
		details.setElevationInFeet(results.getInt("elevationinfeet"));
		details.setMilesOfTrail(results.getDouble("milesoftrail"));
		details.setNumberOfCampsites(results.getInt("numberofcampsites"));
		details.setClimate(results.getString("climate"));
		details.setYearFounded(results.getInt("yearfounded"));
		details.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		details.setInspirationalQuote(results.getString("inspirationalquote"));
		details.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
		details.setParkDescription(results.getString("parkdescription"));
		details.setEntryFee(results.getInt("entryfee"));
		details.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));

		return details;
	}

	@Override
	public ParkDetails getParkByParkCode(String parkCode) {
		SqlRowSet result = jdbcTemplate.queryForRowSet("SELECT * FROM park WHERE parkcode=?", parkCode);
		if (result.next()) {
			ParkDetails parkDetails = mapRowToParkDetails(result);
			return parkDetails;
		} else {
			return null;
		}
	}

}
