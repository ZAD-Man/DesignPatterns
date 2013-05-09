package commands;

import command.WindowModel;

public class DeleteCommand implements ICommand {

	private WindowModel model;
	private int position;
	private char removedChar;

	public DeleteCommand(WindowModel model, int position) {
		this.model = model;
		this.position = position;
	}

	@Override
	public void execute() {
		removedChar = model.removeCharacterAtPosition(position);
	}

	@Override
	public void undo() {
		model.insertCharacterAtPosition(removedChar, position);
	}
}
