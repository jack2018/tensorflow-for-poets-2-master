/* Copyright 2017 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

package com.example.android.tflitecamerademo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.TextureView;

/** A {@link TextureView} that can be adjusted to a specified aspect ratio. */
public class AutoFitTextureView extends TextureView {
  private Paint mLinePaint;
  private Paint mAreaPaint;
  private Rect mCenterRect = null;
  private Context mContext;
  private Paint paint;
  private int widthScreen, heightScreen;
  private int mRatioWidth = 0;
  private int mRatioHeight = 0;

  public AutoFitTextureView(Context context) {
    this(context, null);
    initPaint();
  }

  public AutoFitTextureView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
    initPaint();
  }

  public AutoFitTextureView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    initPaint();
  }

  /**
   * Sets the aspect ratio for this view. The size of the view will be measured based on the ratio
   * calculated from the parameters. Note that the actual sizes of parameters don't matter, that is,
   * calling setAspectRatio(2, 3) and setAspectRatio(4, 6) make the same result.
   *
   * @param width Relative horizontal size
   * @param height Relative vertical size
   */
  public void setAspectRatio(int width, int height) {
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Size cannot be negative.");
    }
    mRatioWidth = width;
    mRatioHeight = height;
    requestLayout();
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    int width = MeasureSpec.getSize(widthMeasureSpec);
    int height = MeasureSpec.getSize(heightMeasureSpec);
    if (0 == mRatioWidth || 0 == mRatioHeight) {
      setMeasuredDimension(width, height);
    } else {
      if (width < height * mRatioWidth / mRatioHeight) {
        setMeasuredDimension(width, width * mRatioHeight / mRatioWidth);
      } else {
        setMeasuredDimension(height * mRatioWidth / mRatioHeight, height);
      }
    }
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
