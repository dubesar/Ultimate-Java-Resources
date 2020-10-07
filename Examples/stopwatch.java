// Java program to illustrate 
// digital stop watch 
// using Applets 

// importing required packages 
import java.applet.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

public class GeeksforGeeks extends Applet implements Runnable, ActionListener { 
	
// Panel to keep all the buttons and labels 
	Panel p; 
	Label display; 

	// Button 
	Button start, stop, reset; 

	// Time 
	int hour, minute, second, millisecond; 

	// string to be displayed on the label 
	String disp; 

	// State of stopwatch on/off 
	boolean on; 

	// initialization 
	public void init() 
	{ 
		// initially off 
		on = false; 

		p = new Panel(); 
		// Setting layout of the panel 
		p.setLayout(new GridLayout(4, 1, 6, 10)); 

		// initial time 00 : 00 : 00 : 000 
		hour = minute = second = millisecond = 0; 

		// Label 
		display = new Label(); 
		disp = "00 : 00 : 00 : 000"; 
		display.setText(disp); 
		p.add(display); 

		// Start button 
		start = new Button("Start"); 
		start.addActionListener((ActionListener) this); 
		p.add(start); 

		// Reset button 
		reset = new Button("Reset"); 
		reset.addActionListener((ActionListener) this); 
		p.add(reset); 

		// Stop button 
		stop = new Button("Stop"); 
		stop.addActionListener((ActionListener) this); 
		p.add(stop); 

		add(p); 

		// starting thread 
		new Thread(this, "StopWatch").start(); 
	} 

	// Reset Function 
	// reset to default value 
	public void reset() 
	{ 
		try { 
			Thread.sleep(1); 
		} 
		catch (Exception e) { 
			System.out.println(e); 
		} 
		hour = minute = second = millisecond = 0; 
	} 

	// update function 
	// update the timer 
	public void update() 
	{ 
		millisecond++; 
		if (millisecond == 1000) { 
			millisecond = 0; 
			second++; 
			if (second == 60) { 
				second = 0; 
				minute++; 
				if (minute == 60) { 
					minute = 0; 
					hour++; 
				} 
			} 
		} 
	} 

	// changing label 
	public void changeLabel() 
	{ 

		// Properly formatting the display of the timer 
		if (hour < 10) 
			disp = "0" + hour + " : "; 
		else
			disp = hour + " : "; 

		if (minute < 10) 
			disp += "0" + minute + " : "; 
		else
			disp += minute + " : "; 

		if (second < 10) 
			disp += "0" + second + " : "; 
		else
			disp += second + " : "; 

		if (millisecond < 10) 
			disp += "00" + millisecond; 
		else if (millisecond < 100) 
			disp += "0" + millisecond; 
		else
			disp += millisecond; 

		display.setText(disp); 
	} 

	// thread.run function 
	public void run() 
	{ 

		// while the stopwatch is on 
		while (on) { 
			try { 
				// pause 1 millisecond 
				Thread.sleep(1); 
				// update the time 
				update(); 
				// changeLabel 
				changeLabel(); 
			} 
			catch (InterruptedException e) { 
				System.out.println(e); 
			} 
		} 
	} 

	// actionPerformed 
	// To listen to the actions on the buttons 
	public void actionPerformed(ActionEvent e) 
	{ 

		// start a thread when start button is clicked 
		if (e.getSource() == start) { 
			// stopwatch is on 
			on = true; 
			new Thread(this, "StopWatch").start(); 
		} 

		// reset 
		if (e.getSource() == reset) { 
			// stopwatch off 
			on = false; 
			reset(); 
			changeLabel(); 
		} 

		if (e.getSource() == stop) { 
			// stopwatch off 
			on = false; 
		} 
	} 
} 
