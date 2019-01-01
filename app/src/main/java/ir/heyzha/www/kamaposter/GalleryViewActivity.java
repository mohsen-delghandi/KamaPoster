package ir.heyzha.www.kamaposter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.veinhorn.scrollgalleryview.MediaInfo;
import com.veinhorn.scrollgalleryview.ScrollGalleryView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GalleryViewActivity extends FragmentActivity {


    private ScrollGalleryView scrollGalleryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_activity_gallery);

        ArrayList<String> images = new ArrayList<>(Arrays.asList(
                getFilesDir().getPath() +"/images_luxury_2019/A3000-copy.jpg",
                "https://dkstatics-public.digikala.com/digikala-adservice-banners/5221.jpg",
                "https://dkstatics-public.digikala.com/digikala-adservice-banners/5217.jpg",
                "https://dkstatics-public.digikala.com/digikala-adservice-banners/5262.jpg"
        ));

        Toast.makeText(this, getFilesDir().getPath() +"/images_luxury_2019/A3000-copy.jpg", Toast.LENGTH_SHORT).show();

        List<MediaInfo> infos = new ArrayList<>(images.size());
        for (String url : images) infos.add(MediaInfo.mediaLoader(new PicassoImageLoader(url)));

        scrollGalleryView = findViewById(R.id.scroll_gallery_view);
        scrollGalleryView
                .setThumbnailSize(100)
                .setZoom(false)
                .setFragmentManager(getSupportFragmentManager())
                .addMedia(infos);
    }
}
