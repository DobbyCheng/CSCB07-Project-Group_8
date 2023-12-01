package com.example.b07project.stuentop;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class ViewAnnouncementFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Handle FCM message here
        Log.d("FCM", "Message received: " + remoteMessage.getData());

        String notificationTitle = remoteMessage.getData().get("title");
        String notificationBody = remoteMessage.getData().get("content");
        Toast.makeText(getApplicationContext(), notificationTitle + ": " + notificationBody, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNewToken(String token) {
        // Handle new FCM token
        Log.d("FCM", "Refreshed token: " + token);
    }
}