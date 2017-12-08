package com.jamescho.simpleandroidgdf;

import java.io.IOException;
import java.io.InputStream;

import com.jamescho.framework.animation.Animation;
import com.jamescho.framework.animation.Frame;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.AudioManager;
import android.media.SoundPool;

public class Assets {
	private static SoundPool soundPool;
	public static Bitmap welcome,block,cloud1,cloud2,duck,grass,jump,run1,run2,run3,run4,run5,score,scoreDown,start,startDown;
	public static Animation runAnimation;
	public static int hitID, onJumpID;
	public static Bitmap state1,state2,gstar;
	public static void load() {
		welcome = loadBitmap("welcome.png", false);
		block = loadBitmap("block.png", false);
		cloud1 = loadBitmap("cloud1.png", false);
		cloud2 = loadBitmap("cloud2.png", false);
		duck = loadBitmap("duck.png", true);
		grass = loadBitmap("grass.png", false);
		jump = loadBitmap("jump.png", true);
		run1 = loadBitmap("run_anim1.png", true);
		run2 = loadBitmap("run_anim2.png", true);
		run3 = loadBitmap("run_anim3.png", true);
		run4 = loadBitmap("run_anim4.png", true);
		run5 = loadBitmap("run_anim5.png", true);
		scoreDown = loadBitmap("score_button_down.png", true);
		score = loadBitmap("score_button.png", true);
		startDown = loadBitmap("start_button_down.png", true);
		start = loadBitmap("start_button.png", true);
		
		state1=loadBitmap("state1.png",false);
		state2=loadBitmap("state2.png",false);
		gstar=loadBitmap("greenstar.png",true);
		
		
		Frame f1 = new Frame(run1, .1f);
		Frame f2 = new Frame(run2, .1f);
		Frame f3 = new Frame(run3, .1f);
		Frame f4 = new Frame(run4, .1f);
		Frame f5 = new Frame(run5, .1f);
		
		runAnimation = new Animation(f1, f2, f3, f4, f5, f3, f2);
		hitID = loadSound("hit.wav");
		onJumpID = loadSound("onjump.wav");
		
	}

	private static Bitmap loadBitmap(String filename, boolean transparency) {
		InputStream inputStream = null;
		try {
			inputStream = GameMainActivity.assetManager.open(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Options options = new Options();
		if (transparency) {
			options.inPreferredConfig = Config.ARGB_8888;
		} else {
			options.inPreferredConfig = Config.RGB_565;
		}
		Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null,
				options);
		return bitmap;
	}

	private static int loadSound(String filename) {
		int soundID = 0;
		if (soundPool == null) {
			soundPool = new SoundPool(25, AudioManager.STREAM_MUSIC, 0);
		}
		try {
			soundID = soundPool.load(GameMainActivity.assetManager.openFd(filename),
					1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return soundID;
	}

	public static void playSound(int soundID) {
		soundPool.play(soundID, 1, 1, 1, 0, 1);
	}
}
