import java.text.DecimalFormat;
/**
 * This class has been created to keep track of a calendar date including
 * month, day and year. Here you can do simple things like checking if it
 * your birthday, advancing to the next day, checking if a given date
 * is valid and checking it is a leap year.
 *
 * @author (Murtaza Badshah)
 * @version (10/04/2020 - Start date)
 */
public class GVdate
{
    // month variable initialized
    private int month;
    // day variable initialized
    private int day;
    // year variable initialized
    private int year;
    // birth month initialized
    private int birthMonth = 8;
    // birth day initialzed
    private int birthDay = 18;

    /**
     * default constructor assigning the inital values to the instance 
     * variables
     */
    public GVdate()
    {
    
        // initialise instance variables of month, day and year.
        // Setting the month to 10
        month = 10; 
        // setting the day to 12
        day = 12; 
        //setting the day to 12
        year = 2020;
    
    }

    /**
     * This is the public method where we will set the instance variables
     * to the provided input parameters. Also added a condition to check
     * if the date is valid otherwise default the month, day and year
     * variables to the default values.
     *
     * @param  m  sample parameter of Month for the GVdate method
     * @param  d  sample parameter of day for the GVdate method
     * @param  y  sample parameter of year for the GVdate method
     * @return    the the values of month, day and year
     */
    public GVdate(int m, int d, int y)
    {
        if(isDateValid(m,d,y)) {
            //Assigning the input parameter m to the month variable.
            month = m;
            //Assigning the input parameter d to the day variable.
            day = d;
            //Assigning the input parameter y to the year variable.
            year = y;
        }
        else {
            /* If date is not valid then we will just set the date to
               the default values*/
               // Setting the month to 10
               month = 10;
               // Setting the day to 12
               day = 12; 
               // Setting the year to 2020.
               year = 2020;
        }
    }

    /**
     * This public method take the string input of the date such and
     * assigns the string value to the appropriate variable. The format
     * of the input parameter must be declared with a "/" such as 
     * "MM/DD/YYYY"
     *
     * @param  y  a sample parameter for the GVdate method
     * @return    the the values of month, day and year
     */
    public GVdate(String date)
    {
        /* We initialize the int variable and use indexOf to store the
        index value of the first "/" we find in the string value.*/
        int firstSlash = date.indexOf("/");
        /* We initialize the int variable and use lastIndexOf to store the
        index value of the last "/" we find in the string value.*/
        int thirdSlash = date.lastIndexOf("/");
        
        /* Using the substring method to pick the String value from Index
         * 0 to the Index with the "/" then applying the parse int to 
         * convert the Strin values into an integer.*/
        int secondMonth = Integer.parseInt (date.substring (0, firstSlash));
        
        /* Using the substring method to pick the String value from the
         * first instance of "/" + 1 to the second instance of "/"
         * then applying the parse int to convert the String 
         * values into an integer.*/
        int secondDay = Integer.parseInt (date.substring(firstSlash + 1,
        thirdSlash));
        
        /* Using the substring method to pick the String value from the
         * last instance of "/" + 1 to end of string and then using 
         * substring to convert the String values into an integer.*/
        int secondYear = Integer.parseInt (date.substring(thirdSlash + 1));
        
        /* Created an IF condition to check if the entered month, day and
         * year is valid. If they are then we will assign them to the 
         * month, day and year private variable. Else set it to the 
         * default values.
         */
        if(isDateValid(secondMonth, secondDay, secondYear)){
            //Assigning the input parameter secondMont to the month variable.
            month = secondMonth;
            //Assigning the input parameter secondDay to the day variable.
            day = secondDay;
            //Assigning the input parameter secondYear to the year variable.
            year = secondYear;
        }
        else {
            /* If date is not valid then we will just set the date to
               the default values*/
               // Setting the month to 10
               month = 10;
               // Setting the day to 12
               day = 12; 
               // Setting the year to 2020.
               year = 2020;
        }
    }

    /**
     * This public method takes Integer year value and checks if the 
     * year is a leap year based on a set of condition. Then returns a
     * boolean variable of True or False.
     *
     * @param  y  Year parameter is required as input.
     * @return    If the year is a leap year return true else false.
     */
    public boolean isLeapYear(int y)
    {
        // Created the IF that checks if year divided by 4 has no remainder then.
        if( (y % 4) == 0 )
        {
            // If year divided by 100 has no remainder then check..
            if((y % 100) == 0)
            {
                // if the year divided by 400 has no remainder then return true
                if((y % 400) == 0)
                {
                    return true;
                }
                // else return false if the abvove condition is not met.
                else
                {
                    return false;
                }
            }
            // Return false is the year divided by 100 has a remainder.
            else 
            {
                return true;
            }
        }
        // return false if the year divided by 4 has a remainder.
        else 
        {
            return false;
        }
    }

