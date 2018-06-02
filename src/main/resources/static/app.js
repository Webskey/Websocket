var stompClient = null;

function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#conversatione").show();
	}
	else {
		$("#conversatione").hide();
	}
	$("#conversation").html("");
}

function connect() {
	var socket = new SockJS('/websocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function (frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/broker/conversation', function (message) {
			onMessage(JSON.parse(message.body).name, JSON.parse(message.body).message, JSON.parse(message.body).ip);
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
	stompClient.send("/receiver/message", {}, JSON.stringify({'name': $("#name").val(), 'message': $('#msg').val(), 'ip' : $('#ip').val()}));
	$('#msg').val("");
}

function onMessage(name, message, ip) {
	var myIP = $('#Myip').val();
	console.log("My IP : " + myIP);
	if(ip === myIP) {
		$("#conversation").append("<tr><td><font color='red'>" + name + " : " + message + "</font></td></tr>");		
	} else {
		$("#conversation").append("<tr><td><font color='blue'>" + name + " : " + message + "</font></td></tr>");
	}
}

$(function () {
	$("form").on('submit', function (e) {
		e.preventDefault();
	});
	$( "#connect" ).click(function() { connect(); });
	$( "#disconnect" ).click(function() { disconnect(); });
	$( "#send" ).click(function() { sendMessage(); });
});

