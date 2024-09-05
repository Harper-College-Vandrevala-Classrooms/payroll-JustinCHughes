package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPayroll {

  Payroll payroll;

  @BeforeEach
  void setUp() {
    payroll = new Payroll();
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
}
