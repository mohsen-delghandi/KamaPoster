package ir.heyzha.www.kamaposter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class GraphiteAndSpecialCategoryActivity extends AppCompatActivity {

    private ImageView imageViewGraphite,
            imageViewStatueAndWind,
            imageViewLux,
            imageViewMusic;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_graphite_and_special_images);

        ImageView imageViewBack;
        imageViewBack = findViewById(R.id.imageView_back);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        intent = getIntent();

        imageViewGraphite = findViewById(R.id.imageView_graphite);
        imageViewStatueAndWind = findViewById(R.id.imageView_statue_and_wind);
        imageViewLux = findViewById(R.id.imageView_lux);
        imageViewMusic = findViewById(R.id.imageView_music);

        imageViewGraphite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_GRAPHITE);
            }
        });
        imageViewStatueAndWind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_STATUE_AND_WIND);
            }
        });
        imageViewLux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_LUX);
            }
        });
        imageViewMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_MUSIC);
            }
        });
    }

    private void goToActivity(String category) {
        Intent i = new Intent(GraphiteAndSpecialCategoryActivity.this, GalleryViewActivity.class);
        i.putExtra(Constants.CATEGORY, intent.getExtras().getString(Constants.CATEGORY) + "/" + category);
        startActivity(i);
    }
}
