package decorations;

import decorator.Window;
import edu.neumont.csc415.DesktopColor;
import edu.neumont.csc415.DesktopGraphics;
import edu.neumont.csc415.Point;

public class TitledWindow extends Window {
	Window window;
	
	private static final int TITLE_WIDTH = 23;
	
	public TitledWindow(Window window){
		this.window = window;
		topLeftPoint = new Point(window.topLeftPoint.getX(), window.topLeftPoint.getY() - TITLE_WIDTH);
		bottomRightPoint = window.bottomRightPoint;
	}
	
	@Override
	public void paint(DesktopGraphics arg0) {
		Point topLeftTitlePoint = new Point(window.topLeftPoint.getX(), window.topLeftPoint.getY() - TITLE_WIDTH);
		Point bottomRightTitlePoint = new Point(window.bottomRightPoint.getX(), window.topLeftPoint.getY());
		arg0.fillRectangle(topLeftTitlePoint, bottomRightTitlePoint, DesktopColor.YELLOW);
		window.paint(arg0);

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
