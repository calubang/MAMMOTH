// hotIce : 0 �������, 1 �����Ѱ�
abstract class Drink implements Food{
	protected int price;
	protected String name;
	protected int hotIce;
	protected int totalPrice;
	
	//totalPrice �� �������� ����
	public abstract int getTotalPrice();
	
	//�Ϲ����� get, set
	public int getPrice(){
		return price;	
	}
	public boolean setPrice(int price){
		if(price > 0 ){
			this.price = price;
			return true;
		}
		return false;
	}
	public String getName(){
		return name;
	}
	public boolean setName(String name){
		this.name = name;
		return true;
	}
	public int getHotIce(){
		return hotIce;
	}
	public boolean setHotIce(int hotIce){
		if ( hotIce == 0 || hotIce == 1){
			this.hotIce = hotIce;
			return true;
		}
		return false;
	}
}
