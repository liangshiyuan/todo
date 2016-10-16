package com.lsy.todo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.view.View;

import com.lsy.test.R;
import com.lsy.todo.tools.Utils;

public class MyCordova extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.endsWith("share")) {
			String title = this.cordova.getActivity().getString(R.string.app_name);
			String text = this.cordova.getActivity().getString(R.string.app_desc);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
			String imagePath = "/sdcard/" + sdf.format(new Date()) + ".png";
			View view = this.cordova.getActivity().getWindow().getDecorView().findViewById(android.R.id.content);
			Utils.saveScreen(view, imagePath);
			Utils.showShare(this.cordova.getActivity(), title, text, imagePath);
		}
		return super.execute(action, args, callbackContext);
	}

}
