package com.csc;

public class PayrollObjectTest {
  // Implement your solution here!

  private double UNION_FEES = 10.00;

  public Integer lifeInsuranceSelection(int dependents, int userInput)
  {
    if(userInput < 0 || userInput > 4)
    {
      return null;
    }
    if(userInput == 4)
    {
      if(dependents == 0)
      {
        return null;
      }
    }

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

  public int insuranceCost(int dependents)
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

  public double grosspay(double hours, double payRate)
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