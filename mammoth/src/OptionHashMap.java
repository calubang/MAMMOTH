import java.util.HashMap;
public class OptionHashMap {
	private static HashMap<String, Integer> optionPrice = new HashMap<String, Integer>();

	private OptionHashMap(){}

	public static HashMap<String, Integer> getInstance(){
		return optionPrice;
	}
	
	public static void set(String name, Integer price){
		optionPrice.put(name, price);
	}
	public static int getPrice(String name){
		return optionPrice.get(name);
	}
}
