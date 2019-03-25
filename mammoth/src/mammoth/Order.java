package mammoth;
import java.util.Iterator;
import java.util.LinkedList;
enum PaymentType{
	NON, CARD, CASH
}
public class Order {
	protected LinkedList<Food> list;
	protected int totalPrice;
	protected final int orderNumber;
	protected static int orderNumbering;
	private PaymentType paymentType;

	//생성자
	//아무것도 없는 상태로 주문이 생성?이건 아직 안정함, 주문한 음식 하나가 들어오면서 생성되거나
	//public Order(){}
	public Order(Food food){
		//oder 마다 고유의 번호를 가지게 해줌.
		orderNumbering++;
		orderNumber = orderNumbering;
		paymentType = PaymentType.NON;
		//list 초기화 하고 들어온 음식 하나를 추가
		list = new LinkedList<Food>();
		addList(food);
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	
	//주문번호를 리턴
	public int getOrderPrice() {
		return orderNumber;
	}
	//주문 전체 금액을 표시
	public int getTotalPrice(){
		return totalPrice;
	}
	//주문내역에 주문한 음식을 추가
	public void addList(Food food){
		list.push(food);
		totalPrice += food.getTotalPrice();
	}
	//주문내역 전체를 return
	public LinkedList<Food> getAllFood(){
		return list;
	}
	//주문내역중 하나를 삭제
	public Food deleleList(int index) {
		Food deleteFood = list.remove(index);
		totalPrice -= deleteFood.getTotalPrice();
		return deleteFood;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
		//주방장쪽으로 리스트를 옮긴다.
	}
	
	public void payment(PaymentType paymentType) {
		if(paymentType != PaymentType.NON) {
			setPaymentType(paymentType);
			//주방에서 볼수 있는 리스트에 추가할것.
			//
			
		}
	}
	
	@Override
	public String toString() {
		Iterator<Food > itr = list.iterator();
		String info = "";
		info += "주문번호 : " + orderNumber + "\n";
		info += "----------주문 내역----------\n";
		if(list.isEmpty()) {
			info += "주문내역이 없습니다.\n";
		}else {
			while(itr.hasNext()) {
				info += itr.next() + "\n";
				info += "-----------------------------\n";
			}
		}
		info += "총 금액 : \t\t" + getTotalPrice() + "\n";
		return info;
	}
}
