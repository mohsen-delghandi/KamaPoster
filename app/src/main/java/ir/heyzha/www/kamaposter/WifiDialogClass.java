package ir.heyzha.www.kamaposter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.TableLayout;
import android.widget.TextView;

/**
 * Created by Mohsen on 2017-07-15.
 */

public class WifiDialogClass extends Dialog implements
        android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public TextView yes,no;
    TableLayout tlMain;

    public WifiDialogClass(Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.wifi_dialog_layout);
        tlMain = (TableLayout)findViewById(R.id.tableLayout_main);
        yes = (TextView) findViewById(R.id.textView_ok);
        no = (TextView) findViewById(R.id.textView_cancel);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        TextView tv = (TextView)findViewById(R.id.textView_wifiConnection);
        tv.setText(Html.fromHtml("<p style=\"text-align:justify;\"> دوست عزیز، متاسفانه ارتباط شبکه برقرار نیست،برای اتصال، تنظیمات وای‌فای را بررسی کنید." +
                "  </p>\n"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView_ok:
                c.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                dismiss();
                break;
            case R.id.textView_cancel:
                dismiss();
                break;
            default:
                break;
        }
    }

}