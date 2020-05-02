function setup() {
    createCanvas(400,400);
    // Second
    myPlayer = new player();
}

function draw() {
    background(220);
    // Third
    myPlayer.show();
}

// First
function player() {
    this.x = 20;
    this.y = 20;

    this.show = function() {
        fill(255);
        ellipse(this.x, this.y, 10, 10);
    }
}
