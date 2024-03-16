import { Component,OnInit,inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Properety } from 'src/app/proprety';
import { faSatelliteDish } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-proprety-listing',
  templateUrl: './proprety-listing.component.html',
  styleUrls: ['./proprety-listing.component.css']
})
export class PropretyListingComponent implements OnInit {
  private route = inject(ActivatedRoute);
  properety !: Properety;
  faSatelliteDish =faSatelliteDish
  constructor(){

  }


  ngOnInit(): void {
  let prop =  JSON.parse(this.route.snapshot.paramMap.get('properety')!);
  this.properety=prop;
  console.log(this.properety)
  }
}
