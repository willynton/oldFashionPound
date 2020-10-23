package test;


import org.junit.Assert;

import junit.framework.TestCase;
import oldFashionPound.UkOldPrice;
import oldFashionPound.UkOldPriceCalculator;
import oldFashionPound.UkOldPriceWithReminder;



public class UkOldPriceTest extends TestCase{
	
    public void testSum(){
        UkOldPrice priceA = new UkOldPrice(5,17,8);
        UkOldPrice priceB = new UkOldPrice(3,4,10);
        UkOldPrice priceExpected = new UkOldPrice(9,2,6);
        Assert.assertEquals(priceExpected, UkOldPriceCalculator.sum(priceA,priceB));
    }
    
    public void testSumComm(){
        UkOldPrice priceA = new UkOldPrice(7,15,8);
        UkOldPrice priceB = new UkOldPrice(1,4,2);
        UkOldPrice priceExpected = new UkOldPrice(8,19,10);
        Assert.assertEquals(priceExpected, UkOldPriceCalculator.sum(priceA,priceB));
        Assert.assertEquals(priceExpected, UkOldPriceCalculator.sum(priceB,priceA));
    }
    
    public void testSubstration(){
        UkOldPrice priceA = new UkOldPrice(5,17,8);
        UkOldPrice priceB = new UkOldPrice(3,4,10);
        UkOldPrice priceExpected = new UkOldPrice(2,12,10);
        Assert.assertEquals(priceExpected, UkOldPriceCalculator.substration(priceA, priceB));
    }
    
    public void testSubstrationNeg(){
        UkOldPrice priceA = new UkOldPrice(2,12,10);
        UkOldPrice priceB = new UkOldPrice(5,17,8);
        UkOldPrice priceExpected = new UkOldPrice(-3,4,10);
        
        Assert.assertEquals(priceExpected, UkOldPriceCalculator.substration(priceA, priceB));
    }
    
    public void testMultiplication(){
        UkOldPrice priceA = new UkOldPrice(5,17,8);
        int multiplicator = 2;
        UkOldPrice priceExpected = new UkOldPrice(11,15,4);
        
        Assert.assertEquals(priceExpected, UkOldPriceCalculator.multiplication(priceA, multiplicator));
    }
    
    public void testMultiplicationNeg(){
        UkOldPrice priceA = new UkOldPrice(5,17,8);
        int multiplicator = -2;
        UkOldPrice priceExpected = new UkOldPrice(-11,15,4);
        
        Assert.assertEquals(priceExpected, UkOldPriceCalculator.multiplication(priceA, multiplicator));
    }
    
    public void testDivision1(){
        UkOldPrice priceA = new UkOldPrice(5,17,8);
        int divisor = 3;
        UkOldPriceWithReminder priceExpected = new UkOldPriceWithReminder(1,19,2, 0, 2);
        
        Assert.assertEquals(priceExpected, UkOldPriceCalculator.division(priceA, divisor));
    }
    
    public void testDivision2(){
        UkOldPrice priceA = new UkOldPrice(18,16,1);
        int divisor = 15;
        UkOldPriceWithReminder priceExpected = new UkOldPriceWithReminder(1,5,0, 1, 1);
        
        Assert.assertEquals(priceExpected, UkOldPriceCalculator.division(priceA, divisor));
    }
    
    public void testValidatorUkOldPrice1(){
        String strPriceA = new String("  5p   17s   2d  ");
        boolean resultExpected = true;
        
        Assert.assertEquals(resultExpected, UkOldPriceCalculator.validatorUkOldPrice(strPriceA));
    }
    
    public void testValidatorUkOldPrice2(){
        String strPriceA = new String("5p 177s 8d");
        boolean resultExpected = false;
        
        Assert.assertEquals(resultExpected, UkOldPriceCalculator.validatorUkOldPrice(strPriceA));
    }
  
    public void testValidatorArg2Sum(){
        String strArg2 = new String("+");
        boolean resultExpected = true;
        
        Assert.assertEquals(resultExpected, UkOldPriceCalculator.validatorArg2(strArg2));
    }  
    
