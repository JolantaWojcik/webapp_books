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
 * Servlet implementation class BookServlet
 */
@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		int price = Integer.parseInt(request.getParameter("price"));
		String category = request.getParameter("category");
		
		Book b = new Book(author,title,price, category);
		ArrayList<Book> books = (ArrayList<Book>) request.getSession().getAttribute("list_of_books");
		if (books == null) {
			books = new ArrayList<Book>();
		}
		books.add(b);

		request.getSession().setAttribute("list_of_books", books);
	//	request.setAttribute("booksList", messages);
	//	request.getRequestDispatcher("/table.jsp").forward(request, response);

		response.setContentType("text/html");
		response.getWriter().println(books);
		 
	}
}
