package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.techelevator.dao.ParkDetailsDao;
import com.techelevator.dao.ParkWeatherDao;

@SessionAttributes("isF")

@Controller
public class ParkDetailsController {

	@Autowired
	ParkDetailsDao parkDetailsDao;

	@Autowired
	ParkWeatherDao parkWeatherDao;

	@RequestMapping(path = { "/parkDetails" }, method = RequestMethod.GET)
	public String displayParkDetailsPage(Model modelHolder, @RequestParam String parkCode) {
		if (!modelHolder.containsAttribute("isF")) {
			modelHolder.addAttribute("isF", true);

		}
		modelHolder.addAttribute("park", parkDetailsDao.getParkByParkCode(parkCode));
		modelHolder.addAttribute("weather", parkWeatherDao.getWeatherByParkCode(parkCode));

		return "parkDetailsHome";
	}

	@RequestMapping(path = { "/parkDetailsTempSwitch" }, method = RequestMethod.POST)
	public String displayTempChangePage(Model modelHolder, @RequestParam String parkCode) {
		Boolean temp = (Boolean) (modelHolder.asMap().get("isF"));
		temp = !temp;
		modelHolder.addAttribute("isF", temp);

		return "redirect:/parkDetails?parkCode=" + parkCode;
	}
}
