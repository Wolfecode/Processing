class Cell {
  float x, y;
  float w, h;
  color fillColor;
  boolean markedX, markedO;
  
  Cell(float x, float y, float w, float h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    fillColor = color(150, 150, 150);
    markedX = false;
    markedO = false;
  }

  void display() {
    stroke(0);
    fill(fillColor);
    rect(x, y, w, h);
    if (markedX) {
      textSize(150);
      fill(0);
      strokeWeight(3);
      line(x, y, x + 100, y + 100);
      line(x, y + 100, x + 100, y);
      strokeWeight(1);
    } else if (markedO) {
      noFill();
      strokeWeight(3);
      stroke(0);
      ellipse(x + 50, y + 50, 100, 100);
      strokeWeight(1);
    }
  }
  
  void markX() {
    markedX = true;
    fillColor = color(0, 25, 255);
  }
  
  void markO() {
    markedO = true;
    fillColor = color(255, 125, 0);
  }
  
  boolean markedX() {
    return markedX;
  }
  
  boolean markedO() {
    return markedO;
  }
  
  boolean isMarked() {
    return markedX || markedO;
  }
}