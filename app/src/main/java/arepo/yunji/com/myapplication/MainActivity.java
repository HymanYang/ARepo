package arepo.yunji.com.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import arepo.yunji.com.common.RepoLibUtils;


/**
 * 测试Activity
 *
 * @author zz
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                testJsonAdapter();
            }
        });


        TextView textView = findViewById(R.id.txt);
        textView.setText("Value:" + RepoLibUtils.getLibStr());


        testPingLib();
    }

    private void testPingLib() {

        //Class pName = P_T01.class;

        //String from = PMainLib.isFrom();

    }


    public void testJsonAdapter() {

        double vD = 45.4545d;
        float vF = 46.232323f;
        int vI = 47;
        long vL = 48L;
        String vS = "49.8";


        Log.e("JSON=result=", vD + "=double");
        Log.e("JSON=result=", vF + "=float");
        Log.e("JSON=result=", vI + "=int");
        Log.e("JSON=result=", vL + "=long");


        String cT = vL + "";

//        cT = "\"" + cT + "\"";

        String json = "{\"booleanStr\":true," +
                "\"doubleStr\":" + cT + "," +
                "\"floadStr\":" + cT + "," +
                "\"intStr\":" + cT + "," +
                "\"longStr\":" + cT + "," +
                "\"strStr\":" + cT + "}";

        Log.e("JSON=preview=", json);

        GsonParseInfo info = GsonUtils.getInstance().fromJson(json, GsonParseInfo.class);

        Log.e("JSON=result=", info.toString());

    }

}
