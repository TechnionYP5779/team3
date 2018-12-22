
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
        new_html += "<tr><td>" + parkings[i].address +"</td><td>"
        		    + parkings[i].Price +"</td><td>" + parkings[i].From +"</td><td>"
        		    + parkings[i].To +"</td><td>" + /*parkings[i].Occupied*/ "No" +"</td></tr>";
      }
      $("#parkings_table").html(new_html);
    },
    error: function(error) {
    	console.log(error);
  	}
  });
});