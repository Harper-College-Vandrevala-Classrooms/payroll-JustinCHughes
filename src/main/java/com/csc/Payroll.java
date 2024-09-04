package com.csc;
import java.util.Scanner;

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

  public static void main(String[] args) {
    try (Scanner hours = new Scanner(System.in)) {
      Payroll payroll = new Payroll();
      double pay;
      System.out.println("Welcome to the Payroll Program!!");
      System.out.println("Enter hom many hours in decimal form you worked and the number of children you have:");
      double time = hours.nextInt();
      int family = hours.nextInt();
      if (family < 0)
        family = -(family);
      // asking for a custom rate
      System.out.print("what is your pay rate?\n");
      pay = hours.nextDouble();
      // payroll text layout seperate from calculations for ease of use in
      // methods
      System.out.print("Payroll Stub\n\n\n");
      System.out.print("Hours you worked:  " + time + "\n");
      System.out.print("Your current rate: " + pay + " $/hr \n");
      System.out.print("Your Total pay:    $ " + payroll.grosspay(time, family, pay) + "\n\n");
      System.out.print(payroll.expenses(payroll.grosspay(time, family, pay), family));
    }
    System.out.print("thank you for loging your hours with us!!\n\n");
  }

  public double grosspay(double time, int children, double pay) {
    //the raw calcuated payout
    double grosspay;
    if (time > 40) {
      double overtime = time - 40;
      grosspay = (time - overtime) * pay;
      grosspay += (1.5 * overtime * pay);
    } else
      grosspay = pay * time;
    return grosspay;
  }

  public String expenses(double money, int child) {
    double SS = money * .06;
    double FedIn = money * .14;
    double StateIn = money * .05;
    double union = 10.00;
    double Ins;
    if (child >= 3)
      Ins = 35.00;
    else
      Ins = 15.00;
    // validation for too little funds and if so the output of the function
    // is switched to a different formatted string along with a dedicated
    // output
    if (money < 60) {
      double total = money - SS - FedIn - StateIn;
      System.out.print(String.format(
          "Expenses:\n\nSS:                $ %.2f\nFedIn:             $ %.2f\nStateIn:           $ %.2f\nnet:               $ %.2f\n\n\n",
          SS, FedIn, StateIn, total));
      return String.format("You still owe:\n\nUnion:             $ %.2f\nIns:               $ %.2f\n\n", union, Ins);
    }
    double total = money - SS - FedIn - StateIn - union - Ins;
    return String.format(
        "Expenses:\n\nSS:                $ %.2f\nFedIn:             $ %.2f\nStateIn:           $ %.2f\nUnion:             $ %.2f\nIns:               $ %.2f\n\nNet:               $ %.2f\n\n\n",
        SS, FedIn, StateIn, union, Ins, total);
  }
}