package edu.binghamton.cs.cs441_project_2;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class MySurface extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private RectF rectf = null;

    private int numRows = 20;
    private int numColumns = 20;

    private float pointerX = 0;
    private float pointerY = 0;



    public MySurface(Context context) {
        super(context);

        surfaceHolder = getHolder();

        paint = new Paint();
        paint.setColor(Color.RED);

        rectf = new RectF(getPointerX(), getPointerY(), 200, 200);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder){
        drawGrid();
    }
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2){
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder){
        paint = null;
    }

    public void setPaint(Paint paint){
        this.paint = paint;
    }

    public int getNumberOfRows(){
        return numRows;
    }

    public int getNumberofColumns(){
        return numColumns;
    }

    protected void drawGrid(){
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        surfaceBackground.setColor(Color.WHITE);
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(15);

        canvas.drawLine(width/2, 0, width/2, height, paint);
        canvas.drawLine(0, height/2, width, height/2, paint);

        paint.setStrokeWidth(5);

        //columns
        for (int i = 1; i <= getNumberofColumns(); i++) {
            canvas.drawLine(width * i / numColumns, 0, width * i / numColumns, height, paint);
        }

        //rows
        for (int i = 1; i <= getNumberOfRows(); i++) {
            canvas.drawLine(0, height * i / numRows, width, height * i / numRows, paint);
        }


        surfaceHolder.unlockCanvasAndPost(canvas);
    }


    public float getPointerX(){
        return pointerX;
    }

    public float getPointerY(){
        return pointerY;
    }

    public void setPointerX(float pointerX) {
        this.pointerX = pointerX;
    }

    public void setPointerY(float pointerY) {
        this.pointerY = pointerY;
    }

    public void drawPiece(int option){
        Canvas canvas = surfaceHolder.lockCanvas();
        //Paint surfaceBackground = new Paint();
        //surfaceBackground.setColor(Color.WHITE);
        //canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        // Draw the pie slices
        if(option == 1) {
            canvas.drawArc(rectf, 0F, 20F, true, paint);
        }
        if(option == 2) {
            canvas.drawArc(rectf, 0F, 30F, true, paint);
        }
        if(option == 3) {
            canvas.drawArc(rectf, 0F, 90F, true, paint);
        }
        if(option == 4) {
            canvas.drawArc(rectf, 0F, 60F, true, paint);
        }

        surfaceHolder.unlockCanvasAndPost(canvas);
    }

}
