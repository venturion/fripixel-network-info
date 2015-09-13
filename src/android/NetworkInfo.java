package org.apache.cordova.fripixel;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

public class NetworkInfo extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("bssid")) {
            String bssid = this.getBSSID(message, callbackContext);

            if(bssid != null){
                callbackContext.success(message);
                return true;
            }
            else{
                callbackContext.error("Expected one non-empty string argument.");
                return false;
            }

        }
        return false;

    }

    private String getBSSID(){
        WifiManager manager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();

        String bssid = info.getBSSID();

        return bssid;
    }

}
