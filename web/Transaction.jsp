<%-- 
    Document   : Transaction
    Created on : Aug 20, 2018, 6:43:53 PM
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
        <form class="col-sm-2 col-sm-offset-2" action="TranServlet">
            <input type="hidden" name="code" value="${code}"><br>
            <div class="form-group">
                <label for="exampleInputEmail1">Pin:</label>
                <input type="password" name="pin" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Pin">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Client ID:</label>
                <input type="text" placeholder="Enter ID" class="form-control" name="clientID">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Transfer Money:</label>
                <input type="text" placeholder="Enter money" class="form-control" name="money">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Transaction's Name:</label>
                <input type="text" placeholder="Enter ID" class="form-control" name="tranName">
            </div>
            <input type="checkbox" name="type" value="0">Client pay<br>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
</html>
