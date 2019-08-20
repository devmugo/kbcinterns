<%-- 
    Document   : supervisorProfile
    Created on : Aug 12, 2019, 10:31:11 AM
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
        <title>Supervisor Profile </title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <jsp:include page="./includes/global_stylesheets.jsp"/>

    </head>
    <jsp:include page="includes/supervisorskele.jsp"/>  

    <main>
        <div style="height:70px">

        </div>
        <div style="width:50%;margin:1em auto; background-color: white;">
            <div>
                <h1 style="color: black;text-align: center" >Supervisor Profile</h1>
            </div>
            <br> <br>


            <div class="form-group row">

                <div class="col-xs-6 col"style="margin-left: 8em">
                    <label for="first_name"><h4>Name</h4></label>
                </div>
                <div class="col">
                    <input type="text" class="form-control"  value="${requestScope.name}" readonly style="margin-left: -55%">
                </div>
            </div>


            <div class="form-group row">

                <div class="col-xs-6 col"style="margin-left: 8em">
                    <label for="first_name"><h4>User Name</h4></label>
                </div>
                <div class="col">
                    <input type="text" class="form-control"  value="${requestScope.username} " readonly style="margin-left: -55%">
                </div>
            </div>


            <div class="form-group row">

                <div class="col-xs-6 col"style="margin-left: 8em">
                    <label for="first_name"><h4>Station</h4></label>
                </div>
                <div class="col">
                    <input type="text" class="form-control"  value="${requestScope.station}" readonly style="margin-left: -55%">
                </div>
            </div>
                 <div class="form-group row">

                <div class="col-xs-6 col"style="margin-left: 8em">
                    <label for="first_name"><h4>Department</h4></label>
                </div>
                <div class="col">
                    <input type="text" class="form-control"  value="${requestScope.dprt}" readonly style="margin-left: -55%">
                </div>
            </div>

            <div style="margin-left:21em">
                <button class="btn btn-sm  btn-green" data-toggle="modal" data-target="#modaladdmore">Change Password </Button>
            </div>
            <br>


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

                                  
                                    <div class="md-form">
                                        <input type="text" id="materialLoginFormEmail" class="form-control" name="pass1">
                                        <label for="materialLoginFormEmail">Old Password</label>
                                    </div>

                                    <!-- Password -->
                                    <div class="md-form">
                                        <input type="text" id="materialLoginFormPassword" class="form-control" name="passn">
                                        <label for="materialLoginFormPassword">New Password</label>
                                    </div>

                                    <div class="md-form">
                                        <input type="text" id="materialLoginFormPassword" class="form-control" name="passn2">
                                        <label for="materialLoginFormPassword">Confirm New Password</label>
                                    </div>

                                    <input type="hidden" name="id" value="${requestScope.id}">

                                    <!-- Sign in button -->
                                    <button class="btn btn-primary btn-green"  type="submit">Change </button>





                                </form>
                                <!-- Form -->

                            </div>

                        </div>
                        <!-- Material form login -->




                    </div>
                </div>
            </div>






        </div>
    </main>

    <jsp:include page="./includes/scripts.jsp"/>

</body>
</html>

