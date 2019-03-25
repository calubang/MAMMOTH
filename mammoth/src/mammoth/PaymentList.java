package mammoth;

import java.util.Iterator;
import java.util.LinkedList;

//결제된 주문정보가 보이는곳
public class PaymentList<K> extends LinkedList<K>{
	
	private static PaymentList<Order> paymentList = new PaymentList<Order>();
	
	private PaymentList(){}
	
	public static PaymentList<Order> getInstance(){
		return paymentList;
	} 
	
	//결제가 된 경우 이 함수를 호출
	public static int add(Order order) {
		paymentList.push(order);
		return paymentList.size();
	}
	
	//주방에서 요리가 나오면 호출
	public static int delete() {
		paymentList.pop();
		return 0;
	}
	public static int delete(int orderNumber) {
		Iterator<Order> itr =  paymentList.iterator();
		Order order = null;
		while(itr.hasNext()) {
			order = itr.next();
			if(order.getOrderNumber() == orderNumber ) {
				break;
			}
		}
		paymentList.remove(order);
		return paymentList.size();
	}
	@Override
	public String toString() {
		String info = "";
		Iterator<Order> itr =  paymentList.iterator();
		Order order = null;
		while(itr.hasNext()) {
			order = itr.next();
			info += "주문번호 : " + order.getOrderNumber();
			info += "\n총금액 : " + order.getTotalPrice();
		}
		info += "\n";
		return info;
	}
	
	
}
