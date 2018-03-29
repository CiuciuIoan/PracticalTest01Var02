package practicaltest01.eim.systems.cs.pub.ro.practicaltest01var02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PracticalTest01Var02MainActivity extends AppCompatActivity {

    Button plus, minus, goToSecond;
    TextView result;
    EditText firstNumber, secondNumber;

    private ButtonListener1 buttonListener1 = new ButtonListener1();
    private class ButtonListener1 implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String first, second, concat;
            int res;

            res = Integer.parseInt(firstNumber.getText().toString()) +
                    Integer.parseInt(secondNumber.getText().toString());
            first = firstNumber.getText().toString();
            second = secondNumber.getText().toString();
            concat = first + " + " + second + " = " + String.valueOf(res) ;
            result.setText(concat);
        }
    }

    private ButtonListener2 buttonListener2 = new ButtonListener2();
    private class ButtonListener2 implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String first, second, concat;
            int res;
            res = Integer.parseInt(firstNumber.getText().toString()) -
                    Integer.parseInt(secondNumber.getText().toString());
            first = firstNumber.getText().toString();
            second = secondNumber.getText().toString();
            concat = first + " - " + second + " = " + String.valueOf(res);
            result.setText(concat);
        }
    }

    private NextActivityListener nextActivityListener = new NextActivityListener();
    private class NextActivityListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02SecondaryActivity.class);
            String str = result.getText().toString();

            intent.putExtra("myText", str);
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_main);

        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        plus.setOnClickListener(buttonListener1);
        minus.setOnClickListener(buttonListener2);

        result = (TextView)findViewById(R.id.result);

        firstNumber = (EditText)findViewById(R.id.firstNumber);
        secondNumber = (EditText)findViewById(R.id.secondNumber);

        goToSecond = (Button)findViewById(R.id.goToSecond);
        goToSecond.setOnClickListener(nextActivityListener);

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("result", result.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        if (savedInstanceState.containsKey("result")) {
            result.setText(savedInstanceState.getString("result"));
        } else {
            result.setText(String.valueOf(0));
        }
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent intent) {
        if (requestCode == 1) {
            Toast.makeText(this, "Result: " + resultCode, Toast.LENGTH_LONG).show();
        }
    }

}
