import java.util.*;
/**
 * Write a description of class GVdateTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GVdateTest
{
    public static void main (String []  args) {
        Scanner scnr = new Scanner(System.in);
        
        int errors = 0;
        System.out.println ("Testing begins");
        System.out.println ("=========================================");
        
        System.out.println ("Testing the default variables");
        //********** phase 1 testing ************

        // testing the default constructor 
        GVdate today = new GVdate();
        if (today.getMonth() != 10){
            System.out.println("month should be 10");
            errors++;
        }else{
            System.out.println ("getMonth() has passed :)");
        }
        
        if (today.getDay() != 12){
            System.out.println("day should be 12");
            errors++;
        }else{
            System.out.println ("getDay() has passed :)");
        }
        // TO DO: test the year
        if(today.getYear() != 2020){
            System.out.println("year should be 2020");
            errors++;
        }else{
            System.out.println ("getYear() has passed :)");
        }
        
        System.out.println ("=========================================");
        
        System.out.println ("Testing the constructor 2");
        // testing constructor 2
        GVdate theDay = new GVdate(1, 10, 1995);
        // TO DO: complete the checks for month, day and year
        System.out.println("Date using the overload method: " + theDay.toString());
        // testing setter methods 
        //testing setMonth
        // TO DO: complete the code to check for month
        // TO DO: finish testing setDay and setYear
        // TO DO: test the toString method
        
        System.out.println("Set the month to 8");
        theDay.setMonth(8);
        
        System.out.println("Set the day to 10");
        theDay.setDay(10);
        
        System.out.println("Set the year to 2020");
        theDay.setYear(2020);
        
        System.out.println("The new Date is: " + theDay.toString());
        
        System.out.println("Errors: " + errors);
        System.out.println ("Testing ends");
        
        System.out.println ("=========================================");
        
        System.out.println ("Testing the toString method by overloading");
        
        GVdate newDay = new GVdate("11/12/2020");
        System.out.println("The date is: " + newDay.toString());
        
        System.out.println ("=========================================");
        
        System.out.println("Today: " + newDay.toString());
        newDay.nextDay();
        System.out.println("Tomorrow: " + newDay.toString());
        newDay.nextDay();
        System.out.println("Next Day: " + newDay.toString());
        newDay.skipAhead(32);
        System.out.println("32 Days later: " + newDay.toString());
        
        System.out.println ("=========================================");
        System.out.println ("Testing leap year");
        
        System.out.println ("Is 1900 a leap year? " + newDay.isLeapYear(1900));
        System.out.println ("Is 2000 a leap year? " + newDay.isLeapYear(2000));
        
        System.out.println ("=========================================");
        System.out.println ("Testing my Birthday");
        
        System.out.println ("Is " + newDay + " my Birthday? " + newDay.isMyBirthday());
        
        System.out.println ("=========================================");
        System.out.println ("Testing equals");
        System.out.println ("Is " + newDay + " equal to 4/10/2015?:  " 
        + newDay.equals("4/10/2015"));
        System.out.println ("Is " + newDay + " equal to 6/22/1992?:  " 
        + newDay.equals("6/22/1992"));
        
        System.out.println ("=========================================");
        System.out.println ("Testing printing date formats");
        
        System.out.println ("Format 1: " + newDay.toString(1));
        System.out.println ("Format 2: " + newDay.toString(2));
        System.out.println ("Format 3: " + newDay.toString(3));
        System.out.println ("Format 4: " + newDay.toString(4));
        
    }  

}
