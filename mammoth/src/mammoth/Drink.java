package mammoth;
// hotIce : 0 �߰ſ��, 1 �������
enum IceType{
	HOT, ICE
}
abstract class Drink implements Food{
	protected int price;
	protected String name;
	protected IceType iceType;
	protected int totalPrice;
	
	public Drink(String name, int price){
		this.name = name;
		this.price = price;
	}

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
	public String getHotIce(){
		switch (iceType){
			case HOT:
				return "HOT";
			case ICE:
				return "ICE";
			default:
				return "Error";		
		}
	}
	public boolean setHotIce(IceType iceType){
		if ( iceType == IceType.HOT  || iceType == IceType.ICE ){
			this.iceType = iceType;
			return true;
		}
		return false;
	}
}
