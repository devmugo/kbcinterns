<%-- 
    Document   : Viehrmanagers
    Created on : Apr 16, 2019, 3:30:27 PM
    Author     : AMO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-3.3.1.min.js"></script>

        <title>HR Managers </title>
    </head>
     <body >
      <% response.setHeader("Cache-Control", "no-cache,must-revalidate,no-store");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
            HttpSession sessionsa = request.getSession(false);
            String role = (String) sessionsa.getAttribute("role");
            String user = (String) sessionsa.getAttribute("user");
            if (role !="admin") {
                response.sendRedirect("Welcome.jsp");
            }


        %>

        <nav class="navbar navbar-expand-lg navbar-dark primary-color-dark">
            <ul class="navbar-nav">
                <a class="navbar-brand" href="#" style="margin-left: -250px">
                    <img src="img/logo.jpg" height="50" width="200" class="d-inline-block align-top"
                         alt="kbc logo"> 
                </a>
            </ul>
            <ul class="navbar-nav">

                <li class="nav-item"  style="margin:0 auto">
                    <a class="nav-link" href="adminHome">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
               

            </ul>


            <ul class="navbar-nav"  style="margin:0 auto">

                
                <li class="nav-item">
                    <a class="nav-link" href="addSupervisor.jsp">Add Supervisor</a>
                </li>

            </ul>


            <ul class="navbar-nav" style="margin:0 auto">

                
                <li class="nav-item">
                    <a class="nav-link" href="viewSupervisors">View Supervisors</a>
                </li>

            </ul>

            <ul class="navbar-nav" style="margin:0 auto">

                <li class="nav-item">
                    <a class="nav-link" href="#"><%=user%></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="logOut">Log Out</a>
                </li>

            </ul>


        </nav>




        <table id="dtBasicExample" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th class="th-sm"> <b>Index</b> 

                    </th>
                    <th class="th-sm"><b>Name </b> 

                    </th>                    
                     <th class="th-sm"><b>email </b> 
                    </th>
                    <th class="th-sm"><b>Station </b> 

                    </th>
                   
                  
                  


                </tr>
            </thead>

            <tbody>
                <c:forEach var="up" items="${hrs}" varStatus="count">
                    <tr> <td>${count.index+1}</td>
                        <td>${up.fname} ${up.lname} </td>
                        <td>${up.email}  </td>
                        <td>${up.station}</td>
                        

                    </tr>
               
            </c:forEach>
        </tbody>


    </table>
  <script>
            $(document).ready(function () {
                $('#dtBasicExample').DataTable();
            });
        </script>
    <jsp:include page="./includes/scripts.jsp"/>
    <jsp:include page="./includes/footer.jsp"/>
    <script type="text/javascript" src="js/toast_message.js"></script>

</body>
</html>
