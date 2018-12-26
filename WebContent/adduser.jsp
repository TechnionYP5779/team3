<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Park4You</title>
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <link rel="stylesheet" href="styleAdd.css">
   <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">

<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">


  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="bg-image"></div>

<nav id="my_nav" class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Park4You</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">

      <ul class="nav navbar-nav navbar-right">
        <li><a href="index.html">HOME</a></li>
        <li><a href="index.html#About Us">ABOUT</a></li>
        <li><a href="loginUser.html">LOGIN</a></li>
        <li><a href="adduser.html">REGISTER</a></li>
        </ul>
    </div>

  </div>
</nav>







<div class="bg-text">
<div  id="registration" class="container">
  <h2>Registration</h2>
  <form class="form-horizontal" action="AddUser" method="post">
    <div class="form-group">
      <label class="control-label col-sm-4" for="userName">User Name</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="userName" name="userName" value="<%= request.getAttribute("username")  %>" placeholder="Enter user name">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-4" for="firstName">First name</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="firstName" name="firstName" value="<%= request.getAttribute("firstName")  %>"  placeholder="Enter first name">
      </div>
    </div>
	    <div class="form-group">
      <label class="control-label col-sm-4" for="lastName">Last name</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="lastName" name="lastName" value="<%= request.getAttribute("lastName")  %>"  placeholder="Enter last name">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-4" for="pwd">Password</label>
      <div class="col-sm-4">
        <input type="password" class="form-control" name="pwd" id="pwd" placeholder="Enter password">
      </div>
    </div>
	    <div class="form-group">
      <label class="control-label col-sm-4" for="phoneNumber">Phone number</label>
      <div class="col-sm-4">
        <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" value="<%= request.getAttribute("phoneNumber")  %>" placeholder="Enter phone number">
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-8">
        <button type="submit" class="btn btn-primary">Submit</button>
      </div>
    </div>
  </form>
  <%
	if(request.getAttribute("errorMessage") != null){
  %>
  <label style="color:red;"><%=request.getAttribute("errorMessage")%></label>
	
  <%
    }
  %>
</div>
</div>




</body>
</html>
