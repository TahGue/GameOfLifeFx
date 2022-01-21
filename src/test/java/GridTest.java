import com.example.gameoflifefx.Cell;
import com.example.gameoflifefx.Grid;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {

    private static final Cell.CellState O = Cell.CellState.DEAD;
    private static final Cell.CellState X = Cell.CellState.ALIVE;

    @Test
    public void shouldStoreItsInitialState(){
        Cell.CellState[][] original = new Cell.CellState[][] {
                { X, O, X,O , O, O, X, O, },
                { O, O, O, X, O, O, O, X  },
                { X, O, X,O, O, O, O, X  },
                { O, O, O, X, O, O, O, X  },
        };
        Grid uut = new Grid(original);

        Cell.CellState[][] actual = uut.getState();
        assertArrayEquals(original, actual);
    }
@Test
    public void getCountIfCellIsAliveTest(){
        Cell.CellState[][] original = new Cell.CellState[][] {
                { X, O, X,O , O, O, X, O, },
                { O, O, O, X, O, O, O, X  },
                { X, O, X,O, O, O, O, X  },
                { O, O, O, X, O, O, O, X  },
    };
        Grid uut = new Grid(original);

        int status = uut.getCountIfCellIsAlive(uut.getState(), 0,0);
        assertEquals(status, 1);
    }
    @Test
    public void  getNumberOfAliveNeighborsInRowTest(){

        Cell.CellState[][] original = new Cell.CellState[][] {
                { X, O, X,O , O, O, X, O, },
                { O, O, O, X, O, O, O, X  },
                { X, O, X,O, O, O, O, X  },
                { O, O, O, X, O, O, O, X  },
        };
        Grid uut = new Grid(original);

        int status = uut.getNumberOfAliveNeighborsInRow(uut.getState(), 1,0);
        assertEquals(status, 0);
    }
    @Test
    public void  getNumberOfAliveNeighborsTest(){

        Cell.CellState[][] original = new Cell.CellState[][] {
                { X, O, X,O , O, O, X, O, },
                { O, O, O, X, O, O, O, X  },
                { X, O, X,O, O, O, O, X  },
                { O, O, O, X, O, O, O, X  },
        };
        Grid uut = new Grid(original);

        int status = uut.getNumberOfAliveNeighbors(uut.getState(), 1,1);
        assertEquals(status, 4);
    }
    @Test
    public void shouldUpdateCell() {
        Grid uut = new Grid(new Cell.CellState[][] { { X } });

        Cell.CellState[][] actual = getNextState(uut);

        assertEquals(Cell.CellState.DEAD, actual[0][0]);
    }
    private Cell.CellState[][] getNextState(Grid uut) {
        uut.update();
        return uut.getState();
    }
    @Test
    public void shouldUpdateAllCells() {
        Grid uut = new Grid(new Cell.CellState[][] {
                { X, O, X,O , O, O, X, O, },
                { O, O, O, X, O, O, O, X  },
                { X, O, X,O, O, O, O, X  },
                { O, O, O, X, O, O, O, X  },
        });
        Cell.CellState[][] expected = new Cell.CellState[][] {
                { O, O, O,O , O, O, O, O, },
                { O, O, X, X, O, O, X, X  },
                { O, O, X,X, O, O, X, X  },
                { O, O, O, O, O, O, O, O  },
        };

        Cell.CellState[][] actual = getNextState(uut);

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldConsiderAllNeighbors() {
        Grid uut = new Grid(new Cell.CellState[][] {
                { X, O, X,O , O, O, X, O, },
                { O, O, O, X, O, O, O, X  },
                { X, O, X,O, O, O, O, X  },
                { O, O, O, X, O, O, O, X  },
        });
        Cell.CellState[][] expected = new Cell.CellState[][] {
                { O, O, O,O , O, O, O, O, },
                { O, O, X, X, O, O, X, X  },
                { O, O, X,X, O, O, X, X  },
                { O, O, O, O, O, O, O, O  },
        };

        Cell.CellState[][] actual = getNextState(uut);

        assertArrayEquals(expected, actual);
    }


}
