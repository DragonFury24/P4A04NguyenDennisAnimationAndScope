package com.dragonfury.duy.p4a04nguyendennisanimationandscope;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by 1383504 on 12/2/2016.
 */
public class DrawView extends View {
    public DrawView(Context context) {
        super(context);
    }

    private RectF sprite = new RectF();
    private int degrees=0;
    private int xSpeed= 100, ySpeed = 100;
    private Paint spritePaint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Reverse xSpeed at left Boundary
        if(sprite.left+xSpeed<getLeft()){
            xSpeed*=-1;
spritePaint.setColor(Color.RED);
        }
        //Reverse xSpeed at Right Boundary
        if(sprite.right+xSpeed>getRight()){
            xSpeed*=-1;
            spritePaint.setColor(Color.BLUE);
        }
        //Reverse ySpeed at top boundary
        if(sprite.top+ySpeed<getTop()){
            ySpeed*=-1;
            spritePaint.setColor(Color.GREEN);
        }
        //Reverse ySpeed at bottom boundary
        if(sprite.bottom+ySpeed>getBottom()){
            ySpeed*=-1;
            spritePaint.setColor(Color.YELLOW);
        }
        //Move sprite by xSpeed in the x direction
        sprite.offset(xSpeed,ySpeed);
        //Draw Oval inside of RectF Sprite
        canvas.drawOval(sprite,spritePaint);
        //Calls onDraw
        invalidate();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //Set Dimensions for RectF Sprite
        sprite.set(left,top,(float).1*right,(float).1*bottom);
    }
}
