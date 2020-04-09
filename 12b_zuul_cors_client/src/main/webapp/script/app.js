function callServiceOne() {
	$.ajax({
		  type: "GET",
		  url: "http://10.0.0.9:8888/service-one/hello",
		  success: function(response) {
			  console.log(response)
			  $( "#service-one-response" ).html( response );
		  }
		});
}