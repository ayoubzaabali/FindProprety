import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { UiServiceService } from 'src/app/services/ui-service.service';
@Component({
  selector: 'app-hero',
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.css']
})
export class HeroComponent {
constructor(private UiService :UiServiceService){
}

checkRoute(): string{
 return this.UiService.getRoute();
}

getHeroImage(): string{
if(this.checkRoute()=="/" ){
  return("../assets/images/bg_2.jpg")
}else if( this.checkRoute()=="/latest" ) {
  return("../assets/images/bg_1.jpg")
}else if( this.checkRoute()=="/search" ) {
  return("../assets/images/search.webp")
}

else if( this.checkRoute()=="/about" ) {
  return("../assets/images/about.png")
}

else if( this.checkRoute()=="/contact" ) {
  return("../assets/images/contact-us.jpg")
}

return("");
}
}
