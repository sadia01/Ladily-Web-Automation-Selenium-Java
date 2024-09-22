package data;

import org.testng.annotations.DataProvider;

public class DataSet {
	

	
	@DataProvider(name = "combinedAccountCheckoutData")
	public static Object[][] combinedDataSet1() {
	    return new Object[][]{
	        {
	            // CreateAccount Data
	            "Rebecca", "Armstrong", "rebeccastrong@gmail.com", "01681336528", "becca1234", "becca1234",
	            // CheckoutProduct Data
	            "Rebecca", "Armstrong", "rebeccastrong@hotmail.com", "Dhaka", "Rayerbazar, Dhanmondi", "01681336528"
	        },
	        {
	            // CreateAccount Data
	            "Freen", "Sarocha", "freensarocha@gmail.com", "01734556443", "sarocha1234", "sarocha1234",
	            // CheckoutProduct Data
	            "Freen", "Sarocha", "freensarocha@gmail.com", "Bagerhat", "Bagerhat Sadar", "01734556443"
	        }
	    };
	}

    @DataProvider(name = "combinedLoginCheckoutData")
    public static Object[][] combinedDataSet2() {
        return new Object[][] {
            { 
            	//Login Data
            	"plengorm@gmail.com", "pleng1234", 
               //Checkout Login Data
            	"01630189022", "plengorm@gmail.com"   
            },
            
               
            { 
            	//Checkout Login Data
            	"wanwiwa@gmail.com", "wan1234", 
            	"01987666789", "wanwiwa@gmail.com"
            }
        };
    }
    
    
    
    
    
    
    
    
    

//	@DataProvider(name = "createAccountData")
//	public static Object createAccountDataSet() {
//		
//		Object[][] obj = {
//				
//				{"Tabitha", "Jones", "tabithajones@hotmail.com", "01682333768", "tabitha1234", "tabitha1234"},
//				{"Jeffery", "Miller", "millerjeffery@gmail.com", "01783555098", "miller1234", "miller"} 
//				};
//		return obj;
//
//	}

	
//	@DataProvider(name = "checkoutProductData")
//	public static Object checkoutProductDataSet() {
//		Object[][] obj = { 
//				
//				{"Carol", "Smith", "carolsmith@hotmail.com", "Dhaka", "Rayerbazar, Dhanmondi", "01682333768"},
//				{"Jeffery", "Miller", "millerjeffery@gmail.com", "Bagerhat", "Bagerhat Sadar", "01783555098"} 
//				};
//		return obj;
//
//	}
    
//    @DataProvider(name = "loginData")
//    public static Object[][] loginAccountDataSet() {
//        return new Object[][] { 
//            { "labibarahman@gmail.com", "labiba1234"},
//            { "samihakabir@hotmail.com", "samiha1234"} 
//        };
//    }
//
//    @DataProvider(name = "checkoutProductLoginData")
//    public static Object[][] checkoutProductLoginDataSet() {
//        return new Object[][] { 
//            { "01832781244", "labibarahman@gmail.com"},
//            { "01756234098", "samihakabir@hotmail.com"}  
//        };
//    }
//	



}
