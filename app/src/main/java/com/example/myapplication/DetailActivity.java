package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("ITEM_INDEX",-1);

        if(index>-1){int pic = getImg(index);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            scaleImg(img, pic);
        }
    }
    private int getImg(int index){
        switch(index){
            case 0: return R.drawable.beer2;
            case 1: return R.drawable.wine;
            case 2: return R.drawable.cider;
            case 3: return R.drawable.mead;
            case 4: return R.drawable.sake;
            case 5: return R.drawable.whiskey;
            case 6: return R.drawable.tequila;
            case 7: return R.drawable.rum;
            case 8: return R.drawable.brandy;
            case 9: return R.drawable.vodka;
            case 10: return R.drawable.gin;
            case 11: return R.drawable.soju;
            default: return -1;
        }
    }

    private void scaleImg(ImageView img, int pic){
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if(imgWidth>screenWidth){
            int ratio = Math.round((float)imgWidth/(float) screenWidth);
            options.inSampleSize = ratio;
        }
        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);
    }
}