package tester;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo {
public static void main(String[] args) throws FileNotFoundException {
	File file = new File("C:\\Users\\Admin\\Documents\\script.txt");
	Scanner in = new Scanner(file);
	for (int i = 0; i < 5; i++) {
		System.out.println(in.next());
	}
}
}
