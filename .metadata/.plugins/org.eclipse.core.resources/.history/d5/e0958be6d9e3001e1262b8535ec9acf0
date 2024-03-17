package mainpackage;
import java.sql.Date;
import java.util.List;

import com.ayoub.real_estate.business.factory.ContextFactory;
import com.ayoub.real_estate.business.factory.Services;
import com.ayoub.real_estate.business.services.CityService;
import com.ayoub.real_estate.modules.amenity;
import com.ayoub.real_estate.modules.proprety;
import com.ayoub.real_estate.modules.args.args;
import com.ayoub.real_estate.modules.args.cityArgs;
import com.ayoub.real_estate.modules.args.propretyArgs;
import com.ayoub.real_estate.modules.interfaces.propretyAttribute;

public class App extends ContextFactory {
	
	
public static void main (String [] args) throws IllegalArgumentException, IllegalAccessException {	

	
	
	//update property (don't apply this on amenities)_______________________________________________________________
	

	/**********************************************************/	
	//new city id
	//cityArgs cArgs=(cityArgs) Context().getBean("cityArgs",1);
	
	//property id argument to update
	//propretyArgs pArgs= (propretyArgs) Context().getBean("propretyArgs",1);
	
	  //           pArgs
	    //         .setPrice(300)
	      //       .setCity( cArgs ).setAdress("hey belabass");
	
//	Services.propretyService().update(pArgs);
	/**********************************************************/
	
	
	
	
	//update property amenities_______________________________________________________________
	
	/**********************************************************/
	Services.propretyService().updateAmenity(2,2);
	/**********************************************************/
	
	
	
	
	//delete property amenities_______________________________________________________________
	
		/**********************************************************/
	//	Services.propretyService().remove(2);
		/**********************************************************/
	
	
	
	//search in propreties available
	
  cityArgs cArgs=(cityArgs) Context().getBean("cityArgs",1);
	
	//property id argument to update
	propretyArgs pArgs= (propretyArgs) Context().getBean("propretyArgs",1);
	
	             pArgs
	 		    .setCreate_time((Date) Date.valueOf("2023-03-11"));
	
	  System.out.println(Services.propretyService().Search(pArgs).toString()) ;
	
	

	
	  
	  
	  
	  
	//System.out.println( Services.Cityservice().getAll() ) ; 	  
	  
	  
	  
	  
	  
	
	
	
	
     //list of all properties
 	//  List<proprety> propreties =	Services.propretyService().getAll();
  
     // For Each Loop for iterating ArrayList
     //for (proprety i : propreties)

         // Printing the elements of ArrayList
       //  System.out.println(i.toString() + "");
    
    
 
}


}
