package com.example.maze;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Player implements Drawable{

    private Point point;
    private Paint paint;
    private int size;

    public Player(Point start, int size) {
        this.paint = getPaint();
        this.point = start;
        this.size = size;
    }

    private static Paint getPaint() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        return paint;
    }

    public void goTo(int x, int y) {
        point.x = x;
        point.y = y;
    }

    public Point getPoint() {
        return point;
    }
    public int getX() {
        return point.x;
    }
    public int getY() {
        return point.y;
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
