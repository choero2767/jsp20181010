package kr.or.ddit.calculation;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculationLogicTest {

	// 1~10 사이의 합계
	@Test
	public void sumBetweenTwoNumbers() {
		int sumResult = new CalculationLogic().sumBetweenTwoNumbers(10, 1);
		
		assertEquals(55, sumResult);
	}
	
	@Test
	public void sumBetweenTwoNumbers2(){
		int sumResult = new CalculationLogic().sumBetweenTwoNumbers(1+2, 10+2);
		
		assertEquals(75, sumResult);
	}
}
