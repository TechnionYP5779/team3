
$(document).ready(function() {
	
  $.ajax({
    type: "POST",
    url : 'GetUsersForRent',
    data : {
    },
    success : function(response) {
      console.log(response);
      parkings = JSON.parse(response);
      new_html = "";
      for (var i in parkings) {
        console.log(parkings[i]);
        new_html += "<tr  class=\"table-light\" ><td>" + parkings[i].Address +"</td><td>"
        		    + parkings[i].Price +"</td><td>" + parkings[i].Date +"</td><td>"
        		    + parkings[i].Hours +"</td><td>" + parkings[i].Occupied +"</td></tr>";
      }
      $("#parkings_table").html(new_html);
    },
    error: function(error) {
    	console.log(error);
  	}
  });
});