package observer;

import edu.neumont.csc415.*;

import java.util.ArrayList;
import java.util.List;

public class Window implements IPaintable, IObserver {
	private List<Character> outputChars = new ArrayList<Character>();
	
	Point topLeftPoint;
	Point bottomRightPoint;

	private Controller controller;

	public Window(Controller controller, Point topLeftPoint, Point bottomRightPoint) {
		this.controller = controller;
		this.controller.registerObserver(this);
		this.topLeftPoint = topLeftPoint;
		this.bottomRightPoint = bottomRightPoint;
	}

	public void addOutputChar(char outputChar) {
		outputChars.add(outputChar);
	}

	@Override
	public void paint(DesktopGraphics arg0) {
		
		arg0.fillRectangle(topLeftPoint, bottomRightPoint, DesktopColor.GREEN);

		int XOffset = 0;
		int YOffset = controller.getDesktopCharHeight();
		for (char c : outputChars) {
			int charX = topLeftPoint.getX() + XOffset;
			int charY = topLeftPoint.getY() + YOffset;
			int charWidth = controller.getDesktopCharWidth(c);

			arg0.drawChar(c, new Point(charX, charY), DesktopColor.BLACK);

			if (XOffset + 2 * charWidth >= bottomRightPoint.getX()
					- topLeftPoint.getX()) {
				XOffset = 0;
				YOffset += controller.getDesktopCharHeight();
			} else {
				XOffset += charWidth;
			}

			if (YOffset >= bottomRightPoint.getY() - topLeftPoint.getY()) {
				XOffset = 0;
				YOffset = controller.getDesktopCharHeight();
			}
		}
	}

	@Override
	public void update() {
		char newChar = (char) controller.getDesktopKeyCode();
		addOutputChar(newChar);

	}
}
