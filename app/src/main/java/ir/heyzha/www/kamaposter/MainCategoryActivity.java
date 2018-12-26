package ir.heyzha.www.kamaposter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainCategoryActivity extends AppCompatActivity {

    private ImageView imageViewNature,
            imageViewFaceAndSport,
            imageViewBacksAnd3dBackgrounds,
            imageViewKid,
            imageViewCityAndClassic,
            imageViewGraphiteAndSpecialImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_main);

        imageViewNature = findViewById(R.id.imageView_nature);
        imageViewFaceAndSport = findViewById(R.id.imageView_face_and_sport);
        imageViewBacksAnd3dBackgrounds = findViewById(R.id.imageView_backs_and_3d_backgrounds);
        imageViewKid = findViewById(R.id.imageView_kid);
        imageViewCityAndClassic = findViewById(R.id.imageView_city_and_classic);
        imageViewGraphiteAndSpecialImages = findViewById(R.id.imageView_grahite_and_special_images);

        imageViewNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this,NatureCategoryActivity.class);
                startActivity(i);
            }
        });

        imageViewFaceAndSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this,FaceImagesAndSportCategoryActivity.class);
                startActivity(i);
            }
        });

        imageViewBacksAnd3dBackgrounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this,BackgroundsCategoryActivity.class);
                startActivity(i);
            }
        });

        imageViewKid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this,KidsCategoryActivity.class);
                startActivity(i);
            }
        });

        imageViewCityAndClassic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this,CityAndClassicCategoryActivity.class);
                startActivity(i);
            }
        });

        imageViewGraphiteAndSpecialImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this,GraphiteAndSpecialCategoryActivity.class);
                startActivity(i);
            }
        });
    }
}
