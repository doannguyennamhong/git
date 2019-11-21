<%-- 
    Document   : staff
    Created on : Jun 27, 2019, 8:18:42 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Page</title>
        <style>
            #insertForm td{
                width: 100px;
            }
        </style>
    </head>
    <body>
        <c:if test="${not empty sessionScope.USERID}">
            <form action="logOut">
                <font color="red">
                Welcome, ${sessionScope.USERID}
                </font>
                <input type="submit" value="Log out" name="btAction"/>
            </form>
            <h1>Manage Student</h1>
            
            <form action="search" method="POST">
                <table>
                    <thead>
                        <tr>
                            <td rowspan="2" width="200px">Status,Id or Name<br/>
                                (approximate name)
                            </td>
                            <td colspan="2">
                                <input type="text" name="txtSearchValue" value="${param.txtSearchValue}"/>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Search" name="btAction" /></td>
                            </form>
                            <td>
                                <form action="showAll" method="POST">
                                    <input type="submit" value="Show All" name="btAction" />
                                </form>
                            </td>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
                <c:set var="searchValue" value="${param.txtSearchValue}"/>
                <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
                <c:set var="total" value="${requestScope.TOTAL}"/>
                <c:set var="errors" value="${requestScope.UPDATEERR}"/>
                <c:if test="${not empty result}">
                    List of students &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    Total of Search Result:${total}            
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Id</th>
                                <th>Full name</th>
                                <th>Class</th>
                                <th>Address1</th>
                                <th>Address2</th>
                                <th>Status</th>
                                <th>Phone</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dto" items="${result}" varStatus="counter">
                            <form action="update">
                                <tr>
                                    <td>
                                        ${counter.count}
                                    </td>
                                    <td>${dto.id} 
                                        <input type="hidden" name="txtId" value="${dto.id}"/>
                                    </td>
                                    <td>
                                        <c:if test="${not empty dto.middlename}">
                                            ${dto.lastname} ${dto.middlename} ${dto.firstname}
                                        </c:if>
                                        <c:if test="${empty dto.middlename}">
                                            ${dto.lastname} ${dto.firstname}
                                        </c:if>
                                    </td>
                                    <td><input type="text" name="txtClass" value="${dto.studentClass}"/></td>
                                    <td><input type="text" name="txtAddress1" value="${dto.address1}"/></td>
                                    <td><input type="text" name="txtAddress2" value="${dto.address2}"/></td>
                                    <td>
                                        <select name="seStatus">
                                            <option value="studying"
                                                    <c:if test = "${dto.status == 0}">
                                                        selected="selected"
                                                    </c:if> 
                                                    >studying</option>
                                            <option value="break"
                                                    <c:if test = "${dto.status == 1}">
                                                        selected="selected"
                                                    </c:if> 
                                                    >break</option>
                                            <option value="dropout"
                                                    <c:if test = "${dto.status == 2}">
                                                        selected="selected"
                                                    </c:if> 
                                                    >dropout</option>
                                        </select>
                                    </td>
                                    <td><input type="text" name="txtPhone" value="${dto.phone}"/></td>
                                    <td>
                                        <input type="submit" value="Update" name="btAction"/>
                                        <input type="hidden" value="${searchValue}" name="lastSearchValue"/>
                                        <input type="hidden" value="${requestScope.SEARCHURL}" name="searchURL"/>
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${not empty searchValue}">
                    <c:if test="${empty result}">
                        <h2>No record is matched!</h2>
                    </c:if>
                </c:if>
                <c:if test="${not empty errors.classLengthErr}">
                    <font color="red">
                    ${errors.classLengthErr}
                    </font><br/>
                </c:if> 
                <c:if test="${not empty errors.address1LengthErr}">
                    <font color="red">
                    ${errors.address1LengthErr}
                    </font><br/> 
                </c:if>
                <c:if test="${not empty errors.phoneFormatErr}">
                    <font color="red">
                    ${errors.phoneFormatErr}
                    </font></br>
                </c:if> 
                <c:if test="${not empty errors.phoneLengthErr}">
                    <font color="red">
                    ${errors.phoneLengthErr}
                    </font><br/> 
                </c:if>
                <c:set var="insertErr" value="${requestScope.INSERTERR}"/>
                <h1>Insert New Student</h1>
                <form action="insert">
                    <table id="insertForm">
                        <tr>
                            <td>Id</td>
                            <td>
                                <input type="text" value="" name="txtId"/>
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
                                Lastname
                            </td>
                            <td>
                                <input type="text" value="" name="txtLastname"/>
                            </td>
                            <td>Middle</td>
                            <td><input type="text" value="" name="txtMiddlename"/></td>
                            <td>First</td>
                            <td>
                                <input type="text" value="" name="txtFirstname"/>
                                  </td>
                        </tr>
                         <c:if test="${not empty insertErr.lastnameLengthErr}">
                             <tr>
                                 <td colspan="2">
                                    <font color="red">
                                    ${insertErr.lastnameLengthErr}
                                    </font><br/> 
                                    </td>
                                </c:if>
                                 <c:if test="${not empty insertErr.firstnameLengthErr}">
                                     <td colspan="2"></td>
                                     <td colspan="2"> <font color="red">
                                    ${insertErr.firstnameLengthErr}
                                    </font><br/> 
                                     </td>
                                </c:if>
                    </tr>
                        <tr>
                            <td>Male</td>
                            <td><input type="checkbox" value="" name="chkMale"/></td>
                        </tr>
                        <tr>
                            <td>Address1</td>
                            <td colspan="4">
                                <input type="text" value="" name="txtAddress1" style="width:350px;"/>
                                     </td>
                        </tr>
                                <c:if test="${not empty insertErr.address1LengthErr}">
                                    <td colspan="3">
                                    <font color="red">
                                    ${insertErr.address1LengthErr}
                                    </font><br/> 
                                </td>
                                </c:if>
                       
                        <tr>
                            <td>Address2</td>
                            <td colspan="4" ><input type="text" value="" name="txtAddress2"  style="width:350px;"/></td>
                        </tr>
                        <tr>
                            <td>Phone</td>
                            <td colspan="2">
                                <input type="text" value="" name="txtPhone"/>
                                    </td>
                        </tr>
                                <c:if test="${not empty insertErr.phoneFormatErr}">
                                    <td colspan="3"><font color="red">
                                    ${insertErr.phoneFormatErr}
                                    </font><br/> 
                                    </td>
                                </c:if>
                                <c:if test="${empty insertErr.phoneFormatErr}">
                                    <td colspan="3"><c:if test="${not empty insertErr.phoneLengthErr}">
                                    <font color="red">
                                    ${insertErr.phoneLengthErr}
                                    </font><br/> 
                                        </td>
                                </c:if>
                                </c:if>
                        
                        <tr>
                            <td>Class</td>
                            <td>
                                <input type="text" value="" name="txtClass"/>
                                 </td>
                        </tr>
                                     <c:if test="${not empty insertErr.classLengthErr}">
                                         <td colspan="3"><font color="red">
                                    ${insertErr.classLengthErr}
                                         </font><br/>
                                         </td>
                                </c:if>
                           
                        <tr>
                            <td colspan="3"><input type="submit" value="Create New Student" name="btAction" style="width:250px;"/></td>
                            <td></td>
                            <td>(Default status is break)</td>
                        </tr>
                    </table>
                    <c:if test="${not empty requestScope.INSERTSUCCESS}">
                        <h2>${requestScope.INSERTSUCCESS}</h2>
                    </c:if>
                </form>
            </c:if>
            <c:if test="${empty sessionScope.USERID}">
                <jsp:forward page="login.html"/>
            </c:if>
    </body>
</html>
