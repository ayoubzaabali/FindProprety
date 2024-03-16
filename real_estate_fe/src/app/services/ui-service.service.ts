import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UiServiceService {
  route:string ="/";

  constructor(private router:Router){
    //this.checkRoute();
  }


  getRoute(): string{
    let myroute=this.router.events.subscribe((route) => {
      this.route= this.router.url
      });
    
     
      return this.route;
  }
}
