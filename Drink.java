// hotIce : 0 차가운거, 1 따뜻한거
class Drink implements Food{
	int price;
	String name;
	int hotIce;
	int totalPrice;
	
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
	public int getTotalPrice(){
		return totalPrice;
	}
	public void setTotalPrice(){

	}

	public String toString(){
		return name + "(" + price + ")";
	}
}
