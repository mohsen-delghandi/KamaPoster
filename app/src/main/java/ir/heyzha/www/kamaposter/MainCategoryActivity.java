package ir.heyzha.www.kamaposter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

public class MainCategoryActivity extends BaseActivity {

    private ImageView imageViewNature,
            imageViewFaceAndSport,
            imageViewBacksAndBackgrounds,
            imageViewKid,
            imageViewCityAndClassic,
            imageViewLuxury2019,
            imageViewSpringFlowers,
            imageViewAnimals,
            imageViewSport,
            imageView3dFlowers,
            imageViewPaperFlowers,
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
                Constants.IMAGES_LUXURY_2019,

                Constants.IMAGES_KID + "/" + Constants.IMAGES_KIDDY,
                Constants.IMAGES_KID + "/" + Constants.IMAGES_HIGHLIGHT,
                Constants.IMAGES_KID + "/" + Constants.IMAGES_GAME_CHARACTER,
                Constants.IMAGES_KID + "/" + Constants.IMAGES_CARTOON_CHARACTER,

                Constants.IMAGES_FACE_AND_SPORT + "/" + Constants.IMAGES_FUN,
                Constants.IMAGES_FACE_AND_SPORT + "/" + Constants.IMAGES_MUSIC,
                Constants.IMAGES_FACE_AND_SPORT + "/" + Constants.IMAGES_ROMANTIC,
                Constants.IMAGES_FACE_AND_SPORT + "/" + Constants.IMAGES_CINEMA_CHARACTERS,
                Constants.IMAGES_FACE_AND_SPORT + "/" + Constants.IMAGES_EYE_AND_LIP,
                Constants.IMAGES_FACE_AND_SPORT + "/" + Constants.IMAGES_WOMAN,

                Constants.IMAGES_PAPER_FLOWERS,

                Constants.IMAGES_CITY_AND_CLASSIC + "/" + Constants.IMAGES_TRADITIONAL,
                Constants.IMAGES_CITY_AND_CLASSIC + "/" + Constants.IMAGES_CEILING,
                Constants.IMAGES_CITY_AND_CLASSIC + "/" + Constants.IMAGES_CITY,
                Constants.IMAGES_CITY_AND_CLASSIC + "/" + Constants.IMAGES_MAP,
                Constants.IMAGES_CITY_AND_CLASSIC + "/" + Constants.IMAGES_BUSINESS,

                Constants.IMAGES_GRAPHITE_AND_SPECIAL + "/" + Constants.IMAGES_GRAPHITE,
                Constants.IMAGES_GRAPHITE_AND_SPECIAL + "/" + Constants.IMAGES_STATUE_AND_WIND,
                Constants.IMAGES_GRAPHITE_AND_SPECIAL + "/" + Constants.IMAGES_LUX,
                Constants.IMAGES_GRAPHITE_AND_SPECIAL + "/" + Constants.IMAGES_SPECIAL_IMAGES,

                Constants.IMAGES_3D_FLOWERS,

                Constants.IMAGES_ANIMALS,

                Constants.IMAGES_NATURE + "/" + Constants.IMAGES_SPRING,
                Constants.IMAGES_NATURE + "/" + Constants.IMAGES_SUMMER,
                Constants.IMAGES_NATURE + "/" + Constants.IMAGES_AUTUMN,
                Constants.IMAGES_NATURE + "/" + Constants.IMAGES_WINTER,
                Constants.IMAGES_NATURE + "/" + Constants.IMAGES_WINDOW_AND_VIEW,
                Constants.IMAGES_NATURE + "/" + Constants.IMAGES_ROCK_AND_WALL,
                Constants.IMAGES_NATURE + "/" + Constants.IMAGES_FOUR_SEASONS,
                Constants.IMAGES_NATURE + "/" + Constants.IMAGES_SEA_AND_BEACH,

                Constants.IMAGES_SPORT,

                Constants.IMAGES_SPRING_FLOWERS,

