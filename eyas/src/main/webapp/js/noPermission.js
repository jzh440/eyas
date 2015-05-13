$(function(){
	
	 var arr=window.location.href.split("=");
	 
	 if(arr[1]=='gisyw'){
		 $('#login').attr('href','/gisyw/login.jsp'); 
		 $('#registor').attr('href','/gisyw/register.jsp'); 
		 
	 }else{
		 $('#login').attr('href','/gisyw/portal/page/login/login.jsp'); 
		 $('#registor').attr('href','/gisyw/portal/register.jsp'); 
	 }
	
});