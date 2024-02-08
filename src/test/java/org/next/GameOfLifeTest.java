package org.next;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import org.junit.jupiter.api.Test;

public class GameOfLifeTest {

  @Test
  public void given_a_start_board_when_is_created_then_it_is_finite_grid() {
    Game game = new Game(5, 5);

    assertEquals(game.getWidth(), 5);
    assertEquals(game.getHeight(), 5);
  }

  /**

     *.      ..
     ..  ->  ..

     ***/
  @Test
  public void given_a_live_cell_with_fewer_than_two_live_neighbours_when_calculate_next_generation_then_dies() {
    Set<Cell> initialState = Set.of(new Cell(0, 0));
    Game game = new Game(5, 5);

    var newState = game.calculateStep(initialState);

    assertEquals(newState, Set.of());
  }

  /**

     .*.      ***
     ***  ->  *.*
     .*.      ***

     ***/
  @Test
  public void given_a_live_cell_with_more_than_three_live_neighbours_when_calculate_next_generation_then_dies() {
    Set<Cell> initialState = Set.of(
      new Cell(1, 0),
      new Cell(0, 1),
      new Cell(1, 1),
      new Cell(2, 1),
      new Cell(1, 2)
    );
    Game game = new Game(5, 5);

    var newState = game.calculateStep(initialState);

    assertEquals(
      newState,
      Set.of(
        new Cell(0, 0),
        new Cell(1, 0),
        new Cell(2, 0),
        new Cell(0, 1),
        new Cell(2, 1),
        new Cell(0, 2),
        new Cell(1, 2),
        new Cell(2, 2)
      )
    );
  }

  /**

     .*      ..
     *.  ->  **
     .*      ..

     ***/
  @Test
  public void given_a_live_cell_with_two_or_three_live_neighbours_when_calculate_next_generation_then_lives() {
    Set<Cell> initialState = Set.of(
      new Cell(1, 0),
      new Cell(0, 1),
      new Cell(1, 2)
    );

    Game game = new Game(5, 5);

    var newState = game.calculateStep(initialState);

    assertEquals(newState, Set.of(new Cell(0, 1), new Cell(1, 1)));
  }

  /**

     .*      **
     **  ->  **
     ..      ..

     ***/
  @Test
  public void given_a_dead_cell_with_three_live_neighbours_when_calculate_next_generation_then_lives() {
    Set<Cell> initialState = Set.of(
      new Cell(1, 0),
      new Cell(0, 1),
      new Cell(1, 1)
    );
    Game game = new Game(5, 5);

    var newState = game.calculateStep(initialState);

    assertEquals(
      newState,
      Set.of(new Cell(0, 0), new Cell(1, 0), new Cell(0, 1), new Cell(1, 1))
    );
  }
}
