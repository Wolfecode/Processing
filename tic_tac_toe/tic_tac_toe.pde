Board board;
boolean xTurn;
int turns;
final int cols = 3;
final int rows = 3;

void setup() {
  size(300, 300);
  background(0);
  board = new Board();
  xTurn = true;
  turns = 0;
}

void draw() {
  board.display();
}

void mouseClicked() { 
  int col = mouseX / (width / cols);
  int row = mouseY / (width / rows);
  if (!board.isMarked(col, row) && turns < 9) {
    if (xTurn) {
      board.markX(col, row);
    } else {
      board.markO(col, row);
    }
    xTurn = !xTurn;
    turns++;
  }
}