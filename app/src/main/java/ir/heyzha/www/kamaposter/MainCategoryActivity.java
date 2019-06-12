package ir.heyzha.www.kamaposter;

import android.Manifest;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    private WebService mTService;
    String versionCode;

    private long enqueue;
    private DownloadManager dm;

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                    checkVersion(versionCode);
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(MainCategoryActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_category_main);

        WebProvider provider = new WebProvider();
        mTService = provider.getTService();

        try {
            versionCode = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode + "";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

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
        ActivityCompat.requestPermissions(MainCategoryActivity.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                1);
    }

    /**
     * Used to download the file from url.
     * <p/>
     * 1. Download the file using Download Manager.
     *
     * @param url      Url.
     * @param fileName File Name.
     */
    public void downloadFile(final Activity activity, final String url, final String fileName) {
        try {
            if (url != null && !url.isEmpty()) {
                Uri uri = Uri.parse(url);
                activity.registerReceiver(attachmentDownloadCompleteReceive, new IntentFilter(
                        DownloadManager.ACTION_DOWNLOAD_COMPLETE));

                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setMimeType(getMimeType(uri.toString()));
                request.setTitle(fileName);
                request.setDescription("Downloading attachment..");
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
                DownloadManager dm = (DownloadManager) activity.getSystemService(Context.DOWNLOAD_SERVICE);
                dm.enqueue(request);
            }
        } catch (IllegalStateException e) {
            Toast.makeText(activity, "Please insert an SD card to download file", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * Used to get MimeType from url.
     *
     * @param url Url.
     * @return Mime Type for the given url.
     */
    private String getMimeType(String url) {
        String type = null;
        String extension = MimeTypeMap.getFileExtensionFromUrl(url);
        if (extension != null) {
            MimeTypeMap mime = MimeTypeMap.getSingleton();
            type = mime.getMimeTypeFromExtension(extension);
        }
        return type;
    }

    /**
     * Attachment download complete receiver.
     * <p/>
     * 1. Receiver gets called once attachment download completed.
     * 2. Open the downloaded file.
     */
    BroadcastReceiver attachmentDownloadCompleteReceive = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
                long downloadId = intent.getLongExtra(
                        DownloadManager.EXTRA_DOWNLOAD_ID, 0);
                openDownloadedAttachment(context, downloadId);
            }
        }
    };

    /**
     * Used to open the downloaded attachment.
     *
     * @param context    Content.
     * @param downloadId Id of the downloaded file to open.
     */
    private void openDownloadedAttachment(final Context context, final long downloadId) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(downloadId);
        Cursor cursor = downloadManager.query(query);
        if (cursor.moveToFirst()) {
            int downloadStatus = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));
            String downloadLocalUri = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
            String downloadMimeType = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_MEDIA_TYPE));
            if ((downloadStatus == DownloadManager.STATUS_SUCCESSFUL) && downloadLocalUri != null) {
                openDownloadedAttachment(context, Uri.parse(downloadLocalUri), downloadMimeType);
            }
        }
        cursor.close();
    }

    /**
     * Used to open the downloaded attachment.
     * <p/>
     * 1. Fire intent to open download file using external application.
     * <p>
     * 2. Note:
     * 2.a. We can't share fileUri directly to other application (because we will get FileUriExposedException from Android7.0).
     * 2.b. Hence we can only share content uri with other application.
     * 2.c. We must have declared FileProvider in manifest.
     * 2.c. Refer - https://developer.android.com/reference/android/support/v4/content/FileProvider.html
     *
     * @param context            Context.
     * @param attachmentUri      Uri of the downloaded attachment to be opened.
     * @param attachmentMimeType MimeType of the downloaded attachment.
     */
    private void openDownloadedAttachment(final Context context, Uri attachmentUri, final String attachmentMimeType) {
        if (attachmentUri != null) {
            // Get Content Uri.
            if (ContentResolver.SCHEME_FILE.equals(attachmentUri.getScheme())) {
                // FileUri - Convert it to contentUri.
                File file = new File(attachmentUri.getPath());
                attachmentUri = FileProvider.getUriForFile(MainCategoryActivity.this, BuildConfig.APPLICATION_ID, file);
                ;
            }

            Intent openAttachmentIntent = new Intent(Intent.ACTION_VIEW);
            openAttachmentIntent.setDataAndType(attachmentUri, attachmentMimeType);
            openAttachmentIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            try {
                context.startActivity(openAttachmentIntent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(context, "noooooooooo", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void folderMaker(String folderPath) {
        File file = new File(getExternalFilesDir(Constants.JPG).getPath() + "/" + Constants.IMAGES + "/" +
                folderPath);
        if (!file.exists())
            file.mkdirs();
    }

    private void checkVersion(final String versionCode) {
        Call<VersionModel> call = mTService.checkVersion(versionCode);
        call.enqueue(new Callback<VersionModel>() {
            @Override
            public void onResponse(Call<VersionModel> call, final Response<VersionModel> response) {

                if (response.body().force_dl) {
                    new AlertDialog.Builder(MainCategoryActivity.this)
                            .setTitle("نسخه جدید")
                            .setMessage("آیا می‌خواهید به‌روزرسانی انجام شود؟")

                            .setPositiveButton("تایید", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    downloadFile(MainCategoryActivity.this, response.body().download_url, "kama.apk");

                                }
                            })
                            .setNegativeButton("لغو", null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }

            @Override
            public void onFailure(Call<VersionModel> call, Throwable t) {
                checkVersion(versionCode);
            }
        });
    }

}
