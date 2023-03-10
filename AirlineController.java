package com.example.fsp.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.fsp.repository.AirlineRepository;
import com.example.fsp.model.Airline;
import com.example.fsp.exceptionalhandling.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class AirlineController {
	
        @Autowired
		private AirlineRepository airlineRepository;

		// get all airlines  
		@GetMapping("/airlines")
		public List<Airline> getAirlines(){
			return airlineRepository.findAll();
		}		

		// create airline 
		@PostMapping("/airlines")
		public Airline createAirline(@RequestBody Airline airline) {
			return airlineRepository.save(airline);
		}

		// get airline by id 
		@GetMapping("/airlines/{id}")
		public ResponseEntity<Airline> getAirlineById(@PathVariable Long id) {
			Airline airline= airlineRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Airline not exist with id :" + id));
			return ResponseEntity.ok(airline);
		}

		// update airline 
        @PutMapping("/airlines/{id}")
		public ResponseEntity<Airline> updateAirline(@PathVariable Long id, @RequestBody Airline airlineDetails){
			Airline airline= airlineRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Airline not exist with id :" + id));

		    airline.setAirlineName(airlineDetails.getAirlineName());
			airline.setAirlineId(airlineDetails.getAirlineId());
			airline.setSource(airlineDetails.getSource());

			Airline updatedairline = airlineRepository.save(airline);
			return ResponseEntity.ok(updatedairline);
		}

		// delete airline 
		@DeleteMapping("/airlines/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteAirline(@PathVariable Long id){
			Airline airline= airlineRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Airline not exist with id :" + id));

			airlineRepository.delete(airline);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	}


