package com.csc;
import java.util.Scanner;

public class Payroll {
  // Implement your solution here!

  private static float UNION_FEES = (float) 10.00;
  private static float PAY_RATE = (float) 16.78;

  public static void main(String[] args) {
        
    System.out.print("Welcome to the Payroll Program!\n\n");
    float hours;
    int dependents;
    int insurance;
    int lifeInsurance;
    float pay;
    float net;

    hours = checkFloat("How many hours did you work this week? "
                    , "\nInput was invalid. Please input a positive number.\n");
    dependents = checkInt("How many children do you have? "
                    , "\nInput was invalid. Please input a positive number.\n");

    if (dependents < 3)
    {
      insurance = 15;
    }
    else
    {
      insurance = 35;
    }

    lifeInsurance = lifeInsuranceSelection(dependents);

    if (hours > 40)
    {
      pay = (float) PAY_RATE * 40;
      pay = pay + ((hours - 40) * (float) 1.5 * (float) PAY_RATE);
    }
    else
    {
      pay = hours * (float) PAY_RATE;
    }

    System.out.print("\nPayroll Stub:");
    System.out.print("\n\nHours:   " + String.format("%.2f", hours));
    System.out.print("\nRate:   16.75 $/hr");
    System.out.print("\nGross:   $ " + String.format("%.2f", pay));

    System.out.print("\n\nSocSec:   $ " + String.format("%.2f", (pay * (float) 0.06)));
    System.out.print("\nFedTax:   $ " + String.format("%.2f", (pay * (float) 0.14)));
    System.out.print("\nStTax:   $ " + String.format("%.2f", (pay * (float) 0.05)));
    System.out.print("\nUnion:   $ 10.00");
    System.out.print("\nIns:   $ " + String.format("%.2f", (float) insurance)); // Needs logic
    System.out.print("\nLifeIns:   $ " + String.format("%.2f", (float) lifeInsurance));

    net = pay - (pay * (float) .25) - UNION_FEES - insurance - lifeInsurance;

    System.out.print("\nNet:   $ " + String.format("%.2f", net));
  }

  public static int checkInt(String checkString, String errorString)
  {
    Scanner checkIntScanner = new Scanner(System.in);
    int userInput = 0;

    do {
      System.out.print(checkString);
      if (checkIntScanner.hasNextInt())
      {
        userInput = checkIntScanner.nextInt();
        if(userInput >= 0)
        {
          break;
        }
        else
        {
          System.out.print(errorString);
          if(checkIntScanner.hasNextLine())
          {
            checkIntScanner.nextLine();
          }
        }
      }
      else
      {
        System.out.print(errorString);
        if(checkIntScanner.hasNextLine())
        {
          checkIntScanner.nextLine();
        }
      }
    } while (true);

    return userInput;
  }

  public static float checkFloat(String checkString, String errorString)
  {
    Scanner checkFloatScanner = new Scanner(System.in);
    float userInput = 0;

    do { 
      System.out.print(checkString);
      if (checkFloatScanner.hasNextFloat())
      {
        userInput = checkFloatScanner.nextFloat();
        if(userInput >= 0)
        {
          break;
        }
        else
        {
          System.out.print(errorString);
          if(checkFloatScanner.hasNextLine())
          {
            checkFloatScanner.nextLine();
          }
        }
      }
      else
      {
        System.out.print(errorString);
        if(checkFloatScanner.hasNextLine())
        {
          checkFloatScanner.nextLine();
        }
      }
    } while (true);

    return userInput;
  }

  public static int lifeInsuranceSelection(int dependents)
  {
    int userInput = 0;

    do { 
      userInput = checkInt("""
                           Which life insurance plan do you want to select?
                           
                             (1) no plan
                             (2) single plan
                             (3) married plan
                             (4) married with children plan
                           ""","\nInvalid input. Input must be '1','2', '3' or '4'.\n");
      if(userInput > 0 && userInput <= 3)
      {
        break;
      }
      else if(userInput == 4)
      {
        if(dependents == 0)
        {
          System.out.print("""
                           Invalid input. You need at least one child to select plan 4.
                           Please select a different plan""");
        }
        else
        {
          break;
        }
      }
      else
      {
        System.out.print("\nInvalid input. Input must be '1','2', '3' or '4'.\n");
      }
    } while (true);

    switch (userInput)
    {
      case 1:
        return 0;
      case 2:
        return 5;
      case 3:
        return 10;
      case 4:
        return 15;
    }
  return 0;
  }
}
