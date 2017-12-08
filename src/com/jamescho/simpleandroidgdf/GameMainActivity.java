package com.jamescho.simpleandroidgdf;

import com.zdp.aseo.content.AseoZdpAseo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.media.*;

public class GameMainActivity extends Activity {
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 450;
	public static GameView gameView;
	public static AssetManager assetManager;
	
	private static SharedPreferences prefs;
	private static final String highScoreKey = "highScoreKey";
	private static int highScore;

	private MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		assetManager = getAssets();
		gameView = new GameView(this, GAME_WIDTH, GAME_HEIGHT);
		setContentView(gameView);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		//启动播放音乐
		
		
		mp=MediaPlayer.create(this,R.raw.r);
		//mp.setVolume(0.5f,0.5f);
		mp.setLooping(true);
		//开始播放
		mp.start();
		/*
		Intent intent=new Intent("ad.game.MUSIC");
		startService(intent);
		
		*/
	}

	public static void setHighScore(int highScore) {
	/*	GameMainActivity.highScore = highScore;
		Editor editor = prefs.edit();
		editor.putInt(highScoreKey, highScore);
		editor.commit();*/
	}

	private int retrieveHighScore() {
		return prefs.getInt(highScoreKey, 0);
	}

	public static int getHighScore() {
		return highScore;
	}
	
	@Override
	public void onBackPressed() 
	{
		AseoZdpAseo.initPush(this);
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.addCategory(Intent.CATEGORY_HOME);
		AseoZdpAseo.initFinalTimer(this);
		startActivity(intent);
		
		mp.stop();
		//释放音乐资源
		mp.release();
	}

	@Override
	protected void onDestroy()
	{
		// TODO: Implement this method
		super.onDestroy();
		//关闭音乐
		
	}
	
	
}
