import { Component, OnInit,inject } from '@angular/core';
import { Properety } from 'src/app/proprety';
import { ProperetyService } from 'src/app/services/properety.service';
import { simple } from 'src/app/simple';

@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css']
})
export class StatsComponent implements OnInit {
  propreties : Properety[]=[]
  cities : simple[] =[];

  constructor(private ps:ProperetyService ){}

  ngOnInit(): void {
    this.getAllPropreties()
    this.ps.getCities().subscribe(cities=>this.cities=cities)
  }

  getAllPropreties():void{
    this.ps.getAllPropreties().subscribe(propreties=>this.propreties=propreties)
  }

  totalPropreties(){
   return this.propreties.length;
  }

  
  totalApparetment(){
    return this.propreties.filter((prop)=>{
      return prop.nature.label=="appartement"
    }).length;
   }

   totalHouses(){
    return this.propreties.filter((prop)=>{
      return prop.nature.label=="house"
    }).length;
   }

   totalCities(){
    return this.cities.length;
   }



}
