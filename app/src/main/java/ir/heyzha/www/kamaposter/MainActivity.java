package ir.heyzha.www.kamaposter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ssynhtn.waveview.WaveView;

public class MainActivity extends AppCompatActivity {

    WaveView waveView,waveView2;
    WaveView.WaveData waveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        waveView = findViewById(com.ssynhtn.waveview.R.id.wave_three);
        waveView.addDefaultWaves(2,2);
        waveData = new
                WaveView.WaveData(500, 100, 400, 0, Color.BLUE, Color.RED, 0.5f, 4000, false);
        waveView.addWaveData(waveData);

        waveView.startAnimation();
    }

    @Override
    protected void onResume() {
        super.onResume();

        waveView.resumeAnimation();
    }

    @Override
    protected void onPause() {
        super.onPause();

        waveView.pauseAnimation();
    }
}
