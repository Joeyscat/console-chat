
const input = document.getElementById("editor");
input.oninput = function () {
    if (input.value.indexOf('\n') > 0) {
        console.log("输入了回车键，发送消息");
        pap();
        const word = input.value.substring(0, input.value.length - 1);
        let username = document.getElementById("username").value;
        // writeTextAndUserNameToPanel(word, username);
        username = username === '' ? 'anonymous' : username;
        sendMessage(username + ": " + word);
        cleanEditor();
    }
};


let ws;

function init() {
    // Connect to Web Socket
    ws = new WebSocket("ws://127.0.0.1:9001/");

    // Set event handlers.
    ws.onopen = function () {
        writeTextToPanel('Online ...')
    };

    ws.onmessage = function (e) {
        console.log('Received Socket: ' + e.data);
        // e.data contains received string.
        writeTextToPanel(e.data);
    };

    ws.onclose = function () {
        writeTextToPanel("Offline");
    };

    ws.onerror = function (e) {
        writeTextToPanel("Connection Error");
        console.warn(e)
    };

}

function sendMessage(msg) {
    // You can send message to the Web Socket using ws.send.
    ws.send(msg);
    // writeTextToPanel(msg);
}

function onCloseClick() {
    ws.close();
}

/**
 * 将文本写入聊天面板
 * @param text
 */
function writeTextToPanel(text) {
    const panel = document.getElementById("content");
    const newLine = document.createElement("p");
    newLine.textContent = text;
    panel.appendChild(newLine)
}

function writeTextAndUserNameToPanel(text,username) {
    username = username === '' ? 'anonymous' : username;
    writeTextToPanel(username + ': ' + text);
}

/**
 * 清除输入框内容
 */
function cleanEditor() {
    document.getElementById("editor").value = '';
}

/**
 * 啪啪特效
 */
function pap() {

}