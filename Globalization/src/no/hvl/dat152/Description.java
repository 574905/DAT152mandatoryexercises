package no.hvl.dat152;

import javax.persistence.Entity;
import javax.persistence.Id;

import no.hvl.dat152.eao.DescriptionEAO;

@Entity
public class Description {
	
	@Id
	String text;
	
	
	public Description(String text) {
		
		this.text = text;
		
	}
	
	public Description() {
		
	}

	public static void main(String[] args) {
		
		

	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
	
	

}

