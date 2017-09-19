<%-- 
    Document   : index
    Created on : Sep 19, 2017, 9:29:30 AM
    Author     : Thomas Hartmann - tha@cphbusiness.dk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>#logo{ margin:5px;}</style>
    </head>
    <body>
        <div id="logo">
            <img src="img/appleworm.png" alt=""/>
        </div>
        <h1 class="text-center">System users</h1>
        <div class="row">
            <!--------------------------------Column 1 -------------------------------------------->
            <div class="col-sm-4">
                <h2>Enter new user</h2>
                <form class="form-horizontal" action="#" method="POST">
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="email">First name:</label>
                        <div class="col-sm-8">
                            <input type="text" name="fname" class="form-control" id="fname" placeholder="Enter first name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="email">Last name:</label>
                        <div class="col-sm-8">
                            <input type="text" name="lname" class="form-control" id="lname" placeholder="Enter last name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="email">Email:</label>
                        <div class="col-sm-8">
                            <input type="email" name="email" class="form-control" id="email" placeholder="Enter email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="pwd">Password:</label>
                        <div class="col-sm-8"> 
                            <input type="password" name="password" class="form-control" id="pwd" placeholder="Enter password">
                        </div>
                    </div>
                    <div class="form-group"> 
                        <div class="col-sm-offset-4 col-sm-8">
                            <div class="checkbox">
                                <label><input type="checkbox" name="remember" > Send me the newsletter</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group"> 
                        <div class="col-sm-offset-4 col-sm-8">
                            <button type="submit" class="btn btn-default">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
            <!-------------------------------- Column 2 ------------------------------------------------->
            <div class="col-sm-8">
                <div id="row1">
                <button id="consoleLog" type="button" class="btn btn-success">console.log this</button>
                <button id="changeMyColor" type="button" class="btn btn-info">change my color</button>
                <button id="changeTHcolor" type="button" class="btn btn-warning">change color on th</button>
                <button id="toggleImg" type="button" class="btn btn-danger">hide/show logo</button>
                <button id="removeBtns" type="button" class="btn btn-primary">remove buttons</button>
                </div>
                <hr>
                <button id="sortFname" type="button" class="btn btn-primary">Sort by First Name</button>
                <button id="sortLname" type="button" class="btn btn-success">Sort by Last Name</button>
                <button id="filterFemale" type="button" class="btn btn-info">Filter only female</button>
                <button id="filterMale" type="button" class="btn btn-warning">Filter only male</button>
                <button id="sumAccount" type="button" class="btn btn-danger">Sum Account</button>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Firstname</th>
                            <th>Lastname</th>
                            <th>Email</th>
                            <th>Gender</th>
                            <th>Account</th>

                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>John</td>
                            <td>Doe</td>
                            <td>john@example.com</td>
                            <td>male</td>
                            <td>100.00</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Mary</td>
                            <td>Moe</td>
                            <td>mary@example.com</td>
                            <td>female</td>
                            <td>200.00</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>July</td>
                            <td>Dooley</td>
                            <td>july@example.com</td>
                            <td>female</td>
                            <td>300.00</td>
                        </tr>
                        <tr>
                            <td><strong>Total</strong></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td id="total"></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="scripts/script.js" type="text/javascript"></script>
    </body>
</html>
