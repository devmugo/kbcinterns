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
        <title>Check Register</title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <jsp:include page="includes/supervisorskele.jsp"/>  
    </head>
    <body >

        <main style="width: 70%;margin: 4em auto;float: right;margin-right: 5em">
            <div >
                <h4>Departments Intern Attendance </h4>

            </div>
            <div>
                  
                    <br>
                </div>
            <form method="post" action="checkRegister">

            <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th class="th-sm"> <b> #</b> 

                        </th>
                        <th class="th-sm"><b>Name </b> 

                        </th>                   
                       
                        <th class="th-sm"><b> Present</b> 
                        </th>
                        
                        <th class="th-sm"><b> Absent</b> 
                        </th>

                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="up" items="${interns}" varStatus="count">
                        <tr> 
                            <td>${count.index+1}</td>
                            <td>${up.firstname} ${up.lastName}  </td>
                            
                            <td>
                                <input name="${up.id}" type="radio" value="present" required > Present                                
                             
                            </td>
                             <td>
                                <input name="${up.id}" type="radio" value="absent" > Absent                               
                             
                            </td>
                        </tr>

                    </c:forEach>
                </tbody>
                


            </table>
                <button type="Submit" class="btn btn-info" style="margin-left: 30em">Submit</button>
                
                
                </form>




        </main>
    </body>
    <jsp:include page="./includes/scripts.jsp"/>            
    <script type="text/javascript" src="js/toast_message.js"></script>
</html>