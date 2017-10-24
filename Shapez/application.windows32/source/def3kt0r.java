import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class def3kt0r extends PApplet {

int value1;
int value2 = 0;
int value3 = 0;
int value;
int z = 2;
int n = 10;
int p = 0;
int h = 10;
int[] heart = new int[h];
int health = 0;
//int[] freq = new int[4n];
Tri[] myTri = new Tri[n];
Sqr[] mySqr = new Sqr[n];
Circ[] myCirc = new Circ[n];
Cross[] myCross = new Cross[n];
boolean paused;


public void setup(){
  size(800,800);
  background(0);
  for(int i=0; i<n; i++){
    myTri[i] = new Tri(width/2, random(-25000,0), 4+z, 1);
    mySqr[i] = new Sqr(random(-25000,0), height/2, 4+z, 4);
    myCirc[i] = new Circ(random(width,25000), height/2, 4+z, 2);
    myCross[i] = new Cross(width/2, random(height,25000), 4+z, 3);
    /*
    for(int j=0; j<4*n; j++){
      if(j % 4 == 0){
    myTri[i] = new Tri(width/2, (-100*j - random(0,95)), 4+z, 1);
    } else if(j % 4 == 1){
    mySqr[i] = new Sqr((-100*j - random(0,95)), height/2, 4+z, 4);
    } else if(j % 4 == 2){
    myCirc[i] = new Circ((100*j + random(0,95)), height/2, 4+z, 2);
    } else if(j % 4 == 3){
    myCross[i] = new Cross(width/2, (100*j + random(0,95)), 4+z, 3);
    }
    */
    //if(abs(myTri[i].y - mySqr[i].x) <= 100  ||  abs(myTri[i].y + myCirc[i].x) <= 100  ||  abs(myTri[i].y + myCross[i].x) <= 100){
    //  myTri[i].y = random(-50000,0);
    //}
  }
  value = 0;
  value1 = 0;
  paused = false;
}


public void draw(){
  if(end()){
    if(!paused){
      noStroke();

        if(value == 0){
          background(0);
          square();
        }
        else if(value == 1){
          background(0);
          tri();
        }
        else if(value == 2){
          background(0);
          circ();
        }
        else if(value == 3){
          background(0);
          cross();
        }
        
        // moving triangles
        for(int i=0; i<n; i++){
          myTri[i].display();
          myTri[i].move();
          if((myTri[i].pos == 1 && myTri[i].x == width/2 && myTri[i].y >= height/2) || (myTri[i].pos == 2 && myTri[i].x <= width/2 && myTri[i].y == height/2) || (myTri[i].pos == 3 && myTri[i].x == width/2 && myTri[i].y <= height/2) || (myTri[i].pos == 4 && myTri[i].x >= width/2 && myTri[i].y == height/2)){
             if(value == 1){
               p ++;
               myTri[i].speed += .2f;
               value1 = 1;
              }else{
                h --;
              }
              if(p<=10){
                myTri[i].y = random(-50000,0);
              }else{
                myTri[i].pos = (int)random(1,4);
                if(myTri[i].pos == 1){
                  myTri[i].x = width/2;
                  myTri[i].y = random(-50000,-1000);
                }else if(myTri[i].pos == 2){
                  myTri[i].x = random(width+1000, 50000);
                  myTri[i].y = height/2;
                }else if(myTri[i].pos == 3){
                  myTri[i].x = width/2;
                  myTri[i].y = random(height+1000,50000);
                }else if(myTri[i].pos == 4){
                  myTri[i].x = random(-50000,-1000);
                  myTri[i].y = height/2;
                }
              }
          }   
        }
        
              if(value1 == 1){
        fill(255);
        strokeWeight(3);
        int fade = 0;
        stroke(255);
        triangle(width/2, height/2-fade, width/2+fade, height/2+fade, width/2-fade, height/2+fade);
        fade += 5;
        println("works");
        if(fade == 255){
          fade = 0;
          value1 = 0;
        }
      }
        
        // moving squares
        for(int i=0; i<n; i++){
          mySqr[i].display();
          mySqr[i].move();
          if((mySqr[i].pos == 1 && mySqr[i].x == width/2 && mySqr[i].y >= height/2) || (mySqr[i].pos == 2 && mySqr[i].x <= width/2 && mySqr[i].y == height/2) || (mySqr[i].pos == 3 && mySqr[i].x == width/2 && mySqr[i].y <= height/2) || (mySqr[i].pos == 4 && mySqr[i].x >= width/2 && mySqr[i].y == height/2)){
            if(value == 0){
              p++;
              mySqr[i].speed += .2f;
            }else{
              h --;
            }
           if(p<=10){
                mySqr[i].x = random(-50000,0);
              }else{
                mySqr[i].pos = (int)random(1,4);
                if(mySqr[i].pos == 1){
                  mySqr[i].x = width/2;
                  mySqr[i].y = random(-50000,-1000);
                }else if(mySqr[i].pos == 2){
                  mySqr[i].x = random(width+1000, 50000);
                  mySqr[i].y = height/2;
                }else if(mySqr[i].pos == 3){
                  mySqr[i].x = width/2;
                  mySqr[i].y = random(height+1000,50000);
                }else if(mySqr[i].pos == 4){
                  mySqr[i].x = random(-50000,-1000);
                  mySqr[i].y = height/2;
                }
              }
          }
        }
        
        // moving circles
        for(int i=0; i<n; i++){
          myCirc[i].display();
          myCirc[i].move();
          if((myCirc[i].pos == 1 && myCirc[i].x == width/2 && myCirc[i].y >= height/2) || (myCirc[i].pos == 2 && myCirc[i].x <= width/2 && myCirc[i].y == height/2) || (myCirc[i].pos == 3 && myCirc[i].x == width/2 && myCirc[i].y <= height/2) || (myCirc[i].pos == 4 && myCirc[i].x >= width/2 && myCirc[i].y == height/2)){
            if(value == 2){
              myCirc[i].speed += .2f;
              p++;
            }else{
              h --;
            }
            if(p<=10){
                myCirc[i].x = random(width,50000);
              }else{
                myCirc[i].pos = (int)random(1,4);
                if(myCirc[i].pos == 1){
                  myCirc[i].x = width/2;
                  myCirc[i].y = random(-50000,-1000);
                }else if(myCirc[i].pos == 2){
                  myCirc[i].x = random(width+1000, 50000);
                  myCirc[i].y = height/2;
                }else if(myCirc[i].pos == 3){
                  myCirc[i].x = width/2;
                  myCirc[i].y = random(height+1000,50000);
                }else if(myCirc[i].pos == 4){
                  myCirc[i].x = random(-50000,-1000);
                  myCirc[i].y = height/2;
                }
              }
          }
        }
        
        // Moving Cross
        for(int i=0; i<n; i++){
          myCross[i].display();
          myCross[i].move();
          if((myCross[i].pos == 1 && myCross[i].x == width/2 && myCross[i].y >= height/2) || (myCross[i].pos == 2 && myCross[i].x <= width/2 && myCross[i].y == height/2) || (myCross[i].pos == 3 && myCross[i].x == width/2 && myCross[i].y <= height/2) || (myCross[i].pos == 4 && myCross[i].x >= width/2 && myCross[i].y == height/2)){
              if(value == 3){
                p++;
                myCross[i].speed += .2f;
              }else{
                h--;
              }
              if(p<=10){
                myCross[i].y = random(height,50000);
              }else{
                myCross[i].pos = (int)random(1,4);
                if(myCross[i].pos == 1){
                  myCross[i].x = width/2;
                  myCross[i].y = random(-50000,-1000);
                }else if(myCross[i].pos == 2){
                  myCross[i].x = random(width+1000, 50000);
                  myCross[i].y = height/2;
                }else if(myCross[i].pos == 3){
                  myCross[i].x = width/2;
                  myCross[i].y = random(height+1000,50000);
                }else if(myCross[i].pos == 4){
                  myCross[i].x = random(-50000,-1000);
                  myCross[i].y = height/2;
              }
            }
          }
        }
        
        //next level
        if(p%25 == 0 &&  p!= 0 && health == 1){
          h++;
          health = 0;
          if(p == 50){
          }else{
          for(int i=0; i<n; i++){
            myCirc[i].speed += .3f;
            mySqr[i].speed += .3f;
            myTri[i].speed += .3f;
          }
          }
        }
        if(p%25 == 1){
          health = 1;
        }
        
        //points and hearts
        textSize(18);
        textAlign(LEFT);
        fill(255,255,0);
        text(p, 0, 20);
        for(int i=0; i<h; i++){
          fill(255,0,0);
          textAlign(RIGHT);
          textFont(createFont("SansSerif", 24));
          if(i<=4){
          text("\u2665", width - 25*i, 25);
          }else if(i<=9){
            text("\u2665", width+125 - 25*i, 55);
        }
        }
        
    }else{
      background(0);
      textAlign(CENTER);
      fill(255,255,0);
      text("Paused", width/2, height/2);
    }
  }else{
    background(0);
    textAlign(CENTER);
    textSize(36);
    strokeWeight(2);
    fill(255,0,0);
    text("GAME OVER", width/2, height/2 - 24);
    fill(255,255,0);
    textSize(24);
    text("Score: " + p, width/2, height/2 + 36);
  }
}

public void keyPressed(){
  if (key == 'a'){
    value = 0;
  } 
  else if (key == 'w'){
    value = 1;
  }
  else if (key == 'd'){
    value = 2;
  }
  else if(key == 's'){
    value = 3;
  }
  else if (key == ' '){
    paused = !paused;
  }
}

public void tri(){
  noFill();
  strokeWeight(3);
  stroke(20,126,0);
  triangle(width/2, height/2-15, width/2+15, height/2+15, width/2-15, height/2+15);
}

public void square(){
  noFill();
  strokeWeight(3);
  stroke(0,53,196);
  rectMode(CENTER);
  rect(width/2, height/2, 30, 30);
}

public void circ(){
  noFill();
  strokeWeight(3);
  stroke(126,46,0);
  ellipse(width/2, height/2, 30, 30);
}

public void cross(){
  noFill();
  strokeWeight(3);
  stroke(126,0,91);
  line(width/2-13, height/2-17, width/2-17, height/2-13);
  line(width/2+13, height/2-17, width/2+17, height/2-13);
  line(width/2+13, height/2+17, width/2+17, height/2+13);
  line(width/2-13, height/2+17, width/2-17, height/2+13);
  line(width/2-13, height/2-17, width/2, height/2-4);
  line(width/2+13, height/2-17, width/2, height/2-4);
  line(width/2-17, height/2-13, width/2-4, height/2);
  line(width/2-17, height/2+13, width/2-4, height/2);
  line(width/2-13, height/2+17, width/2, height/2+4);
  line(width/2+13, height/2+17, width/2, height/2+4);
  line(width/2+17, height/2+13, width/2+4, height/2);
  line(width/2+17, height/2-13, width/2+4, height/2);
  //quad(width/2+17, height/2+13, width/2+13, height/2+17, width/2-17, height/2-13, width/2-13, height/2-17);
  //quad(width/2-13, height/2+17, width/2-17, height/2+13, width/2+13, height/2-17, width/2+17, height/2-13);
}

public boolean end(){
  if(h <= 0){ 
    return false;
  }
  return true;
}


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
  
  public void display(){
    noStroke();
    fill(20,126,0);
    triangle(x, y-15, x+15, y+15, x-15, y+15);
  } 
  
  public void move(){
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
  
  public void display(){
    noStroke();
    fill(0,53,196);
    rectMode(CENTER);
    rect(x, y, 30, 30);
  } 
  
  public void move(){
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
  
  public void display(){
    noStroke();
    fill(126,46,0);
    ellipse(x, y, 30, 30);
  } 
  
  public void move(){
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
  
  public void display(){
    strokeWeight(4);
    stroke(126,0,91);
    line(x-15, y-15, x+15, y+15);
    line(x-15, y+15, x+15, y-15);
  } 
  
  public void move(){
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
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "def3kt0r" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
