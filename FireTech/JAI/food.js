
function setup() {
    createCanvas(400,400);
    myPlayer = new player;
    myFood = new food;
}

function draw() {
    background(220);
    myPlayer.show();
    myPlayer.update();
    // Second
    myPlayer.eat();
    // First
    myFood.show();
    
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
  
  // Second

    this.eat = function() {
        var loc = dist(this.x, this.y, myFood.x, myFood.y)
        if (loc < 10) {
            myFood.x = random(width);
            myFood.y = random(height);
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


// First
function food() {
    this.x = random(width);
    this.y = random(height);

    this.show = function() {
        fill(255,234,0);
        circle(this.x, this.y, 10, 10);
    }

}
