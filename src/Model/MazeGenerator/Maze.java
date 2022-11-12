package Model.MazeGenerator;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;

public class Maze {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Water 7 Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        JButton button = new JButton("Generate");
        button.addActionListener(e -> {
            FloorGenerator floor = new FloorGenerator(10, 10);
            floor.printFloor();
        });
        panel.add(button);
        frame.add(panel, BorderLayout.SOUTH);
    }
}
