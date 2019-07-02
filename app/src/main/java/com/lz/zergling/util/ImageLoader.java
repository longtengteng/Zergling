package com.lz.zergling.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.lnkj.wzhr.net.UrlUtils;
import com.lz.zergling.R;

/**
 * Copyright (c) 山东六牛网络科技有限公司 https://liuniukeji.com
 *
 * @Description
 * @Author 与天同行的观测者
 * @Copyright Copyright (c) 山东六牛网络科技有限公司 保留所有版权(https://www.liuniukeji.com)
 * @Date 2017/12/11 0011 14:18
 */

public class ImageLoader {

    public static void loadHead(final Context context, ImageView view, String url) {
        try {
            if (!TextUtils.isEmpty(url) && !url.contains("http"))
                url = new UrlUtils().getAPIHTTP() + url;
            RequestOptions options = new RequestOptions();
            options.centerCrop().placeholder(R.mipmap.default_avatar).error(R.mipmap.default_avatar);
            Glide.with(context).asBitmap()
                    .load(url)
                    .apply(options)
                    .into(new BitmapImageViewTarget(view) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                            circularBitmapDrawable.setCircular(true);
                            view.setImageDrawable(circularBitmapDrawable);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadImage(Context context, ImageView view, String url) {
        try {
            if (!TextUtils.isEmpty(url) && !url.contains("http"))
                url = new UrlUtils().getAPIHTTP() + url;
            RequestOptions options = new RequestOptions();
            options.centerCrop().placeholder(R.mipmap.default_image).error(R.mipmap.default_image);
            Glide.with(context)
                    .load(url)
                    .apply(options)
                    .into(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadHeadLocal(final Context context, ImageView view, String url) {
        try {
            RequestOptions options = new RequestOptions();
            options.centerCrop().placeholder(R.mipmap.default_avatar).error(R.mipmap.default_avatar).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE);
            Glide.with(context)
                    .asBitmap()
                    .load(url)
                    .apply(options)
                    .into(new BitmapImageViewTarget(view) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable circularBitmapDrawable =
                                    RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                            circularBitmapDrawable.setCircular(true);
                            view.setImageDrawable(circularBitmapDrawable);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadImageLocal(final Context context, ImageView view, String url) {
        try {
            RequestOptions options = new RequestOptions();
            options.centerCrop().placeholder(R.mipmap.default_image).error(R.mipmap.default_image).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE);
            Glide.with(context)
                    .asBitmap()
                    .load(url)
                    .apply(options)
                    .into(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadHeadDefault(final Context context, ImageView view, String url, int defaultRes) {
        try {
            if (!TextUtils.isEmpty(url) && !url.contains("http"))
                url = new UrlUtils().getAPIHTTP() + url;
            RequestOptions options = new RequestOptions();
            options.centerCrop().placeholder(defaultRes).error(defaultRes);
            Glide.with(context).asBitmap()
                    .load(url)
                    .apply(options)
                    .into(new BitmapImageViewTarget(view) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                            circularBitmapDrawable.setCircular(true);
                            view.setImageDrawable(circularBitmapDrawable);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadImageDefault(Context context, ImageView view, String url, int defaultRes) {
        try {
            if (!TextUtils.isEmpty(url) && !url.contains("http"))
                url = new UrlUtils().getAPIHTTP() + url;
            RequestOptions options = new RequestOptions();
            options.centerCrop().placeholder(defaultRes).error(defaultRes);
            Glide.with(context)
                    .load(url)
                    .apply(options)
                    .into(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
