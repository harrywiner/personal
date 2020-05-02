/*
// duplicate code
// copy setup code from model into game
// delete model setup 
// delete model draw
// put the change direction code into gotResult
// https://teachablemachine.withgoogle.com/models/WUTU3YGRh/ arrows
// https://teachablemachine.withgoogle.com/models/cbdJ3ExoM/ words
https://teachablemachine.withgoogle.com/models/npOpXECuM/
*/

// Classifier Variable
let classifier;
// Model URL
let imageModelURL = 'https://teachablemachine.withgoogle.com/models/cbdJ3ExoM/';

// Video
let video;
let flippedVideo;
// To store the classification
let label = "";

// Load the model first
function preload() {
  classifier = ml5.imageClassifier(imageModelURL + 'model.json');
}

// Get a prediction for the current video frame
function classifyVideo() {
  flippedVideo = ml5.flipImage(video)
  classifier.classify(flippedVideo, gotResult);
  flippedVideo.remove();

}

// When we get a result
function gotResult(error, results) {
  // If there is an error
  if (error) {
    console.error(error);
    return;
  }
  // The results are in an array ordered by confidence.
  // console.log(results[0]);
  label = results[0].label;
  
  // 
  if (label == "right") {
    myPlayer.direction(3,0);
    } else if (label == "down") {
    myPlayer.direction(0,3);
    }
    else if (label == "up") {
    myPlayer.direction(0,-3);
    }
    else if (label == "left") {
    myPlayer.direction(-3,0);
    }
  // Classifiy again!
  classifyVideo();
}


  var score = 0
  var timer = 20

function setup() {
  createCanvas(400, 400);

  myPlayer = new player;
  myFood = new food;

  video = createCapture(VIDEO);
  video.size(320, 240);
  video.hide();

  flippedVideo = ml5.flipImage(video);
  // Start classifying
  classifyVideo();
}

function draw() {
  background(220);

  myPlayer.show();
  myPlayer.update();
  myPlayer.eat();

  myFood.show();

  // Second
  if (frameCount % 60 == 0 && timer > 0) {
    timer--;
  }

  if (timer == 0) {
    textAlign(CENTER, CENTER);
    textSize(40);
    text("You Scored: " + score, width / 2, height / 2);

    myPlayer.direction(0, 0);

    myFood.x = -10;
    myFood.y = -10;
  }
}

function player() {
  this.x = 20;
  this.y = 20;

  this.show = function() {
    fill(255);
    ellipse(this.x, this.y, 10, 10);
  }

  this.xmove = 3;
  this.ymove = 0;

  this.update = function() {
    this.x = this.x + this.xmove;
    this.y = this.y + this.ymove;

    this.x = constrain(this.x, 0, width);
    this.y = constrain(this.y, 0, height);
  }


  this.direction = function(dx, dy) {
    this.xmove = dx;
    this.ymove = dy;
  }


  this.eat = function() {
    var loc = dist(this.x, this.y, myFood.x, myFood.y)
    if (loc < 10) {
      myFood.x = random(width);
      myFood.y = random(height);

      // First
      score++
    }
  }
}

function keyPressed() {
  if (keyCode === RIGHT_ARROW) {
    myPlayer.direction(3, 0);
  } else if (keyCode === UP_ARROW) {
    myPlayer.direction(0, -3);
  } else if (keyCode === LEFT_ARROW) {
    myPlayer.direction(-3, 0);
  } else if (keyCode === DOWN_ARROW) {
    myPlayer.direction(0, 3);
  }
}

function food() {
  this.x = random(width);
  this.y = random(height);

  this.show = function() {
    fill(255, 234, 0);
    circle(this.x, this.y, 10, 10);
  }

}