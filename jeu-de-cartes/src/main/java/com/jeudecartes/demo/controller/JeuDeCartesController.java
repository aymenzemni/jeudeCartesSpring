package com.jeudecartes.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jeudecartes.demo.dto.Carte;
import com.jeudecartes.demo.services.CartesService;



@RestController
@CrossOrigin("*")
@RequestMapping("/cartesController")
public class JeuDeCartesController {	

	@Autowired
	CartesService cartesService;	

	
	@GetMapping(value = "/getCartes")
	public ArrayList<Carte> getCartes() {
		ArrayList<Carte> carteListShulled = new ArrayList<Carte>();
		ArrayList<Carte> carteListResult = new ArrayList<Carte>();
		
		carteListShulled = cartesService.distribuerCartes();
		
	    Collections.shuffle(carteListShulled);
		
		for (int i = 0; i < 10; i++) {
			carteListResult.add(carteListShulled.get(i));
		}
		
		return carteListResult;
	}
	

	@PostMapping(value = "/trieeCartes")
	public ArrayList<Carte> trierCartes(@RequestBody ArrayList<Carte> cartesList) {		
		ArrayList<Carte> carteListResult = new ArrayList<Carte>();	
		
		carteListResult = cartesService.trierCartes(cartesList);
    
		return carteListResult;
	}

}
