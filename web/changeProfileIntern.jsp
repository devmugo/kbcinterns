<%-- 
    
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
        <title>Profile</title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
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
    


        <!--Main Navigation-->
        <header>
            <nav class="mb-1 navbar navbar-expand-lg navbar-dark white fixed-top" style="height:70px;">


                <div class="collapse navbar-collapse" id="navbarSupportedContent-333">
                    <ul class="navbar-nav mr-auto">
                        <a class="navbar-brand" href="#" style="margin-left: -250px">
                            <img src="img/logo.jpg" height="50" width="200" class="d-inline-block align-top"
                                 alt="mdb logo"> 
                        </a>

                    </ul>

                    <ul class="navbar-nav ml-auto nav-flex-icons">
                        <li class="nav-item ">
                            <a class="nav-link p-0" href="#">
                                <img src="img/Profile.png" class="rounded-circle z-depth-0"
                                     alt="avatar image" height="35">
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="#" style="color: black;font-weight: bold"></a>
                        </li>

                        <li class="nav-item">
                            <a class="btn btn-outline-default waves-effect btn-sm align-middle " href="logOut" >LOG OUT</a>
                        </li>



                    </ul>

                </div>

            </nav>           

            <div class="sidebar-fixed position-fixed">

                <a class="logo-wrapper waves-effect">
                    <img src="img/logo.jpg" class="img-fluid" alt="">
                </a>

                <div class="list-group list-group-flush">
                    <a href="internDailyWork.jsp" class="list-group-item list-group-item-action waves-effect" >
                        Add Daily Activities
                        <br></a>
                    <br>
                    <a href="internViewOwnActs.jsp"  class="list-group-item list-group-item-action waves-effect" >
                        View Your Daily Activities
                    </a>
                    <br>
                    <a href="profile" class="list-group-item active waves-effect">
                        Profile
                    </a>

                    <a href="" class="list-group-item list-group-item-action waves-effect">
                    </a>



                </div>

            </div>

        </header>
        <!--Main Navigation-->

        <!--Main layout-->
        <main style="margin-top: 5%" style="margin-left:40px" >
            <div class="">
                <!-- Material form login -->
                <div class="card" style="max-width: 80%;margin-top: 80px">


                    <div class="card-body px-lg-5 pt-0">

                        <div class="container bootstrap snippet">

                            <div class="row">
                                <div class="col-sm-3"><!--left col-->


                                    <div class="text-center">
                                        <img src="img/Profile.png" class="avatar img-circle img-thumbnail" alt="avatar">
                                        <br>  <br>
                                        <div class="col-sm-10"><h4><</h4></div>   

                                    </div>  
                                </div>

                                <div class="col-sm-9">           


                                    <div class="tab-content">
                                        <div class="tab-pane active" id="home">
                                            <hr>
                                            <div style="max-width: 100%;margin-left: 30px; height: 20px">
                                                    <h5 style="color:lightgreen; background-color: darkgreen">   ${requestScope.success} </h5> 
                                                    <h5 style="color:red;background-color:darkred"> ${requestScope.error}  </h5>  
                                                    <br>
                                                </div>
                                              
                                                
                                                <form class="form"  id="registrationForm">
                                                    <div class="form-group row">

                                                        <div class="col-xs-6 col" >
                                                            <label for="first_name"><h4>Name</h4></label>
                                                        </div>
                                                        <div class="col">
                                                            <input type="text" class="form-control"  value="" readonly style="margin-left: -60%">
                                                        </div>
                                                    </div>
                                                    <br>

                                                    <div class="form-group row">

                                                        <div class="col-xs-6 col" >
                                                            <label for="first_name"><h4>Email</h4></label>
                                                        </div>
                                                        <div class="col">
                                                            <input type="text" class="form-control" value="" readonly style="margin-left: -60%">
                                                        </div>
                                                    </div>
                                                    <br>

                                                    <div class="form-group row">

                                                        <div class="col-xs-6 col" >
                                                            <label for="first_name"><h4>Station</h4></label>
                                                        </div>
                                                        <div class="col">
                                                            <input type="text" class="form-control" value="" readonly style="margin-left: -60%">
                                                        </div>
                                                    </div>
                                                    <br>

                                                    <div class="form-group row">

                                                        <div class="col-xs-6 col" >
                                                            <label for="first_name"><h4>Department</h4></label>
                                                        </div>
                                                        <div class="col">
                                                            <input type="text" class="form-control" value="" readonly style="margin-left: -60%">
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <div class="form-group row">

                                                        <div class="col-xs-6 col" >
                                                            <label for="first_name"><h4>University</h4></label>
                                                        </div>
                                                        <div class="col">
                                                            <input type="text" class="form-control" value="" readonly style="margin-left: -60%">
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <div class="form-group row">

                                                        <div class="col-xs-6 col" >
                                                            <label for="first_name"><h4>Course</h4></label>
                                                        </div>
                                                        <div class="col">
                                                            <input type="text" class="form-control" value="" readonly style="margin-left: -60%">
                                                        </div>
                                                    </div>

                                                </form>
                                                <div style="margin-left:205px">
                                                    <button class="btn btn-primary btn-green" data-toggle="modal" data-target="#modaladdmore">Change Password </Button>
                                                </div>
                                                <div class="modal fade" id="modaladdmore" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                                                     aria-hidden="true">
                                                    <div class="modal-dialog" role="document">
                                                        <div class="modal-content">
                                                            <div class="modal-header text-center">
                                                                <h4 class="modal-title w-100 font-weight-bold" ><b>Change Password</b></h4>
                                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                    <span aria-hidden="true">&times;</span>
                                                                </button>
                                                            </div>                   



                                                            <div class="card">

                                                                
                                                                <div class="card-body px-lg-5 pt-0">


                                                                    <form class="text-center" style="color: #757575;" method="post" action="changePass">

                                                                        <input type="hidden" value="" name ="id">
                                                                        <div class="md-form">
                                                                            <input type="text" id="materialLoginFormEmail" class="form-control" name="pass1">
                                                                            <label for="materialLoginFormEmail">Old Password</label>
                                                                        </div>

                                                                        <!-- Password -->
                                                                        <div class="md-form">
                                                                            <input type="password" id="materialLoginFormPassword" class="form-control" name="passn">
                                                                            <label for="materialLoginFormPassword">New Password</label>
                                                                        </div>

                                                                        <div class="md-form">
                                                                            <input type="password" id="materialLoginFormPassword" class="form-control" name="passn2">
                                                                            <label for="materialLoginFormPassword">Confirm New Password</label>
                                                                        </div>



                                                                        <!-- Sign in button -->
                                                                        <button class="btn btn-primary btn-green"  type="submit">Change </button>





                                                                    </form>
                                                                    <!-- Form -->

                                                                </div>

                                                            </div>
                                                            <!-- Material form login -->


                                                            </form> 

                                                        </div>
                                                    </div>
                                                </div>

                                            
                                        </div>
                                    </div>  
                                </div>

                            </div>

                        </div>


                    </div> 
                </div>
            </div>

        </main>


        <jsp:include page="./includes/scripts.jsp"/>
        <script type="text/javascript" src="js/toast_message.js"></script>




    </body>

</html>


