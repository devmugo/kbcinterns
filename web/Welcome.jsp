<%-- 
    Document   : index
    Created on : Mar 13, 2019, 1:16:48 PM
    Author     : AMO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/main.css" />
        <title>Welcome  </title>

    </head>
    <body>
        <!-- Image and text -->
        <nav class="navbar navbar-dark primary-color">
            <a class="navbar-brand" href="#" style="margin: 0 auto">
                <img src="img/logo.jpg" height="30" class="d-inline-block align-top"
                     alt="mdb logo"> KBC Interns Portal
            </a>
        </nav>
        <div class="container" style="margin-top: 7em">
            <section id="content">
                <div style="max-width: 100%;margin-left: 30px; height: 50px">    
                       <h5 style="color:white;background-color:green"> ${requestScope.success}  </h5> 
                        <h5 style="color:red;background-color:darkred"> ${requestScope.error}  </h5>  
                        <br>
                    </div>
                <form action="logIn" method="post">
                    <h1>KBC Interns Portal</h1>
                    <div>
                        <input type="text" placeholder="Username" required="" id="username" name="username" />
                    </div>
                    <div>
                        <input type="password" placeholder="Password" required="" id="password" name="password" />
                    </div>
                    <div style="margin-left: 7em">
                        <input type="submit" value="Log in" />
                        
                    </div>
                </form><!-- form -->

            </section><!-- content -->
        </div><!-- container -->
    </body>
</html>
