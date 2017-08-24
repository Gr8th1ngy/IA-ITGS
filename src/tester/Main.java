package tester;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
	private boolean alreadyExecuted =false;

	public GUI() {
		test = new Test();
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	private void createComponents() {

		terminateButton = new JButton("Terminate");
		
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
		filePath = new JTextArea(3,40);
	}

	private void createTestButton() {
		testButton = new JButton("Start testing");
		listener = new TestListener();
		testButton.addActionListener(listener);
	}

	class TestListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			if (!alreadyExecuted) {
			read = new Read();
			try {
				read.setFilePath(filePath.getText());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			alreadyExecuted=true;
			}
			read.readScript();
			textArea.append(read.getFileContent()+" ");
			/*textArea.append(test.getCaseNo() + "\t\t");

			if (test.next() == true) {
				textArea.append("Passed\n");
			} else {
				textArea.append("Failed\n");
			}
			test.setCaseNo("2");
			test.setResult(false);*/

		}
	}
}