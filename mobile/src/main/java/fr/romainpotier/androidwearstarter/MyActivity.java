package fr.romainpotier.androidwearstarter;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.Wearable;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.rest.RestService;

import java.util.ArrayList;
import java.util.List;

import fr.romainpotier.androidwearstarter.beans.ApiResult;
import fr.romainpotier.androidwearstarter.beans.Record;
import fr.romainpotier.androidwearstarter.service.CoffeeService;

@EActivity(R.layout.activity_my)
public class MyActivity extends ActionBarActivity {

    private final static String TAG = "MyTag";

    private GoogleApiClient mGoogleAppiClient;

    // Données synchronisées
    private PutDataMapRequest dataMapRequest;

    @RestService
    CoffeeService coffeeService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mGoogleAppiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(Bundle connectionHint) {
                        Log.d(TAG, "onConnected()");
                    }
                    @Override
                    public void onConnectionSuspended(int cause) {

                    }
                })
                .addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(ConnectionResult result) {
                        Log.d(TAG, "onConnectionFailed: " + result);
                    }
                })
                .addApi(Wearable.API)
                .build();
        mGoogleAppiClient.connect();

     }

    @Click
    void button() {
        new MyAsync().execute();
    }

    private class MyAsync extends AsyncTask<Void, Void, Record> {

        @Override
        protected Record doInBackground(Void... params) {

            // Récupération liste des cafés
            final Record record = coffeeService.getCoffees().getRecords().get(0);

            return record;
        }

        @Override
        protected void onPostExecute(Record record) {
            final String coffeeName = record.getFields().getNom();
            final List<String> coordinates = Lists.transform(record.getGeometry().getCoordinates(), new Function<Double, String>() {

                @Override
                public String apply(Double input) {
                    return String.valueOf(input);
                }
            });

            dataMapRequest = PutDataMapRequest.create("/message/coffee");
            final DataMap dataMap = dataMapRequest.getDataMap();
            dataMap.putString("COFFEE_NAME", coffeeName);
            dataMap.putStringArrayList("COFFEE_COORDINATES", Lists.newArrayList(coordinates));
            Wearable.DataApi.putDataItem(mGoogleAppiClient, dataMapRequest.asPutDataRequest());
        }
    }

}
