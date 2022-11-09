package com.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;


import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import static android.hardware.Camera.Parameters.FLASH_MODE_ON;


//---------------------------------------------------------------
public class MainActivity extends CordovaPlugin{

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
        //Metodos Pagamento
        if (action.equals("getAppsInstalados")) {
            PackageManager packageManager=cordova.getActivity().getPackageManager();
            List<ApplicationInfo> list = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
            String values = "";
            for(ApplicationInfo ap:list){
                values += values == ""?"":"\n";
                values+=ap.packageName;
            }
        
            callbackContext.success(values);
        }

        return false; // Returning false results in a "MethodNotFound" error.
    }

    
}
