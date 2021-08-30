/**
 * 
 */
$(function(){
	$("#sendBtn").click(function(){sendMessage();});
});

var wsocket;

function sendMessage(){
	wsocket=new WebSocket("ws://localhost:8088/ws/echo-ws");
	wsocket.onmessage=onMessage;//메시지는 onMessgae 함수로 처리
	wsocket.onopen=function(){
		//서버 연결 시 메시지 전송
		wsocket.send($("#message").val());
	};
	wsocket.onclose=onClose;//닫는것은 onClose 메서드로 처리
}

//서버에서 메시지를 받으면 실행
function onMessage(event){
	var data=event.data;
	alert(`서버에서 데이터 받음: ${data}`);
	//연결종료
	wsocket.close();
	
}

//연결 종료시 실행
function onClose(event){
	alert("연결 끊김");
}