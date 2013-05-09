package command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import commands.DeleteCommand;
import commands.InsertCommand;

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

	public IIteratorZ getIterator() {
		return new ModelIterator();
	}
	
	public InsertCommand makeInsertCommand(char c){
		InsertCommand insertCommand = new InsertCommand(this, leftStack.size(), c);
		return insertCommand;
	}
	
	public DeleteCommand makeBackspaceCommand(){
		DeleteCommand backspaceCommand = null;
		if (leftStack.size() >= 1) {
			backspaceCommand = new DeleteCommand(this, leftStack.size() - 1);
		}
		return backspaceCommand;	
		
	}
	
	public DeleteCommand makeDeleteCommand(){
		DeleteCommand deleteCommand = null;
		if (rightStack.size() >= 1) {
			deleteCommand = new DeleteCommand(this, leftStack.size());
		}
		return deleteCommand;					
	}

	public void insertCharacter(char c) {
		leftStack.add(c);
		notifyObservers();
	}
	
	public void insertCharacterAtPosition(char c, int position){
		if (position <= leftStack.size()) {
			leftStack.add(position, c);
		}
		else{
			int rightPosition = rightStack.size() - (position - leftStack.size()) - 1;
			rightStack.add(rightPosition, c);
		}
		notifyObservers();
	}
	
	public char removeCharacterAtPosition(int position){
		char removedChar;
		if (position <= leftStack.size() - 1) {
			removedChar = leftStack.remove(position);
		}
		else{
			int rightPosition = rightStack.size() - (position - leftStack.size()) - 1;
			removedChar = rightStack.remove(rightPosition);
		}
		notifyObservers();
		return removedChar;
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

	public class ModelIterator implements IIteratorZ {

		private int position = 0;

		@Override
		public boolean hasNext() {
			int size = leftStack.size() + rightStack.size();
			return position < size;
		}

		@Override
		public char next() {
			char nextChar;
			if (position < leftStack.size()) {
				nextChar = leftStack.get(position);
			} else {
				int rightPosition = rightStack.size() - (position - leftStack.size()) - 1;
				nextChar = rightStack.get(rightPosition);
			}

			position++;
			return nextChar;
		}
	}
}
