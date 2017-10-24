class Ast {
  float y;
  float x;
  float speed;
  Ast(float tempx, float tempy, float tempSpeed){
    x=tempx;
    y=tempy;
    speed=tempSpeed;
  }
  
  void display(){
    noStroke();
    ellipse(x,y,10,10);
  }
  
  void move(){
    y+=speed;
  }
}

class Bad {
  float y;
  float x;
  float speed;
  Bad(float x, float y, float speed){
    this.x = x;
    this.y = y;
    this.speed = speed;
  }
  
  void display(){
    fill(255, 0, 0);
    noStroke();
    ellipse(x, y, 10, 10);
  }
  
  void move(){
    y += speed;
  }
}