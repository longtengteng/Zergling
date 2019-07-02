package com.lz.zergling.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lz.zergling.R;
import com.lz.zergling.ui.main.MainActivity;

public class NativeTabButton extends FrameLayout {
    private Context mContext;
    private int mIndex;
    private Drawable mSelectedImg;
    private Drawable mUnselectedImg;
    private ImageView mImage;
    private TextView mTitle;

    public NativeTabButton(Context context) {
        this(context, null);
    }

    public NativeTabButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NativeTabButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        OnClickListener clickListner = new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContext instanceof MainActivity) {
                    ((MainActivity) mContext).setFragmentShow(mIndex);
                }
            }
        };
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_native_tab_button, this, true);
        LinearLayout container = findViewById(R.id.tab_btn_container);
        mImage = findViewById(R.id.tab_btn_default);
        mTitle = findViewById(R.id.tab_btn_title);
        container.setOnClickListener(clickListner);
    }

    public void setIndex(int index) {
        this.mIndex = index;
    }

    public void setUnselectedImage(Drawable img) {
        this.mUnselectedImg = img;
    }

    public void setSelectedImage(Drawable img) {
        this.mSelectedImg = img;
    }

    /**
     * 设置字体颜色
     *
     * @param selected
     */
    private void setSelectedColor(Boolean selected) {
        if (selected) {
            mTitle.setTextColor(getResources().getColor(
                    R.color.colorPrimary));
        } else {
            mTitle.setTextColor(getResources().getColor(R.color.color_text));
        }
    }

    public void setSelectedButton(Boolean selected) {
        setSelectedColor(selected);
        if (selected) {
            mImage.setImageDrawable(mSelectedImg);
        } else {
            mImage.setImageDrawable(mUnselectedImg);
        }
    }

    public void setTitle(String title) {
        mTitle.setText(title);
    }

}
