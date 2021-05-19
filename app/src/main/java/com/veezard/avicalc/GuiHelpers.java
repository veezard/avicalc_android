package com.veezard.avicalc;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.veezard.avicalc.JniInterfacingConstants.*;

public class GuiHelpers {

    static Map<Integer, String> conversionLabels;
    static Map<Integer, String> standardLabels;

    static Set<Integer> assignableButtons;

    public static void initialize() {
        conversionLabels = new HashMap();
        standardLabels = new HashMap();
        assignableButtons= new HashSet();

        conversionLabels.put(NM_TO_FEET_BUTTON, "nm>\nft");
        conversionLabels.put(FEET_TO_NM_BUTTON, "ft>\nnm");
        conversionLabels.put(KNOTS_TO_FPM_BUTTON, "kn>\nfpm");
        conversionLabels.put(FPM_TO_KNOTS_BUTTON, "fpm>\nkn");
        conversionLabels.put(KPH_TO_MPM_BUTTON, "kph>\nmpm");
        conversionLabels.put(MPM_TO_KPH_BUTTON, "mpm>\nkph");
        conversionLabels.put(NM_TO_MILES_BUTTON, "nm>\nml");
        conversionLabels.put(MILES_TO_NM_BUTTON, "ml>\nnm");
        conversionLabels.put(MILES_TO_KILOMETERS_BUTTON, "ml>\nkm");
        conversionLabels.put(KILOMETERS_TO_MILES_BUTTON, "km>\nml");
        conversionLabels.put(KNOTS_TO_MPH_BUTTON, "kn>\nmph");
        conversionLabels.put(MPH_TO_KNOTS_BUTTON, "mph>\nkn");
        conversionLabels.put(C_TO_F_BUTTON, "c>\nf");
        conversionLabels.put(F_TO_C_BUTTON, "f>\nc");
        conversionLabels.put(LBS_TO_KGS_BUTTON, "lb>\nkg");
        conversionLabels.put(KGS_TO_LBS_BUTTON, "kg>\nlb");
        conversionLabels.put(LITERS_TO_GALLONS_BUTTON, "lt>\ngl");
        conversionLabels.put(GALLONS_TO_LITTERS_BUTTON, "gl>\nlt");
        conversionLabels.put(GALLONS_TO_AVIGAS_LBS_BUTTON, "gl>\nlbsav");
        conversionLabels.put(GALLONS_TO_JET_FUEL_LBS_BUTTON, "gl>\nlbsjf");
        conversionLabels.put(INHG_TO_HECTOPASCALS_BUTTON, "inHg>\nhp");
        conversionLabels.put(HECTOPASCALS_TO_INHG_BUTTON, "hp>\ninHg");


        standardLabels.put(EQUALS_BUTTON,"=");
        standardLabels.put(BACKSPACE_BUTTON,"\u003c");
        standardLabels.put(CLEAR_BUTTON,"CLR");
        standardLabels.put(ZERO_BUTTON,"0");
        standardLabels.put(ONE_BUTTON,"1");
        standardLabels.put(TWO_BUTTON,"2");
        standardLabels.put(THREE_BUTTON,"3");
        standardLabels.put(FOUR_BUTTON,"4");
        standardLabels.put(FIVE_BUTTON,"5");
        standardLabels.put(SIX_BUTTON,"6");
        standardLabels.put(SEVEN_BUTTON,"7");
        standardLabels.put(EIGHT_BUTTON,"8");
        standardLabels.put(NINE_BUTTON,"9");
        standardLabels.put(PERIOD_BUTTON,".");
        standardLabels.put(PLUS_BUTTON,"+");
        standardLabels.put(MINUS_BUTTON,"-");
        standardLabels.put(MULTIPLY_BUTTON,"x");
        standardLabels.put(DIVIDE_BUTTON,"/");
        standardLabels.put(LEFT_PARENTH_BUTTON,"(");
        standardLabels.put(RIGHT_PARENTH_BUTTON,")");
        standardLabels.put(SIN_BUTTON,"sin");
        standardLabels.put(COS_BUTTON,"cos");
        standardLabels.put(TAN_BUTTON,"tan");
        standardLabels.put(ARCSIN_BUTTON,"asin");
        standardLabels.put(ARCCOS_BUTTON,"acos");
        standardLabels.put(ARCTAN_BUTTON,"atan");
        standardLabels.put(ANS_BUTTON,"ANS");


        // Set of assign buttons  so that it is easy to change their view at once

        assignableButtons.add(A_BUTTON);
        assignableButtons.add(B_BUTTON);
        assignableButtons.add(C_BUTTON);
        assignableButtons.add(TEMP_BUTTON);
        assignableButtons.add(ALTITUDE_BUTTON);
        assignableButtons.add(ALTIMETER_BUTTON);
        assignableButtons.add(WIND_SPEED_BUTTON);
        assignableButtons.add(WIND_HEADING_BUTTON);
        assignableButtons.add(HEADING_BUTTON);
        assignableButtons.add(INDICATED_AIRSPEED_BUTTON);
        assignableButtons.add(DEW_POINT_BUTTON);

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void assignButtonsAdjustView(MainActivity mainActivity){

        TextView buttonView;
        int buttonId;

        for (int buttonNumber :assignableButtons) {
            buttonId = androidButtonIdToRustButtonNumber.inverse().get(buttonNumber);
            buttonView = mainActivity.findViewById(buttonId);
            buttonView.setBackgroundTintList(ColorStateList.valueOf(R.color.black));
        }

        // Change the color of assign and add buttons as well
        int[] buttonIds = new int[]{assignButtonId,addButtonId};
        for (int buttonId_ :buttonIds ){
            buttonView = mainActivity.findViewById(buttonId_);
            buttonView.setBackgroundTintList(ColorStateList.valueOf(R.color.black));
        }

    }
    public static void draw_conv_symbols(MainActivity mainActivity){

        TextView buttonView;

        for (int conversionButton : conversionLabels.keySet()) {
            buttonView=mainActivity.findViewById(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(conversionButton));
            buttonView.setText(conversionLabels.get(conversionButton));
        }
    }
    public static void draw_standard_symbols(MainActivity mainActivity){


        TextView buttonView;
        int standardButton;

        for (int conversionButton : conversionLabels.keySet()) {

            buttonView=mainActivity.findViewById(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(conversionButton));
            standardButton = androidButtonIdToRustButtonNumber.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(conversionButton));
            buttonView.setText(standardLabels.get(standardButton));

        }


    }

}
