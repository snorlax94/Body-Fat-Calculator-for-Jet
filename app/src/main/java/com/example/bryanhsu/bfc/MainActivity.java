package com.example.bryanhsu.bfc;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView weight;
    TextView waist;
    TextView input_weight;
    TextView input_waist;
    TextView result;
    Button calculate;
    int count_weight = 150;
    int count_waist = 30;
    boolean weight_check = false;
    boolean waist_check = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = (TextView) findViewById(R.id.weight);
        waist = (TextView) findViewById(R.id.waist);
        result = (TextView) findViewById(R.id.result);
        input_weight = (TextView) findViewById(R.id.input_weight);
        input_waist = (TextView) findViewById(R.id.input_waist);
        calculate = (Button) findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double weight_r;
                double waist_r;
                double result_1;
                double result_2;
                double final_result;


                weight_r = Double.parseDouble((String) input_weight.getText());


                result_1 = (weight_r * 1.082) + 94.42;

                waist_r = Double.parseDouble((String) input_waist.getText());
                result_2 = waist_r * 4.15;
                result_2 = result_1 - result_2;

                final_result = ((weight_r - result_2) * 100) / weight_r;
                if (final_result < 0) {
                    final_result = final_result * -1;
                }

                // DecimalFormat df = new DecimalFormat("##.#");
                //df.format(final_result);

                result.setText("BFI " + String.valueOf(final_result).substring(0, 5) + "%");
                //result.setText("BFI: " + 8.95 + "%");
            }

        });

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (weight_check) {
                    count_weight++;
                    input_weight.setText(String.valueOf(count_weight));
                } else if (waist_check) {
                    count_waist++;
                    input_waist.setText(String.valueOf(count_waist));
                }
                return true;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (weight_check) {
                    count_weight--;
                    input_weight.setText(String.valueOf(count_weight));
                } else if (waist_check) {
                    count_waist--;
                    input_waist.setText(String.valueOf(count_waist));
                }
                return true;
            case KeyEvent.KEYCODE_DPAD_UP:
                input_weight.setTextColor(Color.rgb(255, 179, 0));
                weight.setTextColor(Color.rgb(255, 179, 0));
                input_waist.setTextColor(0xffffffff);
                waist.setTextColor(0xffffffff);
                weight_check = true;
                waist_check = false;
                return true;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                input_waist.setTextColor(Color.rgb(255, 179, 0));
                waist.setTextColor(Color.rgb(255, 179, 0));
                input_weight.setTextColor(0xffffffff);
                weight.setTextColor(0xffffffff);
                waist_check = true;
                weight_check = false;
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }


}








