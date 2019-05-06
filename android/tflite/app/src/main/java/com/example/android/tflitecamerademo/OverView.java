package com.example.android.tflitecamerademo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class OverView extends View {
    public OverView(Context context) {
        super(context);
        initPaint();
    }
    private Paint mLinePaint;
    private Paint mAreaPaint;
    private Rect mCenterRect = null;
    private Context mContext;
    private Paint paint;
    private int widthScreen, heightScreen;
    public OverView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public OverView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }
    public  int bisa=0;
    @Override
    protected void onDraw(Canvas canvas) {
        mAreaPaint.setColor(Color.RED);
        canvas.drawLine(0,0,getWidth(),getHeight(),mAreaPaint);
        canvas.drawLine(0,getHeight(),getWidth(),0,mAreaPaint);
        bisa = getHeight()/4;
        int ds =getHeight()/10;
        canvas.drawLine((getWidth()-getHeight())/2+bisa-ds,0,(getWidth()-getHeight())/2+bisa-ds,getHeight(),mAreaPaint);
        canvas.drawLine(getWidth()-(getWidth()-getHeight())/2-bisa+ds,0,getWidth()-(getWidth()-getHeight())/2-bisa+ds,getHeight(),mAreaPaint);

        canvas.drawLine(0,bisa,getWidth(),bisa,mAreaPaint);
        canvas.drawLine(0,getHeight()-bisa,getWidth(),getHeight()-bisa,mAreaPaint);
        Log.e("vv","A部分起始点"+((getWidth()-getHeight())/2+bisa)+":"+bisa);

        super.onDraw(canvas);
    }
    private void initPaint() {
        // 绘制中间透明区域矩形边界的Paint
        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint.setColor(Color.BLUE);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setStrokeWidth(5f);
        // 值不为0 那么透明取景框 周围就会有线 看需求 修改值就行 我的项目部需要 线 所以透明
        mLinePaint.setAlpha(0);

        // 绘制四周阴影区域 的画笔
        mAreaPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mAreaPaint.setColor(Color.GRAY);
        mAreaPaint.setStyle(Paint.Style.FILL);
        mAreaPaint.setAlpha(100);
        paint = new Paint();

    }
}
