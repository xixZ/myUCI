package com.example.jessica.myuci;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by xi on 2016/3/1.
 */

public class GetLatLng {
    public static LatLng getlatlngFromAddress(Context context,String strAddress) {
        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng p1 = null;
        try {
            address = coder.getFromLocationName("UCI " + strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new LatLng(location.getLatitude(), location.getLongitude() );

        } catch (Exception ex) {
            Log.d("---: ", "LatLng Error. Could not generate appropriate latitude and longitude");
            ex.printStackTrace();
            return null;
        }
        return p1;
    }
}