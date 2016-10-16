package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		int price = Integer.parseInt(request.getParameter("price"));
		String category = request.getParameter("category");
		
		Book book = new Book(author,title, price,category);
		ArrayList<Book> books = (ArrayList<Book>) request.getSession().getAttribute("list_of_books");
		if (books == null) {
			books = new ArrayList<Book>();
		}
		books.add(book);

		request.getSession().setAttribute("list_of_books", books);

		request.setAttribute("books_list", books);
		List<String> parameters = Arrays.asList("author", "title", "price", "category");
		parameters.forEach(e -> request.setAttribute(e, request.getParameter(e)));

		RequestDispatcher rd = request.getRequestDispatcher("/table.jsp");
		rd.forward(request, response);
	}
}
