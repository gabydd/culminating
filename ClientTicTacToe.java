import javax.swing.*;

import java.awt.*;

public class ClientTicTacToe extends JFrame {
    public static void main(String[] args) {
        String address = Utils.initialNetworkConnection();
        System.out.println(address);
        JFrame mainWindow = new JFrame();
        mainWindow.setTitle("title");
        mainWindow.setResizable(false);
        mainWindow.setLocation(Globals.FRAME_X, Globals.FRAME_Y);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel tttPanel = new JPanel();
        tttPanel.setLayout(new GridLayout(Globals.ROWS, Globals.COLS));
        for (int i = 0; i < Globals.ROWS; i++) {

            for (int j = 0; j < Globals.COLS; j++) {
                Globals.grid[i][j] = new GridPanel(new Color(60, 30, 170), i, j);
                tttPanel.add(Globals.grid[i][j]);
            }
        }
        GridBagConstraints constrains = new GridBagConstraints();
        GridBagLayout bagLayout = new GridBagLayout();
        mainWindow.getContentPane().setLayout(bagLayout);
        constrains.gridx = 0;
        constrains.gridy = Globals.ROWS;
        constrains.anchor = GridBagConstraints.LINE_START;
        Globals.status.setFont(new Font("Iosevka", Font.BOLD, 18));
        mainWindow.getContentPane().add(Globals.status, constrains);

        mainWindow.getContentPane().add(tttPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }
}
