package com.jamescho.game.state;

import android.util.Log;
import android.view.MotionEvent;

import com.jamescho.framework.util.Painter;
import com.jamescho.framework.util.UIButton;
import com.jamescho.simpleandroidgdf.Assets;

public class MenuState extends State {
	
	private UIButton playButton,scoreButton,state1Button,state2Button;
	
	//ָ����������
	int gx=0,gy=0;
	//

	@Override
	public void init() {
		//��ʼ���ؿ��İ�ť
		state1Button=new UIButton(316,150,376,206,Assets.state1,Assets.state1);
		state2Button=new UIButton(410,150,480,206,Assets.state2,Assets.state2);
		
		//playButton = new UIButton(316,227,484,286, Assets.start,Assets.startDown);
		scoreButton = new UIButton(316, 300, 484, 359, Assets.score, Assets.scoreDown);
		
		//��ʼ���̵�����
		gx=316;
		gy=206;
		
	}

	@Override
	public void update(float delta) {
	}

	@Override
	public void render(Painter g) {
		//������ͼƬ
		g.drawImage(Assets.welcome, 0, 0);
		//playButton.render(g);
		/*
		
		��Ⱦ������ť
		*/
		scoreButton.render(g);
		state1Button.render(g);
		state2Button.render(g);
		
		//���̵�
		g.drawImage(Assets.gstar,gx,gy);
		//���û��������С
		g.setTextSize(32);
		//����
		g.drawString("��ѡ��ؿ�",250,100);
		
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			//playButton.onTouchDown(scaledX, scaledY);
			
			
			scoreButton.onTouchDown(scaledX, scaledY);
			/*
			����������
			ע�ᰴť����¼�
			*/
			
			state1Button.onTouchDown(scaledX, scaledY);
			state2Button.onTouchDown(scaledX, scaledY);
			
			
			
		}
		/*
		�����ţ̌��
		*/
		if (e.getAction() == MotionEvent.ACTION_UP) {
			//if (playButton.isPressed(scaledX, scaledY)) {
				/*
				playButton.cancel();
				
				if(game_state==1)
				{
					//�����ؿ�1
				setCurrentState(new PlayState());
				}
				
				if(game_state==2)
				{
					//�����ؿ�2
					setCurrentState(new PlayState());
				}
				
				*/
			//} else 
			
			
			/*
			�Ƿ��°�ť 
			�ǵĻ������ж�
			*/
			if (scoreButton.isPressed(scaledX, scaledY)) {
				scoreButton.cancel();
				Log.d("MenuState", "Score Button Pressed!");
			} else if(state1Button.isPressed(scaledX,scaledY))
			{
			//�ͷŰ�ť���
				state1Button.cancel();

				//�����̵��λ��
				gx=316;
				
				//�����ؿ�1
				setCurrentState(new PlayState(0));
			}
			
			
			else if(state2Button.isPressed(scaledX,scaledY))
			{
			
				//�ͷŰ�ť���
				state2Button.cancel();
				
				//�����̵��λ��
				gx=410;
				
				//�����ؿ�2
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
