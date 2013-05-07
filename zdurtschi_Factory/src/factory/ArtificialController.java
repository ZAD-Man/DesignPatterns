package factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.neumont.csc415.Desktop;

public class ArtificialController implements IController {

	private Desktop desktop;
	
	private List<IObserver> observers = new ArrayList<IObserver>();
	
	private static Random random = new Random();

	private static final int MIN_CHARACTER_VALUE = 32;
	private static final int MAX_CHARACTER_VALUE = 126;
	private static final int CHARACTER_HEIGHT = 25;
	private static final int CHARACTER_WIDTH = 11;
	
	public ArtificialController(Desktop desktop){
		this.desktop = desktop;
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
	public int getDesktopKeyCode() {
		return random.nextInt(MAX_CHARACTER_VALUE - MIN_CHARACTER_VALUE) + MIN_CHARACTER_VALUE;
	}

	@Override
	public int getDesktopCharHeight() {
		return CHARACTER_HEIGHT;
	}

	@Override
	public int getDesktopCharWidth(char ch) {
		return CHARACTER_WIDTH;
	}
	
	@Override
	public void repaintDesktop(){
		desktop.repaint();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(42);
				notifyObservers();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
