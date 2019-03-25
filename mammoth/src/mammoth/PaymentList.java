package mammoth;

import java.util.LinkedList;

//결제된 주문정보가 보이는곳
public class PaymentList<K> extends LinkedList<K>{
	
	private static PaymentList<Order> paymentList = new PaymentList<Order>();
	
	private PaymentList(){}
	
	public PaymentList<Order> getInstance(){
		return paymentList;
	} 
	
	//결제가 된 경우 이 함수를 호출
	public int add(Order order) {
		paymentList.push(order);
		return paymentList.size();
	}
	
	//주방에서 요리가 나오면 호출
	public int delete() {
		paymentList.pop();
		return 0;
	}
	public int delete(Order order) {
		return 0;
	}
	
}
