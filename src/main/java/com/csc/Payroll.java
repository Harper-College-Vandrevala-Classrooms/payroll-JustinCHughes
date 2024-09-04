package com.csc;
import java.util.Scanner;

public class Payroll {
  // Implement your solution here!

  private static double UNION_FEES = 10.00;

  public static void main(String[] args) {
    
    // Welcome user and initialize variables
    System.out.print("Welcome to the Payroll Program!\n\n");
    double hours;
    int dependents;
    int insurance;
    int lifeInsurance;
    double pay;
    double net;
    double payRate;

    // Calls checkDouble to ensure hours input is a positive double
    hours = checkDouble("How many hours did you work this week? "
                    , "\nInput was invalid. Please input a positive number.\n");

    // Calls checkInt to make sure user input a positive integer
    dependents = checkInt("How many children do you have? "
                    , "\nInput was invalid. Please input a positive number.\n");
    
    if(dependents < 0)
    {
      dependents = 0;
    }

    payRate = checkDouble("What is your hourly rate? "
                    , "\nInput was invalid. Please input a positive number.\n");

    // Determines how much worker owes in insurance depending on dependents
    insurance = insuranceCost(dependents);

    // Calls lifeInsurance function for user to choose lifeInsurance amount
    lifeInsurance = lifeInsuranceSelection(dependents);

    // Calculates pay and overtime pay
    pay = grosspay(hours, dependents, payRate);

    // Prints out function's calculated paystub
    System.out.print("\nPayroll Stub:" +
            "\n\nHours:   " + String.format("%.2f", hours) +
            "\nRate:   $ " + String.format("%.2f", payRate) +
            "\nGross:   $ " + String.format("%.2f", pay) + 
            "\n\nSocSec:   $ " + String.format("%.2f", (pay * 0.06)) +
            "\nFedTax:   $ " + String.format("%.2f", (pay * 0.14)) +
            "\nStTax:   $ " + String.format("%.2f", (pay * 0.05)) +
            "\nUnion:   $ 10.00" +
            "\nIns:   $ " + String.format("%.2f", (float) insurance) +
            "\nLifeIns:   $ " + String.format("%.2f", (float) lifeInsurance) + "\n");

    net = pay - (pay * .25) - UNION_FEES - insurance - lifeInsurance;

    System.out.print("\nNet:   $ " + String.format("%.2f", net) +
            "\nThank you for checking your payroll." +
            "\nHave a nice day\n");
  }

  public static int checkInt(String checkString, String errorString)
  {
    Scanner checkIntScanner = new Scanner(System.in);
    int userInput = 0;

    // Prompts user using input string for an integer
    // Continues to run until user input an int of 0 or greater
    // Breaks out of loop once input meets parameters
    do {
      System.out.print(checkString);
      if (checkIntScanner.hasNextInt())
      {
        userInput = checkIntScanner.nextInt();
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
    } while (true);

    return userInput;
  }

  public static double checkDouble(String checkString, String errorString)
  {
    Scanner checkDoubleScanner = new Scanner(System.in);
    double userInput = 0;

    // Prompts user using input string for a double
    // Continues to run until user input a double of 0 or greater
    // Breaks out of loop once input meets parameters
    do { 
      System.out.print(checkString);
      if (checkDoubleScanner.hasNextDouble())
      {
        userInput = checkDoubleScanner.nextDouble();
        if(userInput >= 0)
        {
          break;
        }
        else
        {
          System.out.print(errorString);
          if(checkDoubleScanner.hasNextLine())
          {
            checkDoubleScanner.nextLine();
          }
        }
      }
      else
      {
        System.out.print(errorString);
        if(checkDoubleScanner.hasNextLine())
        {
          checkDoubleScanner.nextLine();
        }
      }
    } while (true);

    return userInput;
  }

  public static int lifeInsuranceSelection(int dependents)
  {
    int userInput = 0;

    do { 

      // Calls checkInt to prompt for life insurance plan selection
      // Notifies user on error that they must select 1, 2, 3 or 4
      // Continues to run do while loop until user makes selection from list
      // Also continues loop if user selects plan 4 with no children
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

    // Selects life insurance cost depending on inputs value
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

  public static int insuranceCost(int dependents)
  {
    if (dependents < 3)
    {
      return 15;
    }
    else
    {
      return 35;
    }
  }

  public static double grosspay(double hours, int dependents, double payRate)
  {
    if (hours > 40)
    {
      return (payRate * 40) + ((hours - 40) * 1.5 * payRate);
    }
    else
    {
      return (payRate * hours);
    }
  }
}