package org.cis1200.battleship;

import java.util.LinkedList;
import java.util.TreeMap;

public class Battleship {
    private boolean player1;
    private boolean gameOver;
    private Player p1;
    private Player p2;
    private boolean setUpMode;
    private final int[] shipSizes = { 5, 4, 3, 3, 2 };

    /**
     * Constructor sets up game state.
     */

    public Battleship() {
        reset();
    }

    public void setOceanBoard(int r, int c) {
        if (setUpMode) {
            Player p;
            if (player1) {
                p = p1;
            } else {
                p = p2;
            }
            p.placeShip(r, c, shipSizes[p.getSetup()]);
            if (p.getSetup() == 5) {
                if (!player1) {
                    setUpMode = false;
                }
                player1 = !player1;
            }
        }
    }

    public int takeShot(int r, int c) {
        if (!setUpMode && !gameOver) {
            Player p;
            Player opp;
            if (player1) {
                p = p1;
                opp = p2;
            } else {
                p = p2;
                opp = p1;
            }
            int result = opp.getOceanCell(r, c);
            if (result == 0) {
                p.setTargetCell(r, c, -1);
                player1 = !player1;
                opp.setOceanCell(r, c, -1);
                return 0;// shot missed
            } else if (result == -1 || result == 6) {
                return -1;// already shot there
            } else {
                p.setTargetCell(r, c, 1);
                player1 = !player1;
                opp.setOceanCell(r, c, 6);
                opp.setShipHealth(result, opp.getShipHealth(result) - 1);
                if (opp.getShipHealth(result) == 0) {
                    opp.incrementDeadShips();
                    if (opp.getDeadShips() == 5) {
                        player1 = !player1;
                        gameOver = true;
                        return 3;// won game
                    } else {
                        return 2;// sunk ship
                    }
                } else {
                    return 1;// hit ship
                }
            }
        }
        return -2;// game over or in setup mode
    }

    /**
     * reset (re-)sets the game state to start a new game.
     */
    public void reset() {
        p1 = new Player();
        p2 = new Player();
        gameOver = false;
        player1 = true;
        setUpMode = true;
    }

    /**
     * getCurrentPlayer is a getter for the player
     * whose turn it is in the game.
     * 
     * @return true if it's Player 1's turn,
     *         false if it's Player 2's turn.
     */
    public boolean getCurrentPlayer() {
        return player1;
    }

    public void setCurrentPlayer(boolean v) {
        player1 = v;
    }

    public void setPrevCell(int r, int c, int v, boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        p.setPrevCell(r, c, v);
    }

    /**
     * getCell is a getter for the contents of the cell specified by the method
     * arguments.
     *
     * @param c column to retrieve
     * @param r row to retrieve
     * @return an integer denoting the contents of the corresponding cell on the
     *         game board. 0 = empty, 1 = Player 1, 2 = Player 2
     */
    public int getOceanCell(int r, int c, boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        return p.getOceanCell(r, c);
    }

    public int getTargetCell(int r, int c, boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        return p.getTargetCell(r, c);
    }

    public boolean getSetupMode() {
        return setUpMode;
    }

    public void setSetUpMode(boolean v) {
        setUpMode = v;
    }

    public int getCurrentSetup(boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }

        if (p.getSetup() < 5) {
            return shipSizes[p.getSetup()];
        } else {
            return -1;
        }
    }

    public int getNumSetup(boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        return p.getSetup();
    }

    public int getShipsLeft(boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        return (5 - p.getDeadShips());
    }

    public boolean getGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean v) {
        gameOver = v;
    }

    public int getCurrR(boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        return p.getCurrR();
    }

    public int getCurrC(boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        return p.getCurrC();
    }

    public int getPrevCell(int r, int c, boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        return p.getPrevCell(r, c);
    }

    public LinkedList<int[][]> getOceanHist(boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        return p.getOceanHist();
    }

    public void setOceanCell(int r, int c, int v, boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        p.setOceanCell(r, c, v);
    }

    public void setTargetCell(int r, int c, int v, boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        p.setTargetCell(r, c, v);
    }

    public void undoShip(boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        p.undoShip();
    }

    public void setNumSetup(int v, boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        p.setNumSetup(v);
    }

    public void setCurrR(int v, boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        p.setCurrR(v);
    }

    public void setCurrC(int v, boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        p.setCurrC(v);
    }

    public void setOceanHist(LinkedList<int[][]> v, boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        p.setOceanHist(v);
    }

    public void undoFirstClick(boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        p.undoFirstClick();
    }

    public TreeMap getAllHealth(boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        return p.getAllHealth();
    }

    public void setAllHealth(TreeMap v, boolean player) {
        Player p;
        if (player) {
            p = p1;
        } else {
            p = p2;
        }
        p.setAllHealth(v);
    }

    public static void main(String[] args) {
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

        b.takeShot(1, 0);
        b.takeShot(0, 0);
        b.takeShot(1, 1);
        b.takeShot(0, 1);
        b.takeShot(1, 2);
        b.takeShot(0, 2);
        b.takeShot(1, 3);
        b.takeShot(0, 3);
        b.takeShot(1, 4);
        b.takeShot(0, 4);

        b.takeShot(2, 0);
        b.takeShot(1, 0);
        b.takeShot(2, 1);
        b.takeShot(1, 1);
        b.takeShot(2, 2);
        b.takeShot(1, 2);
        b.takeShot(2, 3);
        b.takeShot(1, 3);
        b.takeShot(2, 4);
        b.takeShot(1, 4);

        b.takeShot(3, 0);
        b.takeShot(2, 0);
        b.takeShot(3, 1);
        b.takeShot(2, 1);
        b.takeShot(3, 2);
        b.takeShot(2, 2);
        b.takeShot(3, 3);
        b.takeShot(2, 3);
        b.takeShot(3, 4);
        b.takeShot(2, 4);

        b.takeShot(4, 0);
        b.takeShot(3, 0);
        b.takeShot(4, 1);
        b.takeShot(3, 1);
        b.takeShot(4, 2);
        b.takeShot(3, 2);
        b.takeShot(4, 3);
        b.takeShot(3, 3);
        b.takeShot(4, 4);
        b.takeShot(3, 4);

        b.takeShot(5, 0);
        b.takeShot(4, 0);
        b.takeShot(5, 1);
    }
}
