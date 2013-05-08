package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WindowModel implements ISubject {
	private List<Character> leftStack = new ArrayList<Character>();
	private List<Character> rightStack = new ArrayList<Character>();

	public Iterator<Character> getLeftStack() {
		return leftStack.iterator();
	}

	public Iterator<Character> getRightStack() {

		final List<Character> rightStackIterator = new ArrayList<>(rightStack);

		Iterator<Character> iterator = new Iterator<Character>() {

			@Override
			public void remove() {
				rightStackIterator.remove(rightStackIterator.size() - 1);
			}

			@Override
			public Character next() {
				char nextChar = rightStackIterator.remove(rightStackIterator.size() - 1);
				return nextChar;
			}

			@Override
			public boolean hasNext() {
				return rightStackIterator.size() != 0;
			}
		};

		return iterator;
	}

	private List<IObserver> observers = new ArrayList<IObserver>();

	public void insertCharacter(char c) {
		leftStack.add(c);
		notifyObservers();
	}

	public void moveCursorLeft() {
		if (leftStack.size() >= 1) {
			char tempChar = leftStack.remove(leftStack.size() - 1);
			rightStack.add(tempChar);
			notifyObservers();
		}
	}

	public void moveCursorRight() {
		if (rightStack.size() >= 1) {
			char tempChar = rightStack.remove(rightStack.size() - 1);
			leftStack.add(tempChar);
			notifyObservers();
		}
	}

	public void backspace() {
		if (leftStack.size() >= 1) {
			leftStack.remove(leftStack.size() - 1);
			notifyObservers();
		}
	}

	public void delete() {
		if (rightStack.size() >= 1) {
			rightStack.remove(rightStack.size() - 1);
			notifyObservers();
		}
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
}
