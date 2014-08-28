package fr.romainpotier.androidwearstarter;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.WearableListenerService;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MyService extends WearableListenerService {

    private final static String TAG = "MyTag";

    private GoogleApiClient mGoogleApiClient;

    @Override
    public void onCreate() {
        super.onCreate();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Wearable.API)
                .build();
    }

    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {
        for (DataEvent dataEvent : dataEvents) {
            if (dataEvent.getType() == DataEvent.TYPE_CHANGED) {
                if ("/message/coffee".equals(dataEvent.getDataItem().getUri().getPath())) {
                    final DataMapItem dataMapItem = DataMapItem.fromDataItem(dataEvent.getDataItem());
                    final DataMap dataMap = dataMapItem.getDataMap();
                    // Coffee name
                    final String coffee = dataMap.getString("COFFEE_NAME");
                    Toast.makeText(this, coffee, Toast.LENGTH_LONG).show();
                    // Coffee coordinates
                    final ArrayList<String> coordinates = dataMap.getStringArrayList("COFFEE_COORDINATES");
                    createNotification(coffee, coordinates);
                }
            }
        }
    }

    private void createNotification(String film, ArrayList<String> coordinates) {
        int notificationId = 001;

        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        final String coordinatesString = Uri.encode(coordinates.get(0)+ "," + coordinates.get(1));
        Uri geoUri = Uri.parse("geo:" + coordinatesString);
        mapIntent.setData(geoUri);
        PendingIntent mapPendingIntent =
                PendingIntent.getActivity(this, 0, mapIntent, 0);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Informations sur un café")
                        .setContentText(film)
                        .addAction(android.R.drawable.ic_dialog_map,
                                "Voir sur une carte", mapPendingIntent);

        notificationBuilder.setVibrate(new long[] { 1000, 1000 });

        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);

        notificationManager.notify(notificationId, notificationBuilder.build());
    }

}
