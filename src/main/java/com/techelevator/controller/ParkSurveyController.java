package com.techelevator.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.classes.ParkDetails;
import com.techelevator.classes.ParkSurvey;
import com.techelevator.classes.SurveyResults;
import com.techelevator.dao.ParkDetailsDao;
import com.techelevator.dao.ParkSurveyDao;

@SessionAttributes("isSurveyComplete")

@Controller
public class ParkSurveyController {
	
	@Autowired
	ParkDetailsDao parkDetailsDao;

	@Autowired
	ParkSurveyDao parkSurveyDao;

	@RequestMapping(path = { "/parkSurveyHome" }, method = RequestMethod.GET)
	public String displayParkSurveyHomePage(Model modelHolder) {
		List<ParkDetails> parkDetails = parkDetailsDao.getAllParkDetails();
		modelHolder.addAttribute("parkDetails", parkDetails);

		if (!modelHolder.containsAttribute("isSurveyComplete")) {
			return "parkSurveyHome";
		} else {
			return "parkSurveyCompleted";
		}
	}

	@RequestMapping(path = { "/parkSurveyCompleted" }, method = RequestMethod.GET)
	public String displayParkSurveyCompletedPage(Model modelHolder) {
		Boolean surveyTemp = (Boolean) (modelHolder.asMap().get("isSurveyCompleted"));
		modelHolder.addAttribute("isSurveyCompleted", surveyTemp);
		return "parkSurveyCompleted";
	}

	@RequestMapping(path = { "/parkSurveyHome" }, method = RequestMethod.POST)
	public String displayParkSurveyResults(Model modelHolder, @Valid @ModelAttribute("survey") ParkSurvey parkSurvey,
			BindingResult result, RedirectAttributes attr) {

		attr.addFlashAttribute("survey", parkSurvey);
		if (result.hasErrors()) {
			attr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			return "redirect:/parkSurveyHome";
		}
		
		parkSurveyDao.saveSurvey(parkSurvey);

		if (!modelHolder.containsAttribute("isSurveyComplete")) {
			modelHolder.addAttribute("isSurveyComplete", true);
		}
		return "redirect:/parkSurveyResults";
	}

	@RequestMapping(path = { "/parkSurveyResults" }, method = RequestMethod.GET)
	public String displayParkSurveyResults(Model modelHolder) {
		List<SurveyResults> surveyResults = parkSurveyDao.getSurveyResults();
		modelHolder.addAttribute("surveyResults", surveyResults);
		return "parkSurveyResults";
	}
}
