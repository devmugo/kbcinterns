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
        <title>View Attendance </title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <jsp:include page="includes/supervisorskele.jsp"/>  
    </head>
    <body >

        <main style="width: 70%;margin: 4em auto;float: right;margin-right: 5em">
            <div>
                <h4>View Attendance </h4>

            </div>
            <form action="viewAttendance">

             <div class="form-row mb-4">
                        <div class="col">
                            <strong style="float: left"> <b> Date </b> </strong>
                            <input placeholder="${requestScope.date}" class="form-control" type="text" onfocus="(this.type='date')"  id="date" name="date" > 
                                                     
                        </div>
                        <div class="col">
                            <button type="Submit" class="btn btn-info btn-sm" style="margin-top: 25px">Check</button>
                        </div>

                    </div>
                
                </form>
            
            
            <table class="table table-striped table-bordered" cellspacing="0" width="100%" style="background-color: white">
                <thead>
                    <tr>
                        <th class="th-sm"> <b>Date </b> 

                        </th>
                        <th class="th-sm"><b>Present</b> 

                        </th>                    
                       
                        <th class="th-sm"><b> Absent</b> 
                        </th>

                    </tr>
                </thead>

                <tbody>
                    
                        <tr> 
                            <td>${requestScope.date}</td>
                            <td>
                            <c:forEach var="up" items="${present}" varStatus="count">
                                ${up.firstname} ${up.lastName} <br>
                            
                            </c:forEach>
                                </td> 
                            <td>
                                <c:forEach var="up" items="${absent}" varStatus="count">
                                    ${up.firstname} ${up.lastName} <br>
                            
                            </c:forEach>
                             </td>   

                            </td>
                        </tr>

                   
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