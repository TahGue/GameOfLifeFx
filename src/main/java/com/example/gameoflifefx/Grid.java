package com.example.gameoflifefx;

public class Grid {

    private Cell[][] state;

    public Grid(Cell.CellState[][] cellStates) {
        state = new Cell[cellStates.length][];
        for (int row = 0; row < cellStates.length; row++) {
            state[row] = new Cell[cellStates[row].length];
            for (int col = 0; col < cellStates[row].length; col++) {
                state[row][col] = new Cell(cellStates[row][col]);
            }
        }
    }




}
