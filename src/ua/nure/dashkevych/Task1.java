package ua.nure.dashkevych;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/calculate" }, name = "Calculator")
public class Task1 extends HttpServlet {

	private static final long serialVersionUID = 6925129519693995942L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Calculator calculator = new Calculator();
		Double first = null;
		Double second = null;
		try {
			first = Double.valueOf(req.getParameter("first").toString());
			second = Double.valueOf(req.getParameter("second").toString());
		} catch (NumberFormatException e) {
			req.getSession().setAttribute("result", "");
			req.getSession().setAttribute("result", e.getMessage());
		}
		String operation = req.getParameter("operation").toString();
		try {
			Double result = calculator.doOperation(operation, first, second);
			req.setAttribute("result", result);
		} catch (IllegalArgumentException e) {
			req.setAttribute("result", e.getMessage());
		}
		finally {
			req.getRequestDispatcher("result.jsp").forward(req, resp);
			
		}
	}

}
