package commands;

import command.WindowModel;

public class InsertCommand implements ICommand {

	private WindowModel model;
	private int position;
	private char character;

	public InsertCommand(WindowModel model, int position, char character) {
		this.model = model;
		this.position = position;
		this.character = character;
	}

	@Override
	public void execute() {
		model.insertCharacterAtPosition(character, position);
	}

	@Override
	public void undo() {
		model.removeCharacterAtPosition(position);
	}
}
