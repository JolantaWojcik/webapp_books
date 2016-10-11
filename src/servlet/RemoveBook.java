package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
/**
 * Servlet implementation class RemoveBook
 */
@WebServlet("/removeBook")
public class RemoveBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int number = Integer.parseInt(request.getParameter("number"));
		ArrayList<Book> books = (ArrayList<Book>) request.getSession().getAttribute("list_of_books");
		books.remove(number);
		request.getSession().setAttribute("list_of_books", books);

		response.sendRedirect("index.html");
	}
}
