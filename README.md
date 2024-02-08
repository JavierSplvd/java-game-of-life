kataGameOfLife
==============

A next version for the game of life kata

## What to do?

This Kata is about calculating the next generation of Conway’s game of life, given any starting position. See http://en.wikipedia.org/wiki/Conway%27s_Game_of_Life for background.

You start with a **two dimensional grid of cells, where each cell is either alive or dead.** In this version of the problem,the grid is finite, and no life can exist off the edges.

When calcuating the next generation of the grid, follow these rules:

```markdown
1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
2. Any live cell with more than three live neighbours dies, as if by overcrowding.
3. Any live cell with two or three live neighbours lives on to the next generation.
4. Any dead cell with exactly three live neighbours becomes a live cell.

* In any other case the cell remains as it is from one generation to the next.
```
You should write a program that can accept an arbitrary grid of cells, and will output a similar grid showing the next generation.

## An example?

Clues
The input starting position could be something that looks like this:

```markdown
Generation 1 (4/8 grid):
........
....*...
...**...
........
```

And the output could look like this:

```markdown
Generation 2 (4/8 grid):
........
...**...
...**...
........
```

## How can I test it?

Make sure you have enough coverage of edge, and check where there are births and deaths at the edge of the grid.

An sample of tests may looks like this:

```java
   @Test
    public void given_a_start_board_when_is_created_then_it_is_finite_grid_with_dead_or_alive_cells() {
        assertFalse(true);
    }

    /**

     *.      ..
     ..  ->  ..

     ***/
    @Test
    public void given_a_live_cell_with_fewer_than_two_live_neighbours_when_calculate_next_generation_then_dies() {
        assertFalse(true);
    }

    /**

     .*.      ***
     ***  ->  *.*
     .*.      ***

     ***/
    @Test
    public void given_a_live_cell_with_more_than_three_live_neighbours_when_calculate_next_generation_then_dies() {
        assertFalse(true);
    }

    /**

     .*      ..
     *.  ->  **
     .*      ..

     ***/
    @Test
    public void given_a_live_cell_with_two_or_three_live_neighbours_when_calculate_next_generation_then_lives() {
        assertFalse(true);
    }


    /**

     .*      **
     **  ->  **
     ..      ..

     ***/
    @Test
    public void given_a_dead_cell_with_three_live_neighbours_when_calculate_next_generation_then_lives() {
        assertFalse(true);
    }
```

## How is the Kata evaluated?

The interviewer's mission is to help the candidate to do a good kata.

Points to be evaluated:

1. Understanding the problem and the solution
2. Code clarity
3. Architecture
4. Git history