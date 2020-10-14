package no.hvl.dat152.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat152.Product;
import no.hvl.dat152.Utility;
import no.hvl.dat152.eao.ProductEAO;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductServlet() {

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Checking if there's any cookies we need to take in to consideration
		Cookie cookies[] = req.getCookies();
		Locale language = null;

		if (cookies != null) {

			for (Cookie c : cookies) {

				if (c.getValue().equals("es")) {
					language = new Locale("es", "ES");

				} else if (c.getValue().equals("no")) {
					language = new Locale("no", "NO");

				} else if (c.getValue().equals("en")) {
					language = new Locale("en", "US");

				}

			}

		} else {

			language = Locale.getDefault();

		}
		
		List<Product> products = Utility.genererProdukter();
		
		req.getSession().setAttribute("language", language);
		req.getSession().setAttribute("products", products);

	

		// forwarding to product.jsp
		req.getRequestDispatcher("WEB-INF/jsp/product.jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String productID = req.getParameter("productID");
		HttpSession session = req.getSession();
		

		if (productID != null) {
			
			List<Product> cart = (List<Product>) req.getSession().getAttribute("cart");

			if (cart == null) {
				cart = new ArrayList<>();
			}

			List<Product> products = (List<Product>) req.getSession().getAttribute("products");
			Product p = products.get(Integer.parseInt(productID));
			cart.add(p);

			session.setAttribute("cart", cart);
			

		} else {

			String currentLang = req.getParameter("lang");
			Cookie c = new Cookie("currentLang", currentLang);
			res.addCookie(c);

		}

		res.sendRedirect("product");
	}

}