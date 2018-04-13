package com.arialyy.simple.test;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.arialyy.annotations.Download;
import com.arialyy.aria.core.Aria;
import com.arialyy.aria.core.common.RequestEnum;
import com.arialyy.aria.core.download.DownloadTask;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.frame.util.show.L;
import java.io.File;

/**
 * Created by laoyuyu on 2018/4/13.
 */

public class AnyRunnModule {
  String TAG = "TestActivity";
  String URL = "http://58.210.9.131/tpk/sipgt//TDLYZTGH.tpk"; //chunked 下载
  private Context mContext;

  public AnyRunnModule(Context context) {
    Aria.download(context, this).register();
    mContext = context;
  }

  @Download.onWait void onWait(DownloadTask task) {
    Log.d(TAG, "wait ==> " + task.getDownloadEntity().getFileName());
  }

  @Download.onPre protected void onPre(DownloadTask task) {
    Log.d(TAG, "onPre");
  }

  @Download.onTaskStart void taskStart(DownloadTask task) {
    Log.d(TAG, "onStart");
  }

  @Download.onTaskRunning protected void running(DownloadTask task) {
    Log.d(TAG, "running");
  }

  @Download.onTaskResume void taskResume(DownloadTask task) {
    Log.d(TAG, "resume");
  }

  @Download.onTaskStop void taskStop(DownloadTask task) {
    Log.d(TAG, "stop");
  }

  @Download.onTaskCancel void taskCancel(DownloadTask task) {
    Log.d(TAG, "cancel");
  }

  @Download.onTaskFail void taskFail(DownloadTask task) {
    Log.d(TAG, "fail");
  }

  @Download.onTaskComplete void taskComplete(DownloadTask task) {
    L.d(TAG, "path ==> " + task.getDownloadEntity().getDownloadPath());
    L.d(TAG, "md5Code ==> " + CommonUtil.getFileMD5(new File(task.getDownloadPath())));
  }

  void start() {
    Aria.download(mContext, this)
        .load(URL)
        .addHeader("Accept-Encoding", "gzip, deflate")
        .setRequestMode(RequestEnum.GET)
        .setFilePath(Environment.getExternalStorageDirectory().getPath() + "/ggsg1.apk")
        .resetState()
        .start();
  }

  void stop() {
    Aria.download(mContext, this).load(URL).stop();
  }

  void cancel() {
    Aria.download(mContext, this).load(URL).cancel();
  }

  void unRegist() {
    Aria.download(mContext, this).unRegister();
  }
}