    /**
     * This private method takes Integer month and year value and returns
     * the last day of the month based on a set of conditions.
     *
     * @param  y  Year parameter is required as input.
     * @param  m  month parameter is required as input.
     * @return    The last day of the month.
     */
    private int getLastDayOfMonth(int m, int y)
    {
        // Created an if to check if the month value is 1,3,5,7,8,10 and 12.
        if(m == 1 || m == 3 || m == 5 ||
           m == 7 || m == 8 || m == 10 || m == 12)
        {
            // Return the last day as 31 if the above conditions are met.
            return 31;
        }
        // Else check if the month is 4,6,9 and 11.
        else if(m == 4 || m == 6 || m == 9 ||m == 11)
        {
            // Return 30 if the above conditions have been met.
            return 30;
        }
        // Else check if the Month is Feb and the year is a leap year.
        else if((m == 2) && (isLeapYear(y))){
            // Return 29 if the Month is feb and the year is a leap year.
            return 29;
        }
        // Else just return 28 if none of the above conditions are met.
        else 
        {
            return 28;
        }
    }
    
    /**
     * This private method takes Integer month, day and year value 
     * and check if conditions of validity are met then returns a True or
     * False value.
     *
     * @param  d  day parameter is required as input.
     * @param  m  month parameter is required as input.
     * @param  y  year parameter is required as input.
     * @return    True or False if the date is valid.
     */
    private boolean isDateValid(int m, int d, int y)
    {
        /* If year is greater than 0 and month is greater than 0 but less
         * 12 and day is greater than 0 and less that the last day of the
         * month then return true else return false.*/
        return y > 0 && m > 0 && m <= 12 && d > 0 && 
        d <= getLastDayOfMonth(m, y);
    }

    /**
     * This is the getMonth() accessor method to retrun the month.
     *
     * @return    Returns the month
     */
    public int getMonth(){
        return month; //return the month
    }

    /**
     * This is the getDay() accessor method to retrun the day.
     *
     * @return    Returns the day
     */
    public int getDay(){
        return day; // return the day
    }

    /**
     * This is the getYear() accessor method to retrun the year.
     *
     * @return    Returns the year
     */
    public int getYear(){
        return year; // return the year
    }

    /**
     * This is the toString() accessor method to retrun a formatted date
     * string.
     * 
     * @return    Returns formatted date string like MM/DD/YYYY
     */
    public String toString(){
        // return date in MM/DD/YYYY format.
        return month + "/" + day + "/" + year;
    }
    
    /**
     * This public method takes a singular integer value from 1 
     * to 4, utilizing a switch case statement to return the date in a
     * specified String format.
     *
     * @param  format  insert a value from 1 to 4 
     * @return    The date in a specific format.
     */
    public String toString(int format)
    {
        /* Start of the switch case statement taking Integer format as 
        the value. */
       switch(format) {
        // Case 1 returns the date in the regular date format MM/DD/YYYY
            case 1:
                return month + "/" + day + "/" + year;
                
                
        // Case 2 returns the date with a trailing unit for example 00/00/0000  
            case 2:
                String pattern = "00";
                DecimalFormat decimalFormat = new DecimalFormat(pattern);
                return decimalFormat.format(month) + "/" + 
                       decimalFormat.format(day) + "/" +
                       year;
                
        /* Case3 take the month value checks the String defined below 
           and outputs the month as a String such as jan, 10 2021*/
            case 3:
                String abbrev = "JanFebMarAprMayJunJulAugSepOctNovDec";
                return abbrev.substring(month * 3 - 3, month * 3) + " " 
                + day + ", " + year;
                
        /* Case4 is similar to case 3 but instead useses a nested switch
           case to display the whole Month name like so: January 10, 2020*/
            case 4:
                
                switch(month)
                {
                    case 1:
                    return "January" + " " + day + ", " + year;
                    
                    
                    case 2:
                    return "February" + " " + day + ", " + year;
                    
                    
                    case 3:
                    return "March" + " " + day + ", " + year;
                    
                    
                    case 4:
                    return "April" + " " + day + ", " + year;
                    
                    
                    case 5:
                    return "May" + " " + day + ", " + year;
                    
                    
                    case 6:
                    return "June" + " " + day + ", " + year;
                    
                    
                    case 7:
                    return "July" + " " + day + ", " + year;
                    
                    
                    case 8:
                    return "August" + " " + day + ", " + year;
                    
                    
                    case 9:
                    return "September" + " " + day + ", " + year;
                    
                    
                    case 10:
                    return "October" + " " + day + ", " + year;
                    
                    
                    case 11:
                    return "November" + " " + day + ", " + year;
                    
                    
                    case 12:
                    return "December" + " " + day + ", " + year;
                    
                  
                    default:
                    return "Error please try again";
                    
                
                }
            /* the value is not specified between 1 and 4 then we display
            this error message. */
            default:
                return "Error please try again";
                
            }
    }
    
