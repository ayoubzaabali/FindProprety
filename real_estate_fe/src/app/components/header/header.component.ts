import { Component } from '@angular/core';
import { UiServiceService } from 'src/app/services/ui-service.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
    constructor(private UiService :UiServiceService){
    }
    
    checkRoute(): string{
     return this.UiService.getRoute();
    }

    getColor():string{
        if(this.checkRoute()=="/" ){
          return("black")
        }else if( this.checkRoute()=="/latest" ) {
          return("white")
        }else if( this.checkRoute()=="/search" ) {
          return("white")
        }
        
        else if( this.checkRoute()=="/about" ) {
          return("black")
        }
        
        else if( this.checkRoute()=="/contact" ) {
          return("black")
        }
        
        return("black");
    }
}
