//Allison Ly
//CS1400, section 03
//Project 5 - Arithmetic Operations with Fractions
//April 1, 2021

import java.util.Scanner;
public class Fraction
{
   private int numerator;    
   private int denominator;
   static int created = 0;   //count total number of created fractions
   public Fraction()
   {
      numerator = 0;
      denominator = 1;
   }
   public Fraction(int num, int den)
   {
      checkCases(num, den);   //passes num and den to checkCases method
      created++;
   }
   private void checkCases(int num, int den)
   {
      int g; //for gcd check later
      if (den == 0)   //sets fraction to 0/1
      {
         System.out.println("denominator cannot be 0");
         System.out.println("the fraction is set to 0/1");
         numerator = 0;
         denominator = 1;
      }
      if (num == 0)   //sets fraction to 0/1
      {
         numerator = 0;
         denominator = 1;
      }
      if (num > 0 && den > 0)   //for when num and den are both positive #'s
      {
         g = gcd(num, den);     //passes to gcd method, then sets that # as g (common den)
         numerator = num / g;  
         denominator = den / g;
      }
      if (num < 0 && den < 0)   //for when num and den are both negative #'s
      {
         num = -num;            //makes num positive
         den = -den;            //makes den positive
         g = gcd(num, den);     //passes to gcd method, then sets that # as g (common den)
         numerator = num / g; 
         denominator = den / g;
      }
      if (num < 0 && den > 0)   //for when num is negative but den is positive #
      {
         num = -num;            //makes num positive (takes out the negative sign)
         g = gcd(num, den);     //passes to gcd method, then sets that # as g (common den)
         numerator = -(num / g);//puts the negative sign back to fraction (in front of num)
         denominator = den / g;
      }
      if (num > 0 && den < 0)   //for when num is positive but den is negative #
      {
         den = -den;            //makes den positive (takes out the negative sign)
         g = gcd(num, den);     //passes to gcd method, then sets that # as g (common den)
         numerator = -(num / g);//puts the negative sign back to fraction (in front of num)
         denominator = den / g;
      }
   }
   private int gcd(int num1, int num2)   //gcd check method
   {
      while (num1 != num2)
      {
         if(num1 > num2)
            num1 = num1 - num2;
         else
            num2 = num2 - num1;
      }
      return num1;
   }
   public Fraction add(Fraction fraction2)   //add fraction method
   {
      int newNum1 = numerator * fraction2.denominator;
      int newNum2 = fraction2.numerator * denominator;
      int commonDen = denominator * fraction2.denominator;
      int newNum = newNum1 + newNum2;
      return new Fraction(newNum, commonDen);
   }
   public Fraction subtract(Fraction fraction2)   //sub fraction method
   {
      int newNum1 = numerator * fraction2.denominator;
      int newNum2 = fraction2.numerator * denominator;
      int commonDen = denominator * fraction2.denominator;
      int newNum = newNum1 - newNum2;
      return new Fraction(newNum, commonDen);
   }
   public Fraction multiply(Fraction fraction2)   //multiply fraction method
   {
      int newNum = numerator * fraction2.numerator;
      int newDen = denominator * fraction2.denominator;
      return new Fraction(newNum, newDen);
   }
   public Fraction divide(Fraction fraction2)   //divide fraction method
   {
      int newNum = numerator * fraction2.denominator;
      int newDen = denominator * fraction2.numerator;
      return new Fraction(newNum, newDen);
   }
   public String toString()   //toString method
   {
      String str = numerator + "/" + denominator;
      return str;
   }
   public float printAsFloat()   //prints fraction as float method
   {
      float fraction = (float)numerator / (float)denominator;
      System.out.print(fraction);
      return fraction;
   }
   public static int numberOfFractions()   //method to return the number of fractions created
   {
      return created;
   }
   public static Fraction read()   //method that asks user for num and den input, then creates new fraction
   {
      int num, den;
      Scanner kb = new Scanner(System.in);
      System.out.print("enter an integer numerator: ");
      num = kb.nextInt();
      System.out.print("enter an integer denominator: ");
      den = kb.nextInt();
      Fraction createdFraction = new Fraction(num, den);
      return createdFraction;
   }
}
