package factory;

import decorations.BorderedWindow;
import decorations.TitledWindow;
import edu.neumont.csc415.Point;

public class WindowFactory {
	
	public IWindow getTextWindow(HardwareController controller, Point topLeftCorner, Point bottomRightCorner){
		IWindow window = new TextWindow(controller, topLeftCorner, bottomRightCorner);
		return window;
	}
	
	public IWindow getTitledTextWindow(HardwareController controller, Point topLeftCorner, Point bottomRightCorner){
		IWindow window = new TextWindow(controller, topLeftCorner, bottomRightCorner);
		IWindow titledWindow = new TitledWindow(window);
		return titledWindow;
	}
	
	public IWindow getBorderedTextWindow(HardwareController controller, Point topLeftCorner, Point bottomRightCorner){
		IWindow window = new TextWindow(controller, topLeftCorner, bottomRightCorner);
		IWindow borderedWindow = new BorderedWindow(window);
		return borderedWindow;
	}
	
	public IWindow getBorderedTitledTextWindow(HardwareController controller, Point topLeftCorner, Point bottomRightCorner){
		IWindow window = new TextWindow(controller, topLeftCorner, bottomRightCorner);
		IWindow titledWindow = new TitledWindow(window);
		IWindow borderedTitledWindow = new BorderedWindow(titledWindow);
		return borderedTitledWindow;
	}
	
	public IWindow getTitledBorderedTextWindow(HardwareController controller, Point topLeftCorner, Point bottomRightCorner){
		IWindow window = new TextWindow(controller, topLeftCorner, bottomRightCorner);
		IWindow borderedWindow = new BorderedWindow(window);
		IWindow titledBorderedWindow = new TitledWindow(borderedWindow);
		return titledBorderedWindow;
	}
}