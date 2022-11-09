package com.plugin;

import android.content.Context;
import android.content.Intent;
import android.util.Log;


import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import org.json.JSONArray;
import org.json.JSONException;

import android.os.Handler;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;


//---------------------------------------------------------------
public class MainActivity extends CordovaPlugin{

    private CallbackContext callbackContext;
    private Intent intent = null;
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.webView = webView;
    }

    public MainActivity() {
        super();
    }
    public void OnDestroy(){
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Context context = cordova.getActivity().getApplicationContext();
        this.callbackContext = callbackContext;
        intent = null;

        if (action.equals("getVersion")) {
            try{
                PackageManager packageManager = this.cordova.getActivity().getPackageManager();
                callbackContext.success(packageManager.getPackageInfo(this.cordova.getActivity().getPackageName(), 0).versionName+ " "+
                        packageManager.getPackageInfo(this.cordova.getActivity().getPackageName(), 0).versionCode);

            }catch (Exception e){
                callbackContext.error("Erro getVersion"+e.getMessage());
            }
            return true;
        }

        return false; // Returning false results in a "MethodNotFound" error.
    }

}
