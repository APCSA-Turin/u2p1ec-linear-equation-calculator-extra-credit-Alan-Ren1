package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below

        //INSTANCE VARIABLES 
        //4 INTEGER variables (name them: x1,x2,y1,y2) 
        private int x1;
        private int x2;
        private int y1;
        private int y2;
    
        //CONSTRUCTOR
        //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
        //For example, "(1,2)" and "(3,4)" would be two parameter values 
        //You will have to parse the string into 4 integers, representing the 2 points.
        public LinearCalculator(String point1, String point2){ // <--add 2 string parameters to this constructor
          x1 = Integer.parseInt(point1.substring(point1.indexOf("(") + 1, point1.indexOf(",")));                    //setting all points to corresponding integers 
          y1 = Integer.parseInt(point1.substring(point1.indexOf(",") + 1, point1.indexOf(")")));
          x2 = Integer.parseInt(point2.substring(point2.indexOf("(") + 1, point2.indexOf(",")));
          y2 = Integer.parseInt(point2.substring(point2.indexOf(",") + 1, point2.indexOf(")")));
        }
    
        //METHODS
        //getters and setters for the 4 instance variables (8 methods total) 
        public int getX1() {
            return x1;
        }
        public int getY1() {
            return y1;
        }
        public int getX2() {
            return x2;
        }
        public int getY2() {
            return y2;
        }
        public void setX1(int x1) {
            this.x1 = x1;
        }
        public void setY1(int y1){
            this.y1 = y1;
        }
        public void setX2(int x2){
            this.x2 = x2;
        }
        public void setY2(int y2){
            this.y2 = y2;
        }
    
        //distance() -> returns a double. 
        //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
        public double distance(){
            double delta_x = x2-x1;
            double delta_y = y2-y1;
            double distanceFormula = Math.sqrt(Math.pow(delta_x, 2) + Math.pow(delta_y, 2));        //distance formula 
            double roundedFormula = Math.round(distanceFormula * Math.pow(10, 2))/ Math.pow(10, 2);     //rounded distance formula 
            return roundedFormula;
        }
        //yInt() -> returns a double.
        //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
        //if y-int if undefined, should return -999.99
        public double yInt(){
            if (slope() == -999.99) {
                return -999.99;
            }
            double formula = -1 * ((slope() * x1) - y1);            //y intercept equation 
            double roundedFormula = Math.round(formula * Math.pow(10, 2))/ Math.pow(10, 2);         //rounded y intercept 
            return roundedFormula;                     
        }
    
        //slope() -> returns a double. 
        //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
        //if slope is undefined, should return -999.99
        public double slope(){
            if ((x2 - x1) == 0) {
                return -999.99;
            }
            double delta_x = x2 - x1;                   //finding delta x
            double delta_y = y2 - y1;               //finding delta y
            double slope = delta_y /delta_x;             //slope
            double roundedSlope = Math.round(slope * Math.pow(10, 2))/ Math.pow(10, 2);            //rounded slope
            return roundedSlope;
        }
    
        //equations() -> returns a String.
        //calculates the final equation in y=mx+b form and returns the string
        //if the equation has no slope, the equation should return -> "undefined"
        //HINT: You may need other custom methods to decrease the amount of code in the equations() method
        public String equation(){
            if (slope() == -999.99) {               //if no slope then undefined 
                return "undefined";
            }
            if (yInt()== 0.0) {             //if y intercept then return slope only 
                return "y=" + slope() + "x";
            }
            if (slope() == 0.0) {                       //if no slope then return the y intecept only
                return "y=" + yInt();
            }
            if (yInt() >= 0) {
            String finalEquation = "y=" + slope() + "x+" + yInt();                  //final equation if y intercept is positive 
            return finalEquation;
            }
            else {
                return "y=" + slope() + "x" + yInt();                           //final equation if y intecept is negative 
            }
        }
    
    
        //roundedToHundredth(double x)-> returns double
        //calculates the input to the nearest hundredth and returns that value
        public double roundedToHundredth(double x){
            x = Math.round(x * 100.0) / 100.0;                  //rounded to the hundredth
            return x;
        }

    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1 + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry();
        str += "\n" + Midpoint();
 
        return str;


    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        if (x2 == -1 * x1 && y2 == -1 * y1) 
            return "Symmetric about the origin";
        else if (x2 == -1 * x1 || y2 == -1 * y1) 
        if (x2 == -1 * x1) {
            return "Symmetric about the y-axis";
        }
        if (y2 == -1 * y1) 
            return "Symmetric about the x-axis";
    

        else 
            return "No symmetry";
        
    
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        double xval = x1 + x2;
        double yval = y1 + y2;
        double midpointX = xval / 2;
        double midpointY = yval / 2;
        return "The midpoint of this line is: (" + midpointX + "," + midpointY + ")";
    }

        public static void main(String[] args) {
            LinearCalculator c2 = new LinearCalculator("(1,2)","(-1,-2)");
            System.out.println(c2.printInfo());
            System.out.println();
            LinearCalculator c3 = new LinearCalculator("(3,4)","(3,-4)");
            System.out.println(c3.printInfo());
            System.out.println();
            LinearCalculator c33 = new LinearCalculator("(-3,-1)","(4,-3)");
            System.out.println(c33.printInfo());
            System.out.println();
            LinearCalculator c4 = new LinearCalculator("(1,2)","(3,4)");
            System.out.println(c4.printInfo());
            System.out.println();
            LinearCalculator c5= new LinearCalculator("(-1,-2)","(5,10)");
            System.out.println(c5.printInfo());
         
        }
    
}



