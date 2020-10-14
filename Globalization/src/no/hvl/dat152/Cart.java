package no.hvl.dat152;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {
	
	@Id
	int hei;
	
	public Cart(int hei) {
		
		this.hei = hei;
	}
	
	public Cart() {
		
	}
	

}