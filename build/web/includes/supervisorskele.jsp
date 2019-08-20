
 <style>

            .map-container{
                overflow:hidden;
                padding-bottom:56.25%;
                position:relative;
                height:0;
            }
            .map-container iframe{
                left:0;
                top:0;
                height:100%;
                width:100%;
                position:absolute;
            }
        </style>
           <%   
            HttpSession sessionsa = request.getSession(false);
            String user = (String) sessionsa.getAttribute("user");  
        %>
        <header>

<nav class="mb-1 navbar navbar-expand-lg navbar-dark default-color fixed-top">
    <div class="container-fluid">



        <!-- Collapse -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Links -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">

            <!-- Left -->
            <ul class="navbar-nav mr-auto">

                <li class="nav-item">
                    <a class="nav-link waves-effect" href="#" target="_blank">
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link waves-effect" href="#"
                       target="_blank">
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link waves-effect" href="3" target="_blank">
                    </a>
                </li>
            </ul>

            <!-- Right -->
            <ul class="navbar-nav nav-flex-icons">
               <ul class="navbar-nav nav-flex-icons">
               <li class="nav-item ">
                <a class="nav-link p-0" href="#">
                    <img src="img/Profile.png" class="rounded-circle z-depth-0"
                         alt="avatar image" height="35">
                </a>
            </li>
         
               <li class="nav-item">
                   <a class="nav-link" href="#" style="color: black;font-weight: bold"><%=user%>   </a>
                    </li>
                   
                <li class="nav-item">
                    <a href="logOut" class="nav-link border border-light rounded waves-effect"
                       style="color:black;font-weight: bold"
                       <i class="fab fa-github mr-2"></i> LOG OUT
                    </a>
                </li>
            </ul>
            </ul>

        </div>

    </div>
</nav>



<div class="sidebar-fixed position-fixed"  style="height:100%; background-color: white;margin-top: 60px;width: 20%">

    <a class="logo-wrapper waves-effect">
        <img src="img/logo.jpg" class="img-fluid" alt="" height="70px" width="100px" >
    </a>
    <br> <br> 

    <div class="list-group list-group-flush">       
        
        <a href="fillAttendance" class="list-group-item list-group-item-action waves-effect">
            Mark Register</a> 
     
        <a href="viewAttendance" class="list-group-item list-group-item-action waves-effect">
          Check Attendance   </a>
          <a href="toAdminViewAllInternsWork" class="list-group-item list-group-item-action waves-effect">
           Check Interns Activities </a>
        <a href="supervisorProfile" class="list-group-item list-group-item-action waves-effect">
          Profile </a>   
        <a href=" " class="list-group-item list-group-item-action waves-effect">
          </a>   
     
        
        
        

    </div>

</div>

</header>

