// Me thinks this is ideal by the end of the day 

function setup() {
    createCanvas(400,400);
    myPlayer = new player();
}

function draw() {
    background(220);
    myPlayer.show();
    myPlayer.update();
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

    // First
    this.direction = function(dx,dy) {
        this.xmove = dx;
        this.ymove = dy;
    }
}
// Second
function keyPressed() {
    if(keyCode === RIGHT_ARROW) {
        player.direction(3,0);
    } else if (keyCode === UP_ARROW) {
        player.direction(0,3);
    } else if (keyCode === LEFT_ARROW) {
        player.direction(-3, 0);
    } else if (keyCode === DOWN_ARROW) {
        player.direction(0, -3);
    }
}
