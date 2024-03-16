import {simple } from './simple'
export interface  Properety{
    id: number;
    price:number;
    bedrooms:number;
    bathrooms:number;
    pets_allowed:boolean;
    adress :string;
    for_rent:number;
    square_metters:number;
    frontPhoto:string;
    amenities:simple[];
    city:simple;
    nature:simple;
    create_time:string;
    description :string;
}


