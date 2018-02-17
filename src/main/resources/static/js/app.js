$(function(){
    $(window).on('load', function(){
        var targetTop = $('#latest').offset().top;
        $('#messages--box').animate({
            scrollTop: targetTop
        }, 800);
        console.log('scroll done!!!!');
        return false;
    });
});

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
        stompClient.subscribe(location.pathname, function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
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
function sendName() {
    stompClient.send(location.pathname + "/post", {}, JSON.stringify({'body': $("#bodyField").val()}));
}
//
function showGreeting(socketMessage) {
    $("#message").append(
        '<div class="message__userphoto--container">'+
        '<div class="message__userphoto"></div>' +
        '<div class="message--content__container">' +
        '<div class="message__username">' + username + '</div>' +
        '<div class="message__timestamp">' + timestamp + '</div>' +
        '<div class="message__text"><p>' + socketMessage + '</p></div></div>'
    );
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#send" ).click(function() { sendName(); });
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
});