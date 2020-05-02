
function setup() {
    createCanvas(400,400);

    myPlayer = new player;
    myFood = new food;
    // First
    score = 0
    // Second
    timer = 5
}

function draw() {
    background(220);

    myPlayer.show();
    myPlayer.update();
    myPlayer.eat();

    myFood.show();

    // Second
    if (frameCount % 60 == 0 && timer > 0) {
        timer --;
    }

    if (timer == 0) {
        textAlign(CENTER, CENTER);
        textSize(40);
        text("You Scored: " + score, width/2, height/2);

        myPlayer.direction(0,0);

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

    
    this.direction = function(dx,dy) {
        this.xmove = dx;
        this.ymove = dy;
    }
  

    this.eat = function() {
        var loc = dist(this.x, this.y, myFood.x, myFood.y)
        if (loc < 10) {
            myFood.x = random(width);
            myFood.y = random(height);

            // First
            score ++
        }
    }
}

function keyPressed() {
    if(keyCode === RIGHT_ARROW) {
        myPlayer.direction(3,0);
    } else if (keyCode === UP_ARROW) {
        myPlayer.direction(0,-3);
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
        fill(255,234,0);
        circle(this.x, this.y, 10, 10);
    }

}
