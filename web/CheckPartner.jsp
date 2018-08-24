<%-- 
    Document   : CheckPartner
    Created on : Aug 20, 2018, 8:27:38 PM
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
        <div class="container">
            <div class="row">
                <div class="col-sm-2 col-sm-offset-2"></div>
                <div class="col-sm-3" style="align-items:center">
                    <form  action="CheckServelet"method="post">
                        <div class="form-group">
                            <label>Partner ID</label>
                            <input class="form-control" type="text" required name="partnerID" placeholder="Username"/>
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input class="form-control" type="password" required name="password" placeholder="Password"/>
                        </div>
                            <div class="form-group">
                                <button class="btn btn-success" style="background-color:#0066ff; color:white ; border-color:#0066ff">Submit</button>
                            </div> 
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
