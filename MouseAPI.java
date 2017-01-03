package me.akarui_kage.repeate.mouse;

import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MouseAPI {
	
	static int left = InputEvent.BUTTON1_MASK;
	static int right = InputEvent.BUTTON3_MASK;
	
	
	public static void genLeft() throws Exception {
		Robot r = new Robot();
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	public static void genRight() throws Exception {
		Robot r = new Robot();
		r.mousePress(right);
		Thread.sleep(100);
		r.mouseRelease(right);
	}
	
	public static void move(Point pos) throws Exception {
		Robot r = new Robot();
		r.mouseMove((int)Math.floor(pos.getX()), (int)Math.floor(pos.getY()));
	}

}
