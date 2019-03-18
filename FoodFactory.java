public class FoodFactory {
	public static Food createFood(String name){
		switch ( name ) {
			case "americano":
				return new Americano();
			case "cafelatte":
				return new CafeLatte();
		}	
	}
}
