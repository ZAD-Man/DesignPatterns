package factory;

public interface IController extends ISubject{
	public int getDesktopKeyCode();

	public int getDesktopCharHeight();

	public int getDesktopCharWidth(char ch);
}
