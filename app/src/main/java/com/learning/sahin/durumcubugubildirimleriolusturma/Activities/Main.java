package com.learning.sahin.durumcubugubildirimleriolusturma.Activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.learning.sahin.durumcubugubildirimleriolusturma.R;

/**
 * Created by Sahin on 18.11.2016.
 */

public class Main extends AppCompatActivity implements View.OnClickListener{
    private Button btnNotif1,btnNotif2,btnNotif3,btnNotif4,btnNotif5;
    private final static String CONTENT_TEXT = "İçerik";
    private final static String BIG_TEXT = "Büyük İçerik Büyük İçerik Büyük İçerik Büyük İçerik.";
    private final static String CONTENT_TITLE = "Bildirim Başlığı";
    private final static String BIG_CONTENT_TITLE = "Büyük Bildirim Başlığı";
    private final static String TICKER = "Ticker";
    private final static String SUB_TEXT = "Sub İçerik";
    private final static String SUMMARY_TEXT = "+2 more";
    private final static String BIG_TEXT_BIG_CONTENT_TITLE = "Big Text Büyük Bildirim Başlığı";
    private final static String BIG_TEXT_SUMMARY_TEXT = "Big Text +2 more";
    private final static String BIG_PICTURE_BIG_CONTENT_TITLE = "Big Picture Büyük Bildirim Başlığı";
    private final static String BIG_PICTURE_SUMMARY_TEXT = "Big Picture +2 more";
    private int sayac = 0;
    private final static int Id1 = 1;
    private final static int Id2 = 2;
    private final static int Id3 = 3;
    private final static int Id4 = 4;
    private final static int Id5 = 5;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        install_elements();
    }


    private void install_elements()
    {
        btnNotif1 = (Button) findViewById(R.id.btnNotif1);
        btnNotif1.setOnClickListener(this);
        btnNotif2 = (Button) findViewById(R.id.btnNotif2);
        btnNotif2.setOnClickListener(this);
        btnNotif3 = (Button) findViewById(R.id.btnNotif3);
        btnNotif3.setOnClickListener(this);
        btnNotif4 = (Button) findViewById(R.id.btnNotif4);
        btnNotif4.setOnClickListener(this);
        btnNotif5 = (Button) findViewById(R.id.btnNotif5);
        btnNotif5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnNotif1:
                createNatification1();
                break;
            case R.id.btnNotif2:
                createNatification2();
                break;
            case R.id.btnNotif3:
                createNatification3();
                break;
            case R.id.btnNotif4:
                createNatification4();
                break;
            case R.id.btnNotif5:
                createNatification5();
                break;
            default: break;
        }
    }

    private void createNatification1() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_action_account_balance)
                .setContentTitle(CONTENT_TITLE)
                .setContentText(CONTENT_TEXT)
                .setContentIntent(getAnotherIntent())
                .addAction(R.drawable.ic_action_exit_to_app,"Show Activity",getAnotherIntent());
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(Id1,mBuilder.build()); // bildirimin uniq id sidir.
    }
    private void createNatification2(){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_action_account_circle)
                .setContentTitle(CONTENT_TITLE)
                .setContentText(CONTENT_TEXT);
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        String[] events = new String[6];
        events[0] = "0";
        events[1] = "1";
        events[2] = "2";
        events[3] = "3";
        events[4] = "4";
        events[5] = "5";
        inboxStyle.setBigContentTitle(BIG_CONTENT_TITLE);
        for (int i=0;i<events.length;i++)
        {
            inboxStyle.addLine(events[i]);
        }
        inboxStyle.setSummaryText(SUMMARY_TEXT);
        mBuilder.setStyle(inboxStyle);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(Id2,mBuilder.build()); //bildirimin uniq id sidir.
    }
    private void createNatification3() {
        long[] pattern = {500,500,500};
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setTicker(TICKER)
                .setSmallIcon(R.drawable.ic_action_get_app)
                .setContentTitle(CONTENT_TITLE)
                .setContentText(CONTENT_TEXT)
                .setWhen(System.currentTimeMillis()).setAutoCancel(true) // Bildirime tıklandığında, bildirimi bildirim çubuğundan siler.
                .setDefaults(Notification.DEFAULT_ALL) // titreşim ve bildirim sesi oluşturur. Yani varsayılan özellikleri yükler.
                //.setVibrate(pattern) // titreşim
                //.setLights(Color.BLUE, 500, 500) // bildirim ışığı
                .setNumber(sayac++)
                .setPriority(Notification.PRIORITY_MAX) // Ekranın üstünden Bildirim çıkarır.
                .setStyle(new NotificationCompat.BigTextStyle().bigText(BIG_TEXT)
                    .setBigContentTitle(BIG_TEXT_BIG_CONTENT_TITLE)
                    .setSummaryText(BIG_TEXT_SUMMARY_TEXT))
                .setSubText(SUB_TEXT);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(Id3,mBuilder.build()); // bildirimin uniq id sidir.
    }
    private void createNatification4() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_action_grade))
                .setContentTitle(CONTENT_TITLE)
                .setContentText(CONTENT_TEXT)
                .setSmallIcon(R.drawable.ic_action_grade);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(Id4,mBuilder.build()); // bildirimin uniq id sidir.
    }

    private void createNatification5() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_action_grade))
                .setContentTitle(CONTENT_TITLE)
                .setContentText(CONTENT_TEXT)
                .setSmallIcon(R.drawable.ic_action_group_work)
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.ic_action_grade))
                        .setBigContentTitle(BIG_PICTURE_BIG_CONTENT_TITLE)
                        .setSummaryText(BIG_PICTURE_SUMMARY_TEXT))
                .addAction(R.drawable.ic_action_exit_to_app,"Show Activity",getAnotherIntent())
                .addAction(R.drawable.ic_social_share,"Share",getAnotherIntent())
                .setContentIntent(getAnotherIntent());
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(Id5,mBuilder.build()); // bildirimin uniq id sidir.
    }

    private PendingIntent getAnotherIntent()
    {
        Intent resultIntent = new Intent(this,Result.class);
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Result.class);
        //Bildirime tıklandığında oluşturulan intenti çalıştırır.
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        return resultPendingIntent;
    }
}
