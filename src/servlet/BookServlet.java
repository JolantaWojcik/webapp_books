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

		response.setContentType("text/html");
		response.getWriter().println(books);
		
//		request.setAttribute("booksList", books);
//		request.getRequestDispatcher("/table.jsp").forward(request, response);
		
		response.getWriter()
		.println("<table><tr bgcolor=\"orange\"><td>#</td><td>author</td>"
				+ "<td>title</td>"
				+ "<td>price</td>"
				+ "<td>category</td>"
				+ "<td>Action</td></tr>");
		for (int i = 0; i < books.size(); i++) {
			response.getWriter()
			.println("<tr><td>" + (i + 1) + "</td><td>" + books.get(i).getAuthor() + "</td>" + "<td>"
					+ books.get(i).getTitle()
					+ "</td><td>" + books.get(i).getPrice()
					+ "</td><td>" + books.get(i).getCategory()
					+ "</td><td><input type=\"button\" "
					+ "value=\"delete\" onclick=\"document.location.href='removeBook?number="
					+ i + "'\"/></td></tr>");
		}
		response.getWriter().println("</table>");

	}
}
