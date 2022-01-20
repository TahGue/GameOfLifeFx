package com.example.gameoflifefx;

public class Cell {
    public CellState  state;
    public Cell (CellState state){
        this.state = state;
    }
    public enum CellState{
        Alive, DEAD
    }
}
