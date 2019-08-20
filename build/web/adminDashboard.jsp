<%-- 
    Document   : adminDashboard
    Created on : Jul 24, 2019, 2:29:54 PM
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
        <title>Add HR </title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <jsp:include page="./includes/global_stylesheets.jsp"/>

    </head>
    <body >
        <jsp:include page="includes/adminskele.jsp"/> 

        <main>

            <div style="background-color: ">

                <%
                    HttpSession sessionsa = request.getSession(false);
                    int user = (Integer) sessionsa.getAttribute("id");
                  
                  


                %>
                 <br>
                 <br>
                 <br>
                 <br>
                <h1 style="color:black">asdfghjkl;'rfghujikol;perghjkl;erghujkl;'<%=user%>   </h1>




            </div>
        </main>

    </body>
</html>
