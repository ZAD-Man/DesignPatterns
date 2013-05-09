package command;

import java.util.Stack;

import commands.ICommand;

public class CommandInvoker {
	private ICommand command;
	private Stack<ICommand> commandHistory = new Stack<ICommand>();
	private Stack<ICommand> undoHistory = new Stack<ICommand>();

	public void invoke() {
		command.execute();
		commandHistory.add(command);
		undoHistory.clear();
	}

	public void devoke() {
		if (commandHistory.size() > 0) {
			ICommand undoCommand = commandHistory.pop();
			undoCommand.undo();
			undoHistory.add(undoCommand);
		}
	}

	public void reinvoke() {
		if (undoHistory.size() > 0) {
			ICommand redoCommand = undoHistory.pop();
			redoCommand.execute();
			commandHistory.add(redoCommand);
		}
	}

	public void setCommand(ICommand command) {
		this.command = command;
	}
}
