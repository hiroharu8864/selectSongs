package jp.mailwalker.selectsongs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// タイトルを非表示にします。
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// splash.xmlをViewに指定します。
		setContentView(R.layout.splash);
		Handler handler = new Handler();
		// 500ms遅延させてsplashHandlerを実行します。
		handler.postDelayed(new splashHandler(), 500);
	}

	class splashHandler implements Runnable {
		public void run() {
			// スプラッシュ完了後に実行するActivityを指定します。
			Intent intent = new Intent(getApplication(), SelectItems.class);
			startActivity(intent);
			// SplashActivityを終了させます。
			SplashActivity.this.finish();
		}
	}

}
