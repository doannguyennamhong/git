<%-- 
    Document   : manager
    Created on : Jun 27, 2019, 9:07:49 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student</title>
        <style type="text/css">
            body{
                padding: 0;
                width: 1400px;
                height: 3000px;
            }
            .book {
                width: 300px;
                height: 300px;
                margin-left: 50px;
                margin-right: 50px;
                margin-bottom: 50px;
                float: left;
            }
            #header {
                width: 1200px;
                height: 2500px;
                float: left;
            }
        </style>
    </head>
    <body>
        <div id="header" >
            <c:if test="${not empty sessionScope.USERNAME}">
                <form action="logOut">
                    <font color="red">
                    Welcome, ${sessionScope.USERNAME}
                    </font>
                    <input type="submit" value="Log out" name="btAction"/>
                </form>
                <h1>Book Store Online</h1>
                <c:if test="${not empty sessionScope.ALLBOOKS}">
                    <c:set var="allbooks" value="${sessionScope.ALLBOOKS}"/>
                    <c:forEach var="dto" items="${allbooks}">
                        <form action="addToCart" method="POST">
                            <div class="book">
                                <img src="${dto.image}" name="txtImage" width="200px" height="200px"/><br>
                                <span> Title: ${dto.name}</span><br>
                                <span>Price: ${dto.price}</span><br>
                                <input type="hidden" name="txtName" value="${dto.name}"/>
                                <input type="submit" value="Add to Cart" name="btAction" />
                            </div>
                        </form>
                    </c:forEach>
                </c:if>
                <a href="cart.jsp">View Your Cart</a>
            </div>
        </c:if>
        <c:if test="${empty sessionScope.USERNAME}">
            <jsp:forward page="login.html"/>
        </c:if>
    </body>
</html>
