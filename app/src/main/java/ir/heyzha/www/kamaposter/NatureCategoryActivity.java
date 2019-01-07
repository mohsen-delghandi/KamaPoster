package ir.heyzha.www.kamaposter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class NatureCategoryActivity extends AppCompatActivity {

    private ImageView imageViewWinter,
            imageViewAutumn,
            imageViewSummer,
            imageSpring,
            imageViewWindowAndView,
            imageViewRockAndWall,
            imageViewFourSeasons,
            imageViewSeaAndBeach;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_nature);

        ImageView imageViewBack;
        imageViewBack = findViewById(R.id.imageView_back);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        intent = getIntent();

        imageViewWinter = findViewById(R.id.imageView_winter);
        imageViewAutumn = findViewById(R.id.imageView_autumn);
        imageViewSummer = findViewById(R.id.imageView_summer);
        imageSpring = findViewById(R.id.imageView_spring);
        imageViewWindowAndView = findViewById(R.id.imageView_window_and_view);
        imageViewRockAndWall = findViewById(R.id.imageView_rock_and_wall);
        imageViewFourSeasons = findViewById(R.id.imageView_four_seasons);
        imageViewSeaAndBeach = findViewById(R.id.imageView_sea_and_beach);

        imageViewWinter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_WINTER);
            }
        });
        imageViewAutumn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_AUTUMN);
            }
        });
        imageViewSummer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_SUMMER);
            }
        });
        imageSpring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_SPRING);
            }
        });
        imageViewWindowAndView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_WINDOW_AND_VIEW);
            }
        });
        imageViewRockAndWall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_ROCK_AND_WALL);
            }
        });
        imageViewFourSeasons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_FOUR_SEASONS);
            }
        });
        imageViewSeaAndBeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_SEA_AND_BEACH);
            }
        });
    }

    private void goToActivity(String category) {
        Intent i = new Intent(NatureCategoryActivity.this, GalleryViewActivity.class);
        i.putExtra(Constants.CATEGORY, intent.getExtras().getString(Constants.CATEGORY) + "/" + category);
        startActivity(i);
    }
}
