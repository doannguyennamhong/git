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
        <title>Admin</title>
        <style>
            #insertForm td{
                width: 100px;
            }
        </style>
        <script type="text/javascript">
            function chooseImage(event) {

                var files = event.target.files;
                var file = files[0];
                var reader = new FileReader();
                reader.onload = function () {
                    var url = reader.result;
                    var hidden = document.getElementById("urlImage");
                    hidden.value = url;
                    var myImg = document.getElementById("myImage");
                    myImg.src = url;
                };
                reader.readAsDataURL(file);
            }
            function openFile() {

                document.getElementById('files').click();

            }
        </script>
    </head>
    <body>
        <c:if test="${not empty sessionScope.USERNAME}">
            <form action="logOut">
                <font color="red">
                Welcome, ${sessionScope.USERNAME}
                </font>
                <input type="submit" value="Log out" name="btAction"/>
            </form>
            <h1>Insert A Book</h1>
            <img width="200" height="200" id="myImage"/><br>
            <input id="files" type="file" onchange="chooseImage(event)" multiple="false" style="display: none;"/>
            <input type="button" onclick="openFile()" value="Choose Image"/><br>
            <form action="insert" method="POST">
                <input type="hidden" id="urlImage" name="txtImage"/>
                <table id="insertForm">
                    <tr>
                        <td>BookID</td>
                        <td>
                            <input type="text" value="" name="txtBookID"/>
                        </td>                            
                    </tr>
                    <c:if test="${not empty insertErr.idExistedErr}">
                        <td colspan="2">
                            <font color="red">
                            ${insertErr.idExistedErr}
                            </font><br/> 
                        </td>
                    </c:if>
                    <c:if test="${empty insertErr.idExistedErr}">
                        <c:if test="${not empty insertErr.idLengthErr}">
                            <td colspan="2">
                                <font color="red">
                                ${insertErr.idLengthErr}
                                </font><br/> 
                            </td>
                        </c:if>
                    </c:if>
                    <tr>
                        <td>
                            Name
                        </td>
                        <td>
                            <input type="text" value="" name="txtName"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Type
                        </td>
                        <td>
                            <input type="text" value="" name="txtType"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td><input type="text" value="" name="txtPrice"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Create New Book" name="btAction" style="width:200px;"/></td>
                    </tr>
                </table>
                <c:if test="${not empty requestScope.INSERTSUCCESS}">
                    <h2>${requestScope.INSERTSUCCESS}</h2>
                </c:if>
            </form>
        </c:if>
        <c:if test="${empty sessionScope.USERNAME}">
            <jsp:forward page="login.html"/>
        </c:if>
    </body>
</html>
