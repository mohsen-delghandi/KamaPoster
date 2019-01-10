package ir.heyzha.www.kamaposter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(BaseActivity.this,VideoActivity.class);
                startActivity(intent);
                stopHandler();
            }
        };
        startHandler();
    }

    public void stopHandler() {
        handler.removeCallbacks(runnable);
    }

    public void startHandler() {
        handler.postDelayed(runnable, 3000);
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        stopHandler();
        startHandler();
    }

    @Override
    protected void onResume() {
        startHandler();
        super.onResume();
    }

    @Override
    protected void onPause() {
        stopHandler();
        super.onPause();
    }
}
