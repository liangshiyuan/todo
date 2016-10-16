package com.lsy.todo.tools;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import cn.sharesdk.framework.ShareSDK;

import com.sharesdk.onekeyshare.OnekeyShare;

public class Utils {

	public static void showShare(Context context, String title, String text, String imagePath) {
		ShareSDK.initSDK(context);
		OnekeyShare oks = new OnekeyShare();
		oks.disableSSOWhenAuthorize();
		oks.setTitle(title);
		oks.setText(text);
		oks.setImagePath(imagePath);
		oks.show(context);
	}

	public static void saveScreen(View view,String imagePath) {
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap bitmap = view.getDrawingCache();
		if (bitmap != null) {
			try {
				FileOutputStream out = new FileOutputStream(imagePath);
				bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			
		}
	}
}
