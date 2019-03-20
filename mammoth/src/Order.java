import java.util.LinkedList;
public class Order {
	protected LinkedList<Food> list;
	protected int totalPrice;

	//������
	//�ƹ��͵� ���� ���·� �ֹ��� �����ǰų�, �ֹ��� ���� �ϳ��� �����鼭 �����ǰų�
	public Order(){
		list = new LinkedList<Food>();
		totalPrice = 0;
	}
	public Order(Food food){
		list = new LinkedList<Food>();
		list.push(food);
		totalPrice = food.getPrice();
	}

	//�ֹ� ��ü �ݾ��� ǥ��
	public int getTotalPrice(){
		return totalPrice;
	}
	//�ֹ������� �ֹ��� ������ �߰�
	public void addList(Food food){
		list.push(food);
		totalPrice += food.getPrice();
	}
	
	public LinkedList<Food> getAllFood(){
		return list;
	}
}
