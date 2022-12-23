package org.cis1200.battleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * You can use this file (and others) to test your
 * implementation.
 */

public class GameTest {

    @Test
    public void simpleBattleshipSetupHorizontal() {
        Battleship b = new Battleship();
        b.setOceanBoard(0, 0);
        b.setOceanBoard(0, 4);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 3);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 2);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 1);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 4);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 3);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 2);
        b.setOceanBoard(5, 0);
        b.setOceanBoard(5, 1);
        assertEquals(b.getOceanCell(0, 0, true), 1);
        assertEquals(b.getOceanCell(0, 1, true), 1);
        assertEquals(b.getOceanCell(0, 2, true), 1);
        assertEquals(b.getOceanCell(0, 3, true), 1);
        assertEquals(b.getOceanCell(0, 4, true), 1);
        assertEquals(b.getOceanCell(1, 0, true), 2);
        assertEquals(b.getOceanCell(1, 1, true), 2);
        assertEquals(b.getOceanCell(1, 2, true), 2);
        assertEquals(b.getOceanCell(1, 3, true), 2);
        assertEquals(b.getOceanCell(2, 0, true), 3);
        assertEquals(b.getOceanCell(2, 1, true), 3);
        assertEquals(b.getOceanCell(2, 2, true), 3);
        assertEquals(b.getOceanCell(3, 0, true), 4);
        assertEquals(b.getOceanCell(3, 1, true), 4);
        assertEquals(b.getOceanCell(3, 2, true), 4);
        assertEquals(b.getOceanCell(4, 0, true), 5);
        assertEquals(b.getOceanCell(4, 1, true), 5);

        assertEquals(b.getOceanCell(1, 0, false), 1);
        assertEquals(b.getOceanCell(1, 1, false), 1);
        assertEquals(b.getOceanCell(1, 2, false), 1);
        assertEquals(b.getOceanCell(1, 3, false), 1);
        assertEquals(b.getOceanCell(1, 4, false), 1);
        assertEquals(b.getOceanCell(2, 0, false), 2);
        assertEquals(b.getOceanCell(2, 1, false), 2);
        assertEquals(b.getOceanCell(2, 2, false), 2);
        assertEquals(b.getOceanCell(2, 3, false), 2);
        assertEquals(b.getOceanCell(3, 0, false), 3);
        assertEquals(b.getOceanCell(3, 1, false), 3);
        assertEquals(b.getOceanCell(3, 2, false), 3);
        assertEquals(b.getOceanCell(4, 0, false), 4);
        assertEquals(b.getOceanCell(4, 1, false), 4);
        assertEquals(b.getOceanCell(4, 2, false), 4);
        assertEquals(b.getOceanCell(5, 0, false), 5);
        assertEquals(b.getOceanCell(5, 1, false), 5);
    }

    @Test
    public void simpleBattleshipSetupVertical() {
        Battleship b = new Battleship();
        b.setOceanBoard(0, 0);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(0, 1);
        b.setOceanBoard(3, 1);
        b.setOceanBoard(0, 2);
        b.setOceanBoard(2, 2);
        b.setOceanBoard(0, 3);
        b.setOceanBoard(2, 3);
        b.setOceanBoard(0, 4);
        b.setOceanBoard(1, 4);
        b.setOceanBoard(0, 1);
        b.setOceanBoard(4, 1);
        b.setOceanBoard(0, 2);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(0, 3);
        b.setOceanBoard(2, 3);
        b.setOceanBoard(0, 4);
        b.setOceanBoard(2, 4);
        b.setOceanBoard(0, 5);
        b.setOceanBoard(1, 5);
        assertEquals(b.getOceanCell(0, 0, true), 1);
        assertEquals(b.getOceanCell(1, 0, true), 1);
        assertEquals(b.getOceanCell(2, 0, true), 1);
        assertEquals(b.getOceanCell(3, 0, true), 1);
        assertEquals(b.getOceanCell(4, 0, true), 1);
        assertEquals(b.getOceanCell(0, 1, true), 2);
        assertEquals(b.getOceanCell(1, 1, true), 2);
        assertEquals(b.getOceanCell(2, 1, true), 2);
        assertEquals(b.getOceanCell(3, 1, true), 2);
        assertEquals(b.getOceanCell(0, 2, true), 3);
        assertEquals(b.getOceanCell(1, 2, true), 3);
        assertEquals(b.getOceanCell(2, 2, true), 3);
        assertEquals(b.getOceanCell(0, 3, true), 4);
        assertEquals(b.getOceanCell(1, 3, true), 4);
        assertEquals(b.getOceanCell(2, 3, true), 4);
        assertEquals(b.getOceanCell(0, 4, true), 5);
        assertEquals(b.getOceanCell(1, 4, true), 5);

        assertEquals(b.getOceanCell(0, 1, false), 1);
        assertEquals(b.getOceanCell(1, 1, false), 1);
        assertEquals(b.getOceanCell(2, 1, false), 1);
        assertEquals(b.getOceanCell(3, 1, false), 1);
        assertEquals(b.getOceanCell(4, 1, false), 1);
        assertEquals(b.getOceanCell(0, 2, false), 2);
        assertEquals(b.getOceanCell(1, 2, false), 2);
        assertEquals(b.getOceanCell(2, 2, false), 2);
        assertEquals(b.getOceanCell(3, 2, false), 2);
        assertEquals(b.getOceanCell(0, 3, false), 3);
        assertEquals(b.getOceanCell(1, 3, false), 3);
        assertEquals(b.getOceanCell(2, 3, false), 3);
        assertEquals(b.getOceanCell(0, 4, false), 4);
        assertEquals(b.getOceanCell(1, 4, false), 4);
        assertEquals(b.getOceanCell(2, 4, false), 4);
        assertEquals(b.getOceanCell(0, 5, false), 5);
        assertEquals(b.getOceanCell(1, 5, false), 5);
    }

    @Test
    public void simpleBattleshipGame() {
        Battleship b = new Battleship();
        b.setOceanBoard(0, 0);
        b.setOceanBoard(0, 4);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 3);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 2);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 1);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 4);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 3);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 2);
        b.setOceanBoard(5, 0);
        b.setOceanBoard(5, 1);

        assertEquals(b.takeShot(1, 0), 1);
        assertEquals(b.takeShot(0, 0), 1);
        assertEquals(b.takeShot(1, 1), 1);
        assertEquals(b.takeShot(0, 1), 1);
        assertEquals(b.takeShot(1, 2), 1);
        assertEquals(b.takeShot(0, 2), 1);
        assertEquals(b.takeShot(1, 3), 1);
        assertEquals(b.takeShot(0, 3), 1);
        assertEquals(b.takeShot(1, 4), 2);
        assertEquals(b.takeShot(0, 4), 2);

        assertEquals(b.takeShot(2, 0), 1);
        assertEquals(b.takeShot(1, 0), 1);
        assertEquals(b.takeShot(2, 1), 1);
        assertEquals(b.takeShot(1, 1), 1);
        assertEquals(b.takeShot(2, 2), 1);
        assertEquals(b.takeShot(1, 2), 1);
        assertEquals(b.takeShot(2, 3), 2);
        assertEquals(b.takeShot(1, 3), 2);
        assertEquals(b.takeShot(2, 4), 0);
        assertEquals(b.takeShot(1, 4), 0);

        assertEquals(b.takeShot(3, 0), 1);
        assertEquals(b.takeShot(2, 0), 1);
        assertEquals(b.takeShot(3, 1), 1);
        assertEquals(b.takeShot(2, 1), 1);
        assertEquals(b.takeShot(3, 2), 2);
        assertEquals(b.takeShot(2, 2), 2);
        assertEquals(b.takeShot(3, 3), 0);
        assertEquals(b.takeShot(2, 3), 0);
        assertEquals(b.takeShot(3, 4), 0);
        assertEquals(b.takeShot(2, 4), 0);

        assertEquals(b.takeShot(4, 0), 1);
        assertEquals(b.takeShot(3, 0), 1);
        assertEquals(b.takeShot(4, 1), 1);
        assertEquals(b.takeShot(3, 1), 1);
        assertEquals(b.takeShot(4, 2), 2);
        assertEquals(b.takeShot(3, 2), 2);
        assertEquals(b.takeShot(4, 3), 0);
        assertEquals(b.takeShot(3, 3), 0);
        assertEquals(b.takeShot(4, 4), 0);
        assertEquals(b.takeShot(3, 4), 0);

        assertEquals(b.takeShot(5, 0), 1);
        assertEquals(b.takeShot(4, 0), 1);
        assertEquals(b.takeShot(5, 1), 3);
        assertTrue(b.getGameOver());
        assertTrue(b.getCurrentPlayer());
    }

    @Test
    public void attemptDiagonalSetup() {
        Battleship b = new Battleship();

        // diagonal clicks
        b.setOceanBoard(0, 0);
        b.setOceanBoard(4, 4);
        assertEquals(b.getOceanCell(0, 0, true), 0);
        assertEquals(b.getOceanCell(1, 1, true), 0);
        assertEquals(b.getOceanCell(2, 2, true), 0);
        assertEquals(b.getOceanCell(3, 3, true), 0);
        assertEquals(b.getOceanCell(4, 4, true), 0);

        b.setOceanBoard(0, 0);
        b.setOceanBoard(0, 4);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 3);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 2);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 1);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 4);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 3);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 2);
        b.setOceanBoard(5, 0);
        b.setOceanBoard(5, 1);
        assertEquals(b.getOceanCell(0, 0, true), 1);
        assertEquals(b.getOceanCell(0, 1, true), 1);
        assertEquals(b.getOceanCell(0, 2, true), 1);
        assertEquals(b.getOceanCell(0, 3, true), 1);
        assertEquals(b.getOceanCell(0, 4, true), 1);
        assertEquals(b.getOceanCell(1, 0, true), 2);
        assertEquals(b.getOceanCell(1, 1, true), 2);
        assertEquals(b.getOceanCell(1, 2, true), 2);
        assertEquals(b.getOceanCell(1, 3, true), 2);
        assertEquals(b.getOceanCell(2, 0, true), 3);
        assertEquals(b.getOceanCell(2, 1, true), 3);
        assertEquals(b.getOceanCell(2, 2, true), 3);
        assertEquals(b.getOceanCell(3, 0, true), 4);
        assertEquals(b.getOceanCell(3, 1, true), 4);
        assertEquals(b.getOceanCell(3, 2, true), 4);
        assertEquals(b.getOceanCell(4, 0, true), 5);
        assertEquals(b.getOceanCell(4, 1, true), 5);

        assertEquals(b.getOceanCell(1, 0, false), 1);
        assertEquals(b.getOceanCell(1, 1, false), 1);
        assertEquals(b.getOceanCell(1, 2, false), 1);
        assertEquals(b.getOceanCell(1, 3, false), 1);
        assertEquals(b.getOceanCell(1, 4, false), 1);
        assertEquals(b.getOceanCell(2, 0, false), 2);
        assertEquals(b.getOceanCell(2, 1, false), 2);
        assertEquals(b.getOceanCell(2, 2, false), 2);
        assertEquals(b.getOceanCell(2, 3, false), 2);
        assertEquals(b.getOceanCell(3, 0, false), 3);
        assertEquals(b.getOceanCell(3, 1, false), 3);
        assertEquals(b.getOceanCell(3, 2, false), 3);
        assertEquals(b.getOceanCell(4, 0, false), 4);
        assertEquals(b.getOceanCell(4, 1, false), 4);
        assertEquals(b.getOceanCell(4, 2, false), 4);
        assertEquals(b.getOceanCell(5, 0, false), 5);
        assertEquals(b.getOceanCell(5, 1, false), 5);
    }

    @Test
    public void attemptWrongSize() {
        Battleship b = new Battleship();
        b.setOceanBoard(0, 0);
        b.setOceanBoard(0, 4);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 3);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 2);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 1);

        // occupies four spots instead of five
        b.setOceanBoard(0, 0);
        b.setOceanBoard(0, 3);
        assertEquals(b.getOceanCell(0, 0, false), 0);
        assertEquals(b.getOceanCell(1, 1, false), 0);
        assertEquals(b.getOceanCell(2, 2, false), 0);
        assertEquals(b.getOceanCell(3, 3, false), 0);

        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 4);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 3);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 2);
        b.setOceanBoard(5, 0);
        b.setOceanBoard(5, 1);
        assertEquals(b.getOceanCell(0, 0, true), 1);
        assertEquals(b.getOceanCell(0, 1, true), 1);
        assertEquals(b.getOceanCell(0, 2, true), 1);
        assertEquals(b.getOceanCell(0, 3, true), 1);
        assertEquals(b.getOceanCell(0, 4, true), 1);
        assertEquals(b.getOceanCell(1, 0, true), 2);
        assertEquals(b.getOceanCell(1, 1, true), 2);
        assertEquals(b.getOceanCell(1, 2, true), 2);
        assertEquals(b.getOceanCell(1, 3, true), 2);
        assertEquals(b.getOceanCell(2, 0, true), 3);
        assertEquals(b.getOceanCell(2, 1, true), 3);
        assertEquals(b.getOceanCell(2, 2, true), 3);
        assertEquals(b.getOceanCell(3, 0, true), 4);
        assertEquals(b.getOceanCell(3, 1, true), 4);
        assertEquals(b.getOceanCell(3, 2, true), 4);
        assertEquals(b.getOceanCell(4, 0, true), 5);
        assertEquals(b.getOceanCell(4, 1, true), 5);

        assertEquals(b.getOceanCell(1, 0, false), 1);
        assertEquals(b.getOceanCell(1, 1, false), 1);
        assertEquals(b.getOceanCell(1, 2, false), 1);
        assertEquals(b.getOceanCell(1, 3, false), 1);
        assertEquals(b.getOceanCell(1, 4, false), 1);
        assertEquals(b.getOceanCell(2, 0, false), 2);
        assertEquals(b.getOceanCell(2, 1, false), 2);
        assertEquals(b.getOceanCell(2, 2, false), 2);
        assertEquals(b.getOceanCell(2, 3, false), 2);
        assertEquals(b.getOceanCell(3, 0, false), 3);
        assertEquals(b.getOceanCell(3, 1, false), 3);
        assertEquals(b.getOceanCell(3, 2, false), 3);
        assertEquals(b.getOceanCell(4, 0, false), 4);
        assertEquals(b.getOceanCell(4, 1, false), 4);
        assertEquals(b.getOceanCell(4, 2, false), 4);
        assertEquals(b.getOceanCell(5, 0, false), 5);
        assertEquals(b.getOceanCell(5, 1, false), 5);
    }

    @Test
    public void undoShip() {
        Battleship b = new Battleship();
        b.setOceanBoard(0, 0);
        b.setOceanBoard(0, 4);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 3);

        // undo a ship placement
        b.setOceanBoard(5, 4);
        b.setOceanBoard(5, 6);
        b.undoShip(b.getCurrentPlayer());
        assertEquals(b.getOceanCell(5, 4, true), 0);
        assertEquals(b.getOceanCell(5, 5, true), 0);
        assertEquals(b.getOceanCell(5, 6, true), 0);

        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 2);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 1);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 4);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 3);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 2);
        b.setOceanBoard(5, 0);
        b.setOceanBoard(5, 1);
        assertEquals(b.getOceanCell(0, 0, true), 1);
        assertEquals(b.getOceanCell(0, 1, true), 1);
        assertEquals(b.getOceanCell(0, 2, true), 1);
        assertEquals(b.getOceanCell(0, 3, true), 1);
        assertEquals(b.getOceanCell(0, 4, true), 1);
        assertEquals(b.getOceanCell(1, 0, true), 2);
        assertEquals(b.getOceanCell(1, 1, true), 2);
        assertEquals(b.getOceanCell(1, 2, true), 2);
        assertEquals(b.getOceanCell(1, 3, true), 2);
        assertEquals(b.getOceanCell(2, 0, true), 3);
        assertEquals(b.getOceanCell(2, 1, true), 3);
        assertEquals(b.getOceanCell(2, 2, true), 3);
        assertEquals(b.getOceanCell(3, 0, true), 4);
        assertEquals(b.getOceanCell(3, 1, true), 4);
        assertEquals(b.getOceanCell(3, 2, true), 4);
        assertEquals(b.getOceanCell(4, 0, true), 5);
        assertEquals(b.getOceanCell(4, 1, true), 5);

        assertEquals(b.getOceanCell(1, 0, false), 1);
        assertEquals(b.getOceanCell(1, 1, false), 1);
        assertEquals(b.getOceanCell(1, 2, false), 1);
        assertEquals(b.getOceanCell(1, 3, false), 1);
        assertEquals(b.getOceanCell(1, 4, false), 1);
        assertEquals(b.getOceanCell(2, 0, false), 2);
        assertEquals(b.getOceanCell(2, 1, false), 2);
        assertEquals(b.getOceanCell(2, 2, false), 2);
        assertEquals(b.getOceanCell(2, 3, false), 2);
        assertEquals(b.getOceanCell(3, 0, false), 3);
        assertEquals(b.getOceanCell(3, 1, false), 3);
        assertEquals(b.getOceanCell(3, 2, false), 3);
        assertEquals(b.getOceanCell(4, 0, false), 4);
        assertEquals(b.getOceanCell(4, 1, false), 4);
        assertEquals(b.getOceanCell(4, 2, false), 4);
        assertEquals(b.getOceanCell(5, 0, false), 5);
        assertEquals(b.getOceanCell(5, 1, false), 5);
    }

    @Test
    public void undoFirstClick() {
        Battleship b = new Battleship();
        b.setOceanBoard(0, 0);
        b.setOceanBoard(0, 4);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 3);

        // undo the starting spot chosen for a ship
        b.setOceanBoard(5, 4);
        b.undoFirstClick(b.getCurrentPlayer());
        assertEquals(b.getOceanCell(5, 4, true), 0);

        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 2);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 1);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 4);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 3);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 2);
        b.setOceanBoard(5, 0);
        b.setOceanBoard(5, 1);
        assertEquals(b.getOceanCell(0, 0, true), 1);
        assertEquals(b.getOceanCell(0, 1, true), 1);
        assertEquals(b.getOceanCell(0, 2, true), 1);
        assertEquals(b.getOceanCell(0, 3, true), 1);
        assertEquals(b.getOceanCell(0, 4, true), 1);
        assertEquals(b.getOceanCell(1, 0, true), 2);
        assertEquals(b.getOceanCell(1, 1, true), 2);
        assertEquals(b.getOceanCell(1, 2, true), 2);
        assertEquals(b.getOceanCell(1, 3, true), 2);
        assertEquals(b.getOceanCell(2, 0, true), 3);
        assertEquals(b.getOceanCell(2, 1, true), 3);
        assertEquals(b.getOceanCell(2, 2, true), 3);
        assertEquals(b.getOceanCell(3, 0, true), 4);
        assertEquals(b.getOceanCell(3, 1, true), 4);
        assertEquals(b.getOceanCell(3, 2, true), 4);
        assertEquals(b.getOceanCell(4, 0, true), 5);
        assertEquals(b.getOceanCell(4, 1, true), 5);

        assertEquals(b.getOceanCell(1, 0, false), 1);
        assertEquals(b.getOceanCell(1, 1, false), 1);
        assertEquals(b.getOceanCell(1, 2, false), 1);
        assertEquals(b.getOceanCell(1, 3, false), 1);
        assertEquals(b.getOceanCell(1, 4, false), 1);
        assertEquals(b.getOceanCell(2, 0, false), 2);
        assertEquals(b.getOceanCell(2, 1, false), 2);
        assertEquals(b.getOceanCell(2, 2, false), 2);
        assertEquals(b.getOceanCell(2, 3, false), 2);
        assertEquals(b.getOceanCell(3, 0, false), 3);
        assertEquals(b.getOceanCell(3, 1, false), 3);
        assertEquals(b.getOceanCell(3, 2, false), 3);
        assertEquals(b.getOceanCell(4, 0, false), 4);
        assertEquals(b.getOceanCell(4, 1, false), 4);
        assertEquals(b.getOceanCell(4, 2, false), 4);
        assertEquals(b.getOceanCell(5, 0, false), 5);
        assertEquals(b.getOceanCell(5, 1, false), 5);
    }

    @Test
    public void multipleUndo() {
        Battleship b = new Battleship();
        b.setOceanBoard(0, 0);
        b.setOceanBoard(0, 4);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 3);

        // undo second ship
        b.undoShip(b.getCurrentPlayer());
        assertEquals(b.getOceanCell(5, 4, true), 0);
        assertEquals(b.getOceanCell(5, 6, true), 0);

        // undo first ship
        b.undoShip(b.getCurrentPlayer());
        assertEquals(b.getOceanCell(5, 4, true), 0);
        assertEquals(b.getOceanCell(5, 6, true), 0);

        // undo on empty board should not throw NoSuchElementException
        assertDoesNotThrow(() -> b.undoShip(b.getCurrentPlayer()));

        b.setOceanBoard(0, 0);
        b.setOceanBoard(0, 4);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 3);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 2);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 1);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 4);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 3);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 2);
        b.setOceanBoard(5, 0);
        b.setOceanBoard(5, 1);
        assertEquals(b.getOceanCell(0, 0, true), 1);
        assertEquals(b.getOceanCell(0, 1, true), 1);
        assertEquals(b.getOceanCell(0, 2, true), 1);
        assertEquals(b.getOceanCell(0, 3, true), 1);
        assertEquals(b.getOceanCell(0, 4, true), 1);
        assertEquals(b.getOceanCell(1, 0, true), 2);
        assertEquals(b.getOceanCell(1, 1, true), 2);
        assertEquals(b.getOceanCell(1, 2, true), 2);
        assertEquals(b.getOceanCell(1, 3, true), 2);
        assertEquals(b.getOceanCell(2, 0, true), 3);
        assertEquals(b.getOceanCell(2, 1, true), 3);
        assertEquals(b.getOceanCell(2, 2, true), 3);
        assertEquals(b.getOceanCell(3, 0, true), 4);
        assertEquals(b.getOceanCell(3, 1, true), 4);
        assertEquals(b.getOceanCell(3, 2, true), 4);
        assertEquals(b.getOceanCell(4, 0, true), 5);
        assertEquals(b.getOceanCell(4, 1, true), 5);

        assertEquals(b.getOceanCell(1, 0, false), 1);
        assertEquals(b.getOceanCell(1, 1, false), 1);
        assertEquals(b.getOceanCell(1, 2, false), 1);
        assertEquals(b.getOceanCell(1, 3, false), 1);
        assertEquals(b.getOceanCell(1, 4, false), 1);
        assertEquals(b.getOceanCell(2, 0, false), 2);
        assertEquals(b.getOceanCell(2, 1, false), 2);
        assertEquals(b.getOceanCell(2, 2, false), 2);
        assertEquals(b.getOceanCell(2, 3, false), 2);
        assertEquals(b.getOceanCell(3, 0, false), 3);
        assertEquals(b.getOceanCell(3, 1, false), 3);
        assertEquals(b.getOceanCell(3, 2, false), 3);
        assertEquals(b.getOceanCell(4, 0, false), 4);
        assertEquals(b.getOceanCell(4, 1, false), 4);
        assertEquals(b.getOceanCell(4, 2, false), 4);
        assertEquals(b.getOceanCell(5, 0, false), 5);
        assertEquals(b.getOceanCell(5, 1, false), 5);
    }

    @Test
    public void overLappingShips() {
        Battleship b = new Battleship();
        b.setOceanBoard(0, 0);
        b.setOceanBoard(0, 4);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 3);

        // overlaps first ship
        b.setOceanBoard(0, 2);
        b.setOceanBoard(2, 2);
        assertEquals(b.getOceanCell(0, 2, true), 1);
        assertEquals(b.getOceanCell(2, 2, true), 0);

        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 2);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 1);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 4);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 3);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 2);
        b.setOceanBoard(5, 0);
        b.setOceanBoard(5, 1);
        assertEquals(b.getOceanCell(0, 0, true), 1);
        assertEquals(b.getOceanCell(0, 1, true), 1);
        assertEquals(b.getOceanCell(0, 2, true), 1);
        assertEquals(b.getOceanCell(0, 3, true), 1);
        assertEquals(b.getOceanCell(0, 4, true), 1);
        assertEquals(b.getOceanCell(1, 0, true), 2);
        assertEquals(b.getOceanCell(1, 1, true), 2);
        assertEquals(b.getOceanCell(1, 2, true), 2);
        assertEquals(b.getOceanCell(1, 3, true), 2);
        assertEquals(b.getOceanCell(2, 0, true), 3);
        assertEquals(b.getOceanCell(2, 1, true), 3);
        assertEquals(b.getOceanCell(2, 2, true), 3);
        assertEquals(b.getOceanCell(3, 0, true), 4);
        assertEquals(b.getOceanCell(3, 1, true), 4);
        assertEquals(b.getOceanCell(3, 2, true), 4);
        assertEquals(b.getOceanCell(4, 0, true), 5);
        assertEquals(b.getOceanCell(4, 1, true), 5);

        assertEquals(b.getOceanCell(1, 0, false), 1);
        assertEquals(b.getOceanCell(1, 1, false), 1);
        assertEquals(b.getOceanCell(1, 2, false), 1);
        assertEquals(b.getOceanCell(1, 3, false), 1);
        assertEquals(b.getOceanCell(1, 4, false), 1);
        assertEquals(b.getOceanCell(2, 0, false), 2);
        assertEquals(b.getOceanCell(2, 1, false), 2);
        assertEquals(b.getOceanCell(2, 2, false), 2);
        assertEquals(b.getOceanCell(2, 3, false), 2);
        assertEquals(b.getOceanCell(3, 0, false), 3);
        assertEquals(b.getOceanCell(3, 1, false), 3);
        assertEquals(b.getOceanCell(3, 2, false), 3);
        assertEquals(b.getOceanCell(4, 0, false), 4);
        assertEquals(b.getOceanCell(4, 1, false), 4);
        assertEquals(b.getOceanCell(4, 2, false), 4);
        assertEquals(b.getOceanCell(5, 0, false), 5);
        assertEquals(b.getOceanCell(5, 1, false), 5);
    }

    @Test
    public void testRepeatedShots() {
        Battleship b = new Battleship();
        b.setOceanBoard(0, 0);
        b.setOceanBoard(0, 4);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 3);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 2);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 1);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 4);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 3);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 2);
        b.setOceanBoard(5, 0);
        b.setOceanBoard(5, 1);

        assertEquals(b.takeShot(1, 0), 1);
        assertEquals(b.takeShot(0, 0), 1);
        // repeat shot
        assertEquals(b.takeShot(1, 0), -1);
        // allow player to take different shot
        assertEquals(b.takeShot(1, 1), 1);
        assertEquals(b.takeShot(0, 1), 1);
        assertEquals(b.takeShot(1, 2), 1);
        assertEquals(b.takeShot(0, 2), 1);
        assertEquals(b.takeShot(1, 3), 1);
        assertEquals(b.takeShot(0, 3), 1);
        assertEquals(b.takeShot(1, 4), 2);
        assertEquals(b.takeShot(0, 4), 2);

        assertEquals(b.takeShot(2, 0), 1);
        assertEquals(b.takeShot(1, 0), 1);
        assertEquals(b.takeShot(2, 1), 1);
        assertEquals(b.takeShot(1, 1), 1);
        assertEquals(b.takeShot(2, 2), 1);
        assertEquals(b.takeShot(1, 2), 1);
        assertEquals(b.takeShot(2, 3), 2);
        assertEquals(b.takeShot(1, 3), 2);
        assertEquals(b.takeShot(2, 4), 0);
        assertEquals(b.takeShot(1, 4), 0);

        assertEquals(b.takeShot(3, 0), 1);
        assertEquals(b.takeShot(2, 0), 1);
        assertEquals(b.takeShot(3, 1), 1);
        assertEquals(b.takeShot(2, 1), 1);
        assertEquals(b.takeShot(3, 2), 2);
        assertEquals(b.takeShot(2, 2), 2);
        assertEquals(b.takeShot(3, 3), 0);
        assertEquals(b.takeShot(2, 3), 0);
        assertEquals(b.takeShot(3, 4), 0);
        assertEquals(b.takeShot(2, 4), 0);

        assertEquals(b.takeShot(4, 0), 1);
        assertEquals(b.takeShot(3, 0), 1);
        assertEquals(b.takeShot(4, 1), 1);
        assertEquals(b.takeShot(3, 1), 1);
        assertEquals(b.takeShot(4, 2), 2);
        assertEquals(b.takeShot(3, 2), 2);
        assertEquals(b.takeShot(4, 3), 0);
        assertEquals(b.takeShot(3, 3), 0);
        assertEquals(b.takeShot(4, 4), 0);
        assertEquals(b.takeShot(3, 4), 0);

        assertEquals(b.takeShot(5, 0), 1);
        assertEquals(b.takeShot(4, 0), 1);
        assertEquals(b.takeShot(5, 1), 3);
        assertTrue(b.getGameOver());
        assertTrue(b.getCurrentPlayer());
    }

    @Test
    public void testMultipleRepeatedShots() {
        Battleship b = new Battleship();
        b.setOceanBoard(0, 0);
        b.setOceanBoard(0, 4);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 3);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 2);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 1);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 4);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 3);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 2);
        b.setOceanBoard(5, 0);
        b.setOceanBoard(5, 1);

        assertEquals(b.takeShot(1, 0), 1);
        assertEquals(b.takeShot(0, 0), 1);
        assertEquals(b.takeShot(1, 1), 1);
        assertEquals(b.takeShot(0, 1), 1);
        // already took shot, so should take new shot
        assertEquals(b.takeShot(1, 0), -1);
        // new shot is also an already taken shot, so should be able to take another new
        // shot
        assertEquals(b.takeShot(1, 1), -1);
        // new shot is a new shot
        assertEquals(b.takeShot(1, 2), 1);
        assertEquals(b.takeShot(0, 2), 1);
        assertEquals(b.takeShot(1, 3), 1);
        assertEquals(b.takeShot(0, 3), 1);
        assertEquals(b.takeShot(1, 4), 2);
        assertEquals(b.takeShot(0, 4), 2);

        assertEquals(b.takeShot(2, 0), 1);
        assertEquals(b.takeShot(1, 0), 1);
        assertEquals(b.takeShot(2, 1), 1);
        assertEquals(b.takeShot(1, 1), 1);
        assertEquals(b.takeShot(2, 2), 1);
        assertEquals(b.takeShot(1, 2), 1);
        assertEquals(b.takeShot(2, 3), 2);
        assertEquals(b.takeShot(1, 3), 2);
        assertEquals(b.takeShot(2, 4), 0);
        assertEquals(b.takeShot(1, 4), 0);

        assertEquals(b.takeShot(3, 0), 1);
        assertEquals(b.takeShot(2, 0), 1);
        assertEquals(b.takeShot(3, 1), 1);
        assertEquals(b.takeShot(2, 1), 1);
        assertEquals(b.takeShot(3, 2), 2);
        assertEquals(b.takeShot(2, 2), 2);
        assertEquals(b.takeShot(3, 3), 0);
        assertEquals(b.takeShot(2, 3), 0);
        assertEquals(b.takeShot(3, 4), 0);
        assertEquals(b.takeShot(2, 4), 0);

        assertEquals(b.takeShot(4, 0), 1);
        assertEquals(b.takeShot(3, 0), 1);
        assertEquals(b.takeShot(4, 1), 1);
        assertEquals(b.takeShot(3, 1), 1);
        assertEquals(b.takeShot(4, 2), 2);
        assertEquals(b.takeShot(3, 2), 2);
        assertEquals(b.takeShot(4, 3), 0);
        assertEquals(b.takeShot(3, 3), 0);
        assertEquals(b.takeShot(4, 4), 0);
        assertEquals(b.takeShot(3, 4), 0);

        assertEquals(b.takeShot(5, 2), 0);
        assertEquals(b.takeShot(4, 0), 1);
        assertEquals(b.takeShot(5, 1), 1);
        assertEquals(b.takeShot(4, 1), 3);
        assertTrue(b.getGameOver());
        assertFalse(b.getCurrentPlayer());
    }

    @Test
    public void testMaxTurnBattleshipGame() {
        Battleship b = new Battleship();
        b.setOceanBoard(0, 2);
        b.setOceanBoard(0, 6);
        b.setOceanBoard(1, 0);
        b.setOceanBoard(1, 3);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 2);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 1);
        b.setOceanBoard(1, 2);
        b.setOceanBoard(1, 6);
        b.setOceanBoard(2, 0);
        b.setOceanBoard(2, 3);
        b.setOceanBoard(3, 0);
        b.setOceanBoard(3, 2);
        b.setOceanBoard(4, 0);
        b.setOceanBoard(4, 2);
        b.setOceanBoard(5, 0);
        b.setOceanBoard(5, 1);

        assertEquals(b.takeShot(0, 0), 0);
        assertEquals(b.takeShot(5, 0), 0);
        assertEquals(b.takeShot(0, 1), 0);
        assertEquals(b.takeShot(5, 1), 0);
        assertEquals(b.takeShot(0, 2), 0);
        assertEquals(b.takeShot(5, 2), 0);
        assertEquals(b.takeShot(0, 3), 0);
        assertEquals(b.takeShot(5, 3), 0);
        assertEquals(b.takeShot(0, 4), 0);
        assertEquals(b.takeShot(5, 4), 0);
        assertEquals(b.takeShot(0, 5), 0);
        assertEquals(b.takeShot(5, 5), 0);
        assertEquals(b.takeShot(0, 6), 0);
        assertEquals(b.takeShot(5, 6), 0);

        assertEquals(b.takeShot(6, 0), 0);
        assertEquals(b.takeShot(6, 0), 0);
        assertEquals(b.takeShot(6, 1), 0);
        assertEquals(b.takeShot(6, 1), 0);
        assertEquals(b.takeShot(6, 2), 0);
        assertEquals(b.takeShot(6, 2), 0);
        assertEquals(b.takeShot(6, 3), 0);
        assertEquals(b.takeShot(6, 3), 0);
        assertEquals(b.takeShot(6, 4), 0);
        assertEquals(b.takeShot(6, 4), 0);
        assertEquals(b.takeShot(6, 5), 0);
        assertEquals(b.takeShot(6, 5), 0);
        assertEquals(b.takeShot(6, 6), 0);
        assertEquals(b.takeShot(6, 6), 0);

        assertEquals(b.takeShot(1, 0), 0);
        assertEquals(b.takeShot(0, 0), 0);
        assertEquals(b.takeShot(1, 1), 0);
        assertEquals(b.takeShot(0, 1), 0);
        assertEquals(b.takeShot(1, 2), 1);
        assertEquals(b.takeShot(0, 2), 1);
        assertEquals(b.takeShot(1, 3), 1);
        assertEquals(b.takeShot(0, 3), 1);
        assertEquals(b.takeShot(1, 4), 1);
        assertEquals(b.takeShot(0, 4), 1);
        assertEquals(b.takeShot(1, 5), 1);
        assertEquals(b.takeShot(0, 5), 1);

        assertEquals(b.takeShot(2, 0), 1);
        assertEquals(b.takeShot(1, 0), 1);
        assertEquals(b.takeShot(2, 1), 1);
        assertEquals(b.takeShot(1, 1), 1);
        assertEquals(b.takeShot(2, 2), 1);
        assertEquals(b.takeShot(1, 2), 1);
        assertEquals(b.takeShot(2, 3), 2);
        assertEquals(b.takeShot(1, 3), 2);
        assertEquals(b.takeShot(2, 4), 0);
        assertEquals(b.takeShot(1, 4), 0);
        assertEquals(b.takeShot(2, 5), 0);
        assertEquals(b.takeShot(1, 5), 0);
        assertEquals(b.takeShot(2, 6), 0);
        assertEquals(b.takeShot(1, 6), 0);

        assertEquals(b.takeShot(3, 0), 1);
        assertEquals(b.takeShot(2, 0), 1);
        assertEquals(b.takeShot(3, 1), 1);
        assertEquals(b.takeShot(2, 1), 1);
        assertEquals(b.takeShot(3, 2), 2);
        assertEquals(b.takeShot(2, 2), 2);
        assertEquals(b.takeShot(3, 3), 0);
        assertEquals(b.takeShot(2, 3), 0);
        assertEquals(b.takeShot(3, 4), 0);
        assertEquals(b.takeShot(2, 4), 0);
        assertEquals(b.takeShot(3, 5), 0);
        assertEquals(b.takeShot(2, 5), 0);
        assertEquals(b.takeShot(3, 6), 0);
        assertEquals(b.takeShot(2, 6), 0);

        assertEquals(b.takeShot(4, 0), 1);
        assertEquals(b.takeShot(3, 0), 1);
        assertEquals(b.takeShot(4, 1), 1);
        assertEquals(b.takeShot(3, 1), 1);
        assertEquals(b.takeShot(4, 2), 2);
        assertEquals(b.takeShot(3, 2), 2);
        assertEquals(b.takeShot(4, 3), 0);
        assertEquals(b.takeShot(3, 3), 0);
        assertEquals(b.takeShot(4, 4), 0);
        assertEquals(b.takeShot(3, 4), 0);
        assertEquals(b.takeShot(4, 5), 0);
        assertEquals(b.takeShot(3, 5), 0);
        assertEquals(b.takeShot(4, 6), 0);
        assertEquals(b.takeShot(3, 6), 0);

        assertEquals(b.takeShot(5, 0), 1);
        assertEquals(b.takeShot(4, 0), 1);
        assertEquals(b.takeShot(5, 1), 2);
        assertEquals(b.takeShot(4, 1), 2);
        assertEquals(b.takeShot(5, 2), 0);
        assertEquals(b.takeShot(4, 2), 0);
        assertEquals(b.takeShot(5, 3), 0);
        assertEquals(b.takeShot(4, 3), 0);
        assertEquals(b.takeShot(5, 4), 0);
        assertEquals(b.takeShot(4, 4), 0);
        assertEquals(b.takeShot(5, 5), 0);
        assertEquals(b.takeShot(4, 5), 0);
        assertEquals(b.takeShot(5, 6), 0);
        assertEquals(b.takeShot(4, 6), 0);

        assertEquals(b.takeShot(1, 6), 3);

        assertTrue(b.getGameOver());
        assertTrue(b.getCurrentPlayer());
    }
}
