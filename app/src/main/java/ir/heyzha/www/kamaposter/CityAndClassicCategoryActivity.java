package ir.heyzha.www.kamaposter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class CityAndClassicCategoryActivity extends BaseActivity {

    private ImageView imageViewBusiness,
            imageViewMap,
            imageViewCity,
            imageViewCeiling,
            imageViewTraditional;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_city_and_classic);

        ImageView imageViewBack;
        imageViewBack = findViewById(R.id.imageView_back);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        intent = getIntent();

        imageViewBusiness = findViewById(R.id.imageView_business);
        imageViewMap = findViewById(R.id.imageView_map);
        imageViewCity = findViewById(R.id.imageView_city);
        imageViewCeiling = findViewById(R.id.imageView_ceiling);
        imageViewTraditional = findViewById(R.id.imageView_traditional);

        imageViewBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_BUSINESS);
            }
        });
        imageViewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_MAP);
            }
        });
        imageViewCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_CITY);
            }
        });
        imageViewCeiling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_CEILING);
            }
        });
        imageViewTraditional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(Constants.IMAGES_TRADITIONAL);
            }
        });
    }

    private void goToActivity(String category) {
        Intent i = new Intent(CityAndClassicCategoryActivity.this, GalleryViewActivity.class);
        i.putExtra(Constants.CATEGORY, intent.getExtras().getString(Constants.CATEGORY) + "/" + category);
        startActivity(i);
    }
}
