package decorations;

import command.IWindow;
import command.WindowModel;

import edu.neumont.csc415.DesktopColor;
import edu.neumont.csc415.DesktopGraphics;
import edu.neumont.csc415.Point;

public class BorderedWindow implements IWindow {
	IWindow window;

	private static final int BORDER_WIDTH = 4;

	private Point topLeftPoint;
	private Point bottomRightPoint;

	@Override
	public Point getTopLeftPoint() {
		return topLeftPoint;
	}

	@Override
	public Point getBottomRightPoint() {
		return bottomRightPoint;
	}

	public BorderedWindow(IWindow window) {
		this.window = window;
		topLeftPoint = new Point(window.getTopLeftPoint().getX() - BORDER_WIDTH, window.getTopLeftPoint().getY() - BORDER_WIDTH);
		bottomRightPoint = new Point(window.getBottomRightPoint().getX() + BORDER_WIDTH, window.getBottomRightPoint().getY() + BORDER_WIDTH);
	}

	@Override
	public void paint(DesktopGraphics arg0) {
		Point topLeftBorderPoint = topLeftPoint;
		Point bottomRightBorderPoint = bottomRightPoint;
		arg0.fillRectangle(topLeftBorderPoint, bottomRightBorderPoint, DesktopColor.BLUE);
		window.paint(arg0);
	}

	@Override
	public void updateText(WindowModel model) {
		window.updateText(model);

	}
}
