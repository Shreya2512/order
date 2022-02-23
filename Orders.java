package con.nt.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Orders {

	@NotBlank
	private String item;
	@Min(value=0)
	private int price;
	
   
	private Address address;

	public Orders(String item, int price, Address address) {
		super();
		this.item = item;
		this.price = price;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Orders [item=" + item + ", price=" + price + ", address=" + address + "]";
	}
	

}
