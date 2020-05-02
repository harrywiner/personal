function setup() {
    createCanvas(500,500);

    myPlayer = new player;
    food = new food;
}

function draw() {
    background(220)

    myPlayer.show();
    myPlayer.update();

    food.show();

    myPlayer.eat();
}

function player() {
    this.x = 0;
    this.y = 0;

    this.show = function() {
        fill(255)
        circle(this.x, this.y, 10, 10)
    }

    // For moving the player
    this.xmove = 1;
    this.ymove = 0;

    this.update = function() {
        this.x = this.x + this.xmove;
        this.y = this.y + this.ymove;

        this.x = constrain(this.x, 0, width);
        this.y = constrain(this.y, 0, height);
    }

    this.direction = function(a,b) {
        myPlayer.xmove = a;
        myPlayer.ymove = b;
    }

    this.eat = function() {
        var loc = dist(this.x, this.y, food.x, food.y);
        if(loc < 10) {
            food.x = random(width);
            food.y = random(height);
        }
    }
}

function keyPressed() {
    if(keyCode === RIGHT_ARROW){
        myPlayer.direction(3,0);
    } else if (keyCode === DOWN_ARROW){
        myPlayer.direction(0,3);
    } else if (keyCode === UP_ARROW) {
        myPlayer.direction(0,-3);
    } else if (keyCode === LEFT_ARROW) {
        myPlayer.direction(-3,0);
    }
}

function food() {
    this.x = random(width);
    this.y = random(height);

    this.show = function(){
        fill(255,234,0);
        circle(this.x, this.y, 10, 10);
    }
}




