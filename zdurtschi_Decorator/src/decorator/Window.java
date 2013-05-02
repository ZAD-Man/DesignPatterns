package decorator;

import edu.neumont.csc415.IPaintable;
import edu.neumont.csc415.Point;

public abstract class Window implements IPaintable, IObserver {
	public Point topLeftPoint;
	public Point bottomRightPoint;

}
