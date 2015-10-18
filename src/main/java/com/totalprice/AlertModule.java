package com.totalprice;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySeyIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.Map;

import javax.annotation.Nullable;

/**
 * Created by neilma on 17/10/15.
 */
public class AlertModule extends ReactContextBaseJavaModule {

    private FragmentActivity mActivity = null;
    ReactApplicationContext mReactContext;
    public AlertModule(ReactApplicationContext reactContext, FragmentActivity activity) {
        super(reactContext);
        mActivity = activity;
        mReactContext = reactContext;
    }

    @Override
    public String getName() {
        return "AlertAndroid";
    }

    @ReactMethod
    public void showAlert(String name, final int index) {
        new AlertDialog.Builder(mActivity)
                .setTitle("Delete Item")
                .setMessage("Are you sure you want to remove '" + name + "' ?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        WritableMap params = Arguments.createMap();
                        params.putInt("index",index);
                        sendEvent(mReactContext, "removeItem", params);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .show();
    }

    private void sendEvent(ReactContext reactContext,
                           String eventName,
                           @Nullable WritableMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }
}
