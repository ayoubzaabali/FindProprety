package com.ayoub.real_estate.rest.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayoub.real_estate.business.factory.Services;
import com.ayoub.real_estate.modules.nature;


@Repository
@CrossOrigin
@RestController
@RequestMapping("types")
public class NatureRest {
	
	@GetMapping("")
	@ResponseBody
    public ResponseEntity<List<nature>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(Services.Natureservice().getAll());
    }
	

}
