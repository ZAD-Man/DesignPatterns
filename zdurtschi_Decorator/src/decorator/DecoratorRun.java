package decorator;

import decorations.BorderedWindow;
import decorations.TitledWindow;
import edu.neumont.csc415.Desktop;
import edu.neumont.csc415.Point;

public class DecoratorRun {

	public static void main(String[] args) {
		Desktop desktop = new Desktop(1900, 1000);
		Controller controller = new Controller(desktop);

		Window window = new TextWindow(controller, new Point(100, 100),	new Point(400, 500));
		Window titledWindow = new TitledWindow(window);
		Window borderedTitledWindow = new BorderedWindow(titledWindow);
		Window titledBorderedTitledWindow = new TitledWindow(borderedTitledWindow);
		
//		desktop.registerPaintable(window);
//		desktop.registerPaintable(titledWindow);
//		desktop.registerPaintable(borderedTitledWindow);
		desktop.registerPaintable(titledBorderedTitledWindow);
		controller.run();
	}
}
