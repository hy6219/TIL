/**
 * 
 */
document.body.style.backgroundColor="orange";
setTimeout(function(){
	opener.open("https://www.naver.com","_self");
	self.close();
},5000);
