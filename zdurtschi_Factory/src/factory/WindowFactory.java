package factory;

import decorations.BorderedWindow;
import decorations.TitledWindow;
import edu.neumont.csc415.Point;

public class WindowFactory {
	
	public Window getTextWindow(HardwareController controller, Point topLeftCorner, Point bottomRightCorner){
		Window window = new TextWindow(controller, topLeftCorner, bottomRightCorner);
		return window;
	}
	
	public Window getTitledTextWindow(HardwareController controller, Point topLeftCorner, Point bottomRightCorner){
		Window window = new TextWindow(controller, topLeftCorner, bottomRightCorner);
		Window titledWindow = new TitledWindow(window);
		return titledWindow;
	}
	
	public Window getBorderedTextWindow(HardwareController controller, Point topLeftCorner, Point bottomRightCorner){
		Window window = new TextWindow(controller, topLeftCorner, bottomRightCorner);
		Window borderedWindow = new BorderedWindow(window);
		return borderedWindow;
	}
	
	public Window getBorderedTitledTextWindow(HardwareController controller, Point topLeftCorner, Point bottomRightCorner){
		Window window = new TextWindow(controller, topLeftCorner, bottomRightCorner);
		Window titledWindow = new TitledWindow(window);
		Window borderedTitledWindow = new BorderedWindow(titledWindow);
		return borderedTitledWindow;
	}
	
	public Window getTitledBorderedTextWindow(HardwareController controller, Point topLeftCorner, Point bottomRightCorner){
		Window window = new TextWindow(controller, topLeftCorner, bottomRightCorner);
		Window borderedWindow = new BorderedWindow(window);
		Window titledBorderedWindow = new TitledWindow(borderedWindow);
		return titledBorderedWindow;
	}
}