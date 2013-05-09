package command;

import commands.DeleteCommand;
import commands.InsertCommand;

public class Controller implements IObserver {

	private static final int LEFT_ARROW_CODE = 17;
	private static final int UP_ARROW_CODE = 38;
	private static final int RIGHT_ARROW_CODE = 19;
	private static final int DOWN_ARROW_CODE = 40;
	private static final int BACKSPACE_CODE = 8;
	private static final int DELETE_CODE = 127;
	private static final int PLUS_CODE = 43;
	private static final int MINUS_CODE = 45;

	private IView view;
	private WindowModel model;

	private CommandInvoker invoker = new CommandInvoker();

	public Controller(IView view, WindowModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void update() {
		int keyCode = view.getDesktopKeyCode();
		System.out.println(keyCode);
		switch (keyCode) {
		case LEFT_ARROW_CODE:
			model.moveCursorLeft();
			break;
		case RIGHT_ARROW_CODE:
			model.moveCursorRight();
			break;
		case BACKSPACE_CODE:
			DeleteCommand backspaceCommand = model.makeBackspaceCommand();
			if (backspaceCommand != null) {
				invoker.setCommand(backspaceCommand);
				invoker.invoke();
			}
			break;
		case DELETE_CODE:
			DeleteCommand deleteCommand = model.makeDeleteCommand();
			if (deleteCommand != null) {
				invoker.setCommand(deleteCommand);
				invoker.invoke();
			}
			break;
		case MINUS_CODE:
			invoker.devoke();
			break;
		case PLUS_CODE:
			invoker.reinvoke();
			break;
		default:
			InsertCommand insertCommand = model.makeInsertCommand((char) keyCode);
			invoker.setCommand(insertCommand);
			invoker.invoke();
			break;
		}

	}
}
