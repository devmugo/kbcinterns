<%-- 
    Document   : removedUsers
    Created on : Aug 14, 2019, 4:37:56 PM
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
        <title>Removed Users </title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <jsp:include page="includes/adminskele.jsp"/>  
    </head>
    <body >

        <main style="width: 70%;margin: 4em auto;float: right;margin-right: 5em">
            <div>
                <h4>Removed Users</h4>

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

                        <th class="th-sm"><b> Restore User</b> 
                        </th>


                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="up" items="${removed}" varStatus="count">
                        <tr> 
                            <td>${count.index  +1} </td>
                            <td>${up.firstname} ${up.lastName}</td>
                            <td>${up.username}  </td>
                            <td>${up.dprt_name}  </td>
                            <td>${up.stn_name}  </td>
                            <td>${up.role_name}  </td>
                            <td>
                                <div class="text-center">
                                    <button class="btn btn-green btn-sm btn-rounded " data-toggle="modal"  data-target="#modalDelete${count.index}"
                                            >Restore </button>
                                </div>

                            </td>

                        </tr>

                    <div class="modal fade" id="modalDelete${count.index}" tabindex="-1" role="dialog" aria-labelledby="modalDelete"
                         aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header text-center">
                                    <h4 class="modal-title w-100 font-weight-bold ml-5 "style="color:black">Restore</h4>
                                    <button type="button" class="close text-danger" data-dismiss="modal" aria-label="Close">

                                    </button>
                                </div>
                                <form method="post" action="restoreUser">
                                <div class="modal-body mx-3">
                                    <p class="text-center h4" style="color:black">Confirm you want to Restore <b>${up.firstname} ${up.lastName} </b>  </p> <br>
                                   
                                    <div class="form-row mb-4">
                                       
                                            <strong style="float: left;color:black"> <b> Enter Your Password  </b> </strong>
                                            <br>
                                           <input type="password" id="defaultRegisterFormFirstName" class="form-control" placeholder="Password" name="pass" required> 
                                           <input type="hidden" name="id" value="${up.id}">
                                    </div>
                                </div>                                     
                                     <div class="d-flex justify-content-center deleteButtonsWrapper" style="margin-top:-1.5em">
                                           <button class="btn btn-primary btnNoClass" type="submit"  style="margin-right:2em"> Restore</button>
                                         <button type="button" class="btn btn-primary btn-danger" id="btnNo" data-dismiss="modal">Cancel</button>
                                  
                                    
                                </div>
                                         </form>
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
