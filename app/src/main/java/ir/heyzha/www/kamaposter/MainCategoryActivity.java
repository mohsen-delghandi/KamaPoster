package ir.heyzha.www.kamaposter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

public class MainCategoryActivity extends AppCompatActivity {

    private ImageView imageViewNature,
            imageViewFaceAndSport,
            imageViewBacksAnd3dBackgrounds,
            imageViewKid,
            imageViewCityAndClassic,
            imageViewLuxury2019,
            imageViewGraphiteAndSpecialImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_main);

        try {
            Process su = Runtime.getRuntime().exec("su");
            DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());

            outputStream.writeBytes("wm size 1920x1080\n");
            outputStream.flush();

            outputStream.writeBytes("exit\n");
            outputStream.flush();
            su.waitFor();
        } catch (IOException e) {

        } catch (InterruptedException e) {

        }

        String[] folderPaths = {
                "images_luxury"
        };

        imageViewNature = findViewById(R.id.imageView_nature);
        imageViewFaceAndSport = findViewById(R.id.imageView_face_and_sport);
        imageViewBacksAnd3dBackgrounds = findViewById(R.id.imageView_backs_and_3d_backgrounds);
        imageViewKid = findViewById(R.id.imageView_kid);
        imageViewCityAndClassic = findViewById(R.id.imageView_city_and_classic);
        imageViewLuxury2019 = findViewById(R.id.imageView_luxury_2019);
        imageViewGraphiteAndSpecialImages = findViewById(R.id.imageView_grahite_and_special_images);

        imageViewNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, NatureCategoryActivity.class);
                startActivity(i);
            }
        });

        imageViewFaceAndSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, FaceImagesAndSportCategoryActivity.class);
                startActivity(i);
            }
        });

        imageViewBacksAnd3dBackgrounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, BackgroundsCategoryActivity.class);
                startActivity(i);
            }
        });

        imageViewKid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, KidsCategoryActivity.class);
                i.putExtra(Constants.CATEGORY, Constants.IMAGES_KID);
                startActivity(i);
            }
        });

        imageViewCityAndClassic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, CityAndClassicCategoryActivity.class);
                startActivity(i);
            }
        });

        imageViewLuxury2019.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, GalleryViewActivity.class);
                i.putExtra(Constants.CATEGORY, Constants.IMAGES_LUXURY_2019);
                startActivity(i);
            }
        });

        imageViewGraphiteAndSpecialImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, GraphiteAndSpecialCategoryActivity.class);
                startActivity(i);
            }
        });
    }

    private void folderMaker(String folderPath) {
        File file = new File(getExternalFilesDir(Constants.JPG).getPath() + "/"+ Constants.IMAGES+"/" +
                folderPath);
        if (!file.exists())
            file.mkdirs();
    }
}
