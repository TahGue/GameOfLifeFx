import com.example.gameoflifefx.Cell;
import org.junit.jupiter.api.Test;

public class CellTest {
    @Test
    public void ShouldDieWithOnlyOneNeighbor(){
       Cell wwt = new Cell(Cell.CellState.Alive);
    }
}
