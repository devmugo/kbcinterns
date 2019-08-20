<%-- 
    Document   : Add Hr
    Created on : Apr 11, 2019, 10:35:45 PM
    Author     : AMO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Add Daily Work </title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <jsp:include page="includes/internSkele.jsp"/>  
    </head>
    <body >

        <main style="width: 70%;margin: 4em auto;float: right;margin-right: 5em">
            <div>
                <h4> Add Daily Work</h4>

            </div>
            <div class="card-body px-lg-5 pt-0" style="width:80%;background-color: white ">

                <!-- Form -->
                <form class="text-center"method="post" style="color: #757575;" action="addinternDailyWork">
                    <div style="max-width: 100%;margin-left: 30px; height: 50px">
                        <h5 style="color:lightgreen; background-color: darkgreen">   ${requestScope.success} </h5> 
                        <h5 style="color:red;background-color:darkred"> ${requestScope.error}  </h5>  
                        <br>
                    </div>
                    <h2>
                        Add Your Daily Activities
                    </h2>

                    <div class="md-form">
                        <input type="date" id="date" class="form-control" name="date" required>
                        <label for="date">Date</label>
                    </div>

                    <div class="md-form">
                        <textarea id="materialContactFormMessage" name="workdone" class="form-control md-textarea" rows="2" required></textarea>
                        <label for="materialContactFormMessage">Work Done </label>
                    </div>

                    <div class="md-form">
                        <textarea id="materialContactFormMessage" name="skills" class="form-control md-textarea" rows="2" required></textarea>
                        <label for="materialContactFormMessage">Skills Learnt </label>
                    </div>

                    <button class="btn btn-outline-info btn-rounded my-4 waves-effect z-depth-0" type="submit">Submit</button>

                </form>
                <!-- Form -->

            </div>




        </main>
    </body>
    <jsp:include page="./includes/scripts.jsp"/>            

</html>