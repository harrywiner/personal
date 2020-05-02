function setup() {
    createCanvas(400, 400);
    
    r = 0;
    g = 0;
    b = 0;
    
    bg = 220;
    background(bg);
  }

  
  function draw() {
    fill(r, g, b);
    noStroke();
  }
  
  function mouseDragged() {
    ellipse(mouseX, mouseY, 10, 10);
  }
  
  function keyPressed() {
    
    
    if (key === '0') {
        r = 0;
        g = 0;
        b = 0;
    } else if (key === '1') {
        r = 255;
        g = 255;
        b = 255;
    } else if (key === '2') {
        r = 255;
        g = 0;
        b = 0;
    } else if (key === '3'){
        r = 0; 
        g = 255;
        b = 0;
    } else if (key === '4') {
        r = 0;
        g = 0;
        b = 255;
    } else if (key === 'c') {
        background(bg);
    } else {
        r = 0;
        g = 0;
        b = 0;
    }

    
  }
  