package factory;

import edu.neumont.csc415.IPaintable;
import edu.neumont.csc415.Point;

public interface IWindow extends IPaintable {
	public Point getTopLeftPoint();
	public Point getBottomRightPoint();

}
