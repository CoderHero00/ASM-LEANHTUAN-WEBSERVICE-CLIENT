<%-- 
    Document   : Client
    Created on : Aug 20, 2018, 9:08:57 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="HistoryQuery" class="col-sm-2">
            <div class="form-group">
                <label for="exampleInputEmail1">Client ID</label>
                <input type="text" name="ID" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter ID">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Pin:</label>
                <input type="password"  placeholder="Enter PIN CODE" class="form-control" name="Password">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Start Date:</label>
                <input type="date" name="StartD" class="form-control">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">End Date:</label>
                <input type="date" name="EndD" class="form-control">
            </div>
            <input type="hidden" name="role" value="0"><br>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
</html>
