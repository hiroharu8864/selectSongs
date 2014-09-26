package jp.mailwalker.selectsongs;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SelectItems extends Activity {

	private final String tag = "Android";
	private final String error = "取得エラー";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// スーパークラスのonCreateメソッド呼び出し
		super.onCreate(savedInstanceState);
		// レイアウト設定ファイルの指定
		setContentView(R.layout.activity_select_items);
		// ボタンオブジェクトを取得
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new ButtonClickListener1());
		
		Button button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(new ButtonClickListener2());
	}

	class ButtonClickListener1 implements OnClickListener {
		public void onClick(View v) {
			InputStream inputStream = null;
			BufferedReader bufferedReader = null;
			ArrayList<String> messageItem = new ArrayList<String>();

		try {
			inputStream = getAssets().open("ranking90.txt");
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String str;

			int rawCounts = 0;
				
			while((str = bufferedReader.readLine()) != null) {
				messageItem.add(str);
				rawCounts++;
			}

			Random random = new Random();
			int randomNumber = random.nextInt(rawCounts);
			String message = messageItem.get(randomNumber);

			bufferedReader.close();
			Toast.makeText(SelectItems.this, message, Toast.LENGTH_LONG).show();
				
			} catch (IOException e) {
					// TODO Auto-generated catch block
					Toast.makeText(SelectItems.this, error, Toast.LENGTH_LONG).show();
			} finally {
				messageItem.clear();
				if (!messageItem.isEmpty()) {
					Log.d(tag, "MessageItem List is not Empty!");
				}
			}
		}
	}
	
	class ButtonClickListener2 implements OnClickListener {
		public void onClick(View v) {
			InputStream inputStream = null;
			BufferedReader bufferedReader = null;
			ArrayList<String> messageItem = new ArrayList<String>();

		try {
			inputStream = getAssets().open("ranking00.txt");
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String str;

			int rawCounts = 0;
				
			while((str = bufferedReader.readLine()) != null) {
				messageItem.add(str);
				rawCounts++;
			}

			Random random = new Random();
			int randomNumber = random.nextInt(rawCounts);
			String message = messageItem.get(randomNumber);

			bufferedReader.close();
			Toast.makeText(SelectItems.this, message, Toast.LENGTH_LONG).show();
				
			} catch (IOException e) {
					// TODO Auto-generated catch block
					Toast.makeText(SelectItems.this, error, Toast.LENGTH_LONG).show();
			} finally {
				messageItem.clear();
				if (!messageItem.isEmpty()) {
					Log.d(tag, "MessageItem List is not Empty!");
				}
			}
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select_items, menu);
		return true;
	}

}
