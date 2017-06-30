package com.techelevator.jdbc;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.techelevator.classes.ParkSurvey;
import com.techelevator.classes.SurveyResults;
import com.techelevator.dao.ParkSurveyDao;

@Component
public class JdbcParkSurveyDao implements ParkSurveyDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcParkSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveSurvey(ParkSurvey survey) {

		jdbcTemplate.update(
				"INSERT INTO survey(parkname, stateofresidence, activitylevel, emailaddress) VALUES (?,?,?,?)",
				survey.getParkName(), survey.getStateOfResidence(), survey.getActivityLevel(),
				survey.getEmailAddress());

	}

	@Override
	public List<SurveyResults> getSurveyResults() {
		SqlRowSet results = jdbcTemplate.queryForRowSet(
				"SELECT parkname, COUNT(parkname) AS survey_votes FROM survey GROUP BY parkname ORDER BY COUNT(parkname) DESC, parkname ASC");
		List<SurveyResults> surveyResults = new ArrayList<>();
		while (results.next()) {
			SurveyResults survey = mapRowToSurveyResults(results);
			surveyResults.add(survey);
		}
		return surveyResults;
	}

	public SurveyResults mapRowToSurveyResults(SqlRowSet results) {
		SurveyResults voteResults = new SurveyResults();
		voteResults.setParkName(results.getString("parkname"));
		voteResults.setVoteCount(results.getInt("survey_votes"));

		return voteResults;
	}

}
