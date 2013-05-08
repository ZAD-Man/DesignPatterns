package mvc;

import java.util.ArrayList;
import java.util.List;

import edu.neumont.csc415.Desktop;
import edu.neumont.csc415.Point;

public class HardwareView implements IView {

	private Desktop desktop;
	
	private WindowModel model;
	
	private List<IWindow> windows = new ArrayList<IWindow>();
	
	private List<IObserver> observers = new ArrayList<IObserver>();

	private int desktopKeyCode;

	public HardwareView(Desktop desktop, WindowModel model) {
		this.desktop = desktop;
		this.model = model;
	}

	public int getDesktopKeyCode() {
		return desktopKeyCode;
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
	public void repaintDesktop(){
		desktop.repaint();
	}

	@Override
	public void run() {
		while (true) {
			if (desktop.hasKeysQueued()) {
				desktopKeyCode = desktop.getKeyCode();
				notifyObservers();
			}
		}
	}

	@Override
	public void createWindow(Point topLeftPoint, Point bottomRightPoint) {
		WindowFactory factory = new WindowFactory();
		IWindow newWindow = factory.getTitledBorderedTextWindow(this, topLeftPoint, bottomRightPoint);
		desktop.registerPaintable(newWindow);
		windows.add(newWindow);
	}

	@Override
	public void update() {
		for (IWindow window : windows) {
			window.updateText(model);
		}
		repaintDesktop();
	}
}