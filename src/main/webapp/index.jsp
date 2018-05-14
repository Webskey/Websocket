<!DOCTYPE html>
<html><meta charset="utf-8">
<head>
    <title>Hello WebSocket</title>
    <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <!--   <link href="/main.css" rel="stylesheet"> -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/sockjs-client/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/stomp.min.js"></script>
    <script src="/app.js"></script>
<meta charset="utf-8"></head>
<body>
<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being
    enabled. Please enable Javascript and reload this page!</h2></noscript>

            <form class="form-inline">
                <div class="form-group">
                    <label for="connect">WebSocket connection:</label>
                    <button id="connect" class="btn btn-default" type="submit">Connect</button>
                    <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect
                    </button>
                </div>
            </form>       
       
            <form class="form-inline">
                <div class="form-group">
                    <label for="name">Your name:</label>
                    <input type="text" id="name" class="form-control" placeholder="name...">
                     <label for="msg">Your message:</label>
                    <input type="text" id="msg" class="form-control" placeholder="Message...">
                </div>
                <button id="send" class="btn btn-default" type="submit">Send</button>
            </form>

            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>Greetings</th>
                </tr>
                </thead>
                <tbody id="greetings">
                </tbody>
            </table>
</div>
</body>
<meta charset="utf-8">
</html>
