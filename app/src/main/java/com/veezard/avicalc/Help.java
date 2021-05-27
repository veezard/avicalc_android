package com.veezard.avicalc;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Map;

import static com.veezard.avicalc.JniInterfacingConstants.*;

public class Help { //Text of help window is hard-coded here
    public static class HelpText {
        String title ="";
        String body = "";
        public HelpText(String title, String body){
            this.title = title;
            this.body = body;
        }
        public void add_to_body(String string_to_add){
            this.body = this.body + "\n-------------------\n" + string_to_add;
        }
    }


    static final String CONVERSION = "\uD835\uDDD6\uD835\uDDFC\uD835\uDDFB\uD835\uDE03\uD835\uDDF2\uD835\uDDFF\uD835\uDE00\uD835\uDDF6\uD835\uDDFC\uD835\uDDFB: ";

    static final String FEATURES = "\uD835\uDC05\uD835\uDC1E\uD835\uDC1A\uD835\uDC2D\uD835\uDC2E\uD835\uDC2B\uD835\uDC1E\uD835\uDC2C";

    static final String INSTRUCTIONS =
            "\uD835\uDC08\uD835\uDC27\uD835\uDC2C\uD835\uDC2D\uD835\uDC2B\uD835\uDC2E\uD835\uDC1C\uD835\uDC2D\uD835\uDC22\uD835\uDC28\uD835\uDC27\uD835\uDC2C";
    static final String UNITS_INSTRUCTIONS =
                "\uD835\uDC13\uD835\uDC21\uD835\uDC1E \uD835\uDC2E\uD835\uDC27\uD835\uDC22\uD835\uDC2D\uD835\uDC2C \uD835\uDC1F\uD835\uDC28\uD835\uDC2B \uD835\uDC2F\uD835\uDC1A\uD835\uDC2B\uD835\uDC22\uD835\uDC1A\uD835\uDC1B\uD835\uDC25\uD835\uDC1E\uD835\uDC2C \uD835\uDC1A\uD835\uDC2B\uD835\uDC1E \uD835\uDC0A\uD835\uDC27\uD835\uDC28\uD835\uDC2D\uD835\uDC2C, \uD835\uDC05\uD835\uDC1E\uD835\uDC1E\uD835\uDC2D \uD835\uDC29\uD835\uDC1E\uD835\uDC2B \uD835\uDC0C\uD835\uDC22\uD835\uDC27\uD835\uDC2E\uD835\uDC2D\uD835\uDC1E, \uD835\uDC05\uD835\uDC1E\uD835\uDC1E\uD835\uDC2D, \uD835\uDC02\uD835\uDC1E\uD835\uDC25\uD835\uDC2C\uD835\uDC22\uD835\uDC2E\uD835\uDC2C, \uD835\uDC08\uD835\uDC27\uD835\uDC07\uD835\uDC20, \uD835\uDC1D\uD835\uDC1E\uD835\uDC20\uD835\uDC2B\uD835\uDC1E\uD835\uDC1E\uD835\uDC2C";

    static final String CONTACT =
            "\uD835\uDC02\uD835\uDC28\uD835\uDC27\uD835\uDC2D\uD835\uDC1A\uD835\uDC1C\uD835\uDC2D";

    static Map<Integer, HelpText> button_view_id_to_help_text = new HashMap();

