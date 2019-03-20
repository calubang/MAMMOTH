enum FoodType{
	COFFEE, BEVERAGE, DESSERT
}
public class FoodFactory {
	public static Food createFood(FoodType type, String name){
		switch ( type ) {
			case COFFEE:
				return new Coffee(name, MenuHashMap.getPrice(name));
			case BEVERAGE:
				return null;
			case DESSERT:
				return null;
			default:
				return new Coffee("Error", -1);
		}	
	}
}
