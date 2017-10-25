PImage img;
float rand;

void setup(){
  size(600,400);
  img = loadImage("Trees.jpg");
  frameRate(60);
}

void draw(){
  background(0);
  img.resize(width, height);
  image(img, 0, 0);
  //update();
}

void update(){
  rand = random(6);
  img.loadPixels();
    float rand = random(6);
    for(int i=0; i<img.pixels.length; i++){
      float red = red(img.pixels[i]);
      float green = green(img.pixels[i]);
      float blue = blue(img.pixels[i]);
      if(rand < 1) img.pixels[i] = color(blue, red, green);
      else if(rand < 2) img.pixels[i] = color(green, blue, red);
      else if(rand < 3) img.pixels[i] = color(red, blue, green);
      else if(rand < 4) img.pixels[i] = color(green, red, blue);
      else if(rand < 5) img.pixels[i] = color(blue, green, red);
      else if(rand < 6) img.pixels[i] = color(red, green, blue);
      else  img.pixels[i] = color(255 - red, 255 - green, 255 - blue);
    }
    img.updatePixels();
}

void keyPressed() {
  update();
}
