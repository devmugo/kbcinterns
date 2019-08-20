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
        <title>View Users </title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <jsp:include page="includes/adminskele.jsp"/>  
    </head>
    <body >

        <main style="width: 70%;margin: 4em auto;float: right;margin-right: 5em">
            <div>
                <h4>Users</h4>

            </div>


            <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th class="th-sm"> <b>#</b> 

                        </th>
                        <th class="th-sm"> <b>Full Names</b> 

                        </th>
                        <th class="th-sm"><b>User Name </b> 

                        </th>                    
                        <th class="th-sm"><b> Department</b> 
                        </th>
                        <th class="th-sm"><b> Station</b> 
                        </th>

                        <th class="th-sm"><b> Role</b> 
                        </th>

                        <th class="th-sm"><b> Remove User</b> 
                        </th>
                        <th class="th-sm"><b> Reset Password</b> 
                        </th>

                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="up" items="${users}" varStatus="count">
                        <tr> 
                            <td>${count.index  +1} </td>
                            <td>${up.firstname} ${up.lastName}</td>
                            <td>${up.username}  </td>
                            <td>${up.dprt_name}  </td>
                            <td>${up.stn_name}  </td>
                            <td>${up.role_name}  </td>
                            <td>
                                <div class="text-center">
                                    <button class="btn btn-danger btn-sm btn-rounded buttonDelete" data-toggle="modal"  data-target="#modalDelete${count.index}"
                                            >Remove </button>
                                </div>

                            </td>
                            <td>
                                <div class="text-center">
                                    <button class="btn btn-blue btn-sm btn-rounded" data-toggle="modal"  data-target="#modalReset${count.index}"
                                            >Reset </button>
                                </div>

                            </td>

                        </tr>

                    <div class="modal fade" id="modalDelete${count.index}" tabindex="-1" role="dialog" aria-labelledby="modalDelete"
                         aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header text-center">
                                    <h4 class="modal-title w-100 font-weight-bold ml-5 "style="color:black">Delete</h4>
                                    <button type="button" class="close text-danger" data-dismiss="modal" aria-label="Close">

                                    </button>
                                </div>
                                <div class="modal-body mx-3">
                                    <p class="text-center h4" style="color:black">Are you sure to Remove <b>${up.firstname} ${up.lastName} </b> from the system ? </p> <br>
                                    <p class="text-center h4"style="color:black">Note: This Action is permanent </p> 


                                </div>
                                <div class="modal-footer d-flex justify-content-center deleteButtonsWrapper">

                                    <a class="btn btn-primary btn-danger" href="removeUser?id=${up.id}"> Yes</a>
                                    <button type="button" class="btn btn-primary btnNoClass" id="btnNo" data-dismiss="modal">No</button>
                                </div>
                            </div>
                        </div>
                    </div>



                    <div class="modal fade" id="modalReset${count.index}" tabindex="-1" role="dialog" aria-labelledby="modalDelete"
                         aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header text-center">
                                    <h4 class="modal-title w-100 font-weight-bold ml-5 "style="color:black">Reset Password</h4>
                                    <button type="button" class="close text-danger" data-dismiss="modal" aria-label="Close">

                                    </button>
                                </div>
                                <div class="modal-body mx-3">
                                    <p class="text-center h4" style="color:black">Are you sure to Reset <b>${up.firstname} ${up.lastName} </b> password? </p> <br>



                                </div>
                                <div class="modal-footer d-flex justify-content-center deleteButtonsWrapper">

                                    <div class="text-center">
                                        <form method="post" action="resetPassAdmin">
                                            <input type="hidden" value="${up.id}" name="id">
                                            <button class="btn btn-primary btnNoClass " type="submit"
                                                    >Reset </button>
                                        </form>
                                    </div>
                                    <button type="button" class="btn btn-red btn-primary btnNoClass" id="btnNo" data-dismiss="modal">No</button>
                                </div>
                            </div>
                        </div>
                    </div>






                </c:forEach>
                </tbody>


            </table>




        </main>
    </body>
    <jsp:include page="./includes/scripts.jsp"/>            
    <script type="text/javascript" src="js/toast_message.js"></script>
    <script>
        $(document).ready(function () {
            $('#dtBasicExample').DataTable();
        });
    </script>


</html>