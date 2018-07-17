<!DOCTYPE html>
<html>
<meta charset="utf-8">
<head>
<title>WebSocket Chat</title>
<link rel="shortcut icon" type="image/png"
	href="https://d30y9cdsu7xlg0.cloudfront.net/png/32396-200.png" />
<link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/main.css" rel="stylesheet">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/sockjs-client/sockjs.min.js"></script>
<script src="/webjars/stomp-websocket/stomp.min.js"></script>
<script src="/app.js"></script>
</head>
<body>
	<input type="hidden" id="paramName" value="${name}">
	
	<div id="welcome">
		<form id='connect'>
			<p id="logo">WebSocket Chat</p>
			<input type="text" autocomplete="off" id="name" class="form-control"
				required placeholder="Your name...">
			<button id="connect-btn" class="btn btn-default" type="submit">
				Connect</button>
		</form>
	</div>

	<div id="rest">
		<div id="scrollable">
			<table id="conversation" class="table table-striped">
				<thead>
					<tr>
						<th>Conversation</th>
					</tr>
				</thead>
				<tbody id="messages">
				</tbody>
			</table>
		</div>
		<form class="form-inline">
			<div id="under-conversation">
				<input autocomplete="off" type="text" id="msg" class="form-control"
					placeholder="Message...">
				<button id="send" class="btn btn-default" type="submit">Send</button>
				<button id="disconnect" class="btn btn-default" type="submit"
					disabled="disabled">Disconnect</button>
			</div>
		</form>
	</div>
</body>
</html>
