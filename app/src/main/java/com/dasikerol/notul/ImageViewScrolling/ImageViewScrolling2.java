package com.dasikerol.notul.ImageViewScrolling;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dasikerol.notul.R;

public class ImageViewScrolling2 extends FrameLayout {
    private static int ANIMATION_DUR = 150;
    ImageView current_image,next_image, win;

    int last_result=0,old_value=0;
    IEventEnd eventEnd;

    public void setEventEnd(IEventEnd eventEnd) {
        this.eventEnd = eventEnd;
    }

    public ImageViewScrolling2(@NonNull Context context) {
        super(context);
        init(context);
    }

    public ImageViewScrolling2(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_view_scrolling2, this);
        current_image = getRootView().findViewById(R.id.current_image2);
        next_image = getRootView().findViewById(R.id.next_image2);
        win = getRootView().findViewById(R.id.win);

        next_image.setTranslationY(getHeight());
    }
    public void setValueRandom(final int image, final int rotate_count){
        current_image.animate().translationY(-getHeight()).setDuration(ANIMATION_DUR).start();
        next_image.setTranslationY(next_image.getHeight());
        next_image.animate().translationY(0).setDuration(ANIMATION_DUR).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                current_image.setVisibility(VISIBLE);
                win.setVisibility(INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                setImage(current_image, old_value%6);
                current_image.setTranslationY(0);
                if(old_value != rotate_count){
                    setValueRandom(image, rotate_count);
                    old_value++;
                }
                else {
                    last_result = 0;
                    old_value = 0;
                    setImage(next_image, image);
                    current_image.setVisibility(INVISIBLE);
                    eventEnd.eventEnd(image%6, rotate_count);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void setImage(ImageView image_view, int value) {
        if (value == Util.BAR)
            image_view.setImageResource(R.drawable.res1);
        else if (value == Util.SEVEN)
            image_view.setImageResource(R.drawable.res2);
        else if (value == Util.LEMON)
            image_view.setImageResource(R.drawable.res3);
        else if (value == Util.ORANGE)
            image_view.setImageResource(R.drawable.res4);
        else if (value == Util.TRIPLE)
            image_view.setImageResource(R.drawable.res5);
        else
            image_view.setImageResource(R.drawable.res1);
        if (value == 5){
            value = 0;
        }
        image_view.setTag(value);
        last_result = value;
    }
    public int getValue(){
        return Integer.parseInt(next_image.getTag().toString());
    }
    public void anim(){
        win.setVisibility(VISIBLE);
        win.animate().alpha(0.8f);
    }
}
