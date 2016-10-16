package com.lsy.todo.tools;

import android.content.Context;
import cn.sharesdk.framework.ShareSDK;

import com.sharesdk.onekeyshare.OnekeyShare;

public class Utils {

	public void showShare(Context context,String title,String text,String imagePath) {
		ShareSDK.initSDK(context);
		OnekeyShare oks = new OnekeyShare();
		oks.disableSSOWhenAuthorize();
		oks.setTitle(title);
		oks.setText(text);
		oks.setImagePath(imagePath);
//		 oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
		oks.show(context);
	}

}
