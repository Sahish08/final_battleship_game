package org.cis1200.battleship;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class TargetBoard extends JPanel {

    private Battleship b; // model for the game
    private PlayerBoard ply;
    private boolean turn;
    private boolean stop;

    // Game constants
    public static final int BOARD_WIDTH = 700;
    public static final int BOARD_HEIGHT = 700;
    private int shotResult;

    /**
     * Initializes the game board.
     */
    public TargetBoard(Battleship battle, PlayerBoard board) {
        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Enable keyboard focus on the court area. When this component has the
        // keyboard focus, key events are handled by its key listener.
        setFocusable(true);

        b = battle; // initializes model for the game
        ply = board;
        turn = b.getCurrentPlayer();
        stop = false;
        shotResult = -2;
        /*
         * Listens for mouseclicks. Updates the model, then updates the game
         * board based off of the updated model.
         */
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (turn == b.getCurrentPlayer() && !b.getGameOver() && !stop) {
                    Point p = e.getPoint();

                    // updates the model given the coordinates of the mouseclick
                    shotResult = b.takeShot(p.x / 100, p.y / 100);
                    ply.updateStatus();
                    ply.repaint(); // repaints the game board
                }
            }
        });
    }

    public boolean getTurn() {
        return turn;
    }

    public void setTurn(boolean t) {
        turn = t;
        ply.repaint();
    }

    public int getShotResult() {
        return shotResult;
    }

    public void setStop(boolean v) {
        stop = v;
    }

    public boolean getStop() {
        return stop;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draws board grid
        g.drawLine(100, 0, 100, 700);
        g.drawLine(200, 0, 200, 700);
        g.drawLine(300, 0, 300, 700);
        g.drawLine(400, 0, 400, 700);
        g.drawLine(500, 0, 500, 700);
        g.drawLine(600, 0, 600, 700);
        g.drawLine(0, 100, 700, 100);
        g.drawLine(0, 200, 700, 200);
        g.drawLine(0, 300, 700, 300);
        g.drawLine(0, 400, 700, 400);
        g.drawLine(0, 500, 700, 500);
        g.drawLine(0, 600, 700, 600);

        // Draws X's and O's
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                int state = b.getTargetCell(j, i, turn);
                if (state == -1) {
                    g.setColor(Color.RED);
                    g.fillRect(100 * j, 100 * i, 100, 100);
                    g.setColor(Color.BLACK);
                    g.drawRect(100 * j, 100 * i, 100, 100);
                }
                if (state == 1) {
                    g.setColor(Color.GREEN);
                    g.fillRect(100 * j, 100 * i, 100, 100);
                    g.setColor(Color.BLACK);
                    g.drawRect(100 * j, 100 * i, 100, 100);
                }
            }
        }
    }

    /**
     * Returns the size of the game board.
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
    }
}
