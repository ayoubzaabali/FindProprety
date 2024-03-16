import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RootComponent } from './root/root.component';
import { ProperetiesComponent } from './components/propereties/propereties.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { ContactComponent } from './components/contact/contact.component';
import { PropretyListingComponent } from './components/proprety-listing/proprety-listing.component';

const routes: Routes = [
 {path:'' ,component:HomeComponent,data: {latest: true}},
 {path:'search' ,component:ProperetiesComponent},
 {path:'about' ,component:AboutComponent},
 {path:'latest' ,component:ProperetiesComponent,data: {latest: true}},
 {path:'contact' ,component:ContactComponent},
 {path: 'listing',component: PropretyListingComponent },
 {path: 'listbycity/:id',component: ProperetiesComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
