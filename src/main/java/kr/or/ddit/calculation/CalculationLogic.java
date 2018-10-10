package kr.or.ddit.calculation;

public class CalculationLogic {

	public static void main(String[] args) {
		int sumResult = new CalculationLogic().sumBetweenTwoNumbers(1, 10);
		
		if(sumResult == 55){
			System.out.println("정답");
		} else{
			System.out.println("오답");
		}
	}
	
	public int sumBetweenTwoNumbers(int start, int end) {
		int min = Math.min(start, end);
		int max = Math.max(start, end);
		
		int sum = 0;
		for(int i=min; i<=max;i++){
			sum += i;
		}
		return sum;
	}
	
}
