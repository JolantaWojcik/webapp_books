<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table id="table_books" border="1">
            <tr>
                <th>Author </th>
                <th>Title </th>
                <th>Price </th>
                <th>Category </th>
                <th>Action </th>
            </tr>
              <c:forEach var="b" items="${requestScope.books_list}">
                <tr>
				<td>${b.author}</td>
				<td>${b.title}</td>
				<td>${b.price}</td>
				<td>${b.category}</td>
				<td><input type="button" value="delete"
				onclick="document.location.href='removeBook?title={$b.title}'">
				</input></td>
			</tr>
			</c:forEach>
			</table>
    </body>
</html>