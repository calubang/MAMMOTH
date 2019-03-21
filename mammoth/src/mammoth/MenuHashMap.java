package mammoth;
import java.util.*;
public class MenuHashMap {
	
	private static HashMap<String, Integer> menuPrice = new HashMap<String, Integer>();

	private MenuHashMap(){}

	public static HashMap<String, Integer> getInstance(){
		return menuPrice;
	}
	
	public static void set(String name, Integer price){
		menuPrice.put(name, price);
	}
	public static int getPrice(String name){
		return menuPrice.get(name);
	}
}
