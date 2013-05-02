package factory;

import java.util.ArrayList;
import java.util.List;

public class ArtificialController implements IController{

	private List<IObserver> observers = new ArrayList<IObserver>();
	
	private static final int CHARACTER_VALUE = 42;
	private static final int CHARACTER_HEIGHT = 5;
	private static final int CHARACTER_WIDTH = 5;
	
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
	public int getDesktopKeyCode() {
		return CHARACTER_VALUE;
	}

	@Override
	public int getDesktopCharHeight() {
		// TODO Auto-generated method stub
		return CHARACTER_HEIGHT;
	}

	@Override
	public int getDesktopCharWidth(char ch) {
		// TODO Auto-generated method stub
		return CHARACTER_WIDTH;
	}
	
}