    /**
     * This public method outputs next day. It also checks if a day
     * goes beyond the specified month then it updates the month and day 
     * to the new parameter accordinly. This also updates the year is the
     * month value goes beyond 12.
     *
     * @return    The day after passing some conditions.
     */
    public void nextDay()
    {
        // checking if day is equal to the last day of month
        if(day == getLastDayOfMonth(month, year)){
            //assigning the day as one to update it to the next day.
            day = 1;
            
            //Checking if the month is 12
            if(month == 12)
            {
                // then we set the month as one and increment the year.
                month = 1;
                year++;
            }
            // otherwise we just increment the month by 1
            else 
            {
                month++;
            }
        }
        // if day is not equal to last day of month then we increment the day.
        else
        {
            day++;
        }
        
    }
    
    /**
     * This public method checks if the date entered matches the date that
     * is stored in the private variables. It returns true if it passes 
     * otherwise it returns a false.
     *
     * @param  otherDate  include a date value in the MM/DD/YYYY format.
     * @return    True or false if the conditions are met.
     */
    public boolean equals(GVdate otherDate)
    {
        /*check if the month, day and year stored in the private variables
           match the entered date.*/
        if(month == otherDate.month && day == otherDate.day && year ==
           otherDate.year)
        {
            // returns true is conditions are met
            return true;
        }
        else
        {
            // returns false if they dont.
            return false;
        }
    }
    
    /**
     * This public method take the user input of the number of days and
     * then runs a while loop on the nextDay method to output the date
     * after the specific number of days entered.
     *
     * @param  numDays  takes a positive integer value as input.
     * @return    The day after running the while loop n number of times.
     */
    public void skipAhead(int numDays)
    {
      // initilaized the i value for the loop
      int i = 0;
      // created an if to check if numDays is positive int value
      if(numDays > 0)
      {
          // Created the while loop to run as long as i is less than numDays.
          while(i < numDays)
          {
          // runs the nextday() method in every loop.
          nextDay();
          /* increments i so that it will eventually not meet the condition 
          and stop the loop*/
          i++;
          }
      }
      
    }   
    
    /**
     * This is the isMyBirthday() accessor method to retrun a boolean 
     * value to check if it is my Birthday or not and return T or F
     * 
     * @return    Returns True or False based on the condition
     */
    public boolean isMyBirthday(){
        // returns the true if my month and day match. else false.
        return (month == birthMonth) && (day == birthDay);
    }

    /*The following setter methods assign the input variables to the 
       private variables.**/
    
    /**
     * This setter method doesnt return any value but instead assigns the
     * month by running a check using an if condition.
     *
     * @param  m  Month input value.
     */
    public void setMonth(int m){
        // Check if the date entered is valid. Then assigns the new month
        if( isDateValid(m, day, year))
        {
            month =  m;
        }
        else 
        {
            // otherwise print the following statement.
            System.out.println("Invalid month! please try again!");
        }
    }

    /**
     * This setter method doesnt return any value but instead assigns the
     * day by running a check using an if condition.
     *
     * @param  d  day input value.
     */
    public void setDay(int d){
        // Check if the date entered is valid. Then assigns the new day
        if(isDateValid(month, d, year))
        {
            day = d;
        }
        else 
        {
            // otherwise print the following statement.
            System.out.println("Invalid day! please try again!");
        }
    }   

    /**
     * This setter method doesnt return any value but instead assigns the
     * year by running a check using an if condition.
     *
     * @param  y  Year input value.
     */
    public void setYear(int y){
        // Check if the date entered is valid. Then assigns the new day
        if(isDateValid(month, day, y))
        {
            year = y;
        }
        else
        {
            // otherwise print the following statement.
            System.out.println("Invalid year! please try again!");
        }
    }

    /**
     * This setter method doesnt return any value but instead assigns the
     * date by running a check using an if condition.
     *
     * @param  m  Month input value.
     * @param  d  day input value.
     * @param  y  year input value.
     */
    public void setDate(int m, int d, int y){
        // Check if the date entered is valid. Then assigns the new day, month and year
        if(isDateValid(m, d, y)) {
            month = m;
            day = d;
            year =  y;
        }
        else
        {
            // otherwise print the following statement.
            System.out.println("Invalid Date! please try again!");
        }
    }
}