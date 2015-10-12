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
		first = Double.valueOf(req.getParameter("first"));
		second = Double.valueOf(req.getParameter("second"));
		String operation = req.getParameter("operation");
		Double result = calculator.doOperation(operation, first, second);
		req.setAttribute("result", result);
		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}
}
