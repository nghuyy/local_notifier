package ngghuy.local_notifier;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;

/** ChromeboxPlugin */
public class LocalNotifierPlugin implements FlutterPlugin, MethodCallHandler,ActivityAware  {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;
  private Activity activity;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "local_notifier");
    channel.setMethodCallHandler(this);
  }

  private void createNotificationChannel() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      CharSequence name = "Notification";
      String description = "App Notification";
      int importance = NotificationManager.IMPORTANCE_DEFAULT;
      NotificationChannel channel = new NotificationChannel(activity.getPackageName(), name, importance);
      channel.setDescription(description);
      NotificationManager notificationManager = activity.getSystemService(NotificationManager.class);
      notificationManager.createNotificationChannel(channel);
    }
  }
  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if(call.method.equals("notify")){
      Log.e(activity.getPackageName(),call.argument("title"));
      createNotificationChannel();
      NotificationCompat.Builder builder = new NotificationCompat.Builder(activity, activity.getPackageName())
              .setSmallIcon(R.drawable.ic_stat_name)
              .setContentTitle(call.argument("title"))
              .setContentText(call.argument("subtitle"))
              .setPriority(NotificationCompat.PRIORITY_DEFAULT);
      NotificationManagerCompat notificationManager = NotificationManagerCompat.from(activity);
      notificationManager.notify(1, builder.build());
    } else {
      result.notImplemented();
    }

  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }

  @Override
  public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
    this.activity = binding.getActivity();
  }

  @Override
  public void onDetachedFromActivityForConfigChanges() {

  }

  @Override
  public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {

  }

  @Override
  public void onDetachedFromActivity() {

  }
}
