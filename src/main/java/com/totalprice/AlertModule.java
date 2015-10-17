package com.totalprice;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Map;
/**
 * Created by neilma on 17/10/15.
 */
public class AlertModule extends ReactContextBaseJavaModule {

    private FragmentActivity mActivity = null;

    public AlertModule(ReactApplicationContext reactContext, FragmentActivity activity) {
        super(reactContext);
        mActivity = activity;
    }

    @Override
    public String getName() {
        return "AlertAndroid";
    }

    @ReactMethod
    public void showAlert(String name) {
        new AlertDialog.Builder(mActivity)
                .setTitle("Delete Item")
                .setMessage("Are you sure you want to remove '" + name + "' ?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .show();
    }

}
