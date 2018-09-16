package tester;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new GUI();
		frame.setTitle("Testing screen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class GUI extends JFrame {
	private JButton testButton;
	private JButton terminateButton;
	private JTextArea textArea;
	private JTextArea filePath;
	private Scanner in;
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	final int ROWS = 15;
	final int COLUMNS = 30;
	private Test test;
	private Read read;
	private ActionListener listener;
	private ActionListener terminateListener;
	private boolean alreadyExecuted = false;
	private Process powerShellProcess;

	public GUI() {
		test = new Test();
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	private void createComponents() {

		
		createTerminateButton();
		createTextArea();
		createTestButton();
		JPanel panel = new JPanel();
		panel.add(filePath);
		panel.add(testButton);
		panel.add(terminateButton);
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane);
		add(panel);
	}

	private void createTextArea() {
		textArea = new JTextArea(ROWS, COLUMNS);
		filePath = new JTextArea(3, 40);
	}
private void createTerminateButton() {
	terminateButton = new JButton("Terminate");
	terminateListener = new terminateListener();
	terminateButton.addActionListener(terminateListener);
}
	private void createTestButton() {
		testButton = new JButton("Start testing");
		listener = new testListener();
		testButton.addActionListener(listener);
	}
class terminateListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	
}
	class testListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			if (!alreadyExecuted) {
				read = new Read();
				try {
					read.setFilePath(filePath.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				alreadyExecuted = true;
			}
			List<String> list = new ArrayList<String>();
			list.add("cmd");
			list.add("/c");
			list.add("start");
			list.add("powershell.exe");
			list.add("-Command");
			list.add("& C:\\Users\\Admin\\eclipse-workspace\\IA-ITGS\\target\\script.ps1");
			String[] command = list.toArray(new String[0]);

			try {
				powerShellProcess = Runtime.getRuntime().exec(command);
				textArea.setText("Testing...");
				TimeUnit.SECONDS.sleep(15);
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			textArea.setText("Test complete");
		}

		/*
		 * read.readScript(); textArea.append(read.getFileContent()+" ");
		 */
		/*
		 * textArea.append(test.getCaseNo() + "\t\t");
		 * 
		 * if (test.next() == true) { textArea.append("Passed\n"); } else {
		 * textArea.append("Failed\n"); } test.setCaseNo("2"); test.setResult(false);
		 */

	}
}