    public void testValidatorArg2Substration(){
        String strArg2 = new String("-");
        boolean resultExpected = true;
        
        Assert.assertEquals(resultExpected, UkOldPriceCalculator.validatorArg2(strArg2));
    } 
    
    public void testValidatorArg2Multiplication(){
        String strArg2 = new String("x");
        boolean resultExpected = true;
        
        Assert.assertEquals(resultExpected, UkOldPriceCalculator.validatorArg2(strArg2));
    } 
    
    public void testValidatorArg2Multiplication2(){
        String strArg2 = new String(" x ");
        boolean resultExpected = true;
        
        Assert.assertEquals(resultExpected, UkOldPriceCalculator.validatorArg2(strArg2));
    }
       
    public void testValidatorArg2Division(){
        String strArg2 = new String("/");
        boolean resultExpected = true;
        
        Assert.assertEquals(resultExpected, UkOldPriceCalculator.validatorArg2(strArg2));
    }
    
    public void testValidatorArg2Division2(){
        String strArg2 = new String("%");
        boolean resultExpected = false;
        
        Assert.assertEquals(resultExpected, UkOldPriceCalculator.validatorArg2(strArg2));
    }
    //*******************************************************
    public void testUkOldPrice1(){
        UkOldPrice priceExpected = new UkOldPrice(0,0,0);

        Assert.assertEquals(priceExpected, new UkOldPrice());
    }
    
    public void testUkOldPrice2(){
        UkOldPrice priceExpected = new UkOldPrice(5,17,8);

        Assert.assertEquals(priceExpected, new UkOldPrice(1412));
    }
     
    public void testUkOldPrice3(){
        UkOldPrice priceExpected = new UkOldPrice(5,17,8);

        Assert.assertEquals(priceExpected, new UkOldPrice("5p 17s 8d"));
    }  
    
    public void testUkOldPriceToString(){
        String strExpected = new String("5p 17s 8d");
        Assert.assertEquals(strExpected, (new UkOldPrice(5,17,8)).toString());
    }    
    //*******************************************************   
    public void testUkOldPriceReminder1(){
        UkOldPriceWithReminder priceExpected = new UkOldPriceWithReminder(0,0,0);

        Assert.assertEquals(priceExpected, new UkOldPriceWithReminder());
    }  
    
    public void testUkOldPriceReminder2(){
        UkOldPriceWithReminder priceExpected = new UkOldPriceWithReminder(0,0,0,0,0);

        Assert.assertEquals(priceExpected, new UkOldPriceWithReminder());
    } 
    
    public void testUkOldPriceReminder3(){
        UkOldPriceWithReminder priceExpected = new UkOldPriceWithReminder(0,0,0,0,0);

        Assert.assertEquals(priceExpected, new UkOldPriceWithReminder(new UkOldPrice()));
    }  
    
    public void testUkOldPriceReminder4(){
        UkOldPriceWithReminder priceExpected = new UkOldPriceWithReminder(5,17,8,0,0);

        Assert.assertEquals(priceExpected, new UkOldPriceWithReminder(new UkOldPrice(5,17,8)));
    } 
    
    public void testUkOldPriceReminder5(){
        UkOldPriceWithReminder priceExpected = new UkOldPriceWithReminder(1,19,2,0,2);

        Assert.assertEquals(priceExpected, new UkOldPriceWithReminder(new UkOldPrice(1,19,2),2));
    }  
    
    public void testUkOldPriceReminder6(){
        UkOldPriceWithReminder priceExpected = new UkOldPriceWithReminder(1,5,0,1,1);

        Assert.assertEquals(priceExpected, new UkOldPriceWithReminder(new UkOldPrice(1,5,0),13));
    } 
    
    public void testUkOldPriceReminderToString(){
        String strExpected = new String("1p 5s 0d (1s 1d)");
        Assert.assertEquals(strExpected, (new UkOldPriceWithReminder(new UkOldPrice(1,5,0),13)).toString());
    }
    
}
