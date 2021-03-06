package com.doctor.demo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doctor.demo.LoginActivity;
import com.doctor.demo.MoreActivity;
import com.doctor.demo.MyDoctorsActivity;
import com.doctor.demo.MyEvaluateActivity;
import com.doctor.demo.R;
import com.doctor.demo.UserInfoActivity;

/**
 * Created by HDY on 2016/12/27.
 */

public class MineFragment extends Fragment implements View.OnClickListener {
    private View layout;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (layout == null){

            layout = inflater.inflate(R.layout.fragment_mine,container,false);
        }
        setOnListener();
        return layout;
    }

    private void setOnListener() {

            layout.findViewById(R.id.layout_userinfo).setOnClickListener(this);
        layout.findViewById(R.id.personal_login_button).setOnClickListener(this);
        layout.findViewById(R.id.layout_more).setOnClickListener(this);
        layout.findViewById(R.id.layout_mine_evaluate).setOnClickListener(this);
        layout.findViewById(R.id.layout_mine_complaint).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.personal_login_button: // 登录
                login();
                break;
            case R.id.layout_userinfo: // 个人信息
                startActivity(new Intent(getActivity(), UserInfoActivity.class));
                break;
            case R.id.layout_mine_evaluate: // 我的评价
                startActivity(new Intent(getActivity(), MyEvaluateActivity.class));
                break;
            case R.id.layout_mine_complaint: // 我的投诉
                startActivity(new Intent(getActivity(), MyEvaluateActivity.class));
                break;
            case R.id.layout_mine_doctors: // 我的医生
                startActivity(new Intent(getActivity(), MyDoctorsActivity.class));
                break;
            case R.id.layout_more: // 更多

                startActivity(new Intent(getActivity(), MoreActivity.class));

                break;
 /* case R.id.layout_mine_android_my_jd_assitant: // 贴心服务
                Intent intent = new Intent(getActivity(), WebActivity.class);
                intent.putExtra("direction", 5);
                startActivity(intent);
                break;
            case R.id.layout_mine_wallet: // 我的钱包
                startActivity(new Intent(getActivity(), PurseActivity.class));
                break;


            case R.id.layout_mine_history: // 浏览记录
                startActivity(new Intent(getActivity(), HistoryActivity.class));
                break;
            case R.id.layout_mine_appoint: // 我的预约
                Intent intent3 = new Intent(getActivity(), WebActivity.class);
                intent3.putExtra("direction", 9);
                startActivity(intent3);
                break;
            case R.id.layout_mine_account_center: // 账户与安全
                Intent intent4 = new Intent(getActivity(), WebActivity.class);
                intent4.putExtra("direction", 12);
                startActivity(intent4);
                break;
            case R.id.layout_mine_service_manager: // 服务管家
                Intent intent5 = new Intent(getActivity(), WebActivity.class);
                intent5.putExtra("direction", 10);
                startActivity(intent5);
                break;
            case R.id.layout_mine_discuss: // 评价商品
                Intent intent6 = new Intent(getActivity(), WebActivity.class);
                intent6.putExtra("direction", 11);
                startActivity(intent6);
                break;
*/
            default:
                break;
        }
    }
    private void login() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}
