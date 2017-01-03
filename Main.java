package me.akarui_kage.repeate.mouse;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	
	static JFrame j = new JFrame();
	static JPanel p = new JPanel();
	static JButton record = new JButton("RECORD");
	static JButton replay = new JButton("REPLAY");
	static JButton stop = new JButton("STOP");
	
	public static boolean btnrec;
	public static boolean btnrepl;
	public static boolean btnstp = false;
	
	public static boolean enRec = true;
	public static boolean enRepl = false;
	public static boolean enStp = false;
	
	public static boolean clicked;
	
	public static boolean rest = false;
	
	
	
	static ArrayList<Point> pos = new ArrayList<>();
	static ArrayList<Integer> time = new ArrayList<>();
	static ArrayList<Boolean> leftClicked = new ArrayList<>();
	static ArrayList<Boolean> rightClicked = new ArrayList<>();
	
	static int timer;
	
	static int keep;
	
	static boolean mouseClicked;
	
	static boolean rec = true;
	static boolean repl;
	static boolean stp;

	public static void main(String[] args) {
		
		j.setTitle("Repeate Mouse");
		j.setAlwaysOnTop(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(350, 200);
		j.setResizable(false);
		j.setLocation(new Point(420, 420));
		j.setVisible(true);
		
		stop.setEnabled(enStp);
		
		record.setSize(175, 40);
		record.setEnabled(enRec);
		
		replay.setSize(175, 40);
		replay.setEnabled(enRepl);
		
		record.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnrec = true;
				btnrepl = false;
				replay.setEnabled(true);
				stop.setEnabled(false);
				record.setEnabled(false);
				j.setTitle("Recording...");
			}
		});
		
		replay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnrepl = true;
				btnrec = false;
				replay.setEnabled(false);
				stop.setEnabled(true);
				record.setEnabled(false);
			}
		});
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnstp = true;
				btnrepl = false;
				replay.setEnabled(true);
				stop.setEnabled(false);
				record.setEnabled(true);
			}
		});
		
		p.add(record);
		p.add(replay);
		p.add(stop);
		j.add(p);
		j.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				clicked = false;
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				clicked = true;
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		timer = -1;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(j.isVisible()) {
			System.out.println("");
			if(btnstp) {
				stop();
			}
			if(btnrec) {
				record();
			}
			if(btnrepl) {
				replay();
			}
			
		}

	}
	
	protected static void record() {
		pos.add(new Point(MouseInfo.getPointerInfo().getLocation()));
		time.add(timer);
		leftClicked.add(clicked);
		timer++;
		System.out.println(pos.get(timer));
		System.out.print(leftClicked.get(timer));
		j.setTitle("Recording....");
	}
	
	protected static void replay() {
		if(!rest) {
			timer = 0;
			rest = true;
		}
		if(leftClicked.get(timer)) {
			try {
				MouseAPI.genLeft();
			} catch (Exception e) {}
		}
		try {
			MouseAPI.move(pos.get(timer));
		} catch (Exception e) {}
		if(timer != time.size()-1) {
			timer++;
		} 
		else {
			rest = false;
		}

	}
	
	protected static void stop() {
		
	}

}
