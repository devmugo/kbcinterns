<%-- 
    Document   : Add More Details about the attachess
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
        <title>Add More Intern Details </title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <jsp:include page="./includes/global_stylesheets.jsp"/>

    </head>




    <body onload="insertValue();">

        <jsp:include page="includes/hrskele.jsp"/>  

        <main>
            <div style="height:80px">

            </div>
            <div style="width:50%;margin:auto; background-color: white;">
                <button class="btn btn-green "  onclick="goBack()"style="float: right">Back</button>

                <form class="text-center border border-light p-5" action="addInternDetails" method="post">

                    <div class="form-row mb-4">

                        <strong style="float: left"> <b> Full Name </b> </strong>
                        <input type="text"  class="form-control" placeholder="${requestScope.name}" readonly>


                    </div>
                    <input type="hidden" value="${requestScope.id}" name="id">
                    <div class="form-row mb-4">
                        <div class="col">
                            <strong style="float: left"> <b> Email </b> </strong>
                            <input type="text"  class="form-control" placeholder="example@gmail.com" name="email" required>
                        </div>
                        <div class="col">
                            <strong style="float: left"> <b> Phone Number </b> </strong>
                            <input type="text"  class="form-control" placeholder="0700111222" name="phone" required>
                        </div>
                    </div>
                    <div class="form-row mb-4">
                        <div class="col">
                            <strong style="float: left"> <b> College </b> </strong>
                            <select class="browser-default custom-select" id="colege" name="cole" required >
                                <option value=""></option>

                            </select>
                        </div>
                        <div class="col">
                            <a href="#" data-toggle="modal" data-target="#addcole"><img src="img/add.png" height="30px" style="margin-right: 11.5em;margin-top: 1.6em"></a>
                        </div>

                    </div>
                    <div class="form-row mb-4">
                        <div class="col">
                            <strong style="float: left"> <b> Course </b> </strong>
                            <input type="text" id="defaultRegisterFormLastName" class="form-control" placeholder="eg Mass Communication" name="course" required>
                        </div>
                        <div class="col">
                            <a href="#" data-toggle="modal" data-target="#adddprt"><img ></a>
                        </div>

                    </div>
                    <div class="form-row mb-4">
                        <div class="col">
                            <strong style="float: left"> <b> From Date </b> </strong>
                            <input type="date" id="defaultRegisterFormFirstName" class="form-control" name="from" required>
                        </div>
                        <div class="col">
                            <strong style="float: left"> <b> To Date </b> </strong>
                            <input type="date" id="defaultRegisterFormLastName" class="form-control" name="to" required>
                        </div>
                    </div>


                    <button class="btn btn-green btn-block " type="submit">Add</button>

                </form>

            </div>
        </main>



        <div class="modal fade" id="addcole" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header text-center">
                        <h4 class="modal-title w-100 font-weight-bold" ><b>Add New College</b></h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="addUni" method="post">

                        <div class="md-form mb-5">                                    
                            <strong style="float: left"> <b> College </b> </strong>
                            <br>
                            <br>
                            <input type="text" name="uni" id="defaultRegisterFormFirstName" class="form-control" placeholder="College" style="max-width:90%" required>
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


                var select = document.getElementById("colege");
                var i;
                var stations =${clgy};
                console.log(stations.length);
                for (i = 0; i < stations.length; i++) {

                    newOption = document.createElement("OPTION");
                    var newOptionVal = document.createTextNode(stations[i]);
                    newOption.appendChild(newOptionVal);
                    select.add(newOption);
                }





            }


        </script>
        <script>
            function goBack() {
                window.history.back();
            }
        </script>



    </body>
</html>