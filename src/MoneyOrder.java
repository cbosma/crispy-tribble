import java.util.UUID;

public class MoneyOrder{
	
	public static double value; //Value of the money order
	public String uniqueNumber; //Uniqueness string
	public static String customerIDLeft;
	public static String customerIDRight;
	public String bankSignature = "";
	
	
	public MoneyOrder(double valueIn, String IDLeft, String IDRight){
		value = valueIn;
		uniqueNumber = UUID.randomUUID().toString();
		customerIDLeft = IDLeft;
		customerIDRight = IDRight;
	}
	
	public static double getValue() {
		return value;
		}
	
	public static String getValueString() {
		return  String.valueOf(value);
		}

	public String getUniqueNumber() {
		return uniqueNumber;
	}
	
	public String getID(){
		String ID = "";
        for (int i = 0; i < customerIDLeft.length() && i < customerIDRight.length(); i++) {
            ID += customerIDLeft.charAt(i) ^ customerIDRight.charAt(i);
        }
        return ID;
	}
	
	
	
	
	
	
}