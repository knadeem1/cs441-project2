package edu.binghamton.cs.cs441_project_2;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class MySurface extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private RectF rectf = null;

    private float angle1;
    private float angle2;
    private float angle3;
    private float angle4;
    private float angle5;
    private float radius;

    private float xcoor;
    private float ycoor;

    private int numRows = 20;
    private int numColumns = 20;

    private float pointerX;
    private float pointerY;



    public MySurface(Context context) {
        super(context);

        surfaceHolder = getHolder();

        paint = new Paint();
        paint.setColor(Color.RED);

        rectf = new RectF(0,0,0,0);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder){
    }
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder,int format, int width,int height) {
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

    public int getNumberOfColumns(){
        return numColumns;
    }

    protected void drawGrid(){
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        surfaceBackground.setColor(Color.WHITE);
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        paint.setColor(Color.DKGRAY);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);

        canvas.drawLine(width/2, 0, width/2, height, paint);
        canvas.drawLine(0, height/2, width, height/2, paint);

        paint.setStrokeWidth(3);

        //columns
        for (int i = 1; i <= getNumberOfColumns(); i++) {
            canvas.drawLine(width * i / numColumns, 0, width * i / numColumns, height, paint);
        }

        //rows
        for (int i = 1; i <= getNumberOfRows(); i++) {
            canvas.drawLine(0, height * i / numRows, width, height * i / numRows, paint);
        }


        surfaceHolder.unlockCanvasAndPost(canvas);
        surfaceHolder.setFormat(PixelFormat.TRANSLUCENT);
    }

/*
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
*/
    public void drawPiece(float angle1, float angle2, float angle3, float angle4, float angle5){
        Canvas canvas = surfaceHolder.lockCanvas();
        //Paint surfaceBackground = new Paint();
        //surfaceBackground.setColor(Color.WHITE);
        //canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        this.angle1 = angle1;
        this.angle2 = angle2;
        this.angle3 = angle3;
        this.angle4 = angle4;
        this.angle5 = angle5;

        int width = canvas.getWidth() /2;
        int height = canvas.getHeight() /2;
        rectf.set(width - 350, height - 350, width + 350, height + 350);

        radius = width - 350;
        // Draw the pie slices
        paint.setColor(Color.GREEN);
        canvas.drawArc(rectf, 0F, angle1, true, paint);
        paint.setColor(Color.BLUE);
        canvas.drawArc(rectf, angle1, angle2, true, paint);
        paint.setColor(Color.GRAY);
        canvas.drawArc(rectf, angle2+angle1, angle3, true, paint);
        paint.setColor(Color.YELLOW);
        canvas.drawArc(rectf, angle3+angle2+angle1, angle4, true, paint);
        paint.setColor(Color.RED);
        canvas.drawArc(rectf, angle1+angle2+angle3+angle4, angle5, true, paint);


        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    public void drawText(double rank1, double rank2, double rank3, double rank4, double rank5) {
        Canvas canvas = surfaceHolder.lockCanvas();

        int width = canvas.getWidth() /2;
        int height = canvas.getHeight() /2;
        paint.setTextSize(70F);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));

        canvas.drawCircle(width,height,350,paint);

        canvas.drawText("Comedy: " + rank1 + "%",width+200, height+650 ,paint);
        canvas.drawText("Action: " + rank2 + "%",width-400, height+650 ,paint);
        canvas.drawText("Horror: " + rank3 + "%",width-700, height+300 ,paint);
        canvas.drawText("Drama: " + rank4 + "%",width-400, height-650 ,paint);
        canvas.drawText("SciFi: " + rank5 + "%",width+250, height-650 ,paint);

        paint.setStrokeWidth(10);


        canvas.drawLine(width+250,height+600, width+350, height, paint);
        double angle = (double) angle1;
        xcoor = (float) (radius * Math.cos(Math.toRadians(angle)));
        ycoor = (float) (radius * Math.sin(Math.toRadians(angle)));
        canvas.drawLine(width-350,height+600, xcoor, ycoor, paint);
        angle = (double) angle2;
        xcoor = (float) (350 * Math.cos(Math.toRadians(angle)));
        ycoor = (float) (350 * Math.sin(Math.toRadians(angle)));
        canvas.drawLine(width-650,height+250, xcoor, ycoor, paint);
        angle = (double) angle3;
        xcoor = (float) (350 * Math.cos(Math.toRadians(angle)));
        ycoor = (float) (350 * Math.sin(Math.toRadians(angle)));
        canvas.drawLine(width-350,height-600, xcoor, ycoor, paint);
        angle = (double) angle4;
        xcoor = (float) (350 * Math.cos(Math.toRadians(angle)));
        ycoor = (float) (350 * Math.sin(Math.toRadians(angle)));
        canvas.drawLine(width+300,height-600, xcoor, ycoor, paint);

        surfaceHolder.unlockCanvasAndPost(canvas);
    }

}
