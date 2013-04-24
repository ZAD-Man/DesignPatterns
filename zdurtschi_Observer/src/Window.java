import edu.neumont.csc415.*;
import java.util.ArrayList;
import java.util.List;

public class Window implements IPaintable, IObserver {
	private List<Character> outputChars = new ArrayList<Character>();

	private Controller controller;

	public Window(Controller controller) {
		this.controller = controller;
		this.controller.registerObserver(this);
	}

	public void addOutputChar(char outputChar) {
		outputChars.add(outputChar);
	}

	@Override
	public void paint(DesktopGraphics arg0) {
		Point firstPoint = new Point(100, 100);
		Point secondPoint = new Point(600, 300);
		arg0.fillRectangle(firstPoint, secondPoint, DesktopColor.GREEN);

		int XOffset = 0;
		int YOffset = controller.getDesktopCharHeight();
		for (char c : outputChars) {
			int charX = firstPoint.getX() + XOffset;
			int charY = firstPoint.getY() + YOffset;
			int charWidth = controller.getDesktopCharWidth(c);

			arg0.drawChar(c, new Point(charX, charY), DesktopColor.BLACK);

			if (XOffset + 2 * charWidth >= secondPoint.getX() - firstPoint.getX()) {
				XOffset = 0;
				YOffset += controller.getDesktopCharHeight();
			} else {
				XOffset += charWidth;
			}

			if (YOffset >= secondPoint.getY() - firstPoint.getY()) {
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
