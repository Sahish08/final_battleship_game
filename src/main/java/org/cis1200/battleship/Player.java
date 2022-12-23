package org.cis1200.battleship;

import java.util.LinkedList;
import java.util.TreeMap;

public class Player {
    private int[][] oceanBoard;
    private int[][] targetBoard;
    private int setup;
    private int currR;
    private int currC;
    private int deadShips;
    private TreeMap<Integer, Integer> shipHealth;
    private LinkedList<int[][]> oceanHist;
    private int[][] prevOcean;

    public Player() {
        oceanBoard = new int[7][7];
        targetBoard = new int[7][7];
        setup = 0;
        shipHealth = new TreeMap<Integer, Integer>();
        currR = -1;
        currC = -1;
        deadShips = 0;
        oceanHist = new LinkedList<int[][]>();
        prevOcean = new int[7][7];
    }

    public boolean placeShip(int endR, int endC, int size) {
        if (currR != -1) {
            int startR = currR;
            int startC = currC;
            currR = -1;
            currC = -1;
            if (startR == endR) {
                if (startC + (size - 1) == endC) {
                    for (int i = startC; i <= endC; i++) {
                        if (oceanBoard[startR][i] != 0) {
                            return false;
                        }
                    }
                    setup += 1;
                    shipHealth.put(setup, size);
                    oceanHist.add(prevOcean);
                    for (int i = startC; i <= endC; i++) {
                        oceanBoard[startR][i] = setup;
                    }
                    prevOcean = new int[7][7];
                    for (int i = 0; i < oceanBoard.length; i++) {
                        System.arraycopy(oceanBoard[i], 0, prevOcean[i], 0, oceanBoard[i].length);
                    }
                    return true;
                } else if (startC - (size - 1) == endC) {
                    for (int i = endC; i <= startC; i++) {
                        if (oceanBoard[startR][i] != 0) {
                            return false;
                        }
                    }
                    setup += 1;
                    shipHealth.put(setup, size);
                    oceanHist.add(prevOcean);
                    for (int i = endC; i <= startC; i++) {
                        oceanBoard[startR][i] = setup;
                    }
                    prevOcean = new int[7][7];
                    for (int i = 0; i < oceanBoard.length; i++) {
                        System.arraycopy(oceanBoard[i], 0, prevOcean[i], 0, oceanBoard[i].length);
                    }
                    return true;
                } else {
                    return false;
                }
            } else if (startC == endC) {
                if (startR + (size - 1) == endR) {
                    for (int i = startR; i <= endR; i++) {
                        if (oceanBoard[i][startC] != 0) {
                            return false;
                        }
                    }
                    setup += 1;
                    shipHealth.put(setup, size);
                    oceanHist.add(prevOcean);
                    for (int i = startR; i <= endR; i++) {
                        oceanBoard[i][startC] = setup;
                    }
                    prevOcean = new int[7][7];
                    for (int i = 0; i < oceanBoard.length; i++) {
                        System.arraycopy(oceanBoard[i], 0, prevOcean[i], 0, oceanBoard[i].length);
                    }
                    return true;
                } else if (startR - (size - 1) == endR) {
                    for (int i = endR; i <= startR; i++) {
                        if (oceanBoard[i][startC] != 0) {
                            return false;
                        }
                    }
                    setup += 1;
                    shipHealth.put(setup, size);
                    oceanHist.add(prevOcean);
                    for (int i = endR; i <= startR; i++) {
                        oceanBoard[i][startC] = setup;
                    }
                    prevOcean = new int[7][7];
                    for (int i = 0; i < oceanBoard.length; i++) {
                        prevOcean[i] = new int[oceanBoard[i].length];
                        System.arraycopy(oceanBoard[i], 0, prevOcean[i], 0, oceanBoard[i].length);
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            currR = endR;
            currC = endC;
            return true;
        }
    }

    public int getOceanCell(int r, int c) {
        return oceanBoard[r][c];
    }

    public int getTargetCell(int r, int c) {
        return targetBoard[r][c];
    }

    public int getShipHealth(int ship) {
        return shipHealth.get(ship);
    }

    public int getSetup() {
        return setup;
    }

    public int getDeadShips() {
        return deadShips;
    }

    public void setOceanCell(int r, int c, int v) {
        oceanBoard[r][c] = v;
    }

    public void setTargetCell(int r, int c, int v) {
        targetBoard[r][c] = v;
    }

    public void setShipHealth(int ship, int v) {
        shipHealth.put(ship, v);
    }

    public void incrementDeadShips() {
        deadShips += 1;
    }

    public int getCurrR() {
        return currR;
    }

    public int getCurrC() {
        return currC;
    }

    public int getPrevCell(int r, int c) {
        return prevOcean[r][c];
    }

    public void setNumSetup(int v) {
        setup = v;
    }

    public void setCurrR(int v) {
        currR = v;
    }

    public void setCurrC(int v) {
        currC = v;
    }

    public LinkedList<int[][]> getOceanHist() {
        LinkedList<int[][]> hist = new LinkedList<>();
        hist.addAll(oceanHist);
        return hist;
    }

    public TreeMap getAllHealth() {
        TreeMap health = new TreeMap();
        health.putAll(shipHealth);
        return health;
    }

    public void setAllHealth(TreeMap v) {
        shipHealth = v;
    }

    public void setOceanHist(LinkedList<int[][]> v) {
        oceanHist = v;
    }

    public void setPrevCell(int r, int c, int v) {
        prevOcean[r][c] = v;
    }

    public void undoShip() {
        if (!oceanHist.isEmpty()) {
            oceanBoard = oceanHist.removeLast();
            prevOcean = new int[7][7];
            for (int i = 0; i < oceanBoard.length; i++) {
                System.arraycopy(oceanBoard[i], 0, prevOcean[i], 0, oceanBoard[i].length);
            }
            setup -= 1;
        }
    }

    public void undoFirstClick() {
        currR = -1;
        currC = -1;
    }
}
