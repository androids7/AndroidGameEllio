package com.jamescho.framework.util;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.jamescho.game.state.State;
import com.jamescho.simpleandroidgdf.GameMainActivity;

public class InputHandler implements OnTouchListener {
	private State currentState;

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public boolean onTouch(View v, MotionEvent event) {
		int scaledX = (int) ((event.getX() / v.getWidth()) * GameMainActivity.GAME_WIDTH);
		int scaledY = (int) ((event.getY() / v.getHeight()) * GameMainActivity.GAME_HEIGHT);
		return currentState.onTouch(event, scaledX, scaledY);
	}


}
