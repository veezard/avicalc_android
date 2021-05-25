extern crate float_pretty_print;
use float_pretty_print::PrettyPrintFloat;

const ENTRY_FIELD_UPDATE_NUMBER: i32 = 0;
const PREVIOUS_ENTRY_FIELD_UPDATE_NUMBER: i32 = 1;
const ANS_UPDATE_NUMBER: i32 = 2;
const A_UPDATE_NUMBER: i32 = 3;
const B_UPDATE_NUMBER: i32 = 4;
const C_UPDATE_NUMBER: i32 = 5;
const D_UPDATE_NUMBER: i32 = 6;
const TEMP_UPDATE_NUMBER: i32 = 7;
const ALTITUDE_UPDATE_NUMBER: i32 = 8;
const ALTIMETER_UPDATE_NUMBER: i32 = 9;
const WIND_SPEED_UPDATE_NUMBER: i32 = 10;
const WIND_HEADING_UPDATE_NUMBER: i32 = 11;
const HEADING_UPDATE_NUMBER: i32 = 12;
const CALIBRATED_AIRSPEED_UPDATE_NUMBER: i32 = 13;
const PRESSURE_ALTITUDE_UPDATE_NUMBER: i32 = 14;
const DENSITY_ALTITUDE_UPDATE_NUMBER: i32 = 15;
const HEAD_WIND_UPDATE_NUMBER: i32 = 16;
const CROSS_WIND_UPDATE_NUMBER: i32 = 17;
const COURSE_UPDATE_NUMBER: i32 = 18;
const TRUE_AIRSPEED_UPDATE_NUMBER: i32 = 19;
const GROUND_SPEED_UPDATE_NUMBER: i32 = 20;
const DEWPOINT_UPDATE_NUMBER: i32 = 21;

fn float_to_pretty_string(number: f64) -> String {
    if number.is_nan() {
        "".to_string()
    } else if number.fract() < 0.0001 && number < 10000. && number.round().abs() >= 1. {
        number.round().to_string()
    } else if number.abs() < 0.0000000001 {
        "0".to_string()
    } else {
        format!("{:0.6}", PrettyPrintFloat(number))
    }
}

/// Expose the JNI interface for android below
#[cfg(target_os = "android")]
#[allow(non_snake_case)]
pub mod android {

    extern crate jni;
    use self::jni::objects::{JClass, JMethodID, JObject, JString, JValue};
    use self::jni::sys::jint;
    use self::jni::sys::jobject;
    use self::jni::sys::jobjectArray;
    use self::jni::sys::jstring;
    use self::jni::JNIEnv;
    use std::cell::RefCell;

    use std::rc::Rc;

    extern crate avicalc_backend;
    use avicalc_backend::consts::*;
    use avicalc_backend::objects::*;
    use avicalc_backend::*;

    pub static mut VM_ENV: Option<RefCell<Box<JNIEnv>>> = None;

