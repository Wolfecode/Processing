class Board {
  Cell[][] grid;
  boolean xWon, oWon;
  
  
  Board() {
    grid = new Cell[cols][rows];
    for (int i = 0; i < cols; i++) {
      for (int j = 0; j < rows; j++) {
        grid[i][j] = new Cell(i * width / cols, j * width / rows, 100, 100);
      }
    }
  }
  
  void display() {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        grid[i][j].display();
      }
    }
    if (xWon) {
      fill(255, 0, 0);
      textAlign(CENTER, CENTER);
      textSize(48);
      text("X won!", width / 2, height / 2);
    } else if (oWon) {
      fill(255, 0, 0);
      textAlign(CENTER, CENTER);
      textSize(48);
      text("O won!", width / 2, height / 2);
    }
  }
  
  void markX(int col, int row) {
    grid[col][row].markX();
    xWon = xWon();
  }
  
  void markO(int col, int row) {
    grid[col][row].markO();
    oWon = oWon();
  }
  
  boolean isMarked(int col, int row) {
    return grid[col][row].isMarked();
  }
  
  boolean xWon() {
    if (grid[0][0].markedX() && grid[0][1].markedX() && grid[0][2].markedX()) {
      return true;
    } else if (grid[1][0].markedX() && grid[1][1].markedX() && grid[1][2].markedX()) {
      return true;
    } else if (grid[2][0].markedX() && grid[2][1].markedX() && grid[2][2].markedX()) {
      return true;
    } else if (grid[0][0].markedX() && grid[1][1].markedX() && grid[2][2].markedX()) {
      return true;
    } else if (grid[0][2].markedX() && grid[1][1].markedX() && grid[2][0].markedX()) {
      return true;
    } else if (grid[0][0].markedX() && grid[1][0].markedX() && grid[2][0].markedX()) {
      return true;
    } else if (grid[0][1].markedX() && grid[1][1].markedX() && grid[2][1].markedX()) {
      return true;
    } else if (grid[0][2].markedX() && grid[1][2].markedX() && grid[2][2].markedX()) {
      return true;
    } else {
      return false;
    }
  }
  
  boolean oWon() {
    if (grid[0][0].markedO() && grid[0][1].markedO() && grid[0][2].markedO()) {
      return true;
    } else if (grid[1][0].markedO() && grid[1][1].markedO() && grid[1][2].markedO()) {
      return true;
    } else if (grid[2][0].markedO() && grid[2][1].markedO() && grid[2][2].markedO()) {
      return true;
    } else if (grid[0][0].markedO() && grid[1][1].markedO() && grid[2][2].markedO()) {
      return true;
    } else if (grid[0][2].markedO() && grid[1][1].markedO() && grid[2][0].markedO()) {
      return true;
    } else if (grid[0][0].markedO() && grid[1][0].markedO() && grid[2][0].markedO()) {
      return true;
    } else if (grid[0][1].markedO() && grid[1][1].markedO() && grid[2][1].markedO()) {
      return true;
    } else if (grid[0][2].markedO() && grid[1][2].markedO() && grid[2][2].markedO()) {
      return true;
    } else {
      return false;
    }
  }
}