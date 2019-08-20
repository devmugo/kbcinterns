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
        <title>View Interns </title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <jsp:include page="includes/hrskele.jsp"/>  
    </head>
    <body >

        <main style="width: 70%;margin: 4em auto;float: right;margin-right: 5em">
            <div>
                <h4>Users</h4>

            </div>

            <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th class="th-sm"> <b> #</b> 

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

                        <th class="th-sm"><b> Add More Details</b> 


                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="up" items="${users}" varStatus="count">
                        <tr>
                            <td>${count.index+1}  </td>
                            <td>${up.firstname} ${up.lastName}</td>
                            <td>${up.username}  </td>
                            <td>${up.dprt_name}  </td>
                            <td>${up.stn_name}  </td>
                            <td>${up.role_name}  </td>

                            <td>
                                <div class="text-center">
                                    <form method="get" action="toAddMore">
                                        <input type="hidden" name="id" value="${up.id}">
                                        <input type="hidden" name="fname" value="${up.firstname}">
                                        <input type="hidden" name="lname" value="${up.lastName}">
                                        
                                        
                                    <button type="submit" class="btn btn-blue btn-sm btn-rounded "  >edit </button>
                                    </form>
                                </div>

                            </td>
                        </tr>



                    </c:forEach>
                </tbody>


            </table>


            <jsp:include page="./includes/scripts.jsp"/>            



        </main>
    </body>

    <script>
        $(document).ready(function () {
            $('#dtBasicExample').DataTable();
        });
    </script>


</html>