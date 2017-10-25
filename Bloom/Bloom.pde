import arb.soundcipher.*;
import arb.soundcipher.constants.*;

SoundCipher sc = new SoundCipher(this);

ArrayList<Orb> orbs = new ArrayList<Orb>();
boolean paused = false;

void setup() {
  size(600, 600);
}

void draw() {
  background(255);
  if (!paused) {
    for (int i=0; i<orbs.size(); i++) {
      Orb orb = orbs.get(i);
      orb.render();
      orb.grow();
    }
  }
}

void mousePressed() {
  orbs.add(new Orb(mouseX, mouseY));
}

void keyPressed() {
  if (key == ' ') {
    paused = !paused;
  }
}


class Orb {
  float x, y;
  float r;
  float speed;
  color myColor;
  int note;
  Orb (float nx, float ny) {
    x = nx;
    y = ny;
    r = 0;
    speed = random(1);
    myColor = color(random(255), random(150), random(255));
    note = int(84*((x + y)/1200))+10;
  }

  void render() {
    noStroke();
    fill(red(myColor), green(myColor), blue(myColor), 100-r);
    ellipse(x, y, r, r);
  }

  void grow() {
    if (r<100) r += speed;
    else {
      r = 0;
      sc.playNote(note, 100, 2.0);
    }
  }
}

