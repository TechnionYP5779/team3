$(document).ready(function() {
	
  $.ajax({
    type: "POST",
    url : 'GetMyOrders',
    data : {
    },
    success : function(response) {
      console.log(response);
      parkings = JSON.parse(response);
      new_html = "";
      for (var i in parkings) {
        console.log(parkings[i]);
        new_html += "<tr><td>" + parkings[i].address +"</td><td>" + 
        parkings[i].Price +"</td><td>" + parkings[i].From +"</td><td>" + 
        parkings[i].To +"</td>" </tr>";
      }
      $("#BuyTable").html(new_html);
    },
    error: function(error) {
    	console.log(error);
  	}
  });
});