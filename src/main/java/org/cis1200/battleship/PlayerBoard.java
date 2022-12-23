package org.cis1200.battleship;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class PlayerBoard extends JPanel {
    private OceanBoard ocean;
    private TargetBoard target;
    private JLabel status; // current status text
    private JLabel lState;
    private JLabel rState;
    private Battleship b;

    /**
     * Initializes the game board.
     */
    public PlayerBoard(JLabel statusInit, JLabel lStateInit, JLabel rStateInit) {

        // Enable keyboard focus on the court area. When this component has the
        // keyboard focus, key events are handled by its key listener.
        setFocusable(true);
        b = new Battleship();
        ocean = new OceanBoard(b, this);
        target = new TargetBoard(b, this);
        status = statusInit; // initializes the status JLabel
        lState = lStateInit;
        rState = rStateInit;
        this.setLayout(new GridLayout(0, 2, 50, 0));
        this.add(ocean);
        this.add(target);
        /*
         * Listens for mouseclicks. Updates the model, then updates the game
         * board based off of the updated model.
         */
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (b.getCurrentPlayer() != ocean.getTurn() && !ocean.getStop()) {
                    ocean.setTurn(b.getCurrentPlayer());
                    target.setTurn(b.getCurrentPlayer());

                    updateStatus(); // updates the status JLabel
                    repaint(); // repaints the game board
                }
            }
        });
    }

    /**
     * (Re-)sets the game to its initial state.
     */
    public void reset() {
        status.setText("Player 1's Turn");
        lState.setText("Your Board: Click the starting and ending points " +
                "to place your ship that occupies 5 boxes.");
        rState.setText("Target Board");
        setFocusable(true);
        b.reset();
        ocean.setTurn(b.getCurrentPlayer());
        target.setTurn(b.getCurrentPlayer());
        repaint();

        // Makes sure this component has keyboard/mouse focus
        requestFocusInWindow();
    }

    public void undo() {
        if (b.getCurrentSetup(ocean.getTurn()) > 0) {
            if (b.getCurrC(ocean.getTurn()) == -1) {
                b.undoShip(ocean.getTurn());
            } else {
                b.undoFirstClick(ocean.getTurn());
            }
            repaint();
            updateStatus();
        }
    }

    public void writeStringsToFile(
            List<String> stringsToWrite, String filePath
    ) {
        File file = Paths.get(filePath).toFile();
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(file, false));
            boolean first = true;
            for (String line : stringsToWrite) {
                if (first) {
                    first = false;
                } else {
                    bw.newLine();
                }
                bw.write(line);
            }
            bw.close();
        } catch (IOException io) {

        }
    }

    public void writeInfoToFile(String filePath) {
        writeStringsToFile(saveGameState(), filePath);
        ocean.setStop(true);
        target.setStop(true);
    }

    public List<String> saveGameState() {
        List<String> gameState = new LinkedList<String>();
        String temp = "";
        for (int i = 0; i < 7; i++) {
            if (i != 0) {
                temp += " ";
            }
            for (int j = 0; j < 7; j++) {
                if (j != 0) {
                    temp += ",";
                }
                temp += b.getOceanCell(i, j, true);
            }
        }
        gameState.add(temp);
        temp = "";
        for (int i = 0; i < 7; i++) {
            if (i != 0) {
                temp += " ";
            }
            for (int j = 0; j < 7; j++) {
                if (j != 0) {
                    temp += ",";
                }
                temp += b.getOceanCell(i, j, false);
            }
        }
        gameState.add(temp);
        temp = "";
        for (int i = 0; i < 7; i++) {
            if (i != 0) {
                temp += " ";
            }
            for (int j = 0; j < 7; j++) {
                if (j != 0) {
                    temp += ",";
                }
                temp += b.getTargetCell(i, j, true);
            }
        }
        gameState.add(temp);
        temp = "";
        for (int i = 0; i < 7; i++) {
            if (i != 0) {
                temp += " ";
            }
            for (int j = 0; j < 7; j++) {
                if (j != 0) {
                    temp += ",";
                }
                temp += (b.getTargetCell(i, j, false));
            }
        }
        gameState.add(temp);
        gameState.add(String.valueOf(b.getNumSetup(true)));
        gameState.add(String.valueOf(b.getNumSetup(false)));
        gameState.add(String.valueOf(b.getCurrR(true)));
        gameState.add(String.valueOf(b.getCurrR(false)));
        gameState.add(String.valueOf(b.getCurrC(true)));
        gameState.add(String.valueOf(b.getCurrC(false)));
        LinkedList<int[][]> hist = b.getOceanHist(true);
        if (hist.isEmpty()) {
            gameState.add("null");
        } else {
            temp = "";
            boolean space = false;
            for (int[][] past : hist) {
                if (!space) {
                    space = true;
                } else {
                    temp += " ";
                }
                for (int i = 0; i < 7; i++) {
                    if (i != 0) {
                        temp += " ";
                    }
                    for (int j = 0; j < 7; j++) {
                        if (j != 0) {
                            temp += ",";
                        }
                        temp += past[i][j];
                    }
                }
            }
            gameState.add(temp);
        }
        hist = b.getOceanHist(false);
        if (hist.isEmpty()) {
            gameState.add("null");
        } else {
            temp = "";
            boolean space = false;
            for (int[][] past : hist) {
                if (!space) {
                    space = true;
                } else {
                    temp += " ";
                }
                for (int i = 0; i < 7; i++) {
                    if (i != 0) {
                        temp += " ";
                    }
                    for (int j = 0; j < 7; j++) {
                        if (j != 0) {
                            temp += ",";
                        }
                        temp += past[i][j];
                    }
                }
            }
            gameState.add(temp);
        }
        temp = "";
        for (int i = 0; i < 7; i++) {
            if (i != 0) {
                temp += " ";
            }
            for (int j = 0; j < 7; j++) {
                if (j != 0) {
                    temp += ",";
                }
                temp += (b.getPrevCell(i, j, true));
            }
        }
        gameState.add(temp);
        temp = "";
        for (int i = 0; i < 7; i++) {
            if (i != 0) {
                temp += " ";
            }
            for (int j = 0; j < 7; j++) {
                if (j != 0) {
                    temp += ",";
                }
                temp += (b.getPrevCell(i, j, false));
            }
        }
        gameState.add(temp);
        gameState.add(String.valueOf(b.getCurrentPlayer()));
        gameState.add(String.valueOf(b.getGameOver()));
        gameState.add(String.valueOf(b.getSetupMode()));
        gameState.add(String.valueOf(ocean.getTurn()));
        Collection<Integer> healths = b.getAllHealth(true).values();
        if (healths.isEmpty()) {
            gameState.add("null");
        } else {
            temp = "";
            for (int v : healths) {
                temp += v;
            }
            gameState.add(temp);
        }
        healths = b.getAllHealth(false).values();
        if (healths.isEmpty()) {
            gameState.add("null");
        } else {
            temp = "";
            for (int v : healths) {
                temp += v;
            }
            gameState.add(temp);
        }
        return gameState;
    }

    public void loadGameState() {
        BufferedReader br = FileLineIterator.fileToReader("files/GameState.txt");
        FileLineIterator iterator = new FileLineIterator(br);
        String temp = "";
        temp = iterator.next();
        String[] r = temp.split(" ");
        for (int i = 0; i < 7; i++) {
            String[] c = r[i].split(",");
            for (int j = 0; j < 7; j++) {
                b.setOceanCell(i, j, Integer.valueOf(c[j]), true);
            }
        }
        temp = iterator.next();
        r = temp.split(" ");
        for (int i = 0; i < 7; i++) {
            String[] c = r[i].split(",");
            for (int j = 0; j < 7; j++) {
                b.setOceanCell(i, j, Integer.valueOf(c[j]), false);
            }
        }
        temp = iterator.next();
        r = temp.split(" ");
        for (int i = 0; i < 7; i++) {
            String[] c = r[i].split(",");
            for (int j = 0; j < 7; j++) {
                b.setTargetCell(i, j, Integer.valueOf(c[j]), true);
            }
        }
        temp = iterator.next();
        r = temp.split(" ");
        for (int i = 0; i < 7; i++) {
            String[] c = r[i].split(",");
            for (int j = 0; j < 7; j++) {
                b.setTargetCell(i, j, Integer.valueOf(c[j]), false);
            }
        }
        temp = iterator.next();
        b.setNumSetup(Integer.valueOf(temp), true);
        temp = iterator.next();
        b.setNumSetup(Integer.valueOf(temp), false);
        temp = iterator.next();
        b.setCurrR(Integer.valueOf(temp), true);
        temp = iterator.next();
        b.setCurrR(Integer.valueOf(temp), false);
        temp = iterator.next();
        b.setCurrC(Integer.valueOf(temp), true);
        temp = iterator.next();
        b.setCurrC(Integer.valueOf(temp), false);
        temp = iterator.next();
        LinkedList<int[][]> oceanHist = new LinkedList<>();
        if (!temp.equals("null")) {
            r = temp.split(" ");
            for (int i = 0; i < (r.length / 7); i++) {
                int[][] past = new int[7][7];
                int startRow = i * 7;
                for (int j = startRow; j < startRow + 7; j++) {
                    String[] c = r[j].split(",");
                    for (int x = 0; x < 7; x++) {
                        past[j - startRow][x] = Integer.valueOf(c[x]);
                    }
                }
                oceanHist.add(past);
            }
        }
        b.setOceanHist(oceanHist, true);
        temp = iterator.next();
        oceanHist = new LinkedList<>();
        if (!temp.equals("null")) {
            r = temp.split(" ");
            for (int i = 0; i < (r.length / 7); i++) {
                int[][] past = new int[7][7];
                int startRow = i * 7;
                for (int j = startRow; j < startRow + 7; j++) {
                    String[] c = r[j].split(",");
                    for (int x = 0; x < 7; x++) {
                        past[j - startRow][x] = Integer.valueOf(c[x]);
                    }
                }
                oceanHist.add(past);
            }
        }
        b.setOceanHist(oceanHist, false);
        temp = iterator.next();
        r = temp.split(" ");
        for (int i = 0; i < 7; i++) {
            String[] c = r[i].split(",");
            for (int j = 0; j < 7; j++) {
                b.setPrevCell(i, j, Integer.valueOf(c[j]), true);
            }
        }
        temp = iterator.next();
        r = temp.split(" ");
        for (int i = 0; i < 7; i++) {
            String[] c = r[i].split(",");
            for (int j = 0; j < 7; j++) {
                b.setPrevCell(i, j, Integer.valueOf(c[j]), false);
            }
        }
        temp = iterator.next();
        b.setCurrentPlayer(Boolean.valueOf(temp));
        temp = iterator.next();
        b.setGameOver(Boolean.valueOf(temp));
        temp = iterator.next();
        b.setSetUpMode(Boolean.valueOf(temp));
        temp = iterator.next();
        ocean.setTurn(Boolean.valueOf(temp));
        target.setTurn(Boolean.valueOf(temp));
        ocean.setStop(false);
        ocean.setStop(false);
        temp = iterator.next();
        TreeMap newHealth = new TreeMap<>();
        if (!temp.equals("null")) {
            for (int i = 0; i < temp.length(); i++) {
                newHealth.put(i + 1, Integer.parseInt(temp.substring(i, i + 1)));
            }
        }
        b.setAllHealth(newHealth, true);
        temp = iterator.next();
        newHealth = new TreeMap<>();
        if (!temp.equals("null")) {
            for (int i = 0; i < temp.length(); i++) {
                newHealth.put(i + 1, Integer.parseInt(temp.substring(i, i + 1)));
            }
        }
        b.setAllHealth(newHealth, false);
        updateStatus();
        repaint();
    }

    /**
     * Updates the JLabel to reflect the current state of the game.
     */
    public void updateStatus() {
        if (b.getGameOver()) {
            status.setText("Game Over!");
        } else if (ocean.getTurn()) {
            status.setText("Player 1's Turn");
        } else {
            status.setText("Player 2's Turn");
        }
        if (ocean.getTurn() != b.getCurrentPlayer()) {
            if (lState.getText().contains("boxes")) {
                lState.setText(
                        "Your Board: " +
                    "Your ships are all setup. Click in the middle of the two boards to proceed."
                );
            }
        } else if (b.getCurrentSetup(ocean.getTurn()) > 0) {
            lState.setText(
                    "Your Board: " +
                            "Click the starting and ending points to place your ship that occupies "
                            +
                            b.getCurrentSetup(ocean.getTurn()) + " boxes."
            );
        } else {
            lState.setText(
                    "Your Board: " +
                            "You have " + b.getShipsLeft(ocean.getTurn()) + " ships left."
            );
        }
        if (b.getGameOver()) {
            String player = "Player 2";
            if (b.getCurrentPlayer()) {
                player = "Player 1";
            }
            rState.setText("Target Board: " + player + " wins!");
        } else if (!lState.getText().contains("left")) {
            rState.setText("Target Board");
        } else if (target.getTurn() == b.getCurrentPlayer()) {
            rState.setText("Target Board: " + "Click on a white box to fire a missile there.");
        } else {
            if (target.getShotResult() == 0) {
                rState.setText(
                        "Target Board: "
                                + "Shot missed. Click in the middle of the two boards to proceed."
                );
            } else if (target.getShotResult() == -1) {
                rState.setText(
                        "Target Board: "
                        + "Shot already taken. Click another box to try a different location."
                );
            } else if (target.getShotResult() == 1) {
                rState.setText(
                        "Target Board: "
                                + "Shot hit. Click in the middle of the two boards to proceed."
                );
            } else if (target.getShotResult() == 2) {
                rState.setText(
                        "Target Board: "
                                + "Ship sunk. Click in the middle of the two boards to proceed."
                );
            } else if (target.getShotResult() == 3) {
                String player = "Player 2";
                if (b.getCurrentPlayer()) {
                    player = "Player 1";
                }
                rState.setText("Target Board: " + player + " wins!");
            } else {
                rState.setText("Target Board");
            }
        }
    }
}
