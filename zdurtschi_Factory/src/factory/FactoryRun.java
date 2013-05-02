package factory;

import edu.neumont.csc415.Desktop;
import edu.neumont.csc415.Point;

public class FactoryRun {

	public static void main(String[] args) {
		Desktop desktop = new Desktop(1900, 1000);
		HardwareController controller = new HardwareController(desktop);
		
		WindowFactory windowFactory = new WindowFactory();

		Window window = windowFactory.getTextWindow(controller, new Point(42, 42), new Point(200, 108));
		Window titledWindow = windowFactory.getTitledTextWindow(controller, new Point(42, 200), new Point(200, 400));
		Window borderedWindow = windowFactory.getBorderedTextWindow(controller, new Point(42, 500), new Point(200, 600));
		Window titledBorderedWindow = windowFactory.getTitledBorderedTextWindow(controller, new Point(300, 108), new Point(815, 420));
		Window borderedTitledWindow = windowFactory.getBorderedTitledTextWindow(controller, new Point(300, 540), new Point(815, 720));
		
		desktop.registerPaintable(window);
		desktop.registerPaintable(titledWindow);
		desktop.registerPaintable(borderedWindow);
		desktop.registerPaintable(borderedTitledWindow);
		desktop.registerPaintable(titledBorderedWindow);
		controller.run();
	}
}
