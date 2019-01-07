package ir.heyzha.www.kamaposter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class BackgroundsCategoryActivity extends AppCompatActivity {

    private ImageView imageViewColorBacks,
            imageView3dBacks,
            imageViewFlowerBacks,
            imageView3d;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_backs_and_backgrounds);

        ImageView imageViewBack;
        imageViewBack = findViewById(R.id.imageView_back);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        intent = getIntent();

        imageView3d = findViewById(R.id.imageView_3d);
        imageViewColorBacks = findViewById(R.id.imageView_color_backs);
        imageView3dBacks = findViewById(R.id.imageView_3d_backs);
        imageViewFlowerBacks = findViewById(R.id.imageView_flower_backs);

        imageView3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_3D);
            }
        });
        imageView3dBacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_3D_BACKS);
            }
        });
        imageViewColorBacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_COLOR_BACKS);
            }
        });
        imageViewFlowerBacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_FLOWER_BACKS);
            }
        });

    }

    private void goToActivity(String category) {
        Intent i = new Intent(BackgroundsCategoryActivity.this, GalleryViewActivity.class);
        i.putExtra(Constants.CATEGORY, intent.getExtras().getString(Constants.CATEGORY) + "/" + category);
        startActivity(i);
    }
}
