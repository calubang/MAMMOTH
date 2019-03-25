package mammoth;

import java.util.LinkedList;

//������ �ֹ������� ���̴°�
public class PaymentList<K> extends LinkedList<K>{
	
	private static PaymentList<Order> paymentList = new PaymentList<Order>();
	
	private PaymentList(){}
	
	public PaymentList<Order> getInstance(){
		return paymentList;
	} 
	
	//������ �� ��� �� �Լ��� ȣ��
	public int add(Order order) {
		paymentList.push(order);
		return paymentList.size();
	}
	
	//�ֹ濡�� �丮�� ������ ȣ��
	public int delete() {
		paymentList.pop();
		return 0;
	}
	public int delete(Order order) {
		return 0;
	}
	
}
