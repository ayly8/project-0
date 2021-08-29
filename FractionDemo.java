//Allison Ly
//CS1400, section 03
//Project 5 - Arithmetic Operations with Fractions
//April 1, 2021

import java.util.Scanner;
public class FractionDemo
{
   public static void main(String[] args)
   {
      String input;
      Scanner kb = new Scanner(System.in);
      Fraction f1;   //creates Fraction variable
      Fraction f2;   //creates Fraction variable
      do
      {
         System.out.println("Please enter 2 fractions --");
         System.out.println("Fraction 1:");
         f1 = Fraction.read();   //calls read method, and sets the user inputs for f1
         System.out.println("Fraction 2:");
         f2 = Fraction.read();   //calls read method, and sets the user inputs for f2

         Fraction f3 = f1.add(f2);   //calls add method
         System.out.print(f1 + " + " + f2 + " = " + f3 + " = ");  //displays added fraction
         f3.printAsFloat();   //displays added fraction as a float
         System.out.println();

         Fraction f4 = f1.subtract(f2);   //calls subtraction method
         System.out.print(f1 + " - " + f2 + " = " + f4 + " = ");   //displays subtracted fraction
         f4.printAsFloat();   //displays subtracted fraction as a float
         System.out.println();

         Fraction f5 = f1.multiply(f2);   //calls multiplication mathod
         System.out.print(f1 + " * " + f2 + " = " + f5 + " = ");   //displays multiplied fraction
         f5.printAsFloat();   //displays multiplied fraction as a float
         System.out.println();

         Fraction f6 = f1.divide(f2);   //calls division method
         System.out.print(f1 + " / " + f2 + " = " + f6 + " = ");   //displays divided fraction
         f6.printAsFloat();   //displays divided fraction as a float
         System.out.println();

         System.out.println();
         System.out.print("Do you want to continue"   //ask user if want to continue
                          + "('Y' or 'y' for yes)? ");
         input = kb.nextLine();
      }while(input.charAt(0) == 'Y' || input.charAt(0) == 'y');

      System.out.println(Fraction.numberOfFractions()
                         + " fractions have been created."); //displays number of fractions created
   }
}
