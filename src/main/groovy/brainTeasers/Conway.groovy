package brainTeasers

/**
 *
 * Conway's Game of Life
 *  - a live cell with fewer than 2 neighbours dies
 *  - a live cell with 2 or 3 neighbours lives
 *  - a live cell with more than 3 neighbours dies
 *  - a dead cell with 3 neighbours becomes a live cell
 *
 * Created by mihail on 12/24/14.
 */
class Conway {

    def liveCells = []

    def willLive(cell) {
        def liveNeighbours = _liveNeighbours(cell).size()
        def alreadyAlive = liveCells.contains(cell)
        return (liveNeighbours == 3 || (liveNeighbours == 2 && alreadyAlive))
    }

    private def _liveNeighbours(cell) {
        liveCells.findAll { candidateCell -> _isNeighboringCell(cell, candidateCell) }
    }

    private static def _isNeighboringCell(cell, candidateCell) {
        Math.abs(cell[0] - candidateCell[0]) <= 1 &&
                Math.abs(cell[1] - candidateCell[1]) <= 1 &&
                candidateCell != cell
    }

}


