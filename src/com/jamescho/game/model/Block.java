package com.jamescho.game.model;

import android.graphics.Rect;
import com.jamescho.framework.util.RandomNumberGenerator;

public class Block {
	private float x, y;
	private int width, height;
	private Rect rectangle;
	private boolean visible;
	private static final int UPPER_Y = 275;
	private static final int LOWER_Y = 355;

	public Block(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		rectangle = new Rect((int) x, (int) y, (int) x + width, (int) y + height);
		visible = false;
	}

	public void update(float delta, float velX) {
		x += velX * delta;
		updateRect();
		if (x <= -50) {
			reset();
		}
	}

	public void updateRect() {
		rectangle.set((int) x, (int) y, (int) x + width, (int) y + height);
	}

	public void reset() {
		visible = true;
		// 1 in 3 chance of becoming an Upper Block
		if (RandomNumberGenerator.getRandInt(3) == 0) {
			y = UPPER_Y;
		} else {
			y = LOWER_Y;
		}
		x += 1000;
		updateRect();
	}

	public void onCollide(Player p) {
		visible = false;
		p.pushBack(30);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public boolean isVisible() {
		return visible;
	}

	public Rect getRect() {
		return rectangle;
	}
}