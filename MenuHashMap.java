import java.util.*;
public class MenuHashMap {
	
	private static HashMap<String, Integer> menuPrice = new HashMap<String, Integer>();

	private MenuHashMap(){}

	public static HashMap getInstance(){
		return menuPrice;
	}
	
	public static void set(String name, Integer price){
		menuPrice.put(name, price);
	}
	public static int getPrice(String name){
		return menuPrice.get(name);
	}

	public static void main(String[] args) 
	{
		System.out.println("");
	}
}
