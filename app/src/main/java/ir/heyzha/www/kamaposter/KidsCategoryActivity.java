package ir.heyzha.www.kamaposter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class KidsCategoryActivity extends BaseActivity {

    private ImageView imageViewKiddy,
            imageViewCartoonCharacter,
            imageViewHighlight,
            imageViewGameCharacter;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_kid);

        ImageView imageViewBack;
        imageViewBack = findViewById(R.id.imageView_back);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        intent = getIntent();

        imageViewKiddy = findViewById(R.id.imageView_kiddy);
        imageViewCartoonCharacter = findViewById(R.id.imageView_cartoon_character);
        imageViewGameCharacter = findViewById(R.id.imageView_game_character);
        imageViewHighlight = findViewById(R.id.imageView_highlight);

        imageViewKiddy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_KIDDY);
            }
        });
        imageViewHighlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_HIGHLIGHT);
            }
        });
        imageViewGameCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_GAME_CHARACTER);
            }
        });
        imageViewCartoonCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_CARTOON_CHARACTER);
            }
        });
    }

    private void goToActivity(String category) {
        Intent i = new Intent(KidsCategoryActivity.this, ThumbnailsViewActivity.class);
        i.putExtra(Constants.CATEGORY, intent.getExtras().getString(Constants.CATEGORY) + "/" + category);
        startActivity(i);
    }
}
