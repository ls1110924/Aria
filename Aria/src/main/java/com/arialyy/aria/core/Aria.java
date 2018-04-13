/*
 * Copyright (C) 2016 AriaLyy(https://github.com/AriaLyy/Aria)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.arialyy.aria.core;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import com.arialyy.aria.core.download.DownloadReceiver;
import com.arialyy.aria.core.upload.UploadReceiver;

/**
 * Created by lyy on 2016/12/1.
 * https://github.com/AriaLyy/Aria
 * Aria启动，管理全局任务
 * <pre>
 *   <code>
 *   //下载
 *   Aria.download(this)
 *       .load(URL)     //下载地址，必填
 *       //文件保存路径，必填
 *       .setDownloadPath(Environment.getExternalStorageDirectory().getPath() + "/test.apk")
 *       .start();
 *   </code>
 *   <code>
 *    //上传
 *    Aria.upload(this)
 *        .load(filePath)     //文件路径，必填
 *        .setUploadUrl(uploadUrl)  //上传路径，必填
 *        .setAttachment(fileKey)   //服务器读取文件的key，必填
 *        .start();
 *   </code>
 * </pre>
 */
@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) public class Aria {

  private Aria() {
  }

  /**
   * 初始化下载
   *
   * @param context 支持类型有【Activity、Service、Application、DialogFragment、Fragment、PopupWindow、Dialog】
   */
  public static DownloadReceiver download(Context context) {
    return get(context).download(context);
  }

  /**
   * 初始化上传
   *
   * @param context 支持类型有【Activity、Service、Application、DialogFragment、Fragment、PopupWindow、Dialog】
   */
  public static UploadReceiver upload(Context context) {
    return get(context).upload(context);
  }

  /**
   * 在任意对象中初始化下载
   *
   * @param obj 任意对象
   */
  public static DownloadReceiver download(Context context, Object obj) {
    return get(context).download(obj);
  }

  /**
   * 在任意对象中初始化上传
   *
   * @param obj 任意对象
   */
  public static UploadReceiver upload(Context context, Object obj) {
    return get(context).upload(obj);
  }

  /**
   * 处理通用事件
   */
  public static AriaManager get(Context context) {
    return AriaManager.getInstance(context);
    //if (obj instanceof Activity || obj instanceof Service || obj instanceof Application) {
    //  return AriaManager.getInstance((Context) obj);
    //} else if (obj instanceof DialogFragment) {
    //  DialogFragment dialog = (DialogFragment) obj;
    //  return AriaManager.getInstance(
    //      Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ? dialog.getContext()
    //          : dialog.getActivity());
    //} else if (obj instanceof android.support.v4.app.Fragment) {
    //  android.support.v4.app.Fragment fragment = (android.support.v4.app.Fragment) obj;
    //  return AriaManager.getInstance(
    //      Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ? fragment.getContext()
    //          : fragment.getActivity());
    //} else if (obj instanceof Fragment) {
    //  Fragment fragment = (Fragment) obj;
    //  return AriaManager.getInstance(
    //      Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ? fragment.getContext()
    //          : fragment.getActivity());
    //} else if (obj instanceof PopupWindow) {
    //  PopupWindow popupWindow = (PopupWindow) obj;
    //  return AriaManager.getInstance(popupWindow.getContentView().getContext());
    //} else if (obj instanceof Dialog) {
    //  Dialog dialog = (Dialog) obj;
    //  return AriaManager.getInstance(dialog.getContext());
    //} else {
    //  throw new IllegalArgumentException("不支持的类型");
    //}
  }
}
