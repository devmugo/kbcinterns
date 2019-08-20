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
        <title>Check Intern Activities</title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <jsp:include page="includes/supervisorskele.jsp"/>  
    </head>
    <body >

        <main style="width: 70%;margin: 4em auto;float: right;margin-right: 5em">
            <div>
                <h4>Interns</h4>

            </div>

            <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th class="th-sm"> <b>#</b> 
                        </th>
                        
                        <th class="th-sm"><b>Intern </b>
                        </th>   
                        <th class="th-sm"><b>Check Activities </b>
                        </th> 
                       
                       
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="up" items="${interns}" varStatus="count">
                        <tr> 
                            <td>${count.index+1}</td>
                            <td>${up.firstname}   ${up.lastName} </td>                            
                            <td>
                                <div class="text-center">
                                    <form method="post" action="checkInternsWork">
                                        <input type="hidden" name="id" value="${up.id}">
                                    <button class="btn btn-info btn-sm btn-rounded " type="submit"
                                            >Check </button>
                                        </form>
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