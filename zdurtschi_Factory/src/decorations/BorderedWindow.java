package decorations;

import edu.neumont.csc415.DesktopColor;
import edu.neumont.csc415.DesktopGraphics;
import edu.neumont.csc415.Point;
import factory.Window;

public class BorderedWindow extends Window {
	Window window;
	
	private static final int BORDER_WIDTH = 4;
	
	public BorderedWindow(Window window){
		this.window = window;
		topLeftPoint = new Point(window.topLeftPoint.getX() - BORDER_WIDTH, window.topLeftPoint.getY() - BORDER_WIDTH);
		bottomRightPoint = new Point(window.bottomRightPoint.getX() + BORDER_WIDTH, window.bottomRightPoint.getY() + BORDER_WIDTH);
	}
	
	@Override
	public void paint(DesktopGraphics arg0) {
		Point topLeftBorderPoint = topLeftPoint;
		Point bottomRightBorderPoint = bottomRightPoint;
		arg0.fillRectangle(topLeftBorderPoint, bottomRightBorderPoint, DesktopColor.BLUE);
		window.paint(arg0);

	}
}
