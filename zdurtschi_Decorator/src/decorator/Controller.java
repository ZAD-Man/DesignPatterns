package decorator;
import java.util.ArrayList;
import java.util.List;

import edu.neumont.csc415.Desktop;

public class Controller implements ISubject, Runnable {

	private Desktop desktop;

	private List<IObserver> observers = new ArrayList<IObserver>();

	public Controller(Desktop desktop) {
		this.desktop = desktop;
	}

	public int getDesktopKeyCode() {
		return desktop.getKeyCode();
	}

	public int getDesktopCharHeight() {
		return desktop.getCharHeight();
	}

	public int getDesktopCharWidth(char ch) {
		return desktop.getCharWidth(ch);
	}

	@Override
	public void registerObserver(IObserver observer) {
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	@Override
	public void unregisterObserver(IObserver observer) {
		if (observers.contains(observer)) {
			observers.remove(observer);
		}
	}

	@Override
	public void notifyObservers() {
		for (IObserver observer : observers) {
			observer.update();
		}
	}

	@Override
	public void run() {
		while (true) {
			if (desktop.hasKeysQueued()) {
				notifyObservers();
				desktop.repaint();
			}
		}
	}
}