    public static HelpText help_text(int buttonViewId){

        if (button_view_id_to_help_text.containsKey(buttonViewId)) {
            return button_view_id_to_help_text.get(buttonViewId);

        }
        else {
            HelpText info = new HelpText("No help for this button","");
            return info;
        }
    }
    public static void initialize(MainActivity mainActivity){
        button_view_id_to_help_text.put(helpButtonId, new HelpText(
                "Aviation Calculator",
                "𝗙𝗢𝗥 𝗘𝗗𝗨𝗖𝗔𝗧𝗜𝗢𝗡𝗔𝗟 𝗣𝗨𝗥𝗣𝗢𝗦𝗘𝗦 𝗢𝗡𝗟𝗬\n"
                        + "----"+FEATURES+"---\n"
                        + "\u25CF Unit conversion\n"
                + "\u25CF Computation of pressure altitude, density altitude, true air speed, heading direction, cross wind, head wind.\n"
                        + "\u25CF Trigonometric functions\n"
                        + "----"+INSTRUCTIONS+"---\n"
                        + "\u25CF Use the \"?\" button to get info on any other button. (Press \"?\" twice for this screen.)\n"
                        + "\u25CF Green buttons correspond to variables to which you can assign a value.\n"
                        + "\u25CF Purple buttons correspond to variables which are automatically computed.\n"
                        + "\u25CF To assign a value to a variable, first press the \":=\" button. "
                        + "When \":=\" is pressed, pressing a green button will evaluate the entry field and assign the result to the corresponding variable. "
                        + "If the entry field is empty, the value in the answer field will be assigned instead.\n "
                        + "\u25CF To add a value to a variable, have \":+\" button pressed. \n"
                        + "\u25CF "+ UNITS_INSTRUCTIONS + " (for angles)\n"
                        + "\u25CF Press \"CONV\" button for unit conversion.\n"
                        + "\u25CF General purpose variables a,b,c,d are convenient when computing weight, moment, and center of mass. \n"
                        + "\u25CF Pressing backspace button \"<\" when the entry field is empty brings back the previous entry and answer fields.\n"
                        + "----"+CONTACT+"---\n"
                        + "val@veezard.pro"

                )
        );

        button_view_id_to_help_text.put(assignButtonId, new HelpText(
                        "Assign to a Variable",
                        "When this button is pressed, the green buttons evaluate the entry field and assign the result to the corresponding variable. When the entry field is empty, the value in the answer field is assigned instead. If neither this button nor the \"+=\" button are pressed, the green buttons insert the corresponding variable into the entry field."
                )
        );
        button_view_id_to_help_text.put(addButtonId, new HelpText(
                        "Add to a Variable",
                "When this button is pressed, the green buttons evaluate the entry field and add the result to the corresponding variable. When the entry field is empty, the value in the answer field is added instead. If neither this button nor the \":=\" button are pressed, the green buttons insert the corresponding variable into the entry field."
                )
        );
        button_view_id_to_help_text.put(convButtonId, new HelpText(
                        "Unit Conversion",
                        "Pressing this button followed with a button which has a superscript will perform the corresponding unit conversion on the value in the answer field.. If the entry field is not empty, it is evaluated first."
                )
        );

        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(EQUALS_BUTTON), new HelpText(
                        "Evaluation",
                        "Evaluate the entry field."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(BACKSPACE_BUTTON), new HelpText(
                        "Backspace",
                        "Removes the last symbol in the entry field. If the entry field is empty, previous entry and answer fields are brought back. "
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(CLEAR_BUTTON), new HelpText(
                        "Clear",
                        "Clears the current entry field."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(ZERO_BUTTON), new HelpText(
                        "0",
                        ""
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(ONE_BUTTON), new HelpText(
                        "1",
                        ""
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(TWO_BUTTON), new HelpText(
                        "2",
                        ""
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(THREE_BUTTON), new HelpText(
                        "3",
                        ""
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(FOUR_BUTTON), new HelpText(
                        "4",
                        ""
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(FIVE_BUTTON), new HelpText(
                        "5",
                        ""
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(SIX_BUTTON), new HelpText(
                        "6",
                        ""
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(SEVEN_BUTTON), new HelpText(
                        "7",
                        ""
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(EIGHT_BUTTON), new HelpText(
                        "8",
                        ""
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(NINE_BUTTON), new HelpText(
                        "9",
                        ""
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(PERIOD_BUTTON), new HelpText(
                        ".",
                        ""
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(PLUS_BUTTON), new HelpText(
                        "Addition",
                        ""
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(MINUS_BUTTON), new HelpText(
                        "Subtraction",
                        ""
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(MULTIPLY_BUTTON), new HelpText(
                        "Multiplication",
                        ""
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(DIVIDE_BUTTON), new HelpText(
                        "Division",
                        ""
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(LEFT_PARENTH_BUTTON), new HelpText(
                        "(",
                        ""
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(RIGHT_PARENTH_BUTTON), new HelpText(
                        ")",
                        ""
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(SIN_BUTTON), new HelpText(
                        "Sin",
                        "Sine function in degrees."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(COS_BUTTON), new HelpText(
                        "Cos",
                        "Cosine function in degrees."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(TAN_BUTTON), new HelpText(
                        "Tan",
                        "Tangent function in degrees."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(ARCSIN_BUTTON), new HelpText(
                        "Arcsin",
                        "Arcsin function with range [-90,90]."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(ARCCOS_BUTTON), new HelpText(
                        "Arccos",
                        "Arccos function with range [0,180]."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(ARCTAN_BUTTON), new HelpText(
                        "Arctan",
                        "Arctan function with range (-90,90)"
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(ANS_BUTTON), new HelpText(
                        "Answer",
                        "Inserts \"ans\" into the entry field which evaluates to the value of the current answer field."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(A_BUTTON), new HelpText(
                        "Variable a",
                        "General purpose variable."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(B_BUTTON), new HelpText(
                "Variable b",
                "General purpose variable."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(C_BUTTON), new HelpText(
                "Variable c",
                "General purpose variable."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(D_BUTTON), new HelpText(
                "Variable d",
                "General purpose variable."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(TEMP_BUTTON), new HelpText(
                        "Temperature",
                        "Temperature outside the aircraft measured in Celsius."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(ALTITUDE_BUTTON), new HelpText(
                        "Altitude",
                        "Altitude of the aircraft in feet."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(ALTIMETER_BUTTON), new HelpText(
                        "Altimeter Setting",
                        "Altimeter setting in inHg."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(WIND_SPEED_BUTTON), new HelpText(
                        "Wind Speed",
                        "Wind speed in knots."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(WIND_HEADING_BUTTON), new HelpText(
                        "Wind Direction",
                        "Direction of the wind in degrees."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(COURSE_BUTTON), new HelpText(
                        "Course",
                        "Direction in which you want the aircraft to be flying. In case of crosswind, this direction is different than where the nose of the aircraft should be pointing."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(CALIBRATED_AIRSPEED_BUTTON), new HelpText(
                        "CAS",
                        "Calibrated Airspeed in knots. This is the airspeed calibrated for the inaccuracies of the measuring device. You can find airspeed calibration charts in your pilot's operating handbook."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(DEW_POINT_BUTTON ), new HelpText(
                        "Dew Point",
                        "Dew Point in Celsius. Use -65 for dry air."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(PRESSURE_ALTITUDE_BUTTON), new HelpText(
                        "Pressure Altitude",
                        "Pressure Altitude in feet. Only uses altitude and altimeter setting."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(DENSITY_ALTITUDE_BUTTON), new HelpText(
                        "Density Altitude",
                        "Density Altitude in feet. Uses altitude, altimeter setting, temperature and dew point."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(HEAD_WIND_BUTTON), new HelpText(
                        "Head Wind",
                        "The component of the wind along the Course direction. Positive values correspond to head wind and negative values correspond to tail wind."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(CROSS_WIND_BUTTON), new HelpText(
                        "Cross Wind",
                        "The component of the wind perpendicular to the Course direction. Negative values correspond to wind coming from the left and positive values correspond to the wind coming from the right."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(HEADING_BUTTON), new HelpText(
                        "Heading",
                        "The direction the aircraft should be directed in order for it to fly in the Course direction. This uses TAS (true airspeed) and therefore requires variables needed to compute it."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(TRUE_AIRSPEED_BUTTON), new HelpText(
                        "TAS",
                        "True airspeed. The speed at which the aircraft is moving through the air. The computation depends on the density of air and therefore requires the same variables as the density altitude computation."
                )
        );
        button_view_id_to_help_text.put(androidButtonIdToRustButtonNumber.inverse().get(GROUND_SPEED_BUTTON), new HelpText(
                        "Ground Speed",
                        "Ground Speed if the wind speed and direction have been inputted and the aircraft is heading in the direction given by the heading variable (and hence flying in the Course direction)."
                )
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(NM_TO_FEET_BUTTON)).add_to_body(
                CONVERSION+"Nautical Miles to Feet"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(FEET_TO_NM_BUTTON)).add_to_body(
                CONVERSION+"Feet to Nautical Miles"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(KNOTS_TO_FPM_BUTTON)).add_to_body(
                CONVERSION+"Knots to Feet Per Minute"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(FPM_TO_KNOTS_BUTTON)).add_to_body(
                CONVERSION+"Feet Per Minute to Knots"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(KPH_TO_MPM_BUTTON)).add_to_body(
                CONVERSION+"Kilometers Per Hour to Meters Per Minute"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(MPM_TO_KPH_BUTTON)).add_to_body(
                CONVERSION+"Meters Per Minute to Kilometers Per Hour"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(NM_TO_MILES_BUTTON)).add_to_body(
                CONVERSION+"Nautical Miles to Miles"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(MILES_TO_NM_BUTTON)).add_to_body(
                CONVERSION+"Miles to Nautical Miles"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(MILES_TO_KILOMETERS_BUTTON)).add_to_body(
                CONVERSION+"Miles to Kilometers"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(KILOMETERS_TO_MILES_BUTTON)).add_to_body(
                CONVERSION+"Kilometers to Miles"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(C_TO_F_BUTTON)).add_to_body(
                CONVERSION+"Celsius to Fahrenheit"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(F_TO_C_BUTTON)).add_to_body(
                CONVERSION+"Fahrenheit to Celsius"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(LBS_TO_KGS_BUTTON)).add_to_body(
                CONVERSION+"Pounds to Kilograms"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(KGS_TO_LBS_BUTTON )).add_to_body(
                CONVERSION+"Kilograms to Pounds"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(LITERS_TO_GALLONS_BUTTON)).add_to_body(
                CONVERSION+"Liters to Gallons"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(GALLONS_TO_LITTERS_BUTTON)).add_to_body(
                CONVERSION+"Gallons to Liters"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(GALLONS_TO_AVIGAS_LBS_BUTTON)).add_to_body(
                CONVERSION+"Gallons of AVGAS to Weight in Pounds"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(GALLONS_TO_JET_FUEL_LBS_BUTTON)).add_to_body(
                CONVERSION+"Gallons of Jet Fuel to Weight in Pounds"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(INHG_TO_HECTOPASCALS_BUTTON)).add_to_body(
                CONVERSION+"Inches of Mercury to Hectopascals"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(HECTOPASCALS_TO_INHG_BUTTON)).add_to_body(
                CONVERSION+"Hectopascals to Inches of Mercury" 
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(FEET_TO_METERS_BUTTON)).add_to_body(
                CONVERSION+"Feet to Meters"
        );
        button_view_id_to_help_text.get(convPressedAndroidButtonIdToRustButtonNumber.inverse().get(METERS_TO_FEET_BUTTON)).add_to_body(
                CONVERSION+"Meters to Feet"
        );


    }

}
