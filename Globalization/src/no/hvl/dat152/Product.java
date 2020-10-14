package no.hvl.dat152;

import java.text.Collator;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Product {
	
	@Id
	
	String name;
	double price;
	String imageFile;
	Map<String, Description> description;
	
	


	public Product(String name, double price, String imageFile, Map<String, Description> description) {
		
		this.name = name;
		this.price = price;
		this.imageFile = imageFile;
		this.description = description;
	}
	
	
	public Product() {
		
	}
	
public static void main(String [] args) throws Exception {
	

		
		
	}
	

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	
	public Map<String, Description> getDescription() {
		return description;
	}


	public void setMap(Map<String, Description> description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Product [Name=" + name + ", price" + price + ", imageFile=" + imageFile + ", description=" + description
				+ "]";
	}

	
	
	

}

