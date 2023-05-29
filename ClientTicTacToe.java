import javax.swing.*;

import java.awt.*;

public class ClientTicTacToe extends JFrame {
    public static void main(String[] args) {
        JFrame mainWindow = new JFrame();
        mainWindow.setTitle("not shown");
        mainWindow.setLocation(Globals.FRAME_X, Globals.FRAME_Y);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        JPanel tttPanel = new JPanel();
        GridPanel grid = new GridPanel(Color.BLACK, 0, 0);
        tttPanel.add(grid);
        mainWindow.getContentPane().add(tttPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
        // new ClientTicTacToe();
    }
    public ClientTicTacToe() {
        this.add(new GridPanel(Color.BLACK, 0, 0));
        this.show();
    }
}
