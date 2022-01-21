package com.example.gameoflifefx;
import com.example.gameoflifefx.Cell.CellState;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Grid {

    private Cell[][] state;

    public Grid(CellState[][] cellStates) {
        state = new Cell[cellStates.length][];
        for (int row = 0; row < cellStates.length; row++) {
            state[row] = new Cell[cellStates[row].length];
            for (int col = 0; col < cellStates[row].length; col++) {
                state[row][col] = new Cell(cellStates[row][col]);
            }
        }
    }
    public Cell[][] getCells(){
        return state;
    }

    public CellState[][] getState()
    { CellState[][] cellStates = new CellState[state.length][];
        for (int row = 0; row < state.length; row++) {
            cellStates[row] = new CellState[state[row].length];
            for (int col = 0; col < state[row].length; col++) {
                cellStates[row][col] = state[row][col].getState();
            }
        }
        return cellStates;
    }
    public int getCountIfCellIsAlive(CellState[][] state, int row, int col) {
        if (col >= 0 && col < state[row].length) {
            if (state[row][col] == CellState.ALIVE) {
                return 1;
            }
        }
        return 0;
    }
    public int getNumberOfAliveNeighborsInRow(CellState[][] state, int row, int col) {
        int numberOfAliveNeighbor = 0;
        if (row >= 0 && row < state.length) {
            numberOfAliveNeighbor += getCountIfCellIsAlive(state, row, col - 1);
            numberOfAliveNeighbor += getCountIfCellIsAlive(state, row, col);
            numberOfAliveNeighbor += getCountIfCellIsAlive(state, row, col + 1);
        }
        return numberOfAliveNeighbor;
    }
    public int getNumberOfAliveNeighbors(CellState[][] state, int row, int col) {
        int numberOfAliveNeighbor = 0;
        numberOfAliveNeighbor += getNumberOfAliveNeighborsInRow(state, row - 1, col);
        numberOfAliveNeighbor += getCountIfCellIsAlive(state, row, col - 1);
        numberOfAliveNeighbor += getCountIfCellIsAlive(state, row, col + 1);
        numberOfAliveNeighbor += getNumberOfAliveNeighborsInRow(state, row + 1, col);
        return numberOfAliveNeighbor;
    }

    public void update() {
        CellState[][] cellStates = getState();
        for (int row = 0; row < state.length; row++) {
            for (int col = 0; col < state[row].length; col++) {
                int numberOfAliveNeighbors = getNumberOfAliveNeighbors(cellStates, row, col);
                state[row][col].update(numberOfAliveNeighbors);
            }
        }
    }


    }




