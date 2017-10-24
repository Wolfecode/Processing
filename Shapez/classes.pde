class Tri{
  float x, y, speed, colorValue1, colorValue2, colorValue3;
  int pos;
  Tri(float tempX, float tempY, float tempSpeed, int tempPos){
    x = tempX;
    y = tempY;
    speed = tempSpeed;
    pos = tempPos;
    colorValue1 = random(256);
    colorValue2 = random(256);
    colorValue3 = random(256);

  }
  
  void display(){
    noStroke();
    fill(20,126,0);
    triangle(x, y-15, x+15, y+15, x-15, y+15);
  } 
  
  void move(){
    if(pos == 1){
      y += speed;
    }else{
      if(pos == 2){
        x -= speed;
      }else{
        if(pos == 3){
          y -= speed;
        }else{
          if(pos == 4){
            x += speed;
          }
        }
      }
    }
  }
}

class Sqr{
  float x, y, speed, colorValue1, colorValue2, colorValue3;
  int pos;
  Sqr(float tempX, float tempY, float tempSpeed, int tempPos){
    x = tempX;
    y = tempY;
    speed = tempSpeed;
    colorValue1 = random(256);
    colorValue2 = random(256);
    colorValue3 = random(256);
    pos = tempPos;
  }
  
  void display(){
    noStroke();
    fill(0,53,196);
    rectMode(CENTER);
    rect(x, y, 30, 30);
  } 
  
  void move(){
   if(pos == 1){
      y += speed;
    }else{
      if(pos == 2){
        x -= speed;
      }else{
        if(pos == 3){
          y -= speed;
        }else{
          if(pos == 4){
            x += speed;
          }
        }
      }
    }
  }
}

class Circ{
  float x, y, speed, colorValue1, colorValue2, colorValue3;
  int pos;
  Circ(float tempX, float tempY, float tempSpeed, int tempPos){
    x = tempX;
    y = tempY;
    speed = tempSpeed;
    colorValue1 = random(256);
    colorValue2 = random(256);
    colorValue3 = random(256);
    pos = tempPos;
  }
  
  void display(){
    noStroke();
    fill(126,46,0);
    ellipse(x, y, 30, 30);
  } 
  
  void move(){
    if(pos == 1){
      y += speed;
    }else{
      if(pos == 2){
        x -= speed;
      }else{
        if(pos == 3){
          y -= speed;
        }else{
          if(pos == 4){
            x += speed;
          }
        }
      }
    }
  }
}

class Cross{
  float x, y, speed, colorValue1, colorValue2, colorValue3;
  int pos;
  Cross(float tempX, float tempY, float tempSpeed, int tempPos){
    x = tempX;
    y = tempY;
    speed = tempSpeed;
    colorValue1 = random(256);
    colorValue2 = random(256);
    colorValue3 = random(256);
    pos = tempPos;
  }
  
  void display(){
    strokeWeight(4);
    stroke(126,0,91);
    line(x-15, y-15, x+15, y+15);
    line(x-15, y+15, x+15, y-15);
  } 
  
  void move(){
    if(pos == 1){
      y += speed;
    }else{
      if(pos == 2){
        x -= speed;
      }else{
        if(pos == 3){
          y -= speed;
        }else{
          if(pos == 4){
            x += speed;
          }
        }
      }
    }
  }
}
