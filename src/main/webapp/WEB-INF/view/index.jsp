<!DOCTYPE html>
<html>
<head>
    <title>WebSocket Chat Application </title>
    <link href="/bootstrap.min.css" rel="stylesheet">
    <link href="/style.css" rel="stylesheet">
    <script src="/jquery-1.10.2.min.js"></script>
    <script src="/app.js"></script>
</head>
<body>
<div id="main-content" class="container">
    <div class="row">
        <div class="col-md-8">
            <form class="form-inline">
                <div class="form-group">
                    <label for="connect">Chat Application:</label>
                    <button id="connect" type="button">Start New Chat</button>
                    <button id="disconnect" type="button" disabled="disabled">End Chat
                    </button>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table id="chat">
                <thead>
                <tr>
                    <th>Welcome user. Please enter you name</th>
                </tr>
                </thead>
                <tbody id="helloworldmessage">
                </tbody>
            </table>
        </div>
            <div class="row">
        
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <textarea id="user" placeholder="Write your message here..." required></textarea>
                </div>
                <button id="send" type="submit">Send</button>
            </form>
        </div>
        </div>
    </div>
 
</div>

 <button onclick="send()">Send</button>
 <p id="demo"></p>
 <button onclick="socket.onmessage">Send</button>
</body>
<script type="text/javascript">
var socket = new WebSocket('ws://' + window.location.host + '/my-websocket-endpoint');

//Add an event listener for when a connection is open
socket.onopen = function() {
console.log('WebSocket connection opened. Ready to send messages.');

// Send a message to the server
socket.send('Hello, from WebSocket client!');
};
function send() {
	socket.send('Sent');
	}
	
function get() {
	socket.onmessage 
	}
//Add an event listener for when a message is received from the server
socket.onmessage = function(message) {
console.log('Message received from server: ' + message);
document.getElementById("demo").innerHTML = message.data;
};</script>
</html>