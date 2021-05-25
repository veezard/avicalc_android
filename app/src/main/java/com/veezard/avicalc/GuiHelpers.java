package com.veezard.avicalc;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.veezard.avicalc.JniInterfacingConstants.*;

public class GuiHelpers {

    static Map<Integer, String> conversionLabels;



    public static void colorButtons(MainActivity mainActivity){
        for (int buttonId : assignableButtonIds){
            View button = mainActivity.findViewById(buttonId);
            button.setBackgroundResource(R.drawable.button_assignable_variable);
        }
        for (int buttonId : calculatedButtonIds){
            View button = mainActivity.findViewById(buttonId);
            button.setBackgroundResource(R.drawable.button_calculated_variable);
        }
        mainActivity.findViewById(assignButtonId).setBackgroundResource(R.drawable.button_assign);
        mainActivity.findViewById(addButtonId).setBackgroundResource(R.drawable.button_assign);
        mainActivity.findViewById(convButtonId).setBackgroundResource(R.drawable.button_conv);
        mainActivity.findViewById(helpButtonId).setBackgroundResource(R.drawable.button_help);
    }


    public static void initialize() {
        conversionLabels = new HashMap();

        conversionLabels.put(NM_TO_FEET_BUTTON, "nm -> ft");
        conversionLabels.put(FEET_TO_NM_BUTTON, "ft -> nm");
        conversionLabels.put(KNOTS_TO_FPM_BUTTON, "kn -> fpm");
        conversionLabels.put(FPM_TO_KNOTS_BUTTON, "fpm -> kn");
        conversionLabels.put(KPH_TO_MPM_BUTTON, "kph -> mpm");
        conversionLabels.put(MPM_TO_KPH_BUTTON, "mpm -> kph");
        conversionLabels.put(NM_TO_MILES_BUTTON, "nm -> ml");
        conversionLabels.put(MILES_TO_NM_BUTTON, "ml -> nm");
        conversionLabels.put(MILES_TO_KILOMETERS_BUTTON, "ml -> km");
        conversionLabels.put(KILOMETERS_TO_MILES_BUTTON, "km -> ml");
        conversionLabels.put(KNOTS_TO_MPH_BUTTON, "kn -> mph");
        conversionLabels.put(MPH_TO_KNOTS_BUTTON, "mph -> kn");
        conversionLabels.put(C_TO_F_BUTTON, "C -> F");
        conversionLabels.put(F_TO_C_BUTTON, "F -> C");
        conversionLabels.put(LBS_TO_KGS_BUTTON, "lb -> kg");
        conversionLabels.put(KGS_TO_LBS_BUTTON, "kg -> lb");
        conversionLabels.put(LITERS_TO_GALLONS_BUTTON, "lt -> gl");
        conversionLabels.put(GALLONS_TO_LITTERS_BUTTON, "gl -> lt");
        conversionLabels.put(GALLONS_TO_AVIGAS_LBS_BUTTON, "gl -> lbsAV");
        conversionLabels.put(GALLONS_TO_JET_FUEL_LBS_BUTTON, "gl -> lbsJF");
        conversionLabels.put(INHG_TO_HECTOPASCALS_BUTTON, "inHg -> hp");
        conversionLabels.put(HECTOPASCALS_TO_INHG_BUTTON, "hp -> inHg");
        conversionLabels.put(FEET_TO_METERS_BUTTON, "ft -> m");
        conversionLabels.put(METERS_TO_FEET_BUTTON, "m -> ft");

    }

}
