package com.example.maze;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class ExitPoint implements Drawable {
    private int size;
    private Point point;
    private Paint paint;

    public ExitPoint(Point point, int size) {
        this.point = point;
        paint = getPaint();
        this.size = size;
    }

    private static Paint getPaint() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GREEN);
        return paint;
    }

    public Point getPoint() {
        return point;
    }

    @Override
    public void draw(Canvas canvas, Rect rect) {
        float cellSize = (float) (rect.right - rect.left) / size;
        canvas.drawRect(rect.left + point.x * cellSize,
                rect.top +  point.y * cellSize,
                rect.left +  point.x * cellSize + cellSize,
                rect.top +  point.y * cellSize + cellSize, paint);
    }
}