package pizzastuff.ed.kiel.pizzaordering;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity{

    private Button button_1, button_2;
    private RadioGroup radioGroup;
    private RadioButton radioButton1, radioButton2, radioButton3;
    private CheckBox checkBox_1,checkBox_2,checkBox_3;
    private ToggleButton toggleButton_1;
    private EditText newEditText;
    private TextView txtView;

    boolean clickAble = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_1 = (Button)findViewById(R.id.button_1);
        button_2 = (Button)findViewById(R.id.orderButton);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioButton1 = (RadioButton)findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton)findViewById(R.id.radioButton3);
        txtView = (TextView)findViewById(R.id.oderText);
        radioGroup.setEnabled(true);

        checkBox_1 = (CheckBox) findViewById(R.id.checkBox_1);
        checkBox_2 = (CheckBox) findViewById(R.id.checkBox_2);
        checkBox_3 = (CheckBox) findViewById(R.id.checkBox_3);

        toggleButton_1 = (ToggleButton)findViewById(R.id.myToggleButton);
        newEditText = (EditText)findViewById(R.id.editText3);

        button_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str = "";
                if (clickAble) {
                    if (radioButton1.isChecked()) {
                        str = radioButton1.getText().toString();
                    } else if (radioButton2.isChecked()) {
                        str = radioButton2.getText().toString();
                    } else if (radioButton3.isChecked()) {
                        str = radioButton3.getText().toString();
                    }

                    if (checkBox_1.isChecked()) {
                        str = str + " " + checkBox_1.getText().toString();
                    }
                    if (checkBox_2.isChecked()) {
                        str = str + " " + checkBox_2.getText().toString();
                    }
                    if (checkBox_3.isChecked()) {
                        str = str + " " + checkBox_3.getText().toString();
                    }

                    if (toggleButton_1.isChecked()) {
                        str = str + " " + "want extra chess";
                    } else {
                        str = str + " " + "does not want extra chess";
                    }
                }

                Toast.makeText(getApplicationContext(), str,Toast.LENGTH_SHORT).show();

                LinearLayout layout = (LinearLayout) findViewById(R.id.orderLayout);
                layout.setVisibility(View.VISIBLE);
                txtView.setText(str);
                clickAble = false;
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.scroleRelative);
                relativeLayout.setVisibility(View.INVISIBLE);
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickAble = true;

                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.scroleRelative);
                relativeLayout.setVisibility(View.VISIBLE);
                LinearLayout layout = (LinearLayout) findViewById(R.id.orderLayout);
                layout.setVisibility(View.INVISIBLE);

            }
        });
    }
}
