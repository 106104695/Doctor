package com.doctor.demo.fragment;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.doctor.demo.R;
import com.doctor.demo.view.UPMarqueeView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private ViewPager mPager;
    private int[] mBanner = new int[]{R.drawable.img_home_banner1,
            R.drawable.img_home_banner2, R.drawable.img_home_banner3,
            R.drawable.img_home_banner4};

    private ImageView mImageView;
    private ImageView mImgCover;
    private int mLastPos;// 记录上一次ViewPager的位置
    private boolean isDragging;// 是否被拖拽
    private boolean isFoucusRight; // ScrollView是否滚动到右侧
    private View layout;

    private UPMarqueeView upview1;
    List<String> data = new ArrayList<>();
    List<View> upviews = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (layout != null) {
            // 防止多次new出片段对象，造成图片错乱问题
            return layout;
        }
        layout = inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        initPager();
        autoScroll();
        initParam();
        initdata();
        initupView();
        return layout;
    }

    private void initView() {

        mImgCover = (ImageView) layout.findViewById(R.id.img_cover);
        mImageView = (ImageView) layout.findViewById(R.id.img_indicator01);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // 将layout从父组件中移除
        ViewGroup parent = (ViewGroup) layout.getParent();
        parent.removeView(layout);
    }

    private void initPager() {
        mPager = (ViewPager) layout.findViewById(R.id.pager_banner);
        FragmentManager fm = getChildFragmentManager();
        MyPagerAdapter adapter = new MyPagerAdapter(fm);
        mPager.setAdapter(adapter);
        mPager.setCurrentItem(1000);
        mPager.setOnPageChangeListener(new MyPagerListener());
    }

    /**
     * 自动滚动
     */
    private void autoScroll() {
        mPager.postDelayed(new Runnable() {

            @Override
            public void run() {
                if (!isDragging) {
                    // 若用户没有拖拽，则自动滚动
                    mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                }

                isFoucusRight = !isFoucusRight;
                mPager.postDelayed(this, 3000);
            }
        }, 3000);

 /*   @Override
    public void onClick(View v) {
        switch (v.getId()) {
           *//* case R.id.img_home_category: // 切换到分类
                activeCategory();
                break;*//*
           // case R.id.img_home_search_code: // 二维码扫描
              //  ((MainActivity) getActivity()).scanQRCode();
               // break;



            default:
                break;
        }
    }*/
/*
    *//**
         * 转到商品详情
         *//*
    private void gotoDetail(int index) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(Constants.INTENT_KEY.INFO_TO_DETAIL, mInfos[index]);
        startActivity(intent);
    }

    private void gotoSearch() {
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        startActivity(intent);
        // activity开启无动画
        getActivity().overridePendingTransition(0, 0);
    }

    private class GetDataTask extends AsyncTask<Void, Void, String[]> {
        protected String[] doInBackground(Void... params) {
            // 下拉刷新
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            return null;
        }



    }*/


    }

    @Override
    public void onClick(View view) {

    }
    private class MyPagerAdapter  extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            BannerItemFragment fragment = new BannerItemFragment();
            fragment.setResId(mBanner[position % mBanner.length]);
            // fragment.setGoodsInfo(mInfos[position % mBanner.length]);
            return fragment;
        }

        @Override
        public int getCount() {
            return 10000;
        }

    }

    private class MyPagerListener implements   ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            int width = mImgCover.getWidth();
            LayoutParams layoutParams = (LayoutParams) mImageView
                    .getLayoutParams();
            int rightMargin = layoutParams.rightMargin;
            int endPos = (width + rightMargin) * (position % 4);
            int startPos = 0;
            if (mLastPos < position) {
                // 图片向右移动
                startPos = (width + rightMargin) * (position % 4 - 1);
            } else {
                // 图片向左移动
                startPos = (width + rightMargin) * (position % 4 + 1);
            }
            ObjectAnimator.ofFloat(mImgCover, "translationX", startPos, endPos)
                    .setDuration(300).start();
            mLastPos = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            switch (state) {
                case ViewPager.SCROLL_STATE_DRAGGING:
                    // 用户拖拽
                    isDragging = true;
                    break;
                case ViewPager.SCROLL_STATE_IDLE:
                    // 空闲状态
                    isDragging = false;
                    break;
                case ViewPager.SCROLL_STATE_SETTLING:
                    // 被释放时
                    isDragging = false;
                    break;

                default:
                    break;
            }
        }
    }


    /**
     * 实例化控件
     */
    private void initParam() {
        upview1 = (UPMarqueeView) layout.findViewById(R.id.upview1);
    }

    /**
     * 初始化数据
     */
    private void initdata() {
        data = new ArrayList<>();
        data.add("家人给2岁孩子喝这个，孩子智力倒退10岁!!!");
        data.add("iPhone8最感人变化成真，必须买买买买!!!!");
        data.add("简直是白菜价！日本玩家33万甩卖15万张游戏王卡");
        data.add("iPhone7价格曝光了！看完感觉我的腰子有点疼...");
        data.add("主人内疚逃命时没带够，回废墟狂挖30小时！");
        data.add("竟不是小米乐视！看水抢了骁龙821首发了！！！");

    }
    /**
     * 初始化界面程序
     */
    private void initupView() {
        setView();
        upview1.setViews(upviews);
        /**
         * 设置item_view的监听
         */
        upview1.setOnItemClickListener(new UPMarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {

            }
        });
    }

    /**
     * 初始化需要循环的View
     * 为了灵活的使用滚动的View，所以把滚动的内容让用户自定义
     * 假如滚动的是三条或者一条，或者是其他，只需要把对应的布局，和这个方法稍微改改就可以了，
     */
    private void setView() {
        for (int i = 0; i < data.size(); i = i + 2) {
            final int position = i;
            //设置滚动的单个布局
            LinearLayout moreView = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.item_upview, null);
            //初始化布局的控件
            TextView tv1 = (TextView) moreView.findViewById(R.id.tv1);
            TextView tv2 = (TextView) moreView.findViewById(R.id.tv2);

            /**
             * 设置监听
             */
            moreView.findViewById(R.id.rl).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            /**
             * 设置监听
             */
            moreView.findViewById(R.id.rl2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            //进行对控件赋值
            tv1.setText(data.get(i).toString());
            if (data.size() > i + 1) {
                //因为淘宝那儿是两条数据，但是当数据是奇数时就不需要赋值第二个，所以加了一个判断，还应该把第二个布局给隐藏掉
                tv2.setText(data.get(i + 1).toString());
            } else {
                moreView.findViewById(R.id.rl2).setVisibility(View.GONE);
            }

            //添加到循环滚动数组里面去
            upviews.add(moreView);
        }
    }

}