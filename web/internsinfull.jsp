<%-- 
    Document   : Viehrmanagers
    Created on : Apr 16, 2019, 3:30:27 PM
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
        <title>Interns Details </title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <jsp:include page="includes/hrskele.jsp"/>  
    </head>
    <body >  


        <main style="width: 75%;margin: 4em auto;float: right;margin-right: 3em">
            <div>
                <h4>Interns  </h4>

            </div>


            <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th class="th-sm"> <b>Index</b> 

                        </th>
                        <th class="th-sm"><b>Name </b> 

                        </th>
                        <th class="th-sm"><b>email </b> 
                        </th>

                        <th class="th-sm"><b>Phone No </b> 

                        </th>
                        <th class="th-sm"><b>Course</b> 
                        </th>
                        <th class="th-sm"><b>University </b> 
                        </th>
                        <th class="th-sm"><b>Period From </b> 
                        </th>
                         <th class="th-sm"><b>Period To </b> 
                        </th>




                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="up" items="${interns}" varStatus="count">
                        <tr> <td>${count.index+1}</td>
                            <td>${up.fullname}</td>
                            <td>${up.email}  </td>
                            <td>${up.phone}</td>
                            <td>${up.course}</td>
                            <td>${up.college_name}</td>
                            <td>${up.from}</td>
                            <td>${up.to}</td>


                        </tr>

                    </c:forEach>
                </tbody>


            </table>
        </main>
          <jsp:include page="./includes/scripts.jsp"/>    
            <script>
                $(document).ready(function () {
                    $('#dtBasicExample').DataTable();
                });
            </script>
          


    </body>
</html>
