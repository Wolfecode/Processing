PImage img;

void setup(){
  size(400,400);
  img = loadImage("ButtShark.jpg");
  updateImg = img;
}

void draw(){
  background(0);
  img.resize(width, height);
  image(img, 0, 0);
  if(keyPressed && key == ' '){
    img.loadPixels();
    float rand = random(6);
    for(int i=0; i<img.pixels.length; i++){
      float red = red(img.pixels[i]);
      float green = green(img.pixels[i]);
      float blue = blue(img.pixels[i]);
//      float rand = random(6);
      if(rand < 1) img.pixels[i] = color(blue, red, green);
      else if(rand <2) img.pixels[i] = color(green, blue, red);
      else if(rand <3) img.pixels[i] = color(red, blue, green);
      else if(rand <4) img.pixels[i] = color(green, red, blue);
      else if(rand <5) img.pixels[i] = color(blue, green, red);
      else img.pixels[i] = color(red, green, blue);
    }
    img.updatePixels();
  }
}

