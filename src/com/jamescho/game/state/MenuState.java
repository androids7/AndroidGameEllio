package com.jamescho.game.state;

import android.util.Log;
import android.view.MotionEvent;

import com.jamescho.framework.util.Painter;
import com.jamescho.framework.util.UIButton;
import com.jamescho.simpleandroidgdf.Assets;

public class MenuState extends State {
	
	private UIButton playButton,scoreButton,state1Button,state2Button;
	
	//指向器的坐标
	int gx=0,gy=0;
	//

	@Override
	public void init() {
		//初始化关卡的按钮
		state1Button=new UIButton(316,150,376,206,Assets.state1,Assets.state1);
		state2Button=new UIButton(410,150,480,206,Assets.state2,Assets.state2);
		
		//playButton = new UIButton(316,227,484,286, Assets.start,Assets.startDown);
		scoreButton = new UIButton(316, 300, 484, 359, Assets.score, Assets.scoreDown);
		
		//初始化绿点的左边
		gx=316;
		gy=206;
		
	}

	@Override
	public void update(float delta) {
	}

	@Override
	public void render(Painter g) {
		//画背景图片
		g.drawImage(Assets.welcome, 0, 0);
		//playButton.render(g);
		/*
		
		渲染各个按钮
		*/
		scoreButton.render(g);
		state1Button.render(g);
		state2Button.render(g);
		
		//画绿点
		g.drawImage(Assets.gstar,gx,gy);
		//设置画笔字体大小
		g.setTextSize(32);
		//画字
		g.drawString("请选择关卡",250,100);
		
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			//playButton.onTouchDown(scaledX, scaledY);
			
			
			scoreButton.onTouchDown(scaledX, scaledY);
			/*
			传入点击坐标
			注册按钮点击事件
			*/
			
			state1Button.onTouchDown(scaledX, scaledY);
			state2Button.onTouchDown(scaledX, scaledY);
			
			
			
		}
		/*
		如果按钮抬起
		*/
		if (e.getAction() == MotionEvent.ACTION_UP) {
			//if (playButton.isPressed(scaledX, scaledY)) {
				/*
				playButton.cancel();
				
				if(game_state==1)
				{
					//启动关卡1
				setCurrentState(new PlayState());
				}
				
				if(game_state==2)
				{
					//启动关卡2
					setCurrentState(new PlayState());
				}
				
				*/
			//} else 
			
			
			/*
			是否按下按钮 
			是的话进行判断
			*/
			if (scoreButton.isPressed(scaledX, scaledY)) {
				scoreButton.cancel();
				Log.d("MenuState", "Score Button Pressed!");
			} else if(state1Button.isPressed(scaledX,scaledY))
			{
			//释放按钮点击
				state1Button.cancel();

				//设置绿点的位置
				gx=316;
				
				//启动关卡1
				setCurrentState(new PlayState(0));
			}
			
			
			else if(state2Button.isPressed(scaledX,scaledY))
			{
			
				//释放按钮点击
				state2Button.cancel();
				
				//设置绿点的位置
				gx=410;
				
				//启动关卡2
				setCurrentState(new PlayState(2));
			}
			
			else {
				//playButton.cancel();
				scoreButton.cancel();
				
				state1Button.cancel();
				state2Button.cancel();
			}
		}
		return true;
	}
}
