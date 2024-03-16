package com.ayoub.real_estate.modules;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import com.ayoub.real_estate.modules.args.propretyArgs;
import com.ayoub.real_estate.modules.interfaces.propretyAttribute;
import com.ayoub.real_estate.modules.amenity;

@Component
@Scope("prototype")
public class proprety {
    
	    protected Integer id ;
		protected Integer price ;
		protected Integer bedrooms ;
		protected Integer bathrooms ;
		protected Boolean pets_allowed ;
		protected String adress ;
		protected Integer for_rent;
		protected Integer square_metters;
		protected String frontPhoto;
		protected  ArrayList<String> photos;
		protected List<amenity> amenities;
		protected propretyAttribute city;
		protected propretyAttribute nature;
		protected Date create_time ;
	    protected String description;
	  @SuppressWarnings("unused")
	  private proprety() {}
		
		
       public proprety(Integer id) {
			this.id=id;
	   }
		
       
       
		
		
	

   public String getDescription() {
		return description;
	}

	public proprety setDescription(String description) {
		this.description = description;
		return this;
	}


		@Override
	public String toString() {
		return "proprety [id=" + id + ", price=" + price + ", bedrooms=" + bedrooms + ", bathrooms=" + bathrooms
				+ ", pets_allowed=" + pets_allowed + ", adress=" + adress + ", for_rent=" + for_rent
				+ ", square_metters=" + square_metters + ", frontPhoto=" + frontPhoto + ", photos=" + photos
				+ ", amenities=" + amenities + ", city=" + city.getLabel() + ", nature=" + nature.getLabel() + ", create_time=" + create_time
				+ "]";
	}
		
		public String AmenetiestoString( List<amenity>  amenities) {
			String output="";
			for(amenity a :amenities ) {
				output=output+a.toString();
			}
			return(output);
		}


		public propretyArgs commit() {
			return( (propretyArgs) this);
		}

		public Integer getPrice() {
			return price;
		}

		public proprety setPrice(Integer price) {
			this.price = price;
			return(this);
		}

		public Integer getBedrooms() {
			return bedrooms;
		}

		public proprety setBedrooms(Integer bedrooms) {
			this.bedrooms = bedrooms;
			return(this);
		}

		public Integer getBathrooms() {
			return bathrooms;
		}

		public proprety setBathrooms(Integer bathrooms) {
			this.bathrooms = bathrooms;
			return(this);
		}

		public Boolean getPets_allowed() {
			return pets_allowed;
		}

		public proprety setPets_allowed(Boolean pets_allowed) {
			this.pets_allowed = pets_allowed;
			return(this);
		}

		public String getAdress() {
			return adress;
		}

		public proprety setAdress(String adress) {
			this.adress = adress;
			return(this);
		}

		public Integer getFor_rent() {
			return for_rent;
		}

		public proprety setFor_rent(Integer for_rent) {
			this.for_rent = for_rent;
			return(this);
		}

		public Integer getSquare_metters() {
			return square_metters;
		}

		public proprety setSquare_metters(Integer square_metters) {
			this.square_metters = square_metters;
			return(this);
		}

		public Date getCreate_time() {
			return create_time;
		}

		public proprety setCreate_time(Date create_time) {
			this.create_time = create_time;
			return(this);
		}
       
		public Integer getId() {
			return id;
		}

		public proprety setId(Integer id) {
			this.id = id;
			return(this);
		}

		

		public List<amenity> getAmenities() {
			return amenities;
		}


		public proprety setAmenities(List<amenity> amenities) {
			this.amenities = amenities;
			 return(this);
		}


		public propretyAttribute getCity() {
			return city;
		}

		public proprety setCity(propretyAttribute city) {
			// city c = (city) Context().getBean("city",id);
			  //c.setLabel(label);
			  this.city=city;
			  return(this);
		}
		 

		public propretyAttribute getNature() {
			return nature;
		}


		public proprety setNature(propretyAttribute nature) {
			this.nature = nature;
			 return(this);
		}


		public String getFrontPhoto() {
			return frontPhoto;
		}

		public proprety setFrontPhoto(String frontPhoto) {
			this.frontPhoto = frontPhoto;
			return(this);
		}

		public ArrayList<String> getPhotos() {
			return photos;
		}

		public proprety setPhotos(ArrayList<String> photos) {
			this.photos = photos;
			return(this);
		}
	

}
