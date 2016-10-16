package com.lsy.todo;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import com.lsy.test.R;
import com.lsy.todo.tools.Utils;

public class MyCordova extends CordovaPlugin{

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if(action.endsWith("share")){
			String title = this.cordova.getActivity().getString(R.string.app_name);
			String text = this.cordova.getActivity().getString(R.string.app_desc);
			String imagePath = "";
			new Utils().showShare(this.cordova.getActivity(), title, text, imagePath);
		}
		return super.execute(action, args, callbackContext);
	}

}
