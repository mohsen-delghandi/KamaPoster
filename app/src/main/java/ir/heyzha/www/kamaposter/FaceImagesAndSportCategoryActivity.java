package ir.heyzha.www.kamaposter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class FaceImagesAndSportCategoryActivity extends BaseActivity {

    private ImageView imageViewWoman,
            imageViewEyeAndLip,
            imageViewCinemaCharacters,
            imageViewRomantic,
            imageViewMusic,
            imageViewFun;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_face_and_sport);

        ImageView imageViewBack;
        imageViewBack = findViewById(R.id.imageView_back);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        intent = getIntent();

        imageViewWoman = findViewById(R.id.imageView_woman);
        imageViewEyeAndLip = findViewById(R.id.imageView_eye_and_lip);
        imageViewCinemaCharacters = findViewById(R.id.imageView_cinema_characters);
        imageViewRomantic = findViewById(R.id.imageView_romantic);
        imageViewMusic = findViewById(R.id.imageView_music);
        imageViewFun = findViewById(R.id.imageView_fun);

        imageViewWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_WOMAN);
            }
        });
        imageViewEyeAndLip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_EYE_AND_LIP);
            }
        });
        imageViewCinemaCharacters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_CINEMA_CHARACTERS);
            }
        });
        imageViewRomantic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_ROMANTIC);
            }
        });
        imageViewMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_MUSIC);
            }
        });
        imageViewFun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_FUN);
            }
        });
    }

    private void goToActivity(String category) {
        Intent i = new Intent(FaceImagesAndSportCategoryActivity.this, GalleryViewActivity.class);
        i.putExtra(Constants.CATEGORY, intent.getExtras().getString(Constants.CATEGORY) + "/" + category);
        startActivity(i);
    }

    private void goToActivity2whenoffline
            (String category) {
        Intent i = new Intent(FaceImagesAndSportCategoryActivity.this, GalleryViewActivity.class);
        i.putExtra(Constants.CATEGORY, intent.getExtras().getString(Constants.CATEGORY) + "/" + category);
        startActivity(i);
    }
}
