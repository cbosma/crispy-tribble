import java.util.Random;
//testpush

public class Bank {
	
	public MoneyOrder[] moneyOrderArrayFromCustomer = null;
	public String[][] uniqueness = new String[100][3];
	public double moneyOrderValue;
	public boolean matchingAmounts = true;
	public boolean isUnique;
	public int moneyOrderSelector;
	private String signature = "1234567890ABCDEFG";
	
	
	public Bank(MoneyOrder[] moneyOrderArray){
		
		moneyOrderArrayFromCustomer = moneyOrderArray;
		
		Random randomSelector = new Random();
        moneyOrderSelector = randomSelector.nextInt(100);
	}
	
	public boolean checkValue(){
		moneyOrderValue = moneyOrderArrayFromCustomer[0].value;
		int counter = 0;
		while(matchingAmounts == true && counter < moneyOrderArrayFromCustomer.length){
			if(moneyOrderValue != moneyOrderArrayFromCustomer[counter].value)
				matchingAmounts = false;
			counter++;
		}
		return matchingAmounts;
	}
	
	public boolean checkUniqueness(){
		isUnique = true;
		int counter = 0;
		while((isUnique == true) && (counter < 100)){
			if(moneyOrderArrayFromCustomer[moneyOrderSelector].uniqueNumber.equals(uniqueness[counter][1]))
				isUnique = false;
		counter++;
		}
		return isUnique;
	}
	
	public int getRandomSelector(){
		return moneyOrderSelector;
	}
	
	public boolean signMoneyOrder(){
		if((isUnique == true) && (matchingAmounts == true)){
			moneyOrderArrayFromCustomer[moneyOrderSelector].bankSignature = signature;
			return true;
		}
		return false;
	}
	
	public boolean storeUniqueness(){
		boolean stored = false;
		int counter = 0;
		if(checkUniqueness() == true){
			while(stored == false && counter < 100){
				if(uniqueness[counter][0] == null){
					uniqueness[counter][0] = moneyOrderArrayFromCustomer[moneyOrderSelector].uniqueNumber;
					uniqueness[counter][1] = moneyOrderArrayFromCustomer[moneyOrderSelector].customerIDLeft;
					uniqueness[counter][2] = moneyOrderArrayFromCustomer[moneyOrderSelector].customerIDRight;
					stored = true;
				}
			counter++;	
			}
		}
		return stored;
	}
	
	

}
