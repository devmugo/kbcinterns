<%-- 
    Document   : adminViewIndInternWork
    Created on : Aug 7, 2019, 1:40:00 PM
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
        <title>View Interns Work </title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <jsp:include page="includes/supervisorskele.jsp"/>  
    </head>
    <body >

        <main style="width: 70%;margin: 4em auto;float: right;margin-right: 5em">
            <div>
                <h4> ${requestScope.name}  Daily Work</h4>

            </div>
            
             <table id="dtBasicExample" class="table table-striped table-bordered" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th class="th-sm"> <b> #</b> 

                        </th>
                        <th class="th-sm"><b>Date</b> 

                        </th>                   
                       
                        <th class="th-sm"><b> Work Done</b> 
                        </th>
                        
                        <th class="th-sm"><b> Skills Learnt</b> 
                        </th>

                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="up" items="${work}" varStatus="count">
                        <tr> 
                            <td>${count.index+1}</td>
                            <td>${up.date}  </td>
                            <td>${up.workdone}  </td>
                            <td>${up.skillslearnt}  </td>
                            
                           
                        </tr>

                    </c:forEach>
                </tbody>                
            </table>
        </main>
    </body>
    <jsp:include page="./includes/scripts.jsp"/>   
     <script>
        $(document).ready(function () {
            $('#dtBasicExample').DataTable();
        });
    </script>

</html>
