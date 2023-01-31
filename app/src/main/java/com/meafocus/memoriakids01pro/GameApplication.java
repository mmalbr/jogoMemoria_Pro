package com.meafocus.memoriakids01pro;

import android.app.Application;

import com.meafocus.memoriakids01pro.utils.FontLoader;

public class GameApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		FontLoader.loadFonts(this);

	}
}
