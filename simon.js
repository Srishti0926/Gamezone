var buttonColours = ["red", "blue", "green", "yellow"];

var userClickedPattern = []; //user entered pattern for all correct colours user selected
var gamePattern = []; //random pattern for all random colours selected




var level = 0;
var started = false;

var simonbdscore=0;
var score=0;


//started is used such that if the keyboard is pressed again, the game shoudlnt restart
$(document).keydown(function(){
  if(!started)
  {
    $("#level-title").text("Level " +level);
    nextSequence();
    started = true;
    
  }
});







//userChosenColour stores the id of the button that got clicked.
//The value of this is determined by how a function is called (runtime binding).
//this returns the HTML element code for the element that was clicked
//For e.g. <div type="button" id="yellow" class="btn yellow">, the attribute id is used then.
$(".btn").click(function() {
  var userChosenColour = $(this).attr("id");
  userClickedPattern.push(userChosenColour);

  // console.log(this); returns
  animatePress(userChosenColour);

  //everytime the button is clicked, the value is immediately checked with that of game pattern.
  //userClickedPattern.length-1 returns the last index of the array.
  checkAnswer(userClickedPattern.length-1);
})








function checkAnswer(currentLevel){
  //last element is checked.
  //so for first click, first two indexes i.e. 0 are checked and sizes are compared.
  //for second click, the second two indexes i.e. 1 are checked and the size of array is checked.
  //in this way each click is compared with the gamePattern.
  if(gamePattern[currentLevel] === userClickedPattern[currentLevel])
  {
    //console.log("Sucess");

    if(userClickedPattern.length === gamePattern.length)
    {
      setTimeout(function(){
        nextSequence();
      },1000);

    }
  }
  else
  {
    //console.log("wrong");

     //wrong should be in string as it isnt a string variable declared earlier
    $("body").addClass("game-over");
    setTimeout(function(){
      $("body").removeClass("game-over");
    }, 1000);

    $("#level-title").text("Game Over, Press Any Key to Restart");
    simonscoredata();
    startOver();
  }
}










//in this function the random color is pushed into the game pattern array
function nextSequence()
{
  //reset the userClickedPattern to an empty array ready for the next level.
  userClickedPattern = [];
  score=level*10;
  document.getElementById("ok").innerHTML=score;
  console.log(score);

  level++;
  $("#level-title").text("Level "+level);

  // random color is generated here
  var randomNumber= Math.floor(Math.random()*4);
  var randomChosenColour = buttonColours[randomNumber];
  gamePattern.push(randomChosenColour);

  //animation for the above button
  $("#" + randomChosenColour).fadeIn(100).fadeOut(100).fadeIn(100);
  
}







//Set timeout function is used to remove the pressed class after 100ms (HOW TO ADD DELAY?)
function animatePress(currentColour){
  $("#"+ currentColour).addClass("pressed");
  setTimeout(function(){
    $("#" + currentColour).removeClass("pressed");
  }, 100);
}

//started is again false, hence the keydown method will work again to check is a key is pressed.
//game pattern and level are also emptied.
function startOver()
{
  level = 0;
  gamePattern = [];
  started = false;
}



function simonscoredata(){
    console.log("====",score);
    simondbscore=score;
    var name=localStorage.getItem(1);
	  console.log("===",name);
	  var request = new XMLHttpRequest();
	  request.open('POST', 'http://localhost:8080/MINI/rest/hello/simonscore', true);
	  request.setRequestHeader("Content-Type","application/json"); 
	  var body= '{"simondbscore":"'+simondbscore+'", "userName":"'+name+'"}';
	  request.onload = function () {
		   var data = this.response;
		   console.log("received: ",data);      
	  }
	 request.send(body);
}