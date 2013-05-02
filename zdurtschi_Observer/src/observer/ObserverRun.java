package observer;

import edu.neumont.csc415.Desktop;
import edu.neumont.csc415.Point;

public class ObserverRun {

	public static void main(String[] args) {
		Desktop desktop = new Desktop(1900, 1000);
		Controller controller = new Controller(desktop);

		Window window = new Window(controller, new Point(100, 100),	new Point(400, 500));
		desktop.registerPaintable(window);
		controller.run();
	}
}
