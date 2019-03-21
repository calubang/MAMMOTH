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

	//������
	//�ƹ��͵� ���� ���·� �ֹ��� ����?�̰� ���� ������, �ֹ��� ���� �ϳ��� �����鼭 �����ǰų�
	//public Order(){}
	public Order(Food food){
		//oder ���� ������ ��ȣ�� ������ ����.
		orderNumbering++;
		orderNumber = orderNumbering;
		paymentType = PaymentType.NON;
		//list �ʱ�ȭ �ϰ� ���� ���� �ϳ��� �߰�
		list = new LinkedList<Food>();
		addList(food);
	}
	
	//�ֹ���ȣ�� ����
	public int getOrderPrice() {
		return orderNumber;
	}
	//�ֹ� ��ü �ݾ��� ǥ��
	public int getTotalPrice(){
		return totalPrice;
	}
	//�ֹ������� �ֹ��� ������ �߰�
	public void addList(Food food){
		list.push(food);
		totalPrice += food.getTotalPrice();
	}
	//�ֹ����� ��ü�� return
	public LinkedList<Food> getAllFood(){
		return list;
	}
	//�ֹ������� �ϳ��� ����
	public Food deleleList(int index) {
		Food deleteFood = list.remove(index);
		totalPrice -= deleteFood.getTotalPrice();
		return deleteFood;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
		//�ֹ��������� ����Ʈ�� �ű��.
	}
	
	@Override
	public String toString() {
		Iterator<Food > itr = list.iterator();
		String info = orderNumbering + "\n";
		info += "�ֹ���ȣ : " + orderNumber + "\n";
		info += "----------�ֹ� ����----------\n";
		if(list.isEmpty()) {
			info += "�ֹ������� �����ϴ�.\n";
		}else {
			while(itr.hasNext()) {
				info += itr.next() + "\n";
				info += "-----------------------------\n";
			}
		}
		info += "�� �ݾ� : \t\t" + getTotalPrice() + "\n";
		return info;
	}
}
