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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private Button showGrid = null;
    private Button button1 = null;
    private Button button2 = null;
    private Button button3 = null;
    private Button button4 = null;
    private Button button5 = null;
    private Button details = null;
    private LinearLayout canvasLayout = null;
    private LinearLayout chartLayout = null;
    private LinearLayout editLayout = null;
    private LinearLayout categoryLayout = null;
    private LinearLayout textLayout = null;
    private LinearLayout gridLayout = null;
    private EditText text1 = null;
    private EditText text2 = null;
    private EditText text3 = null;
    private EditText text4 = null;
    private EditText text5 = null;
    private MySurface customView = null;
    private boolean drawPiece1 = false;
    private boolean drawPiece2 = false;
    private boolean drawPiece3 = false;
    private boolean drawPiece4 = false;
    private boolean drawPiece5 = false;
    private boolean drawGrid = false;
    private boolean drawText = false;
    private TextView surveyText = null;
    private TextView questionText = null;
    private double rank1, rank2, rank3, rank4, rank5;
    private float angle1, angle2, angle3, angle4, angle5;

    @Override
    protected void onCreate(Bundle savedInstanceState){
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
        chartLayout.setVisibility(View.GONE);
        textLayout.setVisibility(View.GONE);

        //if(!text1.getText().toString().isEmpty() &&
        //        !text2.getText().toString().isEmpty() &&
          //      !text3.getText().toString().isEmpty() &&
            //    !text4.getText().toString().isEmpty() &&
              //  !text5.getText().toString().isEmpty()){

        //    showGrid.setVisibility(View.VISIBLE);
        //}

        // Click this button to draw a red circle ball move after finger touch.
        showGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawGrid = true;
                chartLayout.setVisibility(View.VISIBLE);
                editLayout.setVisibility(View.GONE);
                categoryLayout.setVisibility(View.GONE);
                surveyText.setText("Pie Chart");
                surveyText.setTextColor(Color.LTGRAY);
                questionText.setText("");
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                button5.setVisibility(View.GONE);
            }
        });

        // Click this button to draw a red circle ball move after finger touch.
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                drawPiece1 = true;
                rank1 = ((Double.parseDouble(text1.getText().toString()) /15) *100);
                rank1 = Math.round(rank1);
                gridLayout.setVisibility(View.GONE);
                button2.setVisibility(View.VISIBLE);
                questionText.setText("Comedy: " + rank1 + "%");
            }
        });

        // Click this button to draw a green rectangle move after finger touch.
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                drawPiece2 = true;
                rank2 = (Double.parseDouble(text2.getText().toString()) /15) *100;
                rank2 = Math.round(rank2);
                button3.setVisibility(View.VISIBLE);
                questionText.setText("Action: " + rank2 + "%");
            }
        });

        // Click this button to draw a green rectangle move after finger touch.
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                drawPiece3 = true;
                rank3 = (Double.parseDouble(text3.getText().toString()) /15) *100;
                rank3 = Math.round(rank3);
                button4.setVisibility(View.VISIBLE);
                questionText.setText("Horror: " + rank3 + "%");
            }
        });

        // Click this button to draw a green rectangle move after finger touch.
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawPiece4 = true;
                rank4 = (Double.parseDouble(text4.getText().toString()) /15) *100;
                rank4 = Math.round(rank4);
                button5.setVisibility(View.VISIBLE);
                questionText.setText("Drama: " + rank4 + "%");
            }
        });

        // Click this button to draw a green rectangle move after finger touch.
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawPiece5 = true;
                rank5 = (Double.parseDouble(text5.getText().toString()) / 15) * 100;
                rank5 = Math.round(rank5);
                textLayout.setVisibility(View.VISIBLE);
                questionText.setText("SciFi: " + rank5 + "%");
            }
        });

        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawText = true;
            }
        });

    }

    private void initControls(){
        if(canvasLayout == null){
            canvasLayout = findViewById(R.id.customViewLayout);
        }
        if(chartLayout == null){
            chartLayout = findViewById(R.id.chartLayout);
        }
        if(gridLayout == null){
            gridLayout = findViewById(R.id.gridLayout);
        }
        if(editLayout == null){
            editLayout = findViewById(R.id.editLayout);
        }
        if(categoryLayout == null){
            categoryLayout = findViewById(R.id.categoryLayout);
        }
        if(textLayout == null){
            textLayout = findViewById(R.id.textLayout);
        }
        if(showGrid == null){
            showGrid = findViewById(R.id.showGrid);
        }
        if(text1 == null){
            text1 = findViewById(R.id.text1);
        }
        if(text2 == null){
            text2 = findViewById(R.id.text2);
        }
        if(text3 == null){
            text3 = findViewById(R.id.text3);
        }
        if(text4 == null){
            text4 = findViewById(R.id.text4);
        }
        if(text5 == null){
            text5 = findViewById(R.id.text5);
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
        if(button5 == null){
            button5 = findViewById(R.id.Button5);
        }
        if(surveyText == null){
            surveyText = findViewById(R.id.surveyText);
        }
        if(questionText == null){
            questionText = findViewById(R.id.questionText);
        }
        if(details == null){
            details = findViewById(R.id.details);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent){
        // If user touch the custom SurfaceView object.
        if(view instanceof SurfaceView) {
            view.invalidate();

            //float x = motionEvent.getX();
            //float y = motionEvent.getY();
            //customView.setPointerX(x);
            //customView.setPointerY(y);

            angle1 = (float)((rank1/100) * 360);
            angle2 = (float)((rank2/100) * 360);
            angle3 = (float)((rank3/100) * 360);
            angle4 = (float)((rank4/100) * 360);
            angle5 = (float)((rank5/100) * 360);

            if (drawGrid) {
                Paint paint = new Paint();
                paint.setColor(Color.DKGRAY);
                customView.setPaint(paint);
                customView.drawGrid();
            }
            if (drawPiece1) {
                Paint paint = new Paint();
                paint.setColor(Color.GREEN);
                customView.setPaint(paint);
                customView.drawPiece(angle1, angle2, angle3, angle4, angle5);
            }

            if(drawText){
                Paint paint = new Paint();
                paint.setColor(Color.BLACK);
                customView.setPaint(paint);
                customView.drawText(rank1, rank2, rank3, rank4, rank5);
            }

            /*if (drawPiece2){
                Paint paint = new Paint();
                paint.setColor(Color.YELLOW);
                customView.setPaint(paint);
                customView.drawPiece(2, angle1, angle2);

            }
            if (drawPiece3){
                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                customView.setPaint(paint);
                customView.drawPiece(3, angle2, angle3);
            }
            if (drawPiece4) {
                Paint paint = new Paint();
                paint.setColor(Color.MAGENTA);
                customView.setPaint(paint);
                customView.drawPiece(4, angle3, angle4);
            }

            if (drawPiece5) {
                Paint paint = new Paint();
                paint.setColor(Color.GRAY);
                customView.setPaint(paint);
                customView.drawPiece(5, angle4, 360F);
            }*/

            return true;
        }
        else{
            return false;
        }
    }

}
