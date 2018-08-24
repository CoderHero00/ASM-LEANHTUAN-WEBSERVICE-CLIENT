<%-- 
    Document   : Show
    Created on : Aug 21, 2018, 5:36:30 PM
    Author     : Lenovo
--%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table class="table" style="width:50%">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th> 
                <th scope="col">Transaction Money</th>
                <th scope="col">Fee</th>
                <th scope="col">Date</th>
            </tr>
        <c:forEach items="${list}" var="po">
            <tr>
                <th th scope="row">${po.ID}</th>
                <td>${po.name}</td>
                <td>${po.money}</td> 
                <td>${po.fee}</td>
                <td>${po.date}</td>
            </tr>
        </c:forEach>
  </table>
    </body>
</html>
