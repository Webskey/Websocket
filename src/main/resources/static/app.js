var stompClient = null;

function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#conversation").show();
	}
	else {
		$("#conversation").hide();
	}
	$("#greetings").html("");
}

function connect() {
	var socket = new SockJS('/gs-guide-websocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function (frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/greetings', function (greeting) {
			showGreeting(JSON.parse(greeting.body).content, JSON.parse(greeting.body).me);
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

function sendName() {
	stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val(), 'message': $('#msg').val(), 'ip' : $('#ip').val()}));
}

function showGreeting(message, me) {
	var myIP = $('#Myip').val();
	console.log("My IP : " + myIP);
	if(me === myIP) {
		$("#greetings").append("<tr><td><font color='red'>" + message + "</font></td></tr>");		
	} else {
		$("#greetings").append("<tr><td><font color='blue'>" + message + "</font></td></tr>");
	}
}

$(function () {
	$("form").on('submit', function (e) {
		e.preventDefault();
	});
	$( "#connect" ).click(function() { connect(); });
	$( "#disconnect" ).click(function() { disconnect(); });
	$( "#send" ).click(function() { sendName(); });
});

