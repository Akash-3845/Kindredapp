package com.akashyadav.kindredassignment;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

public class firstScreen extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private Resources mResources;
    private RelativeLayout mRelativeLayout;
    private Button btnSquare, btnCircle;
    private ImageButton btnUndo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        initViews();
    }
    private void initViews() {
        mContext = getApplicationContext();
        mResources = getResources();
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
        btnSquare = (Button) findViewById(R.id.square);
        btnCircle = (Button)findViewById(R.id.circle);

        btnUndo=(ImageButton)findViewById(R.id.undo);
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        btnSquare.setOnClickListener(this);
        btnCircle.setOnClickListener(this);

        btnUndo.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.square:
                drawSquare(null);

                break;

            case R.id.circle:
                drawCircle(null);

                break;

            case R.id.undo:

                break;

        }
    }

    private void drawSquare(ImageView imageView) {
        Bitmap bitmap = Bitmap.createBitmap(
                50, // Width
                50, // Height
                Bitmap.Config.ARGB_8888 // Config
        );

        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.LTGRAY);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.DKGRAY);
        paint.setAntiAlias(true);

        int padding = 50;
        Rect rectangle = new Rect(
                padding, // Left
                padding, // Top
                canvas.getWidth() - padding, // Right
                canvas.getHeight() - padding // Bottom
        );
        canvas.drawRect(rectangle, paint);
        addViews(bitmap,imageView,1);

        // Display the newly created bitmap on app interface
        if (imageView == null) {
            imageView = new ImageView(this);
        }
        imageView.setImageBitmap(bitmap);

        final ImageView finalImageView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawCircle(finalImageView);

            }
        });
    }

    private void drawCircle(ImageView imageView) {
        Bitmap bitmap = Bitmap.createBitmap(
                100, // Width
                100, // Height
                Bitmap.Config.ARGB_8888 // Config
        );

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);

        int radius = Math.min(canvas.getWidth(), canvas.getHeight() / 2);
        int padding = 5;
        canvas.drawCircle(
                canvas.getWidth() / 2, // cx
                canvas.getHeight() / 2, // cy
                radius - padding, // Radius
                paint // Paint
        );

        addViews(bitmap,imageView,2);

        // Display the newly created bitmap on app interface
        if (imageView == null) {
            imageView = new ImageView(this);
        }
        imageView.setImageBitmap(bitmap);

        final ImageView finalImageView = imageView;


    }



    private void addViews(Bitmap bitmap, ImageView imageView, final int value) {
        final int min = 20;
        final int max = 80;


        Drawable d = getResources().getDrawable(R.mipmap.ic_launcher_round);
        final int w = d.getIntrinsicWidth();
        final int random = new Random().nextInt((max - min) + 1) + min;

        final RelativeLayout relative4 = (RelativeLayout) findViewById(R.id.rl);
        int width = relative4.getMeasuredWidth();
        int height = relative4.getMeasuredHeight();
        if (imageView == null) {
            imageView = new ImageView(this);
        }
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100, 100);
        params.setMargins(new Random().nextInt((width - 0) + 1), new Random().nextInt((height - 0) + 1), 10, 10);
        imageView.setLayoutParams(params);
        imageView.setImageBitmap(bitmap);


        if (imageView != null) {
            ViewGroup parent = (ViewGroup) imageView.getParent();
            if (parent != null) {
                parent.removeView(imageView);
            }
        }

        relative4.addView(imageView);

        final ImageView finalImageView = imageView;


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (value) {
                    case 1:
                        drawCircle(finalImageView);

                        break;

                    case 3:
                        drawSquare(finalImageView);

                        break;
                    case R.id.undo:
                       relative4.removeView(finalImageView);
                        break;
                }

            }
        });



    }
}