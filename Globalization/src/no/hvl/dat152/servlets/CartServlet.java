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


@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CartServlet() {
        
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// Checking if there's any cookies we need to take in to consideration
		Cookie cookies[] = req.getCookies();
		Locale language = null;
		
		if (cookies!=null) {

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
		
		req.getSession().setAttribute("language", language);
		
		HttpSession session = req.getSession();
		List<Product> cart = (List<Product>) session.getAttribute("cart");
		
		session.setAttribute("cart", cart);
		
		// forwarding to homepage.jsp
		req.getRequestDispatcher("WEB-INF/jsp/cart.jsp").forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String currentLang = req.getParameter("lang");

		Cookie c = new Cookie("currentLang", currentLang);
		res.addCookie(c);
		res.sendRedirect("cart");
	}

}
