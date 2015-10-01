package jaysoncarter.sessionmanagement;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by TZ6YSQ on 9/29/2015.
 */
public class second_main  extends Activity{

    Button bu = null;
    Button bu2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        bu = (Button) findViewById(R.id.button2);
        bu2 = (Button)findViewById(R.id.button3);
    }

    public void logout(View view){
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.MyPRERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public void close(View view){
        finish();
    }
}
