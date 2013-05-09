package command;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SettingsFileIO {

	private static final String FILE_NAME = "settings.txt";

	File file = new File(FILE_NAME);

	FileReader reader;

	public SettingsFileIO() {
		try {
			reader = new FileReader(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	public boolean CheckUseDebugController() {
		int debugSetting;
		boolean useDebug = false;
		try {
			debugSetting = reader.read();

			if (debugSetting == Character.valueOf('1')) {
				useDebug = true;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return useDebug;
	}

	// private char[] readInFile() throws IOException{
	// char[] readInFile = new char[reader.];
	// boolean go = true;
	// for (int i = 0; i < readInFile.length; i++) {
	// readInFile[i] = (char) reader.read();
	// }
	//
	// reader.reset();
	//
	// return readInFile;
	// }
}
