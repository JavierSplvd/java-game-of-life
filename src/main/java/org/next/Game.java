package org.next;

import java.util.Set;
import java.util.stream.Collectors;

public class Game {

  private final int width;
  private final int height;

  public Game(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public Set<Cell> calculateStep(Set<Cell> currentState) {
    Set<Cell> newState = currentState.stream().collect(Collectors.toSet());
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        Cell potentialCell = new Cell(x, y);
        boolean isAlive = currentState.contains(potentialCell);
        int numberNeighbours = getNeighbours(x, y, currentState);
        if (numberNeighbours < 2) { // underpopulation
          newState.remove(potentialCell);
        } else if (numberNeighbours > 3) { // overpopulation
          newState.remove(potentialCell);
        } else if (numberNeighbours == 3 && !isAlive) { // reproduction
          newState.add(potentialCell);
        }
      }
    }
    return newState;
  }

  private int getNeighbours(int x, int y, Set<Cell> cells) {
    int neighboursAlive = 0;
    int[][] coordinatesCellToCheck = {
      { y - 1, x - 1 },
      { y - 1, x },
      { y - 1, x + 1 },
      { y, x - 1 },
      { y, x + 1 },
      { y + 1, x - 1 },
      { y + 1, x },
      { y + 1, x + 1 },
    };
    for (int n = 0; n < 8; n++) {
      int[] neightbourPosition = coordinatesCellToCheck[n];
      boolean isAlive = cells.contains(
        new Cell(neightbourPosition[1], neightbourPosition[0])
      );
      if (isAlive) {
        neighboursAlive++;
      }
    }
    return neighboursAlive;
  }
}
