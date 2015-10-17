# react-native-android-alertDialog

This is really an essential native module however it is not built in the lib yet.
Hope this helps others.

Step 1: 

add new class AlertPackage

Step 2: 

add new class AlertModule

Step 3

go to class MainActivity
  a. extends FragmentActivity instead
  b. the new line in this class is ".addPackage(new AlertPackage(this))"
  
That's all for Java part, then go back to project folder.

Step 4

add a new file called "AlertAndroid.js"

content as follow:

/**
 * @providesModule ToastAndroid
 */

'use strict';

/**
 * This exposes the native ToastAndroid module as a JS module. This has a function 'show'
 * which takes the following parameters:
 *
 * 1. String message: A string with the text to toast
 * 2. int duration: The duration of the toast. May be ToastAndroid.SHORT or ToastAndroid.LONG
 */
var { NativeModules } = require('react-native');
module.exports = NativeModules.AlertAndroid;
  
Step 5

go to index.android.js and add NativeModules as follow

var React = require('react-native');
    var {
        
        NativeModules,
        
    } = React;


Step 6

This is how to call the native alert dialog

NativeModules.AlertAndroid.showAlert(desc);

Thanks! 
