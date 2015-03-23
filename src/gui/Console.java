package gui;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Console {

	private static JTextArea OutputArea;
	static JFrame jf;
	private static Date date;
	public Console(){
		date = new Date();
		
		jf = new JFrame("Database assignment Console");
		final JScrollPane scrollPane = new JScrollPane();
		jf.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				scrollPane.setBounds(0, 0, (jf.getWidth()-16), (jf.getHeight()-36));
			}
		});
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jf.getContentPane().setLayout(null);
		jf.setSize(730,396);
		
		
		scrollPane.setBounds(0, 0, 714, 358);
		jf.getContentPane().add(scrollPane);
		OutputArea = new JTextArea();
		OutputArea.setLineWrap(true);
		OutputArea.setForeground(Color.WHITE);
		OutputArea.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(OutputArea);
		OutputArea.setAutoscrolls(true);
		Console.out("Welcome to the console");
		jf.setVisible(true);
	}


	/*
	 * Outputs the given string to the console using an [INFO] block
	 * for printing out errors see errorOut
	 */
	public static void out(String output){
		if (output.equals(null)){
			
		}else{
			date = Calendar.getInstance().getTime();
			OutputArea.append("[" + date + "]");
			OutputArea.append(" [INFO] ");
			OutputArea.append(output);
			OutputArea.append("\n");
		}
		
	}
	
	/*
	 * Prints out the error to the console, uses the [ERROR] block
	 * for printing out normal messages check the out method
	 */
	public static void errorOut(String error){
		date = Calendar.getInstance().getTime();
		OutputArea.append("[" + date + "]");
		OutputArea.append(" [ERROR] ");
		OutputArea.append(error);
		OutputArea.append("\n");
	}
	
	
	/*
	 * makes the console reappear when you closed it
	 */
	public static void MakeVisible(){
		if (jf.isVisible()){
			Console.errorOut("Console already visible!");
		}else{
			jf.setVisible(true);
		}
		
	}
}
