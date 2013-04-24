import edu.neumont.csc415.Desktop;

public class ObserverRun {

	public static void main(String[] args) {
		Desktop desktop = new Desktop(1900, 1000);
		Controller controller = new Controller(desktop);

		Window window = new Window(controller);
		desktop.registerPaintable(window);
		controller.run();
	}
}
