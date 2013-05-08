package iterator;

public class Controller implements IObserver {

	private static final int LEFT_ARROW_CODE = 17;
	private static final int UP_ARROW_CODE = 38;
	private static final int RIGHT_ARROW_CODE = 19;
	private static final int DOWN_ARROW_CODE = 40;
	private static final int BACKSPACE_CODE = 8;
	private static final int DELETE_CODE = 127;

	private IView view;
	private WindowModel model;

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
			model.backspace();
			break;
		case DELETE_CODE:
			model.delete();
			break;
		default:
			model.insertCharacter((char) keyCode);
			break;
		}

	}
}
