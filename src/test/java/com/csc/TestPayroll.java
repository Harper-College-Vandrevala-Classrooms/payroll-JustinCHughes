package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPayroll {

  PayrollObjectTest payroll;

  @BeforeEach
  void setUp() {
    payroll = new PayrollObjectTest();
  }

  @Test
  public void fullweek() {
    assertEquals(671.2, payroll.grosspay(40, 16.78));
  }

  @Test
  public void fullweek50Sal() {
    assertEquals(2000, payroll.grosspay(40, 50));
  }

  @Test
  public void fullweek50Sal41Hours() {
    assertEquals(2075, payroll.grosspay(41, 50));
  }

  @Test
  public void testInsuranceCostNeg1() {
    assertEquals(15, payroll.insuranceCost(-1));
  }

  @Test
  public void testInsuranceCost0() {
    assertEquals(15, payroll.insuranceCost(0));
  }

  @Test
  public void testInsuranceCost3() {
    assertEquals(35, payroll.insuranceCost(3));
  }

  @Test
  public void testlifeInsuranceNeg1() {
    assertEquals(null, payroll.lifeInsuranceSelection(0, -1));
  }

  @Test
  public void testlifeInsurance4NoKid() {
    assertEquals(null, payroll.lifeInsuranceSelection(0, 4));
  }

  @Test
  public void testlifeInsurance4WithKid() {
    assertEquals(15, payroll.lifeInsuranceSelection(1, 4));
  }

  @Test
  public void testlifeInsurance3() {
    assertEquals(10, payroll.lifeInsuranceSelection(0, 3));
  }

  @Test
  public void testlifeInsurance2() {
    assertEquals(5, payroll.lifeInsuranceSelection(0, 2));
  }

  @Test
  public void testlifeInsurance1() {
    assertEquals(0, payroll.lifeInsuranceSelection(0, 1));
  }
}
