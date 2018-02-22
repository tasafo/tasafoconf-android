package org.tasafo.tasafoconf.io.json.io.playservices;

import android.content.Context;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by ramonrabello on 16/11/15.
 */
public final class PlayServicesManager {

    GoogleApiClient googleApiClient;

    public void authenticate(){

    }

    public void connect(Api api, Context context){
//        googleApiClient = new GoogleApiClient
//                .Builder(context)
//                .addApi(api)
//                .addScope(Drive.SCOPE_FILE)
//                .addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
//                    @Override
//                    public void onConnectionFailed(ConnectionResult connectionResult) {
//
//                    }
//                }).build();
    }

    public void get(Api api){

    }

    public void send(Api api){

    }
}
