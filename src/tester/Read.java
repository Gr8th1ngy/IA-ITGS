package tester;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read {
private String filePath;
private File script;
private Scanner in;
private String fileContent;

public void setFilePath(String filePath) throws FileNotFoundException {
	this.filePath = filePath;
	script = new File(filePath);
	in = new Scanner(script);
}
public void readScript(){
	
	fileContent = in.next();
}
public String getFileContent() {
	return fileContent;
}
}
