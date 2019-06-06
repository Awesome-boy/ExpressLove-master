package com.example.lenovo.expresslove;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gongwen.marqueen.SimpleMF;
import com.gongwen.marqueen.SimpleMarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BannerActivity extends AppCompatActivity {

    private Banner banner;
    List<Integer> images= new ArrayList<>();
    private ArrayList<Integer> list_path;
    private ArrayList<String> list_title;
    private SimpleMarqueeView<String> marqueeView;
    private ListView listView;
    private MyAdapter adapter;
    private List<String> listDates=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        initView();
        initData();
    }

    private void initData() {
        //        images.add(R.mipmap.girl);
//        images.add(R.mipmap.girl2);
//        images.add(R.mipmap.girl3);
//        images.add(R.mipmap.girl4);
        list_path = new ArrayList<Integer>();
        list_title = new ArrayList<>();
        list_path.add(R.mipmap.girl1);
        list_path.add(R.mipmap.girl2);
        list_path.add(R.mipmap.girl3);
        list_path.add(R.mipmap.girl4);
        list_title.add("风筝有风");
        list_title.add("海豚有海");
        list_title.add("520");
        list_title.add("有你");
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(list_path);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(list_title);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        final List<String> datas = Arrays.asList("《Alice专属App》", "版权所有 违者必究");
        SimpleMF<String> marqueeFactory = new SimpleMF(this);
        marqueeFactory.setData(datas);
        marqueeView.setMarqueeFactory(marqueeFactory);
        marqueeView.startFlipping();
        listDates.clear();
        listDates.add("我如果爱你");
        listDates.add("绝不像攀援的凌霄花");
        listDates.add("借你的高枝炫耀自己；");
        listDates.add("我如果爱你");
        listDates.add("绝不学痴情的鸟儿");
        listDates.add("为绿荫重复单调的歌曲");
        listDates.add("也不止像泉源");
        listDates.add("常年送来清凉的慰藉；");
        listDates.add("也不止像险峰");
        listDates.add(" 增加你的高度，衬托你的威仪。");
        listDates.add("甚至日光甚至春雨，");
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        getSupportActionBar().hide();
        banner = (Banner) findViewById(R.id.banner);
        marqueeView = (SimpleMarqueeView<String>) findViewById(R.id.marqueeView1);
        listView = findViewById(R.id.listview);
        adapter = new MyAdapter(this,listDates);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(parent.getContext(),Main3Activity.class));
            }
        });
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            startActivity(new Intent(this,Main3Activity.class));
        }
        return true;
    }
}
