<%-- 
    Document   : ViewTransactions
    Created on : Apr 11, 2019, 10:35:45 PM
    Author     : AMO
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Interns</title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <style>

            .map-container{
                overflow:hidden;
                padding-bottom:56.25%;
                position:relative;
                height:0;
            }
            .map-container iframe{
                left:0;
                top:0;
                height:100%;
                width:100%;
                position:absolute;
            }
        </style>
    </head>

    <body class="grey lighten-3">
        <% response.setHeader("Cache-Control", "no-cache,must-revalidate,no-store");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
            HttpSession sessionsa = request.getSession(false);
            String user = (String) sessionsa.getAttribute("user");
            String role = (String) sessionsa.getAttribute("role");
            if (role != "supervisor") {
                response.sendRedirect("Welcome.jsp");
            }


        %>


        <!--Main Navigation-->
        <header>

            <!-- Navbar -->
            <nav class="navbar fixed-top navbar-expand-lg navbar-light white scrolling-navbar">
                <div class="container-fluid">



                    <!-- Collapse -->
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <!-- Links -->
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">

                        <!-- Left -->
                        <ul class="navbar-nav mr-auto">

                            <li class="nav-item">
                                <a class="nav-link waves-effect" href="" target="_blank">
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link waves-effect" href=""
                                   target="_blank">
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link waves-effect" href="" target="_blank">
                                </a>
                            </li>
                        </ul>

                        <!-- Right -->
                        <ul class="navbar-nav nav-flex-icons">
                            <li class="nav-item">
                                <a href="" class="nav-link waves-effect" target="_blank">

                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="" class="nav-link waves-effect" target="_blank">

                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="logOut" class="nav-link border border-light rounded waves-effect"
                                   style="color:black;font-weight: bold"
                                   <i class="fab fa-github mr-2">Log Out</i> 
                                </a>
                            </li>
                        </ul>

                    </div>

                </div>
            </nav>
            <!-- Navbar -->

            <div class="sidebar-fixed position-fixed">

                <a class="logo-wrapper waves-effect">
                    <img src="img/logo.jpg" class="img-fluid" alt="">
                </a>

                <div class="list-group list-group-flush">
                    <a href="#" class="list-group-item active waves-effect" >
                        Interns
                    </a>
                    <a href="editIntern" class="list-group-item list-group-item-action waves-effect" >
                        Interns Daily Attendance</a>
                    <a href="ViewTransactions" class="list-group-item list-group-item-action waves-effect">
                        Interns Daily Work </a>
                    <a href="ViewTransactions" class="list-group-item list-group-item-action waves-effect">
                        Weekly Intern Review </a>
                </div>

            </div>

        </header>
        <!--Main Navigation-->

        <!--Main layout-->
        <main style="margin-top: 5%" >
            <div class="">
                <%  DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    String formattedDate = df.format(new Date());


                %>

                <div>
                    <h3 style="padding-right: 20em;color: black"> <u>Interns </u> &emsp; <u>Date :<%=formattedDate%>  </u> </h3>
                </div>

                <!--Table-->
                <table id="dtBasicExample" class="table  table-bordered" cellspacing="0" width="100%" >

                    <!--Table head-->
                    <thead class="text-dark">
                        <tr>
                    <strong>     <th>No </th>  </strong>        
                    <strong>     <th>Name </th>  </strong>  
                    <strong>     <th> Daily Review</th>    </strong>                  


                    </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="intern" items="${interns}" varStatus="count">
                            <tr> <td>${count.index+1}</td>
                                <td><a href="#" data-toggle="modal" data-target="#interndetails${count.index}" style="color: black">${intern.name} </a> </td>                                                     
                                <td>
                                    <div class="text-center">
                                        <button class="btn btn-blue btn-sm btn-rounded" data-toggle="modal" onclick="insertValue()" data-target="#modaladdmore${count.index}"
                                                >Daily Review </button>
                                    </div>

                                </td>

                            </tr>

                        </tbody>

                        <!--Table body-->

                    </table>  

                </div> 
            </main>

            <div class="modal fade" id="modaladdmore${count.index}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header text-center">
                            <h4 class="modal-title w-100 font-weight-bold" ><b>Intern Daily Review</b></h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form action="addInternDetails" method="post">

                            <input type="hidden" value="" name="id">
                            <div class="modal-body mx-3">
                                <div class="md-form mb-5">                                    
                                    <input type="text" id="form29" value="<%=formattedDate%>" class="form-control " name="name" >
                                    <label  for="form29" style="color:black"><b>Date</b></label>
                                </div>
                                <div class="md-form mb-5">                                    
                                    <input type="text" id="form29" value="${intern.name} " class="form-control " name="name" >
                                    <label  for="form29" style="color:black"><b>Full Name </b></label>
                                </div>
                                <strong style="float: left;color:black;margin-top:-20px"> <b> Attendance</b> </strong> <br>
                                <div class="md-form mb-5 col"style="margin-left:-20px">   
                                    <select class="browser-default custom-select" style="margin-top:-20px" id="department" name="attendance">
                                        <option selected disabled select>Attendance</option>
                                        <option >Present</option>
                                        <option >Absent</option>

                                    </select>
                                </div>
                                
                                    <strong style="float: left;color:black;margin-top:-20px"> <b> Comments</b> </strong> <br>
                                    <div class="form-group green-border-focus" style="margin-top:-20px">
                                    <textarea class="form-control" id="exampleFormControlTextarea5" rows="2"></textarea>
                                </div>






                            </div>
                            <div class="modal-footer d-flex justify-content-center" style="margin-top:-50px">
                                <button class="btn btn-info btn-block my-4 " type="submit">Submit <i class="fas fa-paper-plane-o ml-1"></i></button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
                                    
                                    
                                    
                                    
                                    
            <div class="modal fade" id="interndetails${count.index}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header text-center">
                            <h4 class="modal-title w-100 font-weight-bold" ><b>Intern Details</b></h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form action="addInternDetails" method="post">

                            <input type="hidden" value="" name="id">
                            <div class="modal-body mx-3">
                               
                                <div class="row" style="margin-top:-20px">
                                    
                                    <div class="md-form mb-5 col" >                                    
                                    <input type="text" id="form29" value="${intern.name}" class="form-control " name="name" >
                                    <label  for="form29"><b>Full Name </b></label>
                                </div>

                                <div class="md-form mb-5 col">                                    
                                    <input type="email" id="form30" value="${intern.email}" class="form-control mb-4" name="email" >
                                    <label  for="form30"><b>Email</b></label>
                                </div>
                                    
                                    
                                </div>
                                 <div class="row" style="margin-top:-20px">
                                    
                                    <div class="md-form mb-5 col" >                                    
                                    <input type="text" id="form29" value="${intern.station}" class="form-control " name="name" >
                                    <label  for="form29"><b>Station </b></label>
                                </div>

                                <div class="md-form mb-5 col">                                    
                                    <input type="email" id="form30" value="${intern.department}" class="form-control mb-4" name="email" >
                                    <label  for="form30"><b>Department</b></label>
                                </div>
                                    
                                    
                                </div>
                                 <div class="row" style="margin-top:-20px">
                                    
                                    <div class="md-form mb-5 col">                                    
                                    <input type="text" id="form29" value="${intern.university}" class="form-control " name="name" >
                                    <label  for="form29"><b>University </b></label>
                                </div>

                                <div class="md-form mb-5 col">                                    
                                    <input type="email" id="form30" value="${intern.course}" class="form-control mb-4" name="email" >
                                    <label  for="form30"><b>Course</b></label>
                                </div>
                                    
                                    
                                </div>
                                 <div class="row" style="margin-top:-20px">
                                    
                                    <div class="md-form mb-5 col">                                    
                                    <input type="text" id="form29" value="${intern.from}" class="form-control " name="name" >
                                    <label  for="form29"><b>Period From </b></label>
                                </div>

                                <div class="md-form mb-5 col">                                    
                                    <input type="email" id="form30" value="${intern.to}" class="form-control mb-4" name="email" >
                                    <label  for="form30"><b>Period To</b></label>
                                </div>
                                    
                                    
                                </div>
                                    <div style="margin-top:-20px">
                                <button type="button" class="btn btn-info btn-block " data-dismiss="modal">Close</button>
                              </div>
                             
                             


                            </div>
                           
                        </form>
                    </div>
                </div>
            </div>


        </c:forEach>
        <!--Main layout-->
        <jsp:include page="./includes/scripts.jsp"/>
        <script type="text/javascript" src="js/toast_message.js"></script>
        <script>
                                            $(document).ready(function () {
                                                $('#dtBasicExample').DataTable();
                                            });
        </script>



    </body>

</html>





