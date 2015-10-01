package jaysoncarter.spellingchecker;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button b1;
    TextView tv1;
    EditText ed1;
    private SpellCheckerSession mScs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        tv1 = (TextView) findViewById(R.id.textView3);

        ed1 = (EditText) findViewById(R.id.editText);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), ed1.getText().toString(), Toast.LENGTH_SHORT).show();
                mScs.getSuggestions(new TextInfo(ed1.getText().toString()), 3);
            }
        });
    }

    public void onResume(){
        super.onResume();
        final TextServicesManager tsm = (TextServicesManager) getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        mScs = tsm.newSpellCheckerSession(null, null, , true);
    }

    public void onPause(){
        super.onPause();
        if (mScs != null){
            mScs.close();
        }
    }

    public void onGetSuggestions(final SuggestionsInfo[] arg0){
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arg0.length; i++) {
            // Returned suggestions are contained in SuggestionInfo
            final int len = arg0[i].getSuggestionsCount();
            sb.append('\n');

            for (int j = 0; j < len; j++) {
                sb.append(", " + arg0[i].getSuggestionAt(j));
            }

            sb.append(" (" + len + ")");
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv1.append(sb.toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
