package com.example.myapplication8_recyclerview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


/**
 * List(リストに表示すべきデータソース)とViewHolder(ビュー情報)をアダプターに格納
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    List<YouTubeVideos> youtubeVideoList;

    public VideoAdapter() {
    }

    //コンストラクター(データソースを準備)
    public VideoAdapter(List<YouTubeVideos> youtubeVideoList) {
        this.youtubeVideoList = youtubeVideoList;
    }

    //ビューホルダーを生成
    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.video_view, parent, false);

        return new VideoViewHolder(view);

    }

    //ビューにデータを割り当て、リスト項目を生成
    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {

        holder.videoWeb.loadData( youtubeVideoList.get(position).getVideoUrl(), "text/html" , "utf-8" );

    }

    //リストの項目数を取得
    @Override
    public int getItemCount() {
        return youtubeVideoList.size();
    }




    //ビューホルダーを作成
    public class VideoViewHolder extends RecyclerView.ViewHolder{

        //ビューに配置されたウィジェットを保持しておくためのフィールド
        WebView videoWeb;

        //コンストラクター
        public VideoViewHolder(View itemView) {
            super(itemView);

            videoWeb = (WebView) itemView.findViewById(R.id.videoWebView);

            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient() {

            } );
        }
    }
}