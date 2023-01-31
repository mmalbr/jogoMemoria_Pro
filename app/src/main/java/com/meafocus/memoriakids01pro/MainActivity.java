package com.meafocus.memoriakids01pro;


import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.LoadAdError;
//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
//import com.google.android.gms.ads.reward.RewardItem;
//import com.google.android.gms.ads.reward.RewardedVideoAd;
//import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.meafocus.memoriakids01pro.common.Shared;
import com.meafocus.memoriakids01pro.engine.Engine;
import com.meafocus.memoriakids01pro.engine.ScreenController;
import com.meafocus.memoriakids01pro.engine.ScreenController.Screen;
import com.meafocus.memoriakids01pro.events.EventBus;
import com.meafocus.memoriakids01pro.events.ui.BackGameEvent;
import com.meafocus.memoriakids01pro.ui.PopupManager;
//import com.meafocus.memoriakids01pro.utils.AdsController;
import com.meafocus.memoriakids01pro.utils.Utils;

public class MainActivity extends FragmentActivity //implements AdsController, RewardedVideoAdListener
 {

	private ImageView mBackgroundImage;
//	private RewardedVideoAd rewardedVideoAd;
	private MediaPlayer mpBackground;
	public static boolean OFFSOUND = false;


	@RequiresApi(api = Build.VERSION_CODES.KITKAT)
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		Shared.context = getApplicationContext();
		Shared.engine = Engine.getInstance();
		Shared.eventBus = EventBus.getInstance();

		setContentView(R.layout.activity_main);
		mBackgroundImage = (ImageView) findViewById(R.id.background_image);

		Shared.activity = this;
		Shared.engine.start();
		Shared.engine.setBackgroundImageView(mBackgroundImage);

		// set background
		setBackgroundImage();

		// set music
		if (!OFFSOUND) {
			soundBackground();
		}

		// set menu
		ScreenController.getInstance().openScreen(Screen.MENU);

		getWindow().getDecorView().setSystemUiVisibility(
				View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
						View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

//		//banner

//		MobileAds.initialize(this, new OnInitializationCompleteListener() {
//			@Override
//			public void onInitializationComplete(InitializationStatus initializationStatus) {
//			}
//		});

		//banner admob - Início
//		AdView mAdView = findViewById(R.id.adView);
//		AdRequest adRequest = new AdRequest.Builder().build();
//		mAdView.loadAd(adRequest);

//		mAdView.setAdListener(new AdListener() {
//			@Override
//			public void onAdLoaded() {
//				// Code to be executed when an ad finishes loading.
//			}

//			@Override
//			public void onAdFailedToLoad(LoadAdError adError) {
//				// Code to be executed when an ad request fails.
//			}

//			@Override
//			public void onAdOpened() {
//				// Code to be executed when an ad opens an overlay that
//				// covers the screen.
//			}

//			@Override
//			public void onAdClicked() {
//				// Code to be executed when the user clicks on an ad.
//			}

//			@Override
//			public void onAdLeftApplication() {
//				// Code to be executed when the user has left the app.
//			}

//			@Override
//			public void onAdClosed() {
//				// Code to be executed when the user is about to return
//				// to the app after tapping on an ad.
//			}
//		});

//		//banner admob - Fim

//		//banner intestitial - inicio

//		rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
//		rewardedVideoAd.setRewardedVideoAdListener(this);
//	//		loadRewardedVideoAd();

	}
//	//banner intestitial -fim


	public void soundBackground(){

			mpBackground = MediaPlayer.create(Shared.context, R.raw.bensound_smile);
			mpBackground.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mpBackground) {
					mpBackground.reset();
					mpBackground.release();
					mpBackground = null;
				}

			});
			mpBackground.start();
			mpBackground.setLooping(true);



	}



//	@Override
//	public void showRewardedVideo() {
//		runOnUiThread(new Runnable() {
//			@Override
//			public void run() {
//				if (rewardedVideoAd.isLoaded()) {
//					rewardedVideoAd.show();
//				} else loadRewardedVideoAd();
//			}
//		});

