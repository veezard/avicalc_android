package com.veezard.avicalc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import static com.veezard.avicalc.JniInterfacingConstants.*;
public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    static {
        System.loadLibrary("android_glue");
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        JniInterfacingConstants.initialize();
        RustGlue.initialize(this);
        GuiHelpers.initialize();
        GuiHelpers.assignButtonsAdjustView(this);
    }
    @Override
    public boolean onTouch(View view, MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        }
        return true;
    }

    boolean assignButtonPressed = false;
    boolean addButtonPressed = false;
    boolean convButtonPressed = false;

    public void respondToButton(View view) {
        int viewId = view.getId();
        int rustButtonNumber ;
        view.setOnTouchListener(MainActivity.this);
        if (assignButtonPressed) {
           assignButtonPressed = false;
           if(assignPressedAndroidButtonIdToRustButtonNumber.containsKey(viewId)){
               rustButtonNumber = assignPressedAndroidButtonIdToRustButtonNumber.get(viewId);
               RustGlue.respondToButtonRust(rustButtonNumber);
            }
        }
        else if (addButtonPressed){
            addButtonPressed = false;
            if(addPressedAndroidButtonIdToRustButtonNumber.containsKey(viewId)){
                rustButtonNumber = addPressedAndroidButtonIdToRustButtonNumber.get(viewId);
                RustGlue.respondToButtonRust(rustButtonNumber);
            }

        }

        else if (convButtonPressed){
            convButtonPressed = false;
            GuiHelpers.draw_standard_symbols(this);
            if(convPressedAndroidButtonIdToRustButtonNumber.containsKey(viewId)){
                rustButtonNumber = convPressedAndroidButtonIdToRustButtonNumber.get(viewId);
                RustGlue.respondToButtonRust(rustButtonNumber);
            }

        }
        else if (viewId == assignButtonId){
            assignButtonPressed = true;
        }
        else if (viewId == addButtonId){
            addButtonPressed = true;
        }
        else if (viewId == convButtonId){
            convButtonPressed = true;
            GuiHelpers.draw_conv_symbols(this);
        }
        else {

            if(androidButtonIdToRustButtonNumber.containsKey(viewId)){
                rustButtonNumber = androidButtonIdToRustButtonNumber.get(viewId);
                RustGlue.respondToButtonRust(rustButtonNumber);
            }

        }


    }


}


