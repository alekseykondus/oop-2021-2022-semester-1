package com.example.maze;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class GameManager extends GestureDetector.SimpleOnGestureListener {

    private List<Drawable> drawables = new ArrayList<>();
    private View view;
    private Player player;
    private Maze maze;
    private ExitPoint exitPoint;
    private Rect rect = new Rect();
    private int screenSize;

    public GameManager(int mazeSize) {
        createManager(mazeSize);
    }

    void createManager(int mazeSize) {
        drawables.clear();
        maze = new Maze(mazeSize);
        player = new Player(maze.getStart(), mazeSize);
        exitPoint = new ExitPoint(maze.getEnd(), mazeSize);
        drawables.add(maze);
        drawables.add(player);
        drawables.add(exitPoint);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        int diffX = Math.round(e2.getX() - e1.getX()),
              diffY = Math.round(e2.getY() - e1.getY());
        if (Math.abs(diffX) > Math.abs(diffY)) {
            diffX = diffX > 0 ? 1 : -1;
            diffY = 0;
        } else {
            diffX = 0;
            diffY = diffY > 0 ? 1 : -1;
        }
        int stepX = player.getX();
        int stepY = player.getY();

        while (maze.canPlayerGoTo(stepX + diffX, stepY + diffY)) {
            stepX += diffX;
            stepY += diffY;
            if (diffX != 0) {
                if (maze.canPlayerGoTo(stepX, stepY + 1)
                        || maze.canPlayerGoTo(stepX, stepY - 1)) {
                    break;
                }
            }
            if (diffY != 0) {
                if (maze.canPlayerGoTo(stepX + 1, stepY)
                        || maze.canPlayerGoTo(stepX - 1, stepY)) {
                    break;
                }
            }
        }
        player.goTo(stepX, stepY);
        if (exitPoint.getPoint().equals(player.getPoint())) {
            createManager(maze.getSize() + 5);
        }
        view.invalidate();

        return super.onFling(e1, e2, velocityX, velocityY);
    }

    public void draw(Canvas canvas) {
        for (Drawable drawableItem : drawables) {
            drawableItem.draw(canvas, rect);
        }
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setScreenSize(int width, int height) {
        screenSize = Math.min(width, height);
        rect.set( (width - screenSize) / 2,
                  (height - screenSize) / 2,
                  (width + screenSize) / 2,
                  (height + screenSize) / 2);
    }
}
