package com.example.sensordemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mGyroscope;
    private TextView tvXgyro;
    private TextView tvYgyro;
    private TextView tvZgyro;
    private int btnFlag = 0;

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
        mSensorManager.registerListener(this, mGyroscope, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Float axisX = event.values[0];
        Float axisY = event.values[1];
        Float axisZ = event.values[2];

        tvXgyro.setText(axisX.toString());
        tvYgyro.setText(axisY.toString());
        tvZgyro.setText(axisZ.toString());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}