package com.example.maze;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * The interface Drawable.
 */
public interface Drawable {
    /**
     * Draw.
     *
     * @param canvas the canvas
     * @param rect   the rect
     */
    void draw(Canvas canvas, Rect rect);
}
