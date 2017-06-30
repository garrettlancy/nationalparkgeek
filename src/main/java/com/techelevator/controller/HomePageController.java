package com.techelevator.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.techelevator.classes.ParkDetails;
import com.techelevator.dao.ParkDetailsDao;

@Controller
public class HomePageController {

	@Autowired
	ParkDetailsDao parkDetailsDao;

	@RequestMapping(path = { "/" }, method = RequestMethod.GET)
	public String displayHomePage(Model modelHolder) {
		List<ParkDetails> parkDetails = parkDetailsDao.getAllParkDetails();
		modelHolder.addAttribute("parkDetails", parkDetails);
		return "homePage";
	}
}
