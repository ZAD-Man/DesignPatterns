package iterator;

import java.util.Iterator;

import edu.neumont.csc415.*;

public class TextWindow implements IWindow {
	private char[][] outputChars;

	private IView view;

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

	public TextWindow(IView view, Point topLeftPoint, Point bottomRightPoint) {
		this.view = view;
		this.topLeftPoint = topLeftPoint;
		this.bottomRightPoint = bottomRightPoint;

		int arrayHeight = (bottomRightPoint.getY() - topLeftPoint.getY()) / view.getDesktopCharHeight();
		int arrayWidth = (bottomRightPoint.getX() - topLeftPoint.getX()) / view.getDesktopCharWidth('a');
		outputChars = new char[arrayHeight][arrayWidth];		
	}

	@Override
	public void paint(DesktopGraphics arg0) {

		arg0.fillRectangle(topLeftPoint, bottomRightPoint, DesktopColor.GREEN);

		int XOffset = 0;
		int YOffset = view.getDesktopCharHeight();
		for (int i = 0; i < outputChars.length; i++) {
			for (int j = 0; j < outputChars[i].length; j++) {

				int charX = topLeftPoint.getX() + XOffset;
				int charY = topLeftPoint.getY() + YOffset;
				int charWidth = view.getDesktopCharWidth(outputChars[i][j]);

				arg0.drawChar(outputChars[i][j], new Point(charX, charY), DesktopColor.BLACK);

				XOffset += charWidth;
			}
			XOffset = 0;
			YOffset += view.getDesktopCharHeight();
		}

	}

	@Override
	public void updateText(WindowModel model) {
		outputChars = new char[outputChars.length][outputChars[0].length];
		Iterator<Character> leftStack = model.getLeftStack();
		Iterator<Character> rightStack = model.getRightStack();
		for (int i = 0; i < outputChars.length; i++) {
			for (int j = 0; j < outputChars[i].length; j++) {
				if (leftStack.hasNext()) {
					char c = leftStack.next();
					outputChars[i][j] = c;
				} else if (rightStack.hasNext()) {
					char c = rightStack.next();
					outputChars[i][j] = c;
				}
			}
		}
	}
}