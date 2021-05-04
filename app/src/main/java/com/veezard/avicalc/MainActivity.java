package com.veezard.avicalc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import static com.veezard.avicalc.JniInterfacingConstants.*;
public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("android_glue");
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        JniInterfacingConstants.initialize();
        RustGlue.initialize(this);
        GuiHelpers.initialize();
        GuiHelpers.assignButtonsAdjustView(this);
    }


    boolean assignButtonPressed = false;
    boolean addButtonPressed = false;
    boolean convButtonPressed = false;


    public void respondToButton(View view) {
        int viewId = view.getId();
        int rustButtonNumber ;

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


