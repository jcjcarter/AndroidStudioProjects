package jaysoncarter.rssreader;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by tz6ysq on 9/28/2015.
 */
public class second extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        WebView w1 = (WebView) findViewById(R.id.webView);
        w1.loadUrl("http://tutorialspoint.com/android/sampleXML.xml");
    }
}
