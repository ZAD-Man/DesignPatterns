package factory;

import decorations.BorderedWindow;
import decorations.TitledWindow;
import edu.neumont.csc415.Point;

public class WindowFactory {
	
	public IWindow getTextWindow(IController controller, Point topLeftCorner, Point bottomRightCorner){
		IWindow window = new TextWindow(controller, topLeftCorner, bottomRightCorner);
		return window;
	}
	
	public IWindow getTitledTextWindow(IController controller, Point topLeftCorner, Point bottomRightCorner){
		IWindow window = new TextWindow(controller, topLeftCorner, bottomRightCorner);
		IWindow titledWindow = new TitledWindow(window);
		return titledWindow;
	}
	
	public IWindow getBorderedTextWindow(IController controller, Point topLeftCorner, Point bottomRightCorner){
		IWindow window = new TextWindow(controller, topLeftCorner, bottomRightCorner);
		IWindow borderedWindow = new BorderedWindow(window);
		return borderedWindow;
	}
	
	public IWindow getBorderedTitledTextWindow(IController controller, Point topLeftCorner, Point bottomRightCorner){
		IWindow window = new TextWindow(controller, topLeftCorner, bottomRightCorner);
		IWindow titledWindow = new TitledWindow(window);
		IWindow borderedTitledWindow = new BorderedWindow(titledWindow);
		return borderedTitledWindow;
	}
	
	public IWindow getTitledBorderedTextWindow(IController controller, Point topLeftCorner, Point bottomRightCorner){
		IWindow window = new TextWindow(controller, topLeftCorner, bottomRightCorner);
		IWindow borderedWindow = new BorderedWindow(window);
		IWindow titledBorderedWindow = new TitledWindow(borderedWindow);
		return titledBorderedWindow;
	}
}