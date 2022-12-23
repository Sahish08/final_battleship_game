package org.cis1200.battleship;

import java.awt.*;
import javax.swing.*;

public class RunBattleship implements Runnable {
    public void run() {
        final JFrame frame = new JFrame("Battleship");
        frame.setLocation(0, 0);

        // Status panel
        final JPanel status_panel = new JPanel();
        status_panel.setLayout(new BoxLayout(status_panel, BoxLayout.Y_AXIS));

        final JLabel status = new JLabel("Player 1's Turn");
        status_panel.add(status);
        final JLabel lState = new JLabel(
                "Your Board: " +
                        "Click the starting and ending points to place " +
                        "your ship that occupies 5 boxes."
        );
        status_panel.add(lState);
        final JLabel rState = new JLabel("Target Board");
        status_panel.add(rState);

        frame.add(status_panel, BorderLayout.SOUTH);

        // Game board
        final PlayerBoard board = new PlayerBoard(status, lState, rState);
        frame.add(board, BorderLayout.CENTER);

        // Reset button
        final JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.NORTH);

        final JButton reset = new JButton("Reset");
        reset.addActionListener(e -> board.reset());
        control_panel.add(reset);

        final JButton undo = new JButton("Undo");
        undo.addActionListener(e -> board.undo());
        control_panel.add(undo);

        final JButton save = new JButton("Save");
        save.addActionListener(e -> board.writeInfoToFile("files/GameState.txt"));
        control_panel.add(save);

        final JButton load = new JButton("Load");
        load.addActionListener(e -> board.loadGameState());
        control_panel.add(load);

        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        String instructions = "Welcome to Battleship!\nThis is a two-player game that consists of" +
                " two phases.\nIn the first phase, each player " +
                "will place down each of their five ships on the 7 by 7 board "
                + "by selecting the starting and ending positions for " +
                "each ship on the left hand side board.\nThe ships "
                + "cannot be diagonal and cannot overlap.\nEach player " +
                "has one five length ship, one four length, two "
                + "three lengths, and one two length ship.\n" +
                "After both players place down their ships, they " +
                "will then take alternating turns guessing spots "
                + "where their opponents' ships may be using the right " +
                "hand side board.\nIf a shot turns red, then the "
                + "shot missed. If the shot turns green, then the " +
                "shot hit.\nThe player to first sink all "
                + "of their opponents' ships wins.\nClick " +
                "reset at any point to restart the game.\nClick undo while "
                + "placing down ships to undo your last placement. You can " +
                "no longer undo placements after your last "
                + "ship is placed.\nClick save to pause and " +
                "save your game state.\n" + "Click load to load " +
                "your last saved game state.\nClick ok to play.";

        JOptionPane.showMessageDialog(frame, instructions);
    }
}