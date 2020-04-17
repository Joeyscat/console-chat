let stompClient = null;

function setConnected(connected) {
    // $("#username").prop("disabled", !connected);
    $("#editor").prop("disabled", !connected);
    if (connected) {
        $("#info").show();
    } else {
        $("#info").hide();
    }
    $("#greetings").html("");
}

function connect() {
    const socket = new SockJS('/web-chat-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/chat', function (data) {
            const message = JSON.parse(data.body);
            showMessage(message);
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

function sendMessage(username, content) {
    stompClient.send("/chat/room1", {}, JSON.stringify({'username': username, 'content': content}));
}

$(function () {
    // 判断当前是否已经存在会话，没有就建立连接
    if (stompClient == null) {
        console.log('登录聊天室 ... ');
        connect();
    }

    // 读取浏览器缓存的用户名作为当前用户名
    loadUserName();

    // 监听 用户输入，但用户按下回车键 立即向服务器发送消息
    const input = document.getElementById("editor");
    input.oninput = function () {
        if (input.value.indexOf('\n') > 0) {
            console.log("输入了回车键，发送消息");
            const word = input.value.substring(0, input.value.length - 1);
            let username = document.getElementById("username").value;
            // writeTextAndUserNameToPanel(word, username);
            username = username === '' ? 'anonymous' : username;
            sendMessage(username, word);
            document.getElementById("editor").value = '';
        }
    };

    // 暂时没有绑定"断开连接/下线"按钮
    $("#disconnect").click(function () {
        disconnect();
    });

    const usernameInput = document.getElementById("username");
    usernameInput.oninput = function () {
        const username = document.getElementById("username").value;
        console.log("save user name: " + username);
        localStorage.setItem('web-socket-chat-user-name', username);
    };

});



function showMessage(msg) {
    const panel = document.getElementById("ul-chat");
    const newLine = document.createElement("li");
    if (msg.username !== $('#username').val()) {
        newLine.textContent = msg.username + ': ' + msg.content;
    } else {
        newLine.textContent = msg.content;
    }
    panel.appendChild(newLine);
    // $('#content').animate({scrollTop: $('.chat-box').offset().top}, 800);
    const co = document.getElementById('content');
    co.scrollTop = co.scrollHeight;
}

function loadUserName() {
    const username = localStorage.getItem('web-socket-chat-user-name');
    console.log('user name: ' + username);
    document.getElementById('username').value = username;
}
