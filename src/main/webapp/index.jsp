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
<meta charset="utf-8">
</head>
<body>
	<noscript>
		<h2 style="color: #ff0000">Seems your browser doesn't support
			Javascript! Websocket relies on Javascript being enabled. Please
			enable Javascript and reload this page!</h2>
	</noscript>

	<div id="welcome">
		<form>
			<p id="logo">WebSocket Chat</p>
			<input type="text" autocomplete="off" id="name" class="form-control"
				placeholder="Your name...">
			<div id="connect-btn">
				<button id="connect" class="btn btn-default" type="submit">
					Connect</button>
			</div>
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
				<tbody id="myMsg">
				</tbody>
				<tbody id="otherMsg">
				</tbody>
			</table>
		</div>
		<form class="form-inline">
			<div id="under-conversation">
				<input autocomplete="off" type="text" id="msg"
					class="form-control" placeholder="Message..."> <input
					type="hidden" id="ip" value="${ip}">
				<button id="send" class="btn btn-default" type="submit">Send</button>
				<button id="disconnect" class="btn btn-default" type="submit"
					disabled="disabled">Disconnect</button>
			</div>
		</form>

		<input type="hidden" id="Myip" value="${ip}">
	</div>
</body>
<meta charset="utf-8">
</html>
