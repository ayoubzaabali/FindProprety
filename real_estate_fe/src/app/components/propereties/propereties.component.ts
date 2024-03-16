import { Component,OnInit,Output,Input,inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UiServiceService } from 'src/app/services/ui-service.service';
import {Properety} from '../../proprety';
import { ProperetyService } from 'src/app/services/properety.service';
import { simple } from 'src/app/simple';
import { params } from 'src/app/params';


@Component({
  selector: 'app-propereties',
  templateUrl: './propereties.component.html',
  styleUrls: ['./propereties.component.css']
})
export class ProperetiesComponent  implements OnInit {
propreties : Properety[] =[];
@Input() latest : boolean = false ;
cities : simple[]=[];
types : simple[]=[];
city_id !: number ;
private route = inject(ActivatedRoute);

constructor(private UiService :UiServiceService, private ps : ProperetyService ){
}

ngOnInit(): void {
  let latest !:boolean;
  
  this.route
  .data
  .subscribe(v => this.latest=v['latest']);


  if(this.latest==true ){
    this.getLatestPropreties();
  }else if(this.route.snapshot.params['id']){
    this.city_id=this.route.snapshot.params['id'];
    this.getcities();
    this.getpropretiesByCity()
  }else{
    this.getcities();
    this.gettypes();
  }
}

getpropretiesByCity():void{
  let params:params ;
  params={city_id:this.city_id};
  params={...params,price:NaN}
  params={...params,for_rent:2}
  params={...params,nature:0}

  this.ps.search(params).subscribe((propreties)=>{
    this.propreties=propreties;
  });
}


handle(){
  let params:params ;
  params={city_id:parseInt((document.querySelector("#city") as HTMLSelectElement).value)};
  params={...params,price:parseInt((document.querySelector("#price") as HTMLInputElement).value)}
  params={...params,for_rent:parseInt((document.querySelector("#for_rent") as HTMLSelectElement).value)}
  params={...params,nature:parseInt((document.querySelector("#nature") as HTMLSelectElement).value)}
   

  this.ps.search(params).subscribe((propreties)=>{
     this.propreties=propreties;
   });

}

getcities() : void{
this.ps.getCities().subscribe((cities)=>{
this.cities=cities;
})
}

getcitylabel(){
let mycity :simple[] = this.cities.filter((city)=>{
  return city.id==this.city_id
})
return mycity[0].label;
}

gettypes() : void{
  this.ps.getTypes().subscribe((types)=>{
  this.types=types;
  })
}

getLatestPropreties(): void {
  this.ps.getLatestPropreties().subscribe((propreties)=>{
    this.propreties=propreties
   });
}

checkRoute(): string{
 return this.UiService.getRoute();
}


}
