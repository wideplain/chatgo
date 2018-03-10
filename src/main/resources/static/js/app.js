$(function(){
    $(window).on('load', function(){
        var targetTop = $('#latest').offset().top;
        $('#messages--box').animate({
            scrollTop: targetTop
        }, 100);
        console.log('scroll done!!!!');
        return false;
    });
});

var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        document.getElementById("checkable").checked = true;
    }
    else {
        document.getElementById("checkable").checked = false;
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/chat-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe(location.pathname, function (message) {
            showMessage(JSON.parse(message["body"]));
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
//
function sendMessage() {
    stompClient.send(location.pathname + "/post", {}, JSON.stringify({'body': $("#bodyField").val(), 'roomId': parseInt($("#roomId").val())}));
}
//
function showMessage(message) {
    $("#message").append(
        '<div class="message__userphoto--container">'+
        '<div class="message__userphoto" style="background-image: url(/users/' + message.userId + '/profile-photo.jpg); "></div>' +
        '<div class="message--content__container">' +
        '<div class="message__username">' + message.username + '</div>' +
        '<div class="message__timestamp">' + message.createdAt + '</div>' +
        '<div class="message__text"><p>' + message.body + '</p></div></div>'
    );
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#send" ).click(function() { sendMessage(); });
});


$(function () {
    $('#checkable').on('click',function(){
        if($('#checkable').prop('checked')) {
            console.log('接続中');
            $(function() { connect(); });
        } else {
            $(function() { disconnect(); });
        }
    });

    $(function() { connect(); });
});