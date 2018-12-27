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
  <script type="text/javascript" src="http://maps.google.com/maps/api/js?key=AIzaSyB04i20gc7nU0lFN2PoYXQpigu9X3kMrPY"></script>

</head>
<body>


<div class="bg-image"></div>

<nav class="navbar navbar-default navbar-fixed-top">
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
        <li><a href="homePage.html">HOME</a></li>
        <li><a href="homePage.html#About Us">ABOUT</a></li>
        <li><a onclick ="myFunction()">LOGOUT</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="bg-text">
<div  id="login" class="container">
  <h2>Add a parking spot</h2>
  <p>Let people use your empty parking spot and earn some money<p>
  <form id="addForm" name="addForm" class="form-horizontal" method="POST" action="AddParkSpot" onsubmit="func();">

    <div class="form-group">
      <label class="control-label col-sm-4" for="Address">Address</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="addressInput" name="Address" value="<%= request.getAttribute("address") %>" placeholder="Enter Address">
      </div>
    </div>
	    <div class="form-group">
      <label class="control-label col-sm-4" for="Date">Date</label>
      <div class="col-sm-4">
        <input type="Date" class="form-control" id="Date" name="date" value="<%= request.getAttribute("date") %>" >
      </div>
    </div>
	    <div class="form-group">
      <label class="control-label col-sm-4" for="FromHour">From hour</label>
      <div class="col-sm-4">
        <input type="time" class="form-control" id="FromHour" name="FromHour" placeholder="Enter From Hour" value="<%= request.getAttribute("fromHour") %>">
      </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-4" for="ToHour">To Hour</label>
      <div class="col-sm-4">
        <input type="time" class="form-control" id="ToHour" name="ToHour" value="<%= request.getAttribute("toHour") %>">
      </div>
    </div>
		<div class="form-group">
      <label class="control-label col-sm-4" for="price">Price</label>
      <div class="col-sm-4">
        <input type="number" class="form-control" id="price" name="price" value="<%= request.getAttribute("price") %>">
      </div>
    </div>
    <div class="form-group" style="display:none">
      <label class="control-label col-sm-4" for="lng"></label>
        <input type="text" style="display:none" class="form-control" id="lng" name="lng" value="<%= request.getAttribute("lng") %>">

    </div>
    <div class="form-group" style="display:none">
      <label class="control-label col-sm-4" for="lat"></label>
        <input type="text" style="display:none" class="form-control" id="lat" name="lat" value="<%= request.getAttribute("lat") %>">

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



<script>
function func() {
  var address = document.getElementById("addressInput").value;
  
  var searchUrl = 'https://maps.googleapis.com/maps/api/geocode/xml?key=AIzaSyB04i20gc7nU0lFN2PoYXQpigu9X3kMrPY&address=' + address;
  //alert("222222222");
  downloadUrl(searchUrl, function(data) {
    //alert("3333333333333333");
    var xml = parseXml(data);
    
    console.log("hi")

    var x = xml.getElementsByTagName("lat")[0];
    var y = x.childNodes[0];
    var z = y.nodeValue;

    if(!x){
    	alert("bad address");
    	document.getElementById("error_msg").style.visibility = "visible";
      return false;
    }

      document.getElementById("lat").value = z;
      
      x = xml.getElementsByTagName("lng")[0];
      y = x.childNodes[0];
      z = y.nodeValue;
      document.getElementById("lng").value = z;
      document.getElementById("addForm").submit();
      
      
      return true;
    });
    //alert("bugg");
    return false;
    }


function downloadUrl(url, callback) {
   var request = window.ActiveXObject ?
   new ActiveXObject('Microsoft.XMLHTTP') :
   new XMLHttpRequest;
       //alert('888888888888');

   request.onreadystatechange = function() {
           //alert('9999999999999999999');
   		if (this.readyState === this.DONE) {
   			callback(this.responseText, this.status); // do something; the request has completed
   		}
	}

   request.open('GET', url,false);
   request.send(null);


}


function parseXml(str) {
   if (window.ActiveXObject) {
     var doc = new ActiveXObject('Microsoft.XMLDOM');
     doc.loadXML(str);
     return doc;
   } else if (window.DOMParser) {
     return (new DOMParser).parseFromString(str, 'text/xml');
   }
}
function doNothing() {}

</script>



<form id="logout-form" style="display:none" action="Logout" method="POST"></form>

<script>
function myFunction() {
  document.getElementById("logout-form").submit();
}
</script>


</body>
</html>
