var stompClient = null;

function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#rest").show();
		$("#welcome").hide();
		$("#msg").select();
	}
	else {
		$("#rest").hide();		
		$("#welcome").show();
	}
	$("#myMsg").html("");
	$("#otherMsg").html("");
}

function connect() {
	var socket = new SockJS('/websocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function (frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/broker/conversation', function (message) {
			onMessage(JSON.parse(message.body).name, JSON.parse(message.body).message);
		});
	});
}

function disconnect() {
	if (stompClient !== null) {
		stompClient.disconnect();
	}
	setConnected(false);
	console.log("Disconnected");
}

function sendMessage() {
	if($('#msg').val().length > 0)
		stompClient.send("/receiver/message", {}, JSON.stringify({'name': $("#name").val(), 'message': $('#msg').val()}));
	$('#msg').val("");
}

function onMessage(name, message) {
	if(name === $('#name').val()) {
		$("#messages").append("<tr id='myMsg'><td>" + message + "</td></tr>");		
	} else {
		$("#messages").append("<tr id='otherMsg'><td><strong>" + name + " </strong>: " + message + "</td></tr>");
	}
	emoji();
	scrollToBottom('scrollable');
}

function emoji(){
	var table = $("#conversation").html();
	var images = ["<img src='https://image.flaticon.com/icons/svg/187/187134.svg' width='16px'>",
		"<img src='https://image.flaticon.com/icons/svg/187/187160.svg' width='16px'>",
		"<img src='https://image.flaticon.com/icons/svg/187/187130.svg' width='16px'>",
		"<img src='http://democracyinactionblog.com/wp-content/uploads/2011/07/Dim_Bulb1.jpg' width='40px'>",
		"<img src='https://image.flaticon.com/icons/svg/187/187143.svg' width='16px'>",
		"<img src='https://image.flaticon.com/icons/svg/187/187150.svg' width='16px'>"];
	var emojis = [":D", ":P", ":\\)", "zarowa", ":\\(", ";\\("];

	for (var i = 0; i < images.length; i++) { 
		var patt = new RegExp(emojis[i], "gi");
		table = table.replace(patt, images[i]);
	}
	$("#conversation").html(table);
}

function scrollToBottom(id){
	var div = document.getElementById(id);
	div.scrollTop = div.scrollHeight - div.clientHeight;
}

$(function () {
	$("form").on('submit', function (e) {
		e.preventDefault();
	});

	$("#connect").on('submit', function (e) {
		e.preventDefault();
		connect();
	});	

	$( "#disconnect" ).click(function() { disconnect(); });
	$( "#send" ).click(function() { sendMessage(); });
});
