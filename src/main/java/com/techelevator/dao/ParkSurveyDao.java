package com.techelevator.dao;

import java.util.List;
import com.techelevator.classes.ParkSurvey;
import com.techelevator.classes.SurveyResults;

public interface ParkSurveyDao {

	public List<SurveyResults> getSurveyResults();

	void saveSurvey(ParkSurvey survey);
	
}
