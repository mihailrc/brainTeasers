package brainTeasers

import org.junit.Test
import static org.junit.Assert.*

/**
 * Created by mihail on 12/24/14.
 */
class ConwayTest {

    @Test
    def void aDeadCellWithThreeLiveNeighboursBecomesLive() {
        Conway conway = new Conway(liveCells: [[2, 2], [2, 3], [3, 2]]);
        assertTrue(conway.willLive([3, 3]))
    }

    @Test
    def void aLivingCellWithThreeLiveNeighboursLives() {
        Conway conway = new Conway(liveCells: [[2, 2], [2, 3], [3, 2], [3, 3]]);
        assertTrue(conway.willLive([3, 3]))
    }

    @Test
    def void aLiveCellWithTwoLivingNeighboursLives() {
        Conway conway = new Conway(liveCells: [[2, 2], [2, 3], [3, 3]]);
        assertTrue(conway.willLive([3, 3]))
    }

    @Test
    def void aDeadCellWithTwoLivingNeighboursStaysDead() {
        Conway conway = new Conway(liveCells: [[2, 2], [2, 3]]);
        assertFalse(conway.willLive([3, 3]))
    }

    @Test
    def void aDeadCellWithOneLivingNeighboursStaysDead() {
        Conway conway = new Conway(liveCells: [[2, 2]]);
        assertFalse(conway.willLive([3, 3]))
    }

    @Test
    def void aLiveCellWithOneLivingNeighboursDies() {
        Conway conway = new Conway(liveCells: [[2, 2], [3, 3]]);
        assertFalse(conway.willLive([3, 3]))
    }


    @Test
    def void aDeadCellWithFourLivingNeighboursStaysDead() {
        Conway conway = new Conway(liveCells: [[2, 2], [2, 3], [2, 4], [3, 4]]);
        assertFalse(conway.willLive([3, 3]))
    }

    @Test
    def void aLiveCellWithFourLivingNeighboursDies() {
        Conway conway = new Conway(liveCells: [[2, 2], [2, 3], [2, 4], [3, 4], [3, 3]]);
        assertFalse(conway.willLive([3, 3]))
    }

}

