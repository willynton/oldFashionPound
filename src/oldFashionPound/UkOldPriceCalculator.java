package oldFashionPound;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UkOldPriceCalculator {
	
	public static void main(String[] args) {
        //for(int i = 0; i < args.length; i++) {
            //System.out.println(args[i]);
        //}
        
		//validatorUkOldPrice("5p  17s  8d");
		
        boolean arg1=false;
        boolean arg2=false;
        boolean arg3=false;
        
        if(args.length==3) {
            arg1=validatorUkOldPrice(args[0].toString());
            arg2=validatorArg2(args[1].toString());
            arg3=validatorArg3(args[2].toString(), args[1].toString());
        }

               
        if(arg1==false||arg2==false||arg3==false) { //sum and substration OK
        	System.out.println("Incompatible arguments");
        	System.out.println("usage:     oldFashionPound  Arg1     Arg2   Arg3");
        	System.out.println("example:   oldFashionPound \"5P 17s 8d\" + \"3p 4s 10d\"");
        	System.out.println("example:   oldFashionPound \"5P 17s 8d\" x 3");
        }else {
        	
    		
	    		UkOldPrice priceA = new UkOldPrice(args[0].toString());
	    		UkOldPrice priceB = new UkOldPrice();
	    		UkOldPrice priceResult = new UkOldPrice();
	    		
	        	
	        	switch(args[1].toString().trim()) 
	            { 
	                case "+": 
	                	priceB = new UkOldPrice(args[2].toString());
	                	priceResult=sum(priceA,priceB);
	                	System.out.println(priceA + " + " + priceB + " = " + priceResult);
	                    break; 
	                case "-": 
	                	priceB = new UkOldPrice(args[2].toString());
	                	priceResult=substration(priceA,priceB);
	                	System.out.println(priceA + " - " + priceB + " = " + priceResult);
	                    break; 
	                case "x": 
	                	int multiplicator=Integer.parseInt(args[2].toString().trim());
	                	priceResult=multiplication(priceA,multiplicator);
	                	System.out.println(priceA + " x " + multiplicator + " = " + priceResult);
	                    break; 
	                case "/": 
	                	int divisor=Integer.parseInt(args[2].toString().trim());
	                	priceResult=division(priceA,divisor);
	                	System.out.println(priceA + " / " + divisor + " = " + priceResult);
	                    break;  
	            } 
        }
        
      
	}
	
	 
	public static boolean validatorUkOldPrice(String str) {
		
		str= str.trim();
		String[] parts = str.toLowerCase().split(" ");
		String[] partsOK = new String[3];
		
		if(parts.length<3) {
        	return false; 
		}else {
			int j=0;
			for(int i =0; i<parts.length;i++) {
				if(!parts[i].trim().equals("")) {
					//partsOK[j]=parts[i].trim();
					j++;
				}	
			}
			
			if(j!=3) {
				return false; 
			}else {
				j=0;
				for(int i =0; i<parts.length;i++) {
					if(!parts[i].trim().equals("")) {
						partsOK[j]=parts[i].trim();
						j++;
					}	
				}
			}
			
			
			String pounds=partsOK[0].trim();
			String shillings=partsOK[1].trim();
			String pence=partsOK[2].trim();
			
		    Pattern pat = Pattern.compile("[0-9]p");   
		    Matcher mat = pat.matcher(pounds);
			
		    if(mat.find()){
		           //System.out.println("pounds valido");
		   	       pat = Pattern.compile("[0-9]s");   
			       mat = pat.matcher(shillings);
				   if(mat.find()){
			           //System.out.println("shillings valido");
			   	       pat = Pattern.compile("[0-9]d");   
				       mat = pat.matcher(pence);
					   if(mat.find()){
						   //System.out.println("pence valido");
						   
						   int penceInt=Integer.parseInt(pence.substring(0,pence.length()-1));
						   int shillingsInt=Integer.parseInt(shillings.substring(0,shillings.length()-1));
						   
						   if(penceInt<12 && shillingsInt<20)
							   return true;
						   else
							   return false; 
						   
					   }else {
				           //System.out.println("pence No Válido");
				           return false;
					   }
				       
				   }else {
				           //System.out.println("shillings No Válido");
				           return false;			    	
				   }
		    }else{
		           //System.out.println("pounds No Válido");
		           return false;
		        }  
		}
			
 

			

	}
	
	
	public static boolean validatorArg3(String arg3, String operator) {
		
		arg3= arg3.trim();
		operator=operator.trim();
		boolean result=false;
    	switch(operator) 
        { 
            case "+": 
            	if(validatorUkOldPrice(arg3))
            		result= true;
            	else
            		result= false;
                break; 
            case "-": 
            	if(validatorUkOldPrice(arg3))
            		result= true;
            	else
            		result= false;
                break;
            case "x": 
            	if(isInteger(arg3))
            		result= true;
            	else
            		result= false;
 
            case "/": 
            	if(isInteger(arg3) && Integer.parseInt(arg3)>0)
            		result= true;
            	else
            		result= false;
                break;  
        }
			
		return result;
			

	}
	
	
	public static boolean validatorArg2(String arg2) {
		String operation=arg2.trim();
		if(operation.equals("+")||operation.equals("-")||operation.equals("x")||operation.equals("/"))
			return true;
		else
			return false;
	}
	
	public static boolean isInteger(String s) {
		try
		{
			Integer.parseInt(s);
			// s is a valid integer
			return true;
		}
		catch (NumberFormatException ex)
		{
			return false;
		}
	}
	
	public static UkOldPrice sum(UkOldPrice priceA, UkOldPrice priceB) {
		
		int totalPence=priceA.getTotalPence()+priceB.getTotalPence();
		
		UkOldPrice resultPrice = new UkOldPrice(totalPence); 
		return resultPrice;
	}
	
	public static UkOldPrice substration(UkOldPrice priceA, UkOldPrice priceB) {
		
		int totalPence=priceA.getTotalPence()-priceB.getTotalPence();
		
		UkOldPrice resultPrice = new UkOldPrice(totalPence); 
		return resultPrice;
	}
	
	public static UkOldPrice multiplication(UkOldPrice priceA, int multiplicator) {
		
		int totalPence=priceA.getTotalPence()*multiplicator;
		
		UkOldPrice resultPrice = new UkOldPrice(totalPence); 
		return resultPrice;
	}
	
	public static UkOldPriceWithReminder division(UkOldPrice priceA, int divisor) {
		
		if (divisor<=0)
			throw new ArithmeticException("Argument 'divisor'  <= 0");
			
		int totalPence=priceA.getTotalPence();
		int reminder = totalPence % divisor;
		totalPence=(int)totalPence/divisor;
		
		UkOldPrice resultPriceInteger = new UkOldPrice(totalPence); 
		
		UkOldPriceWithReminder resultPriceWithReminder = new UkOldPriceWithReminder(resultPriceInteger, reminder); 
		return resultPriceWithReminder;
	}

	
}
