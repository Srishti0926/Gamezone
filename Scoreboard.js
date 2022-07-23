var tabButtons=document.querySelectorAll(".tabContainer .buttonContainer button");
var tabPanels=document.querySelectorAll(".tabContainer .tabPanel");
function showPanel(panelIndex,colorCode){
    tabButtons.forEach(function(node){
        node.style.backgroundColor="";
        node.style.color="";
    });
    tabButtons[panelIndex].style.backgroundColor=colorCode;
	tabButtons[panelIndex].style.color="white";
	tabButtons[panelIndex].style.backgroundColor= "#2f67b9";
    tabPanels.forEach(function (node){
        node.style.display="none";
    });
    tabPanels[panelIndex].style.display="block";
    tabPanels[panelIndex].style.backdroundColor=colorCode;
}
//showPanel(0,'#f44336');
function ticscoreboard()
{
    console.log("=");
    var request = new XMLHttpRequest();
	  request.open('GET', 'http://localhost:8080/MINI/rest/hello/ticscoreboard', true);
	  request.onload = function () {
		   var data = this.response;
		   var obj = JSON.parse(data);
		   var x = obj["Tic Tac Toe"];
		   console.log("received: ",x[0].Username);
		   createTable1(x);      
	  }
	 request.send(null);
    
}
	function createTable1(score){
		document.getElementById("Tab1").innerHTML="";
		var table = document.createElement('table');
		var t = document.createElement('tr');
		var headerCell1 = document.createElement('th');
		headerCell1.innerHTML ='Username';
		var headerCell2 = document.createElement('th');
		headerCell2.innerHTML ='Score';
		t.appendChild(headerCell1);
		t.appendChild(headerCell2);
		//console.log("",headerCell);
		table.appendChild(t);
	for (var i = 0; i < score.length; i++){

		var tr = document.createElement('tr');   

		var td1 = document.createElement('td');
		var td2 = document.createElement('td');

		var text1 = document.createTextNode(score[i].Username);
		var text2 = document.createTextNode(score[i].ScoreTTT);

		td1.appendChild(text1);
		td2.appendChild(text2);
		tr.appendChild(td1);
		tr.appendChild(td2);

		table.appendChild(tr);
	}
	document.getElementById("Tab1").appendChild(table); 

}

function simonscoreboard()
{
    console.log("==");
    var request = new XMLHttpRequest();
	  request.open('GET', 'http://localhost:8080/MINI/rest/hello/simonscoreboard', true);
	  request.onload = function () {
		   var data = this.response;
		   var obj = JSON.parse(data);
		   var x = obj["Simon"];
		   console.log("received: ",x[0].Username);
		   createTable2(x);      
	  }
	 request.send(null);
    
}
	function createTable2(score){
		document.getElementById("Tab2").innerHTML="";
		var table = document.createElement('table');
		var t = document.createElement('tr');
		var headerCell1 = document.createElement('th');
		headerCell1.innerHTML ='Username';
		var headerCell2 = document.createElement('th');
		headerCell2.innerHTML ='Score';
		t.appendChild(headerCell1);
		t.appendChild(headerCell2);
		table.appendChild(t);
	for (var i = 0; i < score.length; i++){

		var tr = document.createElement('tr');   

		var td1 = document.createElement('td');
		var td2 = document.createElement('td');

		var text1 = document.createTextNode(score[i].Username);
		var text2 = document.createTextNode(score[i].ScoreSimon);

		td1.appendChild(text1);
		td2.appendChild(text2);
		tr.appendChild(td1);
		tr.appendChild(td2);

		table.appendChild(tr);
	}
	document.getElementById("Tab2").appendChild(table); 

}

function sudokuscoreboard()
{
    console.log("===");
    var request = new XMLHttpRequest();
	  request.open('GET', 'http://localhost:8080/MINI/rest/hello/sudokuscoreboard', true);
	  request.onload = function () {
		   var data = this.response;
		   var obj = JSON.parse(data);
		   var x = obj["Sudoku"];
		   console.log("received: ",x[0].Username);
		   createTable3(x);      
	  }
	 request.send(null);
}
function createTable3(score){
	document.getElementById("Tab3").innerHTML="";
	var table = document.createElement('table');
	var t = document.createElement('tr');
	var headerCell1 = document.createElement('th');
	headerCell1.innerHTML ='Username';
	var headerCell2 = document.createElement('th');
	headerCell2.innerHTML ='Score';
	t.appendChild(headerCell1);
	t.appendChild(headerCell2);
	table.appendChild(t);
	for (var i = 0; i < score.length; i++){
		var tr = document.createElement('tr');   
		var td1 = document.createElement('td');
		var td2 = document.createElement('td');
		var text1 = document.createTextNode(score[i].Username);
		var text2 = document.createTextNode(score[i].ScoreSudoku);
		td1.appendChild(text1);
		td2.appendChild(text2);
		tr.appendChild(td1);
		tr.appendChild(td2);
		table.appendChild(tr);
	}
	document.getElementById("Tab3").appendChild(table); 
}
