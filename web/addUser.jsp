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
        <title>Add Users </title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <jsp:include page="./includes/global_stylesheets.jsp"/>

    </head>
    
    


    <body onload="insertValue();">

        <jsp:include page="includes/adminskele.jsp"/>  

        <main>
            <div style="height:80px">

            </div>
            <div style="width:50%;margin:auto; background-color: white;">
                <form class="text-center border border-light p-5" action="addUsers" method="post">

                    <strong style=""> <b> Add User </b> </strong>
                    <br><br>
                    <div class="form-row mb-4">
                        <div class="col">
                            <strong style="float: left"> <b> First Name </b> </strong>
                            <input type="text" id="defaultRegisterFormFirstName" class="form-control" placeholder="First name" name="fname" required>
                        </div>
                        <div class="col">
                            <strong style="float: left"> <b> Last Name </b> </strong>
                            <input type="text" id="defaultRegisterFormLastName" class="form-control" placeholder="Last name" name="lname" required>
                        </div>
                    </div>
                    <div class="form-row mb-4">
                        <div class="col">
                            <strong style="float: left"> <b> Station </b> </strong>
                            <select class="browser-default custom-select" id="station" name="station" required>
                                <option value=""></option>

                            </select>
                        </div>
                        <div class="col">
                            <a href="#" data-toggle="modal" data-target="#addstn"><img src="img/add.png" height="30px" style="margin-right: 11.5em;margin-top: 1.6em"></a>
                        </div>

                    </div>
                    <div class="form-row mb-4">
                        <div class="col">
                            <strong style="float: left"> <b> Department </b> </strong>
                            <select class="browser-default custom-select" id="department" name="department" required>
                                <option value="" ></option>

                            </select>
                        </div>
                        <div class="col">
                            <a href="#" data-toggle="modal" data-target="#adddprt"><img src="img/add.png" height="30px" style="margin-right: 11.5em;margin-top: 1.6em"></a>
                        </div>

                    </div>
                    <div class="form-row mb-4">
                        <div class="col">
                            <strong style="float: left"> <b> Role</b> </strong>
                            <select class="browser-default custom-select" id="role" name="role" required>
                                <option value=""></option>

                            </select>
                        </div>
                        <div class="col">
                            <a href="#" data-toggle="modal" data-target="#addrole"><img src="img/add.png" height="30px" style="margin-right: 11.5em;margin-top: 1.6em"></a>
                        </div>

                    </div>

                    <button class="btn btn-green btn-block " type="submit">Add</button>

                </form>

            </div>
        </main>

        <div class="modal fade" id="addrole" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header text-center">
                        <h4 class="modal-title w-100 font-weight-bold" ><b>Add New Role</b></h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="addRole" method="post">

                        <div class="md-form mb-5">                                    
                            <strong style="float: left"> <b> Role </b> </strong>
                            <br>
                            <br>
                            <input type="text" name="role" id="defaultRegisterFormFirstName" class="form-control" placeholder="Role" style="max-width:90%" required>
                        </div>


                        <div class="modal-footer d-flex justify-content-center" style="margin-top:-50px">
                            <button class="btn btn-info btn-green my-4 btn-sm" type="submit">Add <i class="fas fa-paper-plane-o ml-1"></i></button>
                        </div>

                    </form>
                </div>
            </div>

        </div>

        <div class="modal fade" id="adddprt" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header text-center">
                        <h4 class="modal-title w-100 font-weight-bold" ><b>Add New Department</b></h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="addDprt" method="post">

                        <div class="md-form mb-5">                                    
                            <strong style="float: left"> <b> Department </b> </strong>
                            <br>
                            <br>
                            <input type="text" name="dprt" id="defaultRegisterFormFirstName" class="form-control" placeholder="Department" style="max-width:90%" required>
                        </div>


                        <div class="modal-footer d-flex justify-content-center" style="margin-top:-50px">
                            <button class="btn btn-info btn-green my-4 btn-sm" type="submit">Add <i class="fas fa-paper-plane-o ml-1"></i></button>
                        </div>

                    </form>
                </div>
            </div>

        </div>

        <div class="modal fade" id="addstn" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header text-center">
                        <h4 class="modal-title w-100 font-weight-bold" ><b>Add New Station</b></h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="addStation" method="post">

                        <div class="md-form mb-5">                                    
                            <strong style="float: left"> <b> Station </b> </strong>
                            <br>
                            <br>
                            <input type="text" name="station" id="defaultRegisterFormFirstName" class="form-control" placeholder="Station" style="max-width:90%" required>
                        </div>


                        <div class="modal-footer d-flex justify-content-center" style="margin-top:-50px">
                            <button class="btn btn-info btn-green my-4 btn-sm" type="submit">Add <i class="fas fa-paper-plane-o ml-1"></i></button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
         <jsp:include page="./includes/scripts.jsp"/>
        <script>
            function insertValue()
            {

               
                var select = document.getElementById("station");
                var i;
                var stations =${stn};
                console.log(stations.length);
                for (i = 0; i < stations.length; i++) {

                    newOption = document.createElement("OPTION");
                    var newOptionVal = document.createTextNode(stations[i]);
                    newOption.appendChild(newOptionVal);
                    select.add(newOption);
                }

                var select = document.getElementById("department");
                var i;
                var stations = ${dprt};
                for (i = 0; i < stations.length; i++) {

                    newOption = document.createElement("OPTION");
                    var newOptionVal = document.createTextNode(stations[i]);
                    newOption.appendChild(newOptionVal);
                    select.add(newOption);





                }
                var select = document.getElementById("role");
                var i;
                var stations = ${role}
                for (i = 0; i < stations.length; i++) {

                    newOption = document.createElement("OPTION");
                    var newOptionVal = document.createTextNode(stations[i]);
                    newOption.appendChild(newOptionVal);
                    select.add(newOption);





                }
               




                }
            
            


        </script>
        


    </body>
</html>