<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

            <c:forEach var="book_table" items="${requestScope.booksList}">
                <tr>
                    <td>${book_table[0]}</td>
                    <td>${book_table[1]}</td>
                    <td>${book_table[2]}</td>
                    <td>${book_table[3]}</td>
                    <td>
                    <input type="button" value="delete" 
                    onclick="document.location.href='deletebook"></input>
                    </td>
                </tr>
            </c:forEach>    
        </table>     
    </body>
</html>