<%-- 
    Document   : cart
    Created on : Nov 21, 2019, 1:32:55 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${not empty sessionScope.USERNAME}">
            <form action="logOut">
                <font color="red">
                Welcome, ${sessionScope.USERNAME}
                </font>
                <input type="submit" value="Log out" name="btAction"/>
            </form>
            <h1>Book Store Online</h1>
            <c:set var="cart" value="${sessionScope.CART}"/>
            <c:if test="${not empty cart.items}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Title</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <form action="remove">
                        <tbody>
                            <c:forEach var="item" items="${cart.items}" varStatus="counter">            
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${item.key}</td>
                                    <td>${item.value}</td>
                                    <c:set var="price" value="${item.key}"
                                    <td>${sessionScope.}</td>
                                    <td>
                                        <input type="checkbox" name="chkItem" value="${item.key}"/>
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>

                                <td colspan="3">
                                    <a href="user.jsp">Add more book to your cart</a>
                                </td>
                                <td>
                                    <input type="submit" value="Remove" name="btAction"/>
                                </td>
                            </tr>
                        </tbody>
                    </form>
                </table>
                <form action="Checkout">
                    <
                    <input type="submit" value="Checkout" name="btAction"/>
                </form>
            </c:if>
        </c:if>
        <c:if test="${empty sessionScope.USERNAME}">
            <jsp:forward page="login.html"/>
        </c:if>       
    </body>
</html>
