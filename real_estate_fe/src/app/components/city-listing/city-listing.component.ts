import { Component,Inject, OnInit } from '@angular/core';
import { inject } from '@angular/core/testing';
import { ProperetyService } from 'src/app/services/properety.service';
import { simple } from 'src/app/simple';


@Component({
  selector: 'app-city-listing',
  templateUrl: './city-listing.component.html',
  styleUrls: ['./city-listing.component.css']
})
export class CityListingComponent implements OnInit {
  cities : simple[] =[];
  constructor( private ps :ProperetyService){
  }
  
  ngOnInit(): void {
    this.ps.getCities().subscribe(cities=>this.cities=cities)
  }
  
  
  }
  
