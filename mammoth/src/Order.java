import java.util.LinkedList;
public class Order {
	protected LinkedList<Food> list;
	protected int totalPrice;

	//생성자
	//아무것도 없는 상태로 주문이 생성되거나, 주문한 음식 하나가 들어오면서 생성되거나
	public Order(){
		list = new LinkedList<Food>();
		totalPrice = 0;
	}
	public Order(Food food){
		list = new LinkedList<Food>();
		list.push(food);
		totalPrice = food.getPrice();
	}

	//주문 전체 금액을 표시
	public int getTotalPrice(){
		return totalPrice;
	}
	//주문내역에 주문한 음식을 추가
	public void addList(Food food){
		list.push(food);
		totalPrice += food.getPrice();
	}
	
	public LinkedList<Food> getAllFood(){
		return list;
	}
}
