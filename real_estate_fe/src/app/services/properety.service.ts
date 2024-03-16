import { Injectable } from '@angular/core';
import { Observable,of } from 'rxjs';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import  {Properety } from '../proprety';
import {simple } from '../simple'
import { params } from '../params';



@Injectable({
  providedIn: 'root'
})
export class ProperetyService {
  apiUri : string ='http://localhost:9090';

  constructor(private http : HttpClient) { }

  search(parameters:params) :  Observable<Properety[]> {
    let URI = `${this.apiUri}/propereties/search?`
    let base =URI;
    parameters.city_id !==0 ? URI=URI+"city_id="+parameters.city_id :URI=URI+"city_id";
    parameters.for_rent!=2 ? URI=URI+"&for_rent="+parameters.for_rent :URI=URI+"&for_rent";
    parameters.nature!=0 ? URI=URI+"&nature="+parameters.nature :URI=URI+"&nature";
    !isNaN(parameters.price!) ? URI=URI+"&price="+parameters.price :URI=URI+"&price";

    console.log(URI);

  if(base+"city_id&for_rent&nature&price"==URI){
   let props : Properety[] = [];
   return of(props)
  }
    
    return this.http.get< Properety[]>(URI);
  }

  getAllPropreties()  :  Observable<Properety[]>{
    let URI = `${this.apiUri}/propereties/`
    return this.http.get< Properety[]>(URI);
  }

  getLatestPropreties() :  Observable<Properety[]> {
    var date = new Date();
    date.setDate(date.getDate() - 7);
    var SevenDaysAgo = date.getFullYear()+'-'+ (date.getMonth()+1) +'-'+date.getDate();


    let URI = `${this.apiUri}/propereties/search?date=${SevenDaysAgo}`
    return this.http.get< Properety[]>(URI);
   }


   getCities() :  Observable<simple[]> {
    let URI = `${this.apiUri}/cities`
    return this.http.get< simple[]>(URI);
   }

   getTypes() :  Observable<simple[]> {
    let URI = `${this.apiUri}/types`
    return this.http.get< simple[]>(URI);
   }



}
