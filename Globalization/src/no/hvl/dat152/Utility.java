package no.hvl.dat152;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import no.hvl.dat152.Description;
import no.hvl.dat152.Product;
public class Utility {
	
	
	public static List<Product> genererProdukter() {
		Description nb1 = new Description("Dette er den ultimate kaffekoppen for programvareutviklere som jobber sene"
				+ " kvelder og trenger noe for å hindre dem i å sovne.");
		Description en1 = new Description("This is the ultimate coffeecup for software developers who work late nights"
				+ " and need something to prevent them from falling asleep.");
		Description es1 = new Description("Este es el ultimato taza para software developers que trabajan en las"
				+ " noches y nessecitan algo para no dormir.");
		Description nb2 = new Description("Dette er et krus for de som liker svart farge. Kruset passer veldig bra til"
				+ " kaffe, te og melk, men det er også mulig å bruke det til andre drinker.");
		Description en2 = new Description("This is a mug for those who like the color black. The mug is very good for"
				+ " coffee, tea and milk, but it is also possible to use it with other drinks.");
		Description es2 = new Description("Este es una taza para ellos que gusta el colore negra. La taza es muy bueno"
				+ " para café, té y leche, pero es tambien posible usarla con otro bebidas.");
		Map<String, Description> b1 = new HashMap<>();
		b1.put("no", nb1);
		b1.put("en", en1);
		b1.put("es", es1);
		Map<String, Description> b2 = new HashMap<>();
		b2.put("no", nb2);
		b2.put("en", en2);
		b2.put("es", es2);
		Product p1 = new Product("White Coffee Cup (TM)", 6.50, "images/white_coffee_cup.jpg", b1);
		Product p2 = new Product("Black Coffee Cup (TM)", 4.75, "images/black_coffee_cup.jpg", b2);
		return Arrays.asList(p1, p2);
	}
//	public static Object byttValuta(String language) {
//		if (language == "")
//	}
}