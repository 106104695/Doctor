package com.doctor.demo;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MyEvaluateActivity extends FragmentActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myevaluate);

//		  //姝ラ涓�锛氭坊鍔犱竴涓狥ragmentTransaction鐨勫疄渚�
//		                FragmentManager fragmentManager =getFragmentManager();
//	                FragmentTransaction transaction = fragmentManager.beginTransaction();
//
//		                 //姝ラ浜岋細鐢╝dd()鏂规硶鍔犱笂Fragment鐨勫璞ightFragment
//	                Listitem_activity_fragment listitem_activityfrg = new Listitem_activity_fragment();
//
//		                transaction.add(R.id.complainitems, listitem_activityfrg);
//
//		                //姝ラ涓夛細璋冪敤commit()鏂规硶浣垮緱FragmentTransaction瀹炰緥鐨勬敼鍙樼敓鏁�
//		                 transaction.commit();

        ImageView iv_title_bar_left = (ImageView) findViewById(R.id.img_myevaluate_back);
        iv_title_bar_left.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // 闃叉鎸夐挳杩炵画鐐瑰嚮
//				if (Utils.isFastClick()) {
//					return;
//				}
                finish();
//				Intent intent = new Intent(Complain_activity.this,
//						User_nominfo_activity.class);
//				Complain_activity.this.startActivity(intent);

            }
        });

    }

}
