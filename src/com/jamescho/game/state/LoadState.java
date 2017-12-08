package com.jamescho.game.state;

import android.view.MotionEvent;
import com.jamescho.framework.util.Painter;
import com.jamescho.simpleandroidgdf.Assets;

public class LoadState extends State {
	@Override
	public void init() {
		Assets.load();
	}

	@Override
	public void update(float delta) {
		setCurrentState(new MenuState());
	}

	@Override
	public void render(Painter g) {
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		return false;
	}
}