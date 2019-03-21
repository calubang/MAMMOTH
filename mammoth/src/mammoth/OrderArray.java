package mammoth;

import java.util.HashMap;
import java.util.Iterator;

public class OrderArray {
	private Food foodList[];
	protected int totalPrice;
	protected final int orderNumber;
	protected static int orderNumbering;
	private PaymentType paymentType;
	
	public OrderArray(Food food) {
		foodList = new Food[3];
		orderNumbering++;
		this.orderNumber = orderNumbering;
		paymentType = PaymentType.NON;
		addFood(food);
	}
	
	public Food[] getFoodList() {
		return foodList;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public int getOrderNumber() {
		return orderNumber;
	}
	
	//음식정보를 배열에 저장하는 메소드
	//주문의 첫음식이면 바로 저장하지만 그렇지 않다면 배열의 크기를 한칸 늘리고 데이터의 가장 마지막에 저장한다.
	public void addFood(Food food) {
		if(foodListisEmpty()) {
			foodList[0] = food;
		}else {
			int dataLength = listExtends();
			foodList[dataLength] = food;
		}	
		totalPrice += food.getTotalPrice();
	}
	
	//배열의 크기를 한칸 늘리는 메소드
	public int listExtends() {
		int dataLength = 0;
		int newLength = foodList.length + 1;
		Food tempFoodList[] = new Food[newLength];
		for(int i =0 ; i < foodList.length ; i++ ){
			if(foodList[i] != null) {
				tempFoodList[i] = foodList[i];
			} else {
				dataLength = i;
				break;
			}
		}
		foodList = tempFoodList;
		return dataLength;
	}
	
	//음식정보를 삭제하는 메소드
	//index를 받아서 삭제하고 뒤에 있는 주문정보를 앞으로 당긴다.
	//삭제에서는 foodList 의 크기가 변하지는 않는다.
	public void deleteFood(int index) {
		totalPrice -= foodList[index].getTotalPrice();
		foodList[index] = null;
		for(int i = (index+1) ; i<foodList.length ; i++) {
			if(foodList[i] != null) {
				foodList[i-1] = foodList[i];
				foodList[i] = null;
			} else
				break;
		}
	}
	
	//음식리스트가 비었는지 확인하는 메소드
	//비었으면 true , 아니면 false
	public boolean foodListisEmpty() {
		if(foodList[0] == null) {
			return true;
		}
		return false;
	}
	//음식리스트에 음식이 총 몇개 담겨있는지 확인하는 메소드
	public int foodListDataLength() {
		int dataLength = 0;
		if(foodListisEmpty()) {
			return 0;
		} 
		for(int i=0 ; i<foodList.length ; i++) {
			if(foodList[i] == null) {
				dataLength = i;
				break;
			}
		}
		return dataLength;
	}
	
	@Override
	public String toString() {
		String info = "주문번호 : " + getOrderNumber() + "\n";
		info += "----------주문 내역----------\n";
		if(foodListisEmpty()) {
			info += "주문내역이 없습니다.\n";
		}else {
			for(int i = 0; i < foodList.length ; i++) {
				if(foodList[i] != null) {
					info += foodList[i] + "\n";
					info += "-----------------------------\n";
				}else
					break;
			}
		}
		info += "총 금액 : \t\t" + getTotalPrice() + "\n";
		return info;
	}
	
	public static void main(String[] args) {
		//가격표 설정
		HashMap<String, Integer> menuPrice = MenuHashMap.getInstance();
		menuPrice.put("americano", 900);
		menuPrice.put("cafelatte", 2100);
		menuPrice.put("cafemoca", 2200);
		//옵션별 가격 설정
		HashMap<String, Integer> optionPrice = OptionHashMap.getInstance();
		optionPrice.put("SYRUP_PRICE", 500);
		optionPrice.put("SHOT_PRICE", 500);
		
		Coffee coffee1 = (Coffee)FoodFactory.createFood(FoodType.COFFEE, "americano");
		coffee1.setHotIce(IceType.HOT);
		coffee1.setShotAmount(2);
		coffee1.setSyrupAmount(1);
		
		Coffee coffee2 = (Coffee)FoodFactory.createFood(FoodType.COFFEE, "cafelatte");
		coffee2.setHotIce(IceType.ICE);
		coffee2.setShotAmount(2);
		coffee2.setSyrupAmount(0);
		
		Coffee coffee3 = (Coffee)FoodFactory.createFood(FoodType.COFFEE, "cafemoca");
		coffee3.setHotIce(IceType.HOT);
		coffee3.setShotAmount(0);
		coffee3.setSyrupAmount(1);

		//test
		OrderArray orderArray = new OrderArray(coffee1);
		//System.out.println(orderArray);
		orderArray.addFood((Food)coffee2);
		orderArray.addFood((Food)coffee3);
		//System.out.println(orderArray);
		
		orderArray.deleteFood(1);
		//orderArray.deleteFood(0);
		System.out.println(orderArray);
	}
}
