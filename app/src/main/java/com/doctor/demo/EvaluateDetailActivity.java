package com.doctor.demo;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.doctor.demo.util.Utils;


public class EvaluateDetailActivity extends FragmentActivity {
    private	String itemclick="";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //鐐瑰嚮listview item 鐨勫��
//		Intent intent = getIntent();
//		Bundle bundle = intent.getExtras();
//		itemclick = bundle.getString("itemclivk");
//		Log.e("鐐瑰嚮浜嬩欢", itemclick);


//		  //姝ラ涓�锛氭坊鍔犱竴涓狥ragmentTransaction鐨勫疄渚�
//        FragmentManager fragmentManager =getFragmentManager();
//    FragmentTransaction transaction = fragmentManager.beginTransaction();
//
//         //姝ラ浜岋細鐢╝dd()鏂规硶鍔犱笂Fragment鐨勫璞ightFragment
//    Listitem_activity_fragment listitem_activityfrg = new Listitem_activity_fragment();
//
//        transaction.add(R.id.complainitems, listitem_activityfrg);
//
//        //姝ラ涓夛細璋冪敤commit()鏂规硶浣垮緱FragmentTransaction瀹炰緥鐨勬敼鍙樼敓鏁�
//         transaction.commit();


        setContentView(R.layout.activity_item_details_top);

        ImageView iv_title_bar_complainleft = (ImageView) findViewById(R.id.img_myevaluate_detail_back);
        iv_title_bar_complainleft.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // 闃叉鎸夐挳杩炵画鐐瑰嚮
                if (Utils.isFastClick()) {
                    return;
                }
                finish();
//				Intent intent = new Intent(Complaindetail_activity.this,
//						Complain_activity.class);
//				Complaindetail_activity.this.startActivity(intent);

            }
        });

    }
}


