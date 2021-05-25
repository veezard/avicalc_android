package com.veezard.avicalc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.util.HashSet;
import java.util.Set;

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
        Help.initialize(this);
        TextView last_conv_operation_display = this.findViewById(R.id.last_conv_operation);
        last_conv_operation_display.setText("");

        View outer_layout = this.findViewById(R.id.main_container_layout);
        for(View buttonView : return_buttons_recursively(outer_layout)){
            buttonView.setOnTouchListener(MainActivity.this);
        }

        this.findViewById(R.id.help_close_button).setOnTouchListener(MainActivity.this);


        GuiHelpers.colorButtons(this);
        ((TextView)this.findViewById(R.id.help_body)).setMovementMethod(new ScrollingMovementMethod());


        SharedPreferences settings = this.getPreferences(0);
        if (settings.getBoolean("first time running", true)){
            this.helpButtonPressed=true;
            respondToButton(this.findViewById(helpButtonId));
            settings.edit().putBoolean("first time running", false).commit();

        }

    }

    private Set<View> return_buttons_recursively(View layout_view){
        Set<View> button_ids= new HashSet<View>();
        if (layout_view instanceof ViewGroup){
            ViewGroup layout = (ViewGroup) layout_view;
            for (int i=0; i<  layout.getChildCount(); i++) {
                View child = layout.getChildAt(i);
                    if(child instanceof Button){
                        button_ids.add(child);
                    }
                    else if(child instanceof ViewGroup){
                        button_ids.addAll(return_buttons_recursively(child));
                    }
            }
        }
        return button_ids;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN & (view instanceof Button) ){
            view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
            respondToButton(view);
        }
        return true;
    }

    boolean assignButtonPressed = false;
    boolean addButtonPressed = false;
    boolean convButtonPressed = false;
    boolean helpButtonPressed = false;

    public void respondToButton(View view) {
        int viewId = view.getId();
        int rustButtonNumber ;
        Help.HelpText helpText;

        if (viewId == R.id.help_close_button) {
            this.findViewById(R.id.help_window).setVisibility(View.INVISIBLE);
            return ;
        }
        if (convButtonPressed){
            convButtonPressed = false;
            this.findViewById(convButtonId).setBackgroundResource(R.drawable.button_conv);
            if(convPressedAndroidButtonIdToRustButtonNumber.containsKey(viewId)){
                rustButtonNumber = convPressedAndroidButtonIdToRustButtonNumber.get(viewId);
                RustGlue.respondToButtonRust(rustButtonNumber);
                if(GuiHelpers.conversionLabels.containsKey(rustButtonNumber)) {
                    TextView last_conv_operation_display = this.findViewById(R.id.last_conv_operation);
                    last_conv_operation_display.setText(GuiHelpers.conversionLabels.get(rustButtonNumber));
                }
            }
            return;
        }
        if (helpButtonPressed){
            helpButtonPressed=false;
            this.findViewById(helpButtonId).setBackgroundResource(R.drawable.button_help);

            helpText = Help.help_text(viewId);
            ((TextView)this.findViewById(R.id.help_title)).setText(helpText.title);
            ((TextView)this.findViewById(R.id.help_body)).setText(helpText.body);

            this.findViewById(R.id.help_window).setVisibility(View.VISIBLE);
            return;
        }

        if (viewId == convButtonId){
            convButtonPressed = true;
            this.findViewById(convButtonId).setBackgroundResource(R.drawable.button_conv_pressed);
        }
        else if (viewId == helpButtonId) {
            if(helpButtonPressed){
                helpButtonPressed=false;
                this.findViewById(helpButtonId).setBackgroundResource(R.drawable.button_help);
            }
            else {
                helpButtonPressed=true;
                this.findViewById(helpButtonId).setBackgroundResource(R.drawable.button_help_pressed);
            }
        }
        else if (viewId == assignButtonId){
            if(assignButtonPressed) {
                assignButtonPressed=false;
                this.findViewById(assignButtonId).setBackgroundResource(R.drawable.button_assign);
            }
            else {
                assignButtonPressed=true;
                addButtonPressed=false;
                this.findViewById(assignButtonId).setBackgroundResource(R.drawable.button_assign_pressed);
                this.findViewById(addButtonId).setBackgroundResource(R.drawable.button_assign);
            }
        }
        else if (viewId ==addButtonId){
            if(addButtonPressed) {
                addButtonPressed=false;
                this.findViewById(addButtonId).setBackgroundResource(R.drawable.button_assign);
            }
            else {
                addButtonPressed=true;
                assignButtonPressed=false;
                this.findViewById(addButtonId).setBackgroundResource(R.drawable.button_assign_pressed);
                this.findViewById(assignButtonId).setBackgroundResource(R.drawable.button_assign);
            }
        }


       else if(assignPressedAndroidButtonIdToRustButtonNumber.containsKey(viewId)){

           if (assignButtonPressed) {
               rustButtonNumber = assignPressedAndroidButtonIdToRustButtonNumber.get(viewId);
               TextView last_conv_operation_display = this.findViewById(R.id.last_conv_operation);
               last_conv_operation_display.setText("");
           }
           else if (addButtonPressed){
               rustButtonNumber = addPressedAndroidButtonIdToRustButtonNumber.get(viewId);
               TextView last_conv_operation_display = this.findViewById(R.id.last_conv_operation);
               last_conv_operation_display.setText("");
           }
           else {
               rustButtonNumber = androidButtonIdToRustButtonNumber.get(viewId);
           }
           RustGlue.respondToButtonRust(rustButtonNumber);
        }

       else {
            rustButtonNumber = androidButtonIdToRustButtonNumber.get(viewId);
            RustGlue.respondToButtonRust(rustButtonNumber);

            if (rustButtonNumber==EQUALS_BUTTON) {
                TextView last_conv_operation_display = this.findViewById(R.id.last_conv_operation);
                last_conv_operation_display.setText("");
            }
        }


    }


}


