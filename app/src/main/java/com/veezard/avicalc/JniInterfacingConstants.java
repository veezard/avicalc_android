package com.veezard.avicalc;


import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.HashSet;
import java.util.Set;

public class JniInterfacingConstants{

    public static BiMap<Integer,Integer> androidButtonIdToRustButtonNumber;
    public static BiMap<Integer,Integer> assignPressedAndroidButtonIdToRustButtonNumber;
    public static BiMap<Integer,Integer> addPressedAndroidButtonIdToRustButtonNumber;
    public static BiMap<Integer,Integer> convPressedAndroidButtonIdToRustButtonNumber;
    public static Set<Integer> assignableButtonIds;
    public static Set<Integer> calculatedButtonIds;

    public static int assignButtonId;
    public static int addButtonId;
    public static int convButtonId;
    public static int helpButtonId;



    public static void initialize(){

        androidButtonIdToRustButtonNumber = HashBiMap.create();
        assignPressedAndroidButtonIdToRustButtonNumber = HashBiMap.create();
        addPressedAndroidButtonIdToRustButtonNumber = HashBiMap.create();
        convPressedAndroidButtonIdToRustButtonNumber = HashBiMap.create();

        calculatedButtonIds = new HashSet();

        //Toggle buttons

        assignButtonId = R.id.but_34;
        addButtonId = R.id.but_30;
        convButtonId = R.id.but_44;
        helpButtonId = R.id.but_90;


        //Buttons without modifiers
        androidButtonIdToRustButtonNumber.put(R.id.but_00, HEADING_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_01, HEAD_WIND_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_02, CROSS_WIND_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_03, PRESSURE_ALTITUDE_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_04, DENSITY_ALTITUDE_BUTTON);

        androidButtonIdToRustButtonNumber.put(R.id.but_10, GROUND_SPEED_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_11, WIND_SPEED_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_12, WIND_HEADING_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_13, ALTITUDE_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_14, ALTIMETER_BUTTON);

        androidButtonIdToRustButtonNumber.put(R.id.but_20, TRUE_AIRSPEED_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_21, CALIBRATED_AIRSPEED_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_22, COURSE_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_23, TEMP_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_24, DEW_POINT_BUTTON);

        androidButtonIdToRustButtonNumber.put(R.id.but_31, ARCSIN_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_32, ARCCOS_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_33, ARCTAN_BUTTON);

        androidButtonIdToRustButtonNumber.put(R.id.but_40, A_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_41, SIN_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_42, COS_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_43, TAN_BUTTON);

        androidButtonIdToRustButtonNumber.put(R.id.but_50, B_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_51, SEVEN_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_52, EIGHT_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_53, NINE_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_54, MULTIPLY_BUTTON);

        androidButtonIdToRustButtonNumber.put(R.id.but_60, C_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_61, FOUR_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_62, FIVE_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_63, SIX_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_64, DIVIDE_BUTTON);

        androidButtonIdToRustButtonNumber.put(R.id.but_70, D_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_71, ONE_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_72, TWO_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_73, THREE_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_74, PLUS_BUTTON);


        androidButtonIdToRustButtonNumber.put(R.id.but_80, CLEAR_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_81, PERIOD_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_82, ZERO_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_83, EQUALS_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_84, MINUS_BUTTON);

        androidButtonIdToRustButtonNumber.put(R.id.but_91, BACKSPACE_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_92, LEFT_PARENTH_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_93, RIGHT_PARENTH_BUTTON);
        androidButtonIdToRustButtonNumber.put(R.id.but_94, ANS_BUTTON);

        //Buttons with assignment modifier

        assignPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_11, WIND_SPEED_ASSIGN_BUTTON);
        assignPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_12, WIND_HEADING_ASSIGN_BUTTON);
        assignPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_13, ALTITUDE_ASSIGN_BUTTON);
        assignPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_14, ALTIMETER_ASSIGN_BUTTON);

        assignPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_21, CALIBRATED_AIRSPEED_ASSIGN_BUTTON);
        assignPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_22, COURSE_ASSIGN_BUTTON);
        assignPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_23, TEMP_ASSIGN_BUTTON);
        assignPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_24, DEW_POINT_ASSIGN_BUTTON);

        assignPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_40, A_ASSIGN_BUTTON);
        assignPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_50, B_ASSIGN_BUTTON);
        assignPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_60, C_ASSIGN_BUTTON);
        assignPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_70, D_ASSIGN_BUTTON);


        //Buttons with add modifier
        addPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_11, WIND_SPEED_ADD_BUTTON);
        addPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_12, WIND_HEADING_ADD_BUTTON);
        addPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_13, ALTITUDE_ADD_BUTTON);
        addPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_14, ALTIMETER_ADD_BUTTON);

        addPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_21, CALIBRATED_AIRSPEED_ADD_BUTTON);
        addPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_22, COURSE_ADD_BUTTON);
        addPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_23, TEMP_ADD_BUTTON);
        addPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_24, DEW_POINT_ADD_BUTTON);

        addPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_40, A_ADD_BUTTON);
        addPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_50, B_ADD_BUTTON);
        addPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_60, C_ADD_BUTTON);
        addPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_70, D_ADD_BUTTON);

        //Buttons with conversion modifier
        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_31, NM_TO_FEET_BUTTON);
        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_32, FEET_TO_NM_BUTTON);
        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_33, FEET_TO_METERS_BUTTON);


        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_41, KNOTS_TO_FPM_BUTTON);
        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_42, FPM_TO_KNOTS_BUTTON);
        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_43, METERS_TO_FEET_BUTTON);

        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_51, NM_TO_MILES_BUTTON);
        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_52, MILES_TO_NM_BUTTON);
        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_53, KPH_TO_MPM_BUTTON);
        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_54, MPM_TO_KPH_BUTTON);

        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_61, MILES_TO_KILOMETERS_BUTTON);
        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_62, KILOMETERS_TO_MILES_BUTTON);
        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_63, C_TO_F_BUTTON);
        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_64, F_TO_C_BUTTON);

        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_71, LBS_TO_KGS_BUTTON);
        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_72, KGS_TO_LBS_BUTTON);
        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_73, LITERS_TO_GALLONS_BUTTON);
        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_74, GALLONS_TO_LITTERS_BUTTON );

        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_81, INHG_TO_HECTOPASCALS_BUTTON);
        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_82, HECTOPASCALS_TO_INHG_BUTTON);
        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_83, GALLONS_TO_AVIGAS_LBS_BUTTON);
        convPressedAndroidButtonIdToRustButtonNumber.put(R.id.but_84, GALLONS_TO_JET_FUEL_LBS_BUTTON);


        assignableButtonIds = assignPressedAndroidButtonIdToRustButtonNumber.keySet();



        calculatedButtonIds.add(androidButtonIdToRustButtonNumber.inverse().get(PRESSURE_ALTITUDE_BUTTON));
        calculatedButtonIds.add(androidButtonIdToRustButtonNumber.inverse().get(DENSITY_ALTITUDE_BUTTON));
        calculatedButtonIds.add(androidButtonIdToRustButtonNumber.inverse().get(HEAD_WIND_BUTTON));
        calculatedButtonIds.add(androidButtonIdToRustButtonNumber.inverse().get(CROSS_WIND_BUTTON));
        calculatedButtonIds.add(androidButtonIdToRustButtonNumber.inverse().get(HEADING_BUTTON));
        calculatedButtonIds.add(androidButtonIdToRustButtonNumber.inverse().get(TRUE_AIRSPEED_BUTTON));
        calculatedButtonIds.add(androidButtonIdToRustButtonNumber.inverse().get(GROUND_SPEED_BUTTON));
    }


    // These constants must be the same as in the main rust library file

    public static final int ENTRY_FIELD_UPDATE_NUMBER=0;
    public static final int PREVIOUS_ENTRY_FIELD_UPDATE_NUMBER=1;
    public static final int ANS_UPDATE_NUMBER=2;
    public static final int A_UPDATE_NUMBER= 3;
    public static final int B_UPDATE_NUMBER= 4;
    public static final int C_UPDATE_NUMBER= 5;
    public static final int D_UPDATE_NUMBER= 6;
    public static final int TEMP_UPDATE_NUMBER=7 ;
    public static final int ALTITUDE_UPDATE_NUMBER= 8;
    public static final int ALTIMETER_UPDATE_NUMBER= 9;
    public static final int WIND_SPEED_UPDATE_NUMBER= 10;
    public static final int WIND_HEADING_UPDATE_NUMBER= 11;
    public static final int HEADING_UPDATE_NUMBER= 12;
    public static final int CALIBRATED_AIRSPEED_UPDATE_NUMBER= 13;
    public static final int PRESSURE_ALTITUDE_UPDATE_NUMBER= 14;
    public static final int DENSITY_ALTITUDE_UPDATE_NUMBER= 15;
    public static final int HEAD_WIND_UPDATE_NUMBER= 16;
    public static final int CROSS_WIND_UPDATE_NUMBER= 17;
    public static final int COURSE_UPDATE_NUMBER= 18;
    public static final int TRUE_AIRSPEED_UPDATE_NUMBER= 19;
    public static final int GROUND_SPEED_UPDATE_NUMBER= 20;
    public static final int DEWPOINT_UPDATE_NUMBER= 21;

    // These constants must be the same as constants in the const module of the rust library
    public static final int EQUALS_BUTTON= 1000;
    public static final int BACKSPACE_BUTTON= 1001;
    public static final int CLEAR_BUTTON= 1002;
    public static final int ZERO_BUTTON= 0;
    public static final int ONE_BUTTON= 1;
    public static final int TWO_BUTTON= 2;
    public static final int THREE_BUTTON= 3;
    public static final int FOUR_BUTTON= 4;
    public static final int FIVE_BUTTON= 5;
    public static final int SIX_BUTTON= 6;
    public static final int SEVEN_BUTTON= 7;
    public static final int EIGHT_BUTTON= 8;
    public static final int NINE_BUTTON= 9;
    public static final int PERIOD_BUTTON= 10;
    public static final int PLUS_BUTTON= 11;
    public static final int MINUS_BUTTON= 12;
    public static final int MULTIPLY_BUTTON= 13;
    public static final int DIVIDE_BUTTON= 14;
    public static final int LEFT_PARENTH_BUTTON= 15;
    public static final int RIGHT_PARENTH_BUTTON= 16;
    public static final int SIN_BUTTON= 21;
    public static final int COS_BUTTON= 22;
    public static final int TAN_BUTTON= 23;
    public static final int ARCSIN_BUTTON= 24;
    public static final int ARCCOS_BUTTON= 25;
    public static final int ARCTAN_BUTTON= 26;
    public static final int ANS_BUTTON= 30;
    public static final int A_BUTTON= 41;
    public static final int B_BUTTON= 42;
    public static final int C_BUTTON= 43;
    public static final int D_BUTTON= 44;
    public static final int TEMP_BUTTON= 51;
    public static final int ALTITUDE_BUTTON= 52;
    public static final int ALTIMETER_BUTTON= 53;
    public static final int WIND_SPEED_BUTTON= 54;
    public static final int WIND_HEADING_BUTTON= 55;
    public static final int COURSE_BUTTON= 56;
    public static final int CALIBRATED_AIRSPEED_BUTTON= 57;
    public static final int DEW_POINT_BUTTON = 58;
    public static final int PRESSURE_ALTITUDE_BUTTON= 61;
    public static final int DENSITY_ALTITUDE_BUTTON= 62;
    public static final int HEAD_WIND_BUTTON= 63;
    public static final int CROSS_WIND_BUTTON= 64;
    public static final int HEADING_BUTTON= 65;
    public static final int TRUE_AIRSPEED_BUTTON= 66;
    public static final int GROUND_SPEED_BUTTON= 67;
    public static final int A_ASSIGN_BUTTON= 101;
    public static final int B_ASSIGN_BUTTON= 102;
    public static final int C_ASSIGN_BUTTON= 103;
    public static final int D_ASSIGN_BUTTON= 104;
    public static final int TEMP_ASSIGN_BUTTON= 111;
    public static final int ALTITUDE_ASSIGN_BUTTON= 112;
    public static final int ALTIMETER_ASSIGN_BUTTON= 113;
    public static final int WIND_SPEED_ASSIGN_BUTTON= 114;
    public static final int WIND_HEADING_ASSIGN_BUTTON= 115;
    public static final int COURSE_ASSIGN_BUTTON= 116;
    public static final int CALIBRATED_AIRSPEED_ASSIGN_BUTTON= 117;
    public static final int DEW_POINT_ASSIGN_BUTTON = 118;
    public static final int A_ADD_BUTTON= 201;
    public static final int B_ADD_BUTTON= 202;
    public static final int C_ADD_BUTTON= 203;
    public static final int D_ADD_BUTTON= 204;
    public static final int TEMP_ADD_BUTTON= 211;
    public static final int ALTITUDE_ADD_BUTTON= 212;
    public static final int ALTIMETER_ADD_BUTTON= 213;
    public static final int WIND_SPEED_ADD_BUTTON= 214;
    public static final int WIND_HEADING_ADD_BUTTON= 215;
    public static final int COURSE_ADD_BUTTON= 216;
    public static final int CALIBRATED_AIRSPEED_ADD_BUTTON= 217;
    public static final int DEW_POINT_ADD_BUTTON = 218;
    public static final int NM_TO_FEET_BUTTON= 301;
    public static final int FEET_TO_NM_BUTTON= 302;
    public static final int KNOTS_TO_FPM_BUTTON= 303;
    public static final int FPM_TO_KNOTS_BUTTON= 304;
    public static final int KPH_TO_MPM_BUTTON= 305;
    public static final int MPM_TO_KPH_BUTTON= 306;
    public static final int NM_TO_MILES_BUTTON= 307;
    public static final int MILES_TO_NM_BUTTON= 308;
    public static final int MILES_TO_KILOMETERS_BUTTON= 309;
    public static final int KILOMETERS_TO_MILES_BUTTON= 310;
    public static final int KNOTS_TO_MPH_BUTTON= 311;
    public static final int MPH_TO_KNOTS_BUTTON= 312;
    public static final int C_TO_F_BUTTON= 313;
    public static final int F_TO_C_BUTTON= 314;
    public static final int LBS_TO_KGS_BUTTON= 315;
    public static final int KGS_TO_LBS_BUTTON = 316;
    public static final int LITERS_TO_GALLONS_BUTTON= 317;
    public static final int GALLONS_TO_LITTERS_BUTTON= 318;
    public static final int GALLONS_TO_AVIGAS_LBS_BUTTON= 319;
    public static final int GALLONS_TO_JET_FUEL_LBS_BUTTON= 320;
    public static final int INHG_TO_HECTOPASCALS_BUTTON= 321;
    public static final int HECTOPASCALS_TO_INHG_BUTTON= 322;
    public static final int FEET_TO_METERS_BUTTON= 323;
    public static final int METERS_TO_FEET_BUTTON= 324;


}


