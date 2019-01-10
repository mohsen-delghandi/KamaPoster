package ir.heyzha.www.kamaposter;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.VideoView;

import java.io.File;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onPause() {
        videoView.stopPlayback();
        finish();
        super.onPause();
    }

    @Override
    public void onUserInteraction() {
        videoView.stopPlayback();
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        videoView = findViewById(R.id.videoView);

        File file = new File(getExternalFilesDir(Constants.MP4).getPath());
        String[] fileName = file.list();

        if (fileName.length > 0) {
            Uri uri = Uri.parse(getExternalFilesDir(Constants.MP4).getPath() + "/" + fileName[0]);
            videoView.setVideoURI(uri);
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.setLooping(true);
                }
            });
            videoView.start();
        }
    }
}
