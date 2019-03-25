package mammoth;

import java.util.Iterator;
import java.util.LinkedList;

//������ �ֹ������� ���̴°�
public class PaymentList<K> extends LinkedList<K>{
	
	private static PaymentList<Order> paymentList = new PaymentList<Order>();
	
	private PaymentList(){}
	
	public static PaymentList<Order> getInstance(){
		return paymentList;
	} 
	
	//������ �� ��� �� �Լ��� ȣ��
	public static int add(Order order) {
		paymentList.push(order);
		return paymentList.size();
	}
	
	//�ֹ濡�� �丮�� ������ ȣ��
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
			info += "�ֹ���ȣ : " + order.getOrderNumber();
			info += "\n�ѱݾ� : " + order.getTotalPrice();
		}
		info += "\n";
		return info;
	}
	
	
}
