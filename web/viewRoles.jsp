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
        <title>View Roles </title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <jsp:include page="includes/adminskele.jsp"/>  
    </head>
    <body >

        <main style="width: 70%;margin: 4em auto;float: right;margin-right: 5em">
            <div>
                <h4>Roles</h4>

            </div>

            <table id="dtBasicExample" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th class="th-sm"> <b>Role ID</b> 

                        </th>
                        <th class="th-sm"><b>Role </b> 

                        </th>                    
                       
                        <th class="th-sm"><b> Delete</b> 
                        </th>

                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="up" items="${roles}" varStatus="count">
                        <tr> 
                            <td>${up.role_id}</td>
                            <td>${up.role_name}  </td>                            
                            <td>
                                <div class="text-center">
                                    <button class="btn btn-danger btn-sm btn-rounded buttonDelete" data-toggle="modal"  data-target="#modalDelete${count.index}"
                                            >Delete </button>
                                </div>

                            </td>
                        </tr>

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