//	}


//	@Override
//	public void loadRewardedVideoAd() {
//		rewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917", // Test Ad
//				new AdRequest.Builder().build());

//	}

//	@Override
//	public void onRewardedVideoAdLoaded() {
//		Toast.makeText(this, "Ads Carregado", Toast.LENGTH_SHORT).show();
//		showRewardedVideo();


//	}

//	@Override
//	public void onRewardedVideoAdOpened() {

//	}


//	@Override
//	public void onRewardedVideoStarted() {
//		Toast.makeText(this, "Exibindo ads", Toast.LENGTH_SHORT).show();

//	}

//	@Override
//	public void onRewardedVideoAdClosed() {

//	}


//	@Override
//	public void onRewarded(RewardItem rewardItem) {
//	//		Toast.makeText(this, "Recompensa: "+rewardItem.getAmount(), Toast.LENGTH_SHORT).show();
//		Toast.makeText(this, "ADS assistido...", Toast.LENGTH_LONG).show();

//	}

//	@Override
//	public void onRewardedVideoAdLeftApplication() {

//	}

//	@Override
//	public void onRewardedVideoAdFailedToLoad(int i) {

//	}

//	@Override
//	public void onRewardedVideoCompleted() {

//	}


	@Override
	protected void onDestroy() {
		Shared.engine.stop();
		if (mpBackground != null) {
			mpBackground.stop();
			mpBackground.reset();
			mpBackground.release();
		}
		super.onDestroy();
	}

	@Override
	public void onBackPressed() {
		if (PopupManager.isShown()) {
			if (OFFSOUND) {
				if (mpBackground != null) {
					if (mpBackground.isPlaying()) {
						mpBackground.pause();
					}
				}
			}else
			{
				if 	(mpBackground == null){
					soundBackground();
				}else{
					if (!mpBackground.isPlaying()) {
						mpBackground.start();
					}
				}
			}
				PopupManager.closePopup();
			if (ScreenController.getLastScreen() == Screen.GAME) {
				Shared.eventBus.notify(new BackGameEvent());
			}
		} else if (ScreenController.getInstance().onBack()) {
			super.onBackPressed();
		}
	}


	private void setBackgroundImage() {
		Bitmap bitmap = Utils.scaleDown(R.drawable.background, Utils.screenWidth(), Utils.screenHeight());
		bitmap = Utils.crop(bitmap, Utils.screenHeight(), Utils.screenWidth());
		bitmap = Utils.downscaleBitmap(bitmap, 2);
		mBackgroundImage.setImageBitmap(bitmap);
	}


	public void adsButton(View view) {
		PopupManager.showPopupNoAds();
	}


	public void voltar(View view) {
		if (PopupManager.isShown()) {
			if (OFFSOUND) {
				if (mpBackground != null) {
					if (mpBackground.isPlaying()) {
						mpBackground.pause();
					}
				}
			}else
			{
				if 	(mpBackground == null){
				soundBackground();
			}else{
				if (!mpBackground.isPlaying()) {
					mpBackground.start();
				}
			}
			}
			PopupManager.closePopup();
			if (ScreenController.getLastScreen() == Screen.GAME) {
				Shared.eventBus.notify(new BackGameEvent());
			}
		} else if (ScreenController.getInstance().onBack()) {
			super.onBackPressed();
		}
	}

	@Override
	protected void onStop() {
		super.onStop();
		if (!OFFSOUND) {
			if (mpBackground != null) {
				if (mpBackground.isPlaying()) {
					mpBackground.pause();
				}
			}
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		if (!OFFSOUND) {
			if (mpBackground != null) {
				if (mpBackground.isPlaying()) {
					mpBackground.pause();
				}
			}
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (!OFFSOUND) {
			if (mpBackground != null) {
				mpBackground.start();
				mpBackground.setLooping(true);
			}
		}
	}


}
