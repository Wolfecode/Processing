boolean grow(){
  player();
  for(int i=0; i < n; i++){
    if(abs(height - asteroid[i].y) < 15){
     if(abs(pos + size/2-asteroid[i].x) < size/2){
      return false;
     }
    }
  }
  return true;
}


boolean shrink(){
  player();
  for(int i=0; i < n; i++){
    if(abs(height - badAsteroid[i].y) < 15){
      if(abs(pos + size/2 - badAsteroid[i].x) < size/2){
        return false;
      }
    }
  }
  return true;
}

boolean gold(){
  player();
  if(abs(height - gold.y) < 15){
    if( abs(pos + size/2 - gold.x) < size/2){
      return false;
    }
  }
  return true;
}

//paused
void keyPressed(){
  if(key == ' ' && gameState == 1){
    paused = !paused;
  }
}

void end(){
  player();
  if(size<20){
    gameState = 2;
  }
}
