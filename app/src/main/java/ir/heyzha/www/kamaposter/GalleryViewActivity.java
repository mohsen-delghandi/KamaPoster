package ir.heyzha.www.kamaposter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

import com.veinhorn.scrollgalleryview.MediaInfo;
import com.veinhorn.scrollgalleryview.ScrollGalleryView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GalleryViewActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_activity_gallery);

        ImageView imageViewBack;
        imageViewBack = findViewById(R.id.imageView_back);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();
        String folderName = intent.getExtras().getString(Constants.CATEGORY);
        String folderPath = getExternalFilesDir(Constants.JPG).getPath() + "/" + Constants.IMAGES + "/";

        File file = new File(folderPath + folderName);
        String[] files = file.list();

        ArrayList<String> images = new ArrayList<>(files.length);
        for (String temporaryFile : files)
            images.add("file://" + folderPath + folderName + "/" + temporaryFile);


        List<MediaInfo> infos = new ArrayList<>(images.size());
        for (String url : images) infos.add(MediaInfo.mediaLoader(new PicassoImageLoader(url)));

        ScrollGalleryView scrollGalleryView = findViewById(R.id.scroll_gallery_view);
        scrollGalleryView
                .setThumbnailSize(175)
                .setZoom(false)
                .setFragmentManager(getSupportFragmentManager())
                .addMedia(infos)
                .setCurrentItem(intent.getExtras().getInt(Constants.POSITION));
    }
}