                Constants.IMAGES_BACKS_AND_BACKGROUNDS + "/" + Constants.IMAGES_3D,
                Constants.IMAGES_BACKS_AND_BACKGROUNDS + "/" + Constants.IMAGES_FLOWER_BACKS,
                Constants.IMAGES_BACKS_AND_BACKGROUNDS + "/" + Constants.IMAGES_COLOR_BACKS,
                Constants.IMAGES_BACKS_AND_BACKGROUNDS + "/" + Constants.IMAGES_3D_BACKS
        };

        for (String folderPath : folderPaths)
            folderMaker(folderPath);

        imageViewNature = findViewById(R.id.imageView_nature);
        imageViewFaceAndSport = findViewById(R.id.imageView_face_and_sport);
        imageViewBacksAndBackgrounds = findViewById(R.id.imageView_backs_and_3d_backgrounds);
        imageViewKid = findViewById(R.id.imageView_kid);
        imageViewCityAndClassic = findViewById(R.id.imageView_city_and_classic);
        imageViewLuxury2019 = findViewById(R.id.imageView_luxury_2019);
        imageViewGraphiteAndSpecialImages = findViewById(R.id.imageView_grahite_and_special_images);
        imageViewPaperFlowers = findViewById(R.id.imageView_paper_flowers);
        imageView3dFlowers = findViewById(R.id.imageView_3d_flowers);
        imageViewSport = findViewById(R.id.imageView_sport);
        imageViewAnimals = findViewById(R.id.imageView_animals);
        imageViewSpringFlowers = findViewById(R.id.imageView_spring_flowers);

        imageViewKid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, KidsCategoryActivity.class);
                i.putExtra(Constants.CATEGORY, Constants.IMAGES_KID);
                startActivity(i);
            }
        });

        imageViewGraphiteAndSpecialImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, GraphiteAndSpecialCategoryActivity.class);
                i.putExtra(Constants.CATEGORY, Constants.IMAGES_GRAPHITE_AND_SPECIAL);
                startActivity(i);
            }
        });

        imageViewNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, NatureCategoryActivity.class);
                i.putExtra(Constants.CATEGORY, Constants.IMAGES_NATURE);
                startActivity(i);
            }
        });

        imageViewFaceAndSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, FaceImagesAndSportCategoryActivity.class);
                i.putExtra(Constants.CATEGORY, Constants.IMAGES_FACE_AND_SPORT);
                startActivity(i);
            }
        });

        imageViewBacksAndBackgrounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, BackgroundsCategoryActivity.class);
                i.putExtra(Constants.CATEGORY, Constants.IMAGES_BACKS_AND_BACKGROUNDS);
                startActivity(i);
            }
        });

        imageViewCityAndClassic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, CityAndClassicCategoryActivity.class);
                i.putExtra(Constants.CATEGORY, Constants.IMAGES_CITY_AND_CLASSIC);
                startActivity(i);
            }
        });

        imageViewLuxury2019.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, ThumbnailsViewActivity.class);
                i.putExtra(Constants.CATEGORY, Constants.IMAGES_LUXURY_2019);
                startActivity(i);
            }
        });

        imageViewSpringFlowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, ThumbnailsViewActivity.class);
                i.putExtra(Constants.CATEGORY, Constants.IMAGES_SPRING_FLOWERS);
                startActivity(i);
            }
        });

        imageViewAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, ThumbnailsViewActivity.class);
                i.putExtra(Constants.CATEGORY, Constants.IMAGES_ANIMALS);
                startActivity(i);
            }
        });

        imageViewSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, ThumbnailsViewActivity.class);
                i.putExtra(Constants.CATEGORY, Constants.IMAGES_SPORT);
                startActivity(i);
            }
        });

        imageView3dFlowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, ThumbnailsViewActivity.class);
                i.putExtra(Constants.CATEGORY, Constants.IMAGES_3D_FLOWERS);
                startActivity(i);
            }
        });

        imageViewPaperFlowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCategoryActivity.this, ThumbnailsViewActivity.class);
                i.putExtra(Constants.CATEGORY, Constants.IMAGES_PAPER_FLOWERS);
                startActivity(i);
            }
        });
    }

    private void folderMaker(String folderPath) {
        File file = new File(getExternalFilesDir(Constants.JPG).getPath() + "/" + Constants.IMAGES + "/" +
                folderPath);
        if (!file.exists())
            file.mkdirs();
    }
}
