import { Component , Input,inject } from '@angular/core';
import {Properety} from '../../proprety';
import { faBedPulse } from '@fortawesome/free-solid-svg-icons';
import { faBathtub } from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';
import {
  Location
} from '@angular/common';


@Component({
  selector: 'app-proprety-item',
  templateUrl: './proprety-item.component.html',
  styleUrls: ['./proprety-item.component.css']
})
export class PropretyItemComponent{
@Input() properety !: Properety
faBedPulse =faBedPulse;
faBathtub=faBathtub;
private router = inject(Router);
private location = inject(Location)


handle() :void{
let url=this.router.createUrlTree(['/listing', {properety: JSON.stringify(this.properety)}]);
this.location.replaceState(url.toString());
window.location.reload();
}

handleEventMouseIn(event:Event) :void{
   let elem= (event.target as HTMLElement).closest(".property-wrap")?.children[1].children[2].children[0];
   let elem2= (event.target as HTMLElement).closest(".property-wrap")?.children[1].children[4];

   (elem! as HTMLElement).style.color="orange";
   (elem2! as HTMLElement).style.color="orange";

} 


handleEventMouseOut(event:Event) :void{
  let elem= (event.target as HTMLElement).closest(".property-wrap")?.children[1].children[2].children[0];
  let elem2= (event.target as HTMLElement).closest(".property-wrap")?.children[1].children[4];
  
  (elem! as HTMLElement).style.color="black";
  (elem2! as HTMLElement).style.color="black";
} 



}
