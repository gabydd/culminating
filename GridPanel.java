import javax.swing.*;

import java.awt.*;

public class GridPanel extends JPanel {
	private int row;
	private int col;
	private int val = Globals.NO_PLAYER;

    public GridPanel(Color color, int row, int col) {
		super();
		this.row = row;
		this.col = col;
		this.setBackground(color);
		this.setPreferredSize(new Dimension(Globals.COL_WIDTH, Globals.ROW_WIDTH));
		this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	}
}
