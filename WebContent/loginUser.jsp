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
<div  id="login" class="container">
  <h2>Login</h2>
  <form class="form-horizontal" action="Login" method="post">
  <%
		if(request.getAttribute("errorMessage") != null){
	  %>
	  <label style="color:red;"><%=request.getAttribute("errorMessage")%></label>

	  <%
	    }
	  %>
    <div class="form-group">
      <label class="control-label col-sm-4" for="userName">User Name:</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="userName" value="<%= request.getAttribute("username") %>" name="userName" placeholder="Enter user name">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-4" for="pwd">Password:</label>
      <div class="col-sm-4">
        <input type="password" class="form-control" name="pwd" id="pwd" placeholder="Enter password">
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-4 col-sm-4">
        <button type="submit" class="btn btn-primary">Submit</button>
      </div>
    </div>
  </form>
</div>
</div>

</body>
</html>
