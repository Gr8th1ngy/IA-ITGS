package tester;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Read {
	private String filePath;
	private Scanner in;
	private String pathFragment;
	private String fileContent;
	private String out;

	public Read() {
	}

	public void setFilePath(String filePath) throws FileNotFoundException {
		this.filePath = filePath;
		pathFragment = filePath;
		for (int i = 0; i < 3; i++) {
			pathFragment = pathFragment.substring(pathFragment.indexOf("\\") + 1, pathFragment.length());
		}
	}

	public void readScript() {

		fileContent = in.next();
	}

	public String getFileContent() {
		return fileContent;
	}

	public String getFilePath() {
		if (pathFragment.contains("\\") == true) {
			out = pathFragment.substring(0, pathFragment.indexOf("\\"));
			pathFragment = pathFragment.substring(pathFragment.indexOf("\\") + 1, pathFragment.length());
		} else {
		out = pathFragment;
		pathFragment = "done";
		}
		return out;
	}

	public String getPathFragment() {
		return pathFragment;
	}
}
