import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'
import { MatProgressBarModule } from '@angular/material/progress-bar';

import { AppRoutingModule } from './app-routing.module';
import { RootComponent } from './root/root.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { ProperetiesComponent } from './components/propereties/propereties.component';
import { WhyUsComponent } from './components/why-us/why-us.component';
import { StatsComponent } from './components/stats/stats.component';
import { CityListingComponent } from './components/city-listing/city-listing.component';
import { HeroComponent } from './components/hero/hero.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { ContactComponent } from './components/contact/contact.component';
import { PropretyItemComponent } from './components/proprety-item/proprety-item.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { PropretyListingComponent } from './components/proprety-listing/proprety-listing.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';



@NgModule({
  declarations: [
    RootComponent,
    FooterComponent,
    HeaderComponent,
    ProperetiesComponent,
    WhyUsComponent,
    StatsComponent,
    CityListingComponent,
    HeroComponent,
    HomeComponent,
    AboutComponent,
    ContactComponent,
    PropretyItemComponent,
    PropretyListingComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    FontAwesomeModule,
    BrowserAnimationsModule,
    MatProgressBarModule
  ],
  providers: [],
  bootstrap: [RootComponent]
})
export class AppModule { }
