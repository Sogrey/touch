/**
 * 
 */
package org.sogrey.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;

/**
 * @author Sogrey
 * 
 */
public class GameView extends SurfaceView implements Callback, Runnable {

	public GameView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initCopms();
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initCopms();
	}

	public GameView(Context context) {
		super(context);
		getHolder().addCallback(this);
		initCopms();
	}

	private void initCopms() {
		setOnTouchListener(new View.OnTouchListener() {

			private float startX, startY, offsetX, offsetY;

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub

				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					startX = event.getX();
					startY = event.getY();
					break;
				case MotionEvent.ACTION_UP:
					offsetX = event.getX() - startX;
					offsetY = event.getY() - startY;

					if (Math.abs(offsetX) > Math.abs(offsetY)) {
						if (offsetX < -5) {
							// swipeLeft();
							Log.e("Touch", "Left");
						} else if (offsetX > 5) {
							// swipeRight();
							Log.e("Touch", "Right");
						}
					} else {
						if (offsetY < -5) {
							// swipeUp();
							Log.e("Touch", "Up");
						} else if (offsetY > 5) {
							// swipeDown();
							Log.e("Touch", "Down");
						}
					}
					break;
				}
				return true;
			}

		});
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		new Thread(this).start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
