package com.example.sensordemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mGyroscope;
    private TextView Input;
    private TextView Output;
    private int count = 0;
    private String finalOutput="";
    private float [][] data = new float[1][18];
    Interpreter tflite;
    Interpreter tflite2;
    String input ="";
    Boolean full = false;

    public MainActivity(){
        //

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        mSensorManager.registerListener(this, mGyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        Input = (TextView) findViewById(R.id.input);
        Output = (TextView) findViewById(R.id.output);

        Button button = (Button) findViewById(R.id.button);
        Button clear = (Button) findViewById(R.id.clear);
        Button a = (Button) findViewById((R.id.aButton));
        Button b = (Button) findViewById((R.id.bButton));
        Button c = (Button) findViewById((R.id.cButton));
        Button d = (Button) findViewById((R.id.dButton));
        Button e = (Button) findViewById((R.id.eButton));
        Button f = (Button) findViewById((R.id.fButton));
        Button g = (Button) findViewById((R.id.gButton));
        Button h = (Button) findViewById((R.id.hButton));
        Button i = (Button) findViewById((R.id.iButton));
        Button j = (Button) findViewById((R.id.jButton));
        Button k = (Button) findViewById((R.id.kButton));
        Button l = (Button) findViewById((R.id.lButton));
        Button m = (Button) findViewById((R.id.mButton));
        Button n = (Button) findViewById((R.id.nButton));
        Button o = (Button) findViewById((R.id.oButton));
        Button p = (Button) findViewById((R.id.pButton));
        Button q = (Button) findViewById((R.id.qButton));
        Button r = (Button) findViewById((R.id.rButton));
        Button s = (Button) findViewById((R.id.sButton));
        Button t = (Button) findViewById((R.id.tButton));
        Button u = (Button) findViewById((R.id.uButton));
        Button v = (Button) findViewById((R.id.vButton));
        Button w = (Button) findViewById((R.id.wButton));
        Button x = (Button) findViewById((R.id.xButton));
        Button y = (Button) findViewById((R.id.yButton));
        Button z = (Button) findViewById((R.id.zButton));
        Button space  = (Button)findViewById((R.id.space));

        try{
            tflite = new Interpreter(loadModelFile());
        } catch (IOException ee) {
            ee.printStackTrace();
        }
        try{
            tflite2 = new Interpreter(loadModelFile2());
        } catch (IOException ee) {
            ee.printStackTrace();
        }
        space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + " ";
                Input.setText(input);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Output.setText(finalOutput);

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input="";
                finalOutput="";
                Input.setText("Your Letter");
                Output.setText("Output");

            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "a";
                Input.setText(input);

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "b";
                Input.setText(input);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "c";
                Input.setText(input);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "d";
                Input.setText(input);
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "e";
                Input.setText(input);
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "f";
                Input.setText(input);
            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "g";
                Input.setText(input);
            }
        });
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "h";
                Input.setText(input);
            }
        });
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "i";
                Input.setText(input);
            }
        });
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "j";
                Input.setText(input);
            }
        });
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "k";
                Input.setText(input);
            }
        });
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "l";
                Input.setText(input);
            }
        });
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "m";
                Input.setText(input);
            }
        });
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "n";
                Input.setText(input);
            }
        });
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "o";
                Input.setText(input);
            }
        });
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "p";
                Input.setText(input);
            }
        });
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "q";
                Input.setText(input);
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "r";
                Input.setText(input);
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "s";
                Input.setText(input);
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "t";
                Input.setText(input);
            }
        });
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "u";
                Input.setText(input);
            }
        });
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "v";
                Input.setText(input);
            }
        });
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "w";
                Input.setText(input);
            }
        });
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "x";
                Input.setText(input);
            }
        });
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "y";
                Input.setText(input);
            }
        });
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + "z";
                Input.setText(input);
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        data[0][count] = event.values[0];
        data[0][count+1] = event.values[1];
        data[0][count+2] = event.values[2];
        count += 3;
        System.out.println(count);

        System.out.println("SSSSSSAAAAAAAAAAAAAADDDDDDDDDD");
        if(count == 15)
        {

            count = 0;


            float [] arr = inference();
            System.out.println(arr[0]);
            System.out.println(arr[1]);
            if(arr[0] > .3)
            {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                float [] arr2 = inference2();
                finalOutput = finalOutput+letter(arr2);
            }

        }



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    private MappedByteBuffer loadModelFile() throws IOException{
        AssetFileDescriptor fileDescriptor = this.getAssets().openFd("model/model_id2.tflite");
        FileInputStream fileInputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel =fileInputStream.getChannel();
        long startOffSets = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY,startOffSets,declaredLength);
    }
    private MappedByteBuffer loadModelFile2() throws IOException{
        AssetFileDescriptor fileDescriptor = this.getAssets().openFd("model/model_kp2.tflite");
        FileInputStream fileInputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel =fileInputStream.getChannel();
        long startOffSets = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY,startOffSets,declaredLength);
    }
    public float[] inference(){
        //{0.25757468, 0.3120915, -0.024509924, -0.02205725, 0.35949576, 0.022894345, -0.3448324, -0.3457093, -0.06445734, -0.39543244, -0.57101274, -0.10973108, -0.24682805, -0.18645227, -0.04528258, -0.0076761795, 0.050036434, 0.015437493}
        //block of data
        float[][] outputValue = new float[1][2];
        tflite.run(data,outputValue);
        System.out.println("SSSSSSSSSSASDASDDDDDDDDDDDDD");
        float [] inferedValue = outputValue[0];
        return inferedValue;
    }

    public float[] inference2(){
        //{0.25757468, 0.3120915, -0.024509924, -0.02205725, 0.35949576, 0.022894345, -0.3448324, -0.3457093, -0.06445734, -0.39543244, -0.57101274, -0.10973108, -0.24682805, -0.18645227, -0.04528258, -0.0076761795, 0.050036434, 0.015437493}
        //block of data
        float[][] outputValue = new float[1][27];
        tflite2.run(data,outputValue);
        float [] inferedValue = outputValue[0];
        return inferedValue;
    }
    public char letter(float[]datablock)
    {
        int ascii = 65;
        int size = 18;
        float temp;
        int largest = 0;
        for ( int i = 1; i < size; i++ )
        {
            if ( datablock[i] > datablock[largest] ) largest = i;
        }
        if(largest ==26)
        {
            return (char)26;
        }
        else {
            ascii = ascii + largest;
        }
        System.out.println((char)ascii);
        return (char)ascii;
    }
}