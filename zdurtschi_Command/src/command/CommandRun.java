package command;

import edu.neumont.csc415.Desktop;
import edu.neumont.csc415.Point;

public class CommandRun {

	public static void main(String[] args) {
		Desktop desktop = new Desktop(1900, 1000);
		SettingsFileIO settingsIO = new SettingsFileIO();
		WindowModel model = new WindowModel();
		IView view;

		if (settingsIO.CheckUseDebugController()) {
			view = new ArtificialView(desktop, model);
		} else {
			view = new HardwareView(desktop, model);
		}

		Controller controller = new Controller(view, model);

		view.registerObserver(controller);
		model.registerObserver(view);

		view.createWindow(new Point(300, 108), new Point(815, 420));

		view.run();
	}
}
