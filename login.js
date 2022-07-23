function databaselogin(){
    console.log("inside login");
    var username;
    var password;
    username=document.getElementById("Un").value;
    password=document.getElementById("Pw").value;
    localStorage.setItem(1, username);
    console.log("++++",username);
    console.log("++++",password);
    if(username=="") alert("Please Enter UserName");
    if(password=="") alert("Please Enter Password");
	var request = new XMLHttpRequest();
    request.open('POST', 'http://localhost:8080/MINI/rest/hello/login', true);
    request.setRequestHeader("Content-Type","application/json"); 
    var body= '{"userName":"'+username+'", "password":"'+password+'"}';
    request.onload = function () {
         var data = this.response;
         if(data[0]=="f") alert("Please Enter valid username and password!");
         else window.location.href="Gameselection.html"
         console.log("received: ",data);      
    }
   request.send(body);
}
