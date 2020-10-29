package com.example.sensordemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mGyroscope;
    private TextView tvXgyro;
    private TextView tvYgyro;
    private TextView tvZgyro;
    private TextView tvBtnNum;
    private Integer btnFlag = 0;
    private Button btn1;
    private Button btn2;

    public MainActivity(){
        //

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        tvXgyro = (TextView)findViewById(R.id.xGyro);
        tvYgyro = (TextView)findViewById(R.id.yGyro);
        tvZgyro = (TextView)findViewById(R.id.zGyro);
        tvBtnNum = (TextView)findViewById(R.id.btnNum);
        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                btnFlag = 1;
            }
        });
        btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                btnFlag = 2;
            }
        });
        mSensorManager.registerListener(this, mGyroscope, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(btnFlag>0) {

            Float axisX = event.values[0];
            Float axisY = event.values[1];
            Float axisZ = event.values[2];

            tvBtnNum.setText(btnFlag.toString());
            btnFlag = 0;
            tvXgyro.setText(axisX.toString());
            tvYgyro.setText(axisY.toString());
            tvZgyro.setText(axisZ.toString());
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}