    use super::*;
    #[no_mangle]
    pub unsafe extern "C" fn Java_com_veezard_avicalc_RustGlue_initializeRust(
        env: JNIEnv<'static>,
        _: JClass,
    ) -> () {
        VM_ENV = Some(RefCell::new(Box::new(env)));
        fn update_callback_function_wrapper(
            java_side_update_number: i32,
        ) -> Rc<RefCell<Box<dyn FnMut(f64) -> ()>>> {
            Rc::new(RefCell::new(Box::new(move |val| unsafe {
                let global_env = VM_ENV.as_ref().unwrap().borrow_mut();
                let entry: String = float_to_pretty_string(val);
                if let Ok(rust_glue_class) = global_env.find_class("com/veezard/avicalc/RustGlue") {
                    if let Ok(entry_as_jstring) = global_env.new_string(entry) {
                        global_env.call_static_method(
                            rust_glue_class,
                            "update_field",
                            "(ILjava/lang/String;)V",
                            &[
                                JValue::Int(java_side_update_number),
                                JValue::Object(*entry_as_jstring),
                            ],
                        );
                    }
                }
            })))
        }
        fn gui_update_functions(var: Variable) -> Rc<RefCell<Box<dyn FnMut(f64) -> ()>>> {
            match var {
                Variable::Ans => update_callback_function_wrapper(ANS_UPDATE_NUMBER),
                Variable::A => update_callback_function_wrapper(A_UPDATE_NUMBER),
                Variable::B => update_callback_function_wrapper(B_UPDATE_NUMBER),
                Variable::C => update_callback_function_wrapper(C_UPDATE_NUMBER),
                Variable::D => update_callback_function_wrapper(D_UPDATE_NUMBER),
                Variable::Temp => update_callback_function_wrapper(TEMP_UPDATE_NUMBER),
                Variable::Altitude => update_callback_function_wrapper(ALTITUDE_UPDATE_NUMBER),
                Variable::Altimeter => update_callback_function_wrapper(ALTIMETER_UPDATE_NUMBER),
                Variable::WindSpeed => update_callback_function_wrapper(WIND_SPEED_UPDATE_NUMBER),
                Variable::WindDir => update_callback_function_wrapper(WIND_HEADING_UPDATE_NUMBER),
                Variable::Heading => update_callback_function_wrapper(HEADING_UPDATE_NUMBER),
                Variable::Cas => {
                    update_callback_function_wrapper(CALIBRATED_AIRSPEED_UPDATE_NUMBER)
                }
                Variable::PressAlt => {
                    update_callback_function_wrapper(PRESSURE_ALTITUDE_UPDATE_NUMBER)
                }
                Variable::DensAlt => {
                    update_callback_function_wrapper(DENSITY_ALTITUDE_UPDATE_NUMBER)
                }
                Variable::HeadWind => update_callback_function_wrapper(HEAD_WIND_UPDATE_NUMBER),
                Variable::CrossWind => update_callback_function_wrapper(CROSS_WIND_UPDATE_NUMBER),
                Variable::Course => update_callback_function_wrapper(COURSE_UPDATE_NUMBER),
                Variable::Tas => update_callback_function_wrapper(TRUE_AIRSPEED_UPDATE_NUMBER),
                Variable::GrdSpd => update_callback_function_wrapper(GROUND_SPEED_UPDATE_NUMBER),
                Variable::DewPoint => update_callback_function_wrapper(DEWPOINT_UPDATE_NUMBER),
                _ => Rc::new(RefCell::new(Box::new(|_| {}))),
            }
        }

        let entry_field_writer = Box::new(|entry: String| {
            let global_env = VM_ENV.as_ref().unwrap().borrow_mut();
            if let Ok(rust_glue_class) = global_env.find_class("com/veezard/avicalc/RustGlue") {
                if let Ok(entry_as_jstring) = global_env.new_string(entry) {
                    global_env.call_static_method(
                        rust_glue_class,
                        "update_field",
                        "(ILjava/lang/String;)V",
                        &[
                            JValue::Int(ENTRY_FIELD_UPDATE_NUMBER),
                            JValue::Object(*entry_as_jstring),
                        ],
                    );
                }
            }
        });
        let previous_entry_field_writer = Box::new(|entry| {
            let global_env = VM_ENV.as_ref().unwrap().borrow_mut();
            if let Ok(rust_glue_class) = global_env.find_class("com/veezard/avicalc/RustGlue") {
                if let Ok(entry_as_jstring) = global_env.new_string(entry) {
                    global_env.call_static_method(
                        rust_glue_class,
                        "update_field",
                        "(ILjava/lang/String;)V",
                        &[
                            JValue::Int(PREVIOUS_ENTRY_FIELD_UPDATE_NUMBER),
                            JValue::Object(*entry_as_jstring),
                        ],
                    );
                }
            }
        });
        //--------------Initialize state of the calculator
        STATE = Some(RefCell::new(Box::new(State::default(gui_update_functions))));

        STRING_DISPLAY_FUNCTIONS = Some(RefCell::new(vec![
            RefCell::new(entry_field_writer),
            RefCell::new(previous_entry_field_writer),
        ]));
        refresh_screen(&mut STATE, &mut STRING_DISPLAY_FUNCTIONS);
    }

    #[no_mangle]
    pub unsafe extern "C" fn Java_com_veezard_avicalc_RustGlue_respondToButtonRust(
        env: JNIEnv<'static>,
        _: JClass,
        button_number: jint,
    ) -> () {
        VM_ENV = Some(RefCell::new(Box::new(env)));
        let key_pressed_wrapper =
            |button_number: u16| key_pressed(button_number, &STATE, &STRING_DISPLAY_FUNCTIONS);

        key_pressed_wrapper(button_number as u16);
    }
}
