package decorations;

import iterator.IWindow;
import iterator.WindowModel;
import edu.neumont.csc415.DesktopColor;
import edu.neumont.csc415.DesktopGraphics;
import edu.neumont.csc415.Point;

public class TitledWindow implements IWindow {
	IWindow window;

	private Point topLeftPoint;
	private Point bottomRightPoint;

	private static final int TITLE_WIDTH = 23;

	@Override
	public Point getTopLeftPoint() {
		return topLeftPoint;
	}

	@Override
	public Point getBottomRightPoint() {
		return bottomRightPoint;
	}

	public TitledWindow(IWindow window) {
		this.window = window;
		topLeftPoint = new Point(window.getTopLeftPoint().getX(), window.getTopLeftPoint().getY() - TITLE_WIDTH);
		bottomRightPoint = window.getBottomRightPoint();
	}

	@Override
	public void paint(DesktopGraphics arg0) {
		Point topLeftTitlePoint = new Point(window.getTopLeftPoint().getX(), window.getTopLeftPoint().getY() - TITLE_WIDTH);
		Point bottomRightTitlePoint = new Point(window.getBottomRightPoint().getX(), window.getTopLeftPoint().getY());
		arg0.fillRectangle(topLeftTitlePoint, bottomRightTitlePoint, DesktopColor.YELLOW);
		window.paint(arg0);

	}

	@Override
	public void updateText(WindowModel model) {
		window.updateText(model);
		
	}
}