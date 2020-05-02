function setup() {
    createCanvas(400,400);
    myPlayer = new player();
}

function draw() {
    background(220);
    myPlayer.show();
    // Second
    myPlayer.update();
}

function player() {
    this.x = 20;
    this.y = 20;

    this.show = function() {
        fill(255);
        ellipse(this.x, this.y, 10, 10);
    }

    // First
    this.xmove = 3;
    this.ymove = 0;

    this.update = function() {
        this.x = this.x + this.xmove;
        this.y = this.y + this.ymove;

        this.x = constrain(this.x, 0, width);
        this.y = constrain(this.y, 0, height);
    }
}
