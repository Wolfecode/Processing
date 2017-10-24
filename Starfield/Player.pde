void player(){
  if(!paused && gameState == 1){
  if(pos + size < width){
    if (keyPressed && keyCode == RIGHT){
      pos += 2;
      }
    }else{
      pos += 0;
    }
    if(pos > 0){
      if(keyPressed && keyCode == LEFT){
        pos -= 2;
        }
    }else{
      pos -= 0;
    }
  fill(255);
  noStroke();
  rect(pos, height - 20, size, 20);
  }
}
