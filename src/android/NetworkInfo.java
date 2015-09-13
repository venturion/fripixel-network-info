package org.apache.cordova.fripixel;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

public class NetworkInfo extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

            String bssid = this.getBSSID();

            if(bssid != null){
                callbackContext.success(bssid);
                return true;
            }
            else{
                callbackContext.error("Expected one non-empty string argument.");
                return false;
            }

        
        return false;

    }

    private String getBSSID(){
        WifiManager manager = (WifiManager) this.cordova.getActivity().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();

        String bssid = info.getBSSID();

        return bssid;
    }

}
