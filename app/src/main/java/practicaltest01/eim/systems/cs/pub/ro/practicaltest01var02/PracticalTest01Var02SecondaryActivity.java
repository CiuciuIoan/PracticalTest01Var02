package practicaltest01.eim.systems.cs.pub.ro.practicaltest01var02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var02SecondaryActivity extends AppCompatActivity {

    TextView result2;

    Button yes, no;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.yes:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.no:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_secondary);

        result2 = (TextView)findViewById(R.id.resultSecond);
        yes = (Button)findViewById(R.id.yes);
        no = (Button)findViewById(R.id.no);

        yes.setOnClickListener(buttonClickListener);
        no.setOnClickListener(buttonClickListener);

        Intent intent =  getIntent();

        if (intent != null && intent.getExtras().containsKey("myText")) {
            String str = intent.getStringExtra("myText");
            result2.setText(str);
        }

    }
}
