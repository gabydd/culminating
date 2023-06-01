import javax.swing.*;
import java.awt.event.*;
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
		this.addMouseListener(new MoveListener());
	}

	public void setVal(int val) {
		this.val = val;
	}

	public void drawXorO() {
		Graphics2D g = (Graphics2D) getGraphics();
		g.setStroke(new BasicStroke(4));
		if (val == Globals.PLAYER_ONE) {
			g.drawLine(Globals.OFFSET, Globals.OFFSET, Globals.COL_WIDTH - Globals.OFFSET, Globals.ROW_WIDTH - Globals.OFFSET);
			g.drawLine(Globals.OFFSET, Globals.COL_WIDTH - Globals.OFFSET, Globals.ROW_WIDTH - Globals.OFFSET, Globals.OFFSET);
		} else if (val == Globals.PLAYER_TWO) {
			g.drawOval(Globals.OFFSET, Globals.OFFSET, Globals.COL_WIDTH - 2 * Globals.OFFSET, Globals.ROW_WIDTH - 2 * Globals.OFFSET);

		}
	}
	private class MoveListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			System.out.println(row + " " + col);
			setVal(1);
			drawXorO();
		}
	}
}