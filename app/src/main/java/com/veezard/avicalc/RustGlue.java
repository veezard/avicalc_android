package com.veezard.avicalc;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

import static com.veezard.avicalc.JniInterfacingConstants.*;

public class RustGlue {

    private static MainActivity mainActivity;

    public static native void respondToButtonRust(int button_number);
    private static native void initializeRust();

    public static void initialize(MainActivity mainActivity){
        RustGlue.mainActivity = mainActivity;
        initializeRust();
    }


    public static void update_field(int field, String val){
        TextView textView;
        Button buttonView;
        int buttonId;
        switch(field){
            case ENTRY_FIELD_UPDATE_NUMBER:
                textView = RustGlue.mainActivity.findViewById(R.id.entry_field);
                textView.setText(val);
                break;
            case PREVIOUS_ENTRY_FIELD_UPDATE_NUMBER:
                textView = RustGlue.mainActivity.findViewById(R.id.prev_entry_field);
                textView.setText(val);
                break;
            case ANS_UPDATE_NUMBER:
                textView = RustGlue.mainActivity.findViewById(R.id.answer_field);
                textView.setText(val);
                break;

            case A_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(A_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("a\n" + val);
                break;
            case B_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(B_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("b\n" + val);
                break;
            case C_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(C_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("c\n" + val);
                break;
            case TEMP_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(TEMP_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("TEMP\n" + val);
                break;
            case ALTITUDE_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(ALTITUDE_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("ALT\n" + val);
                break;
            case ALTIMETER_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(ALTIMETER_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("PRES\n" + val);
                break;
            case WIND_SPEED_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(WIND_SPEED_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("WND\nSPD\n" + val);
                break;
            case WIND_HEADING_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(WIND_HEADING_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("WND\nDIR\n" + val);
                break;
            case HEADING_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(HEADING_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("HDG\n" + val);
                break;
            case INDICATED_AIRSPEED_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(INDICATED_AIRSPEED_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("IAS\n" + val);
                break;
            case PRESSURE_ALTITUDE_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(PRESSURE_ALTITUDE_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("PRES\nALT\n" + val);
                break;
            case DENSITY_ALTITUDE_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(DENSITY_ALTITUDE_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("DENS\nALT\n" + val);
                break;
            case HEAD_WIND_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(HEAD_WIND_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("HD\nWND\n" + val);
                break;
            case CROSS_WIND_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(CROSS_WIND_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("CRS\nWND\n" + val);
                break;
            case DEVIATION_ANGLE_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(DEVIATION_ANGLE_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("DEV\nANG\n" + val);
                break;
            case TRUE_AIRSPEED_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(TRUE_AIRSPEED_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("TAS\n" + val);
                break;
            case GROUND_SPEED_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(GROUND_SPEED_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("GSPD\n" + val);
                break;
            case DEWPOINT_UPDATE_NUMBER:
                buttonId=androidButtonIdToRustButtonNumber.inverse().get(DEW_POINT_BUTTON);
                textView = RustGlue.mainActivity.findViewById(buttonId);
                textView.setText("DWPT\n" + val);
                break;
            default:
                return;

        }

    }

}
