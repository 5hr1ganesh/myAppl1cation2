package com.dharamveer.mytogglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


public class AnimalsInfo extends AppCompatActivity {
    GridView gridView;
    Integer[] imageId = {
            R.drawable.arcticfox, R.drawable.lynx, R.drawable.redpanda, R.drawable.siberiantigger, R.drawable.snowleepard, R.drawable.wolf,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_info);

        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapterGridView(this));

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            if (position == 0)
                Toast.makeText(AnimalsInfo.this, "ArcticFox", Toast.LENGTH_SHORT).show();
            else if (position == 1)
                Toast.makeText(AnimalsInfo.this, "Lynx", Toast.LENGTH_SHORT).show();
            else if (position == 2)
                Toast.makeText(AnimalsInfo.this, "Red Panda", Toast.LENGTH_SHORT).show();
            else if (position == 3)
                Toast.makeText(AnimalsInfo.this, "Siberian Tiger", Toast.LENGTH_SHORT).show();
            else if (position == 4)
                Toast.makeText(AnimalsInfo.this, "Snow Leopard", Toast.LENGTH_SHORT).show();
            else if (position == 5)
                Toast.makeText(AnimalsInfo.this, "Snow Leopard", Toast.LENGTH_SHORT).show();
        });

    }

    public class ImageAdapterGridView extends BaseAdapter {
        Context context;

        public ImageAdapterGridView(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return imageId.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(context);
                imageView.setLayoutParams(new
                        GridView.LayoutParams(500, 500));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                imageView.setPadding(16, 16, 16, 16);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(imageId[position]);
            return imageView;
        }


    }

}

