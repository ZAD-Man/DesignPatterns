package iterator;

import edu.neumont.csc415.Point;

public interface IView extends ISubject, IObserver {
	public void createWindow(Point topLeftPoint, Point bottomRightPoint);
	
	public int getDesktopKeyCode();

	public int getDesktopCharHeight();

	public int getDesktopCharWidth(char ch);
	
	public void repaintDesktop();
	
	public void run();
}
