package edu.binghamton.cs.cs441_project_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private Button showGrid = null;
    private Button button1 = null;
    private Button button2 = null;
    private Button button3 = null;
    private Button button4 = null;
    private LinearLayout canvasLayout = null;
    MySurface customView = null;
    private boolean drawPiece1 = false;
    private boolean drawPiece2 = false;
    private boolean drawPiece3 = false;
    private boolean drawPiece4 = false;
    private boolean drawGrid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("SurfaceView");

        initControls();

        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        customView = new MySurface(getApplicationContext());
        customView.setOnTouchListener(this);
        canvasLayout.addView(customView);

        showGrid.setVisibility(View.VISIBLE);
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);

        // Click this button to draw a red circle ball move after finger touch.
        showGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawGrid = true;
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                button3.setVisibility(View.VISIBLE);
                button4.setVisibility(View.VISIBLE);
            }
        });

        // Click this button to draw a red circle ball move after finger touch.
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawPiece1 = true;
            }
        });

        // Click this button to draw a green rectangle move after finger touch.
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawPiece2 = true;
            }
        });

        // Click this button to draw a green rectangle move after finger touch.
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawPiece3 = true;
            }
        });

        // Click this button to draw a green rectangle move after finger touch.
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawPiece4 = true;
            }
        });
    }
    private void initControls(){
        if(canvasLayout == null){
            canvasLayout = findViewById(R.id.customViewLayout);
        }
        if(showGrid == null){
            showGrid = findViewById(R.id.showGrid);
        }
        if(button1 == null){
            button1 = findViewById(R.id.Button1);
        }
        if(button2 == null){
            button2 = findViewById(R.id.Button2);
        }
        if(button3 == null){
            button3 = findViewById(R.id.Button3);
        }
        if(button4 == null){
            button4 = findViewById(R.id.Button4);
        }

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent){
        // If user touch the custom SurfaceView object.
        if(view instanceof SurfaceView) {
            view.invalidate();

            float x = motionEvent.getX();
            float y = motionEvent.getY();
            customView.setPointerX(x);
            customView.setPointerY(y);

            if (drawGrid) {
                Paint paint = new Paint();
                paint.setColor(Color.BLACK);
                customView.setPaint(paint);
                customView.drawGrid();
            }
            if (drawPiece1) {
                Paint paint = new Paint();
                paint.setColor(Color.GREEN);
                customView.setPaint(paint);
                customView.drawPiece(1);
            }
            if (drawPiece2) {
                Paint paint = new Paint();
                paint.setColor(Color.YELLOW);
                customView.setPaint(paint);
                customView.drawPiece(2);
            }
            if (drawPiece3) {
                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                customView.setPaint(paint);
                customView.drawPiece(3);
            }
            if (drawPiece4) {
                Paint paint = new Paint();
                paint.setColor(Color.RED);
                customView.setPaint(paint);
                customView.drawPiece(4);
            }

            return true;
        }
        else{
            return false;
        }
    }

}
