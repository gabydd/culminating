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
			if (Globals.currentPlayer == Globals.iAmPlayer && !Globals.gameOver && val == Globals.NO_PLAYER) {
			    int errorCode = Utils.clientRequest(Globals.REQUEST_TO_PROCESS_PLAY, row, col, "");
			    if (errorCode == Globals.NET_OK) {
				setVal(Globals.iAmPlayer);
				drawXorO();
				String request = NetIO.receiveRequest();
				NodeInfo commandFromServer = new NodeInfo(request);
				int row = Integer.parseInt(commandFromServer.getRowColPlayer().substring(0, 1));
				int col = Integer.parseInt(commandFromServer.getRowColPlayer().substring(1, 2));                                
				Globals.grid[row][col].setVal(1 - Globals.iAmPlayer);  
			    }
			}
		}
	}
}
