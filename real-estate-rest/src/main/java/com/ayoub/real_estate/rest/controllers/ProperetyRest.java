package com.ayoub.real_estate.rest.controllers;



import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ayoub.real_estate.business.factory.ContextFactory;
import com.ayoub.real_estate.business.factory.Services;
import com.ayoub.real_estate.modules.proprety;
import com.ayoub.real_estate.modules.args.cityArgs;
import com.ayoub.real_estate.modules.args.propretyArgs;
import com.ayoub.real_estate.modules.args.natureArgs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




@Repository
@CrossOrigin
@RestController
@RequestMapping("propereties")
public class ProperetyRest extends ContextFactory {
	
    private static final Logger logger = LogManager.getLogger(ProperetyRest.class);

 
	@GetMapping("/{id}")
	@ResponseBody
    public ResponseEntity<proprety> getProprety(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(Services.propretyService().get(id));
    }
	
	
	@GetMapping("/")
	@ResponseBody
    public ResponseEntity<List<proprety>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body( Services.propretyService().getAll());
    }
	
	
	@GetMapping("/search")
	@ResponseBody
    public ResponseEntity<List<proprety>> filter(@RequestParam(required = false) Integer city_id,
    		@RequestParam(required = false) Integer nature,
    		@RequestParam(required = false) Integer for_rent,
    		@RequestParam(required = false) Integer price,
    		@RequestParam(required = false) String date ) throws ParseException {
		
		//property id argument to update
		propretyArgs pArgs= (propretyArgs) Context().getBean("propretyArgs",1);

		//validate city
		if(!validator.isNull(city_id)) {
			cityArgs cArgs=(cityArgs) Context().getBean("cityArgs",city_id);
			pArgs
	          .setCity( cArgs );
			logger.info("city is set") ; 
		}
		
		
		//validate nature
		if(!validator.isNull(nature)) {
		natureArgs nArgs=(natureArgs) Context().getBean("natureArgs",nature);
				   pArgs
			          .setNature(nArgs);
				   
		logger.info("nature is set") ;   

	     }
		
		
		
		//validate for_rent
		if(!validator.isNull(for_rent)) {
				   pArgs
			          .setFor_rent(for_rent);
				   logger.info("for_rent is set") ;  
	     }
		
		
		//validate price
		if(!validator.isNull(price)) {
				   pArgs
			          .setPrice(price);
				   logger.info("price is set") ; 
	     }
		
		//validate date
		if(!validator.isNull(date)) {
		  pArgs
		    .setCreate_time((Date) Date.valueOf(date));
		  logger.info("date is set") ;
	    }	

			
			try {
				return ResponseEntity.status(HttpStatus.OK).body( Services.propretyService().Search(pArgs));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				return (ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
			}
			

			
    }
	
	
	
    
    
	 @GetMapping("/error")
	    public String error() {
	        return "Error handling";
	 }
	
}