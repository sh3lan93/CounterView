package com.shalan.mohamed.itemcounterview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by mohamed on 11/15/17.
 */

public class IncDecView extends RelativeLayout implements View.OnClickListener {
    public static final String TAG = IncDecView.class.getSimpleName();
    private TextView itemCounterValue;
    private ImageButton incButton;
    private ImageButton decButton;
    private Drawable incIcon;
    private Drawable decIcon;
    private Drawable incDecBackground;
    private Drawable viewBackground;
    private RelativeLayout rootView;
    private int strokeWidthRef = 0;
    private float incDecViewBorderWidth;
    private int incDecViewBorderColor;
    private String incDecViewStartValue;
    private int incDecViewCounterValueColor;
    private float defWidthValue;
    private CounterListener listener;

    public IncDecView(Context context) {
        super(context);
        def(context);
        init(context, null, 0);
    }

    public IncDecView(Context context, AttributeSet attrs) {
        super(context, attrs);
        def(context);
        init(context, attrs, 0);
    }

    public IncDecView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        def(context);
        init(context, attrs, defStyleAttr);
    }

    private void def(Context context){
        this.incIcon = context.getResources().getDrawable(R.drawable.ic_add);
        this.decIcon = context.getResources().getDrawable(R.drawable.ic_remove);
        this.incDecBackground = context.getResources().getDrawable(R.drawable.inc_dec_counter_view_button_background);
        this.viewBackground = context.getResources().getDrawable(R.drawable.inc_dec_counter_view_background);
    }

    private void init(Context context, AttributeSet attrs, int defStyle){
        inflate(context, R.layout.item_counter_view, this);
        this.rootView = findViewById(R.id.root_view);
        this.itemCounterValue = findViewById(R.id.item_counter_value);
        this.incButton = findViewById(R.id.inc_button);
        this.decButton = findViewById(R.id.dec_button);
        this.incButton.setOnClickListener(this);
        this.decButton.setOnClickListener(this);
        if (attrs != null){
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.IncDecView, defStyle, 0);
            try {
                this.incIcon = a.getDrawable(R.styleable.IncDecView_inc_icon);
                this.decIcon = a.getDrawable(R.styleable.IncDecView_dec_icon);
                this.viewBackground = a.getDrawable(R.styleable.IncDecView_view_background);
                this.incDecBackground = a.getDrawable(R.styleable.IncDecView_inc_dec_button_color);
                this.incDecViewBorderWidth = a.getDimension(R.styleable.IncDecView_border_width, 0);
                this.incDecViewBorderColor = a.getColor(R.styleable.IncDecView_border_color, 0);
                this.incDecViewStartValue = a.getString(R.styleable.IncDecView_startCounterValue);
                this.incDecViewCounterValueColor = a.getColor(R.styleable.IncDecView_counterValueColor, 0);
            }catch (Exception e){
                Log.i(TAG, "init: " + e.getLocalizedMessage());
            }
            finally {
                a.recycle();
            }
            if (this.incIcon != null)
                this.incButton.setImageDrawable(this.incIcon);
            if (this.decIcon != null)
                this.decButton.setImageDrawable(this.decIcon);
            if (this.viewBackground != null)
                this.rootView.setBackgroundDrawable(this.viewBackground);
            if (this.incDecBackground != null){
                this.incButton.setBackgroundDrawable(this.incDecBackground);
                this.decButton.setBackgroundDrawable(this.incDecBackground);
            }
            if (this.incDecViewBorderWidth != 0){
                this.setBorderWidth(this.incDecViewBorderWidth);
            }
            if (this.incDecViewBorderColor != 0){
                this.setBorderColor_(this.incDecViewBorderColor);
            }
            if (this.incDecViewStartValue != null){
                this.itemCounterValue.setText(this.incDecViewStartValue);
            }
            if (this.incDecViewCounterValueColor != 0){
                this.itemCounterValue.setTextColor(this.incDecViewCounterValueColor);
            }
        }
    }

    public IncDecView setStartCounterValue(String startValue){
        if (this.itemCounterValue != null)
            this.itemCounterValue.setText(startValue);
        return this;
    }

    public IncDecView setStartCounterValue(@StringRes int startValue){
        if (this.itemCounterValue != null)
            this.itemCounterValue.setText(getString(startValue));
        return this;
    }

    public IncDecView setCounterListener(CounterListener counterListener){
        listener = counterListener;
        return this;
    }
    public String getCounterValue(){
        String text = "";
        if (this.itemCounterValue != null)
            text = this.itemCounterValue.getText().toString();
        return text;
    }
    public IncDecView setIncButtonIcon(@DrawableRes int incButtonIcon){
        if (this.incButton != null)
            this.incButton.setImageDrawable(getDrawable(incButtonIcon));
        return this;
    }

    public IncDecView setDecButtonIcon(@DrawableRes int decButtonIcon){
        if (this.decButton != null)
            this.decButton.setImageDrawable(getDrawable(decButtonIcon));
        return this;
    }

    public IncDecView setBorderWidth(@DimenRes int strokeWidth){
        this.strokeWidthRef = strokeWidth;
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(getDimension(R.dimen.inc_dec_counter_view_corner_radius));
        drawable.setStroke((int) getDimension(strokeWidth), getResources().getColor(android.R.color.darker_gray));
        if (rootView != null)
            rootView.setBackgroundDrawable(drawable);
        return this;
    }

    private IncDecView setBorderWidth(float value){
        this.defWidthValue = value;
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(getDimension(R.dimen.inc_dec_counter_view_corner_radius));
        drawable.setStroke((int) value, getResources().getColor(android.R.color.darker_gray));
        if (rootView != null)
            rootView.setBackgroundDrawable(drawable);
        return this;
    }

    public IncDecView setBorderColor(@ColorRes int strokeColor){
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(getDimension(R.dimen.inc_dec_counter_view_corner_radius));
        if (this.strokeWidthRef != 0)
            drawable.setStroke((int) getDimension(this.strokeWidthRef), getColor(strokeColor));
        else
            drawable.setStroke((int) getDimension(R.dimen.inc_dec_counter_view_stroke_width), getColor(strokeColor));
        if (rootView != null)
            rootView.setBackgroundDrawable(drawable);
        return this;
    }

    private IncDecView setBorderColor_(int color){
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(getDimension(R.dimen.inc_dec_counter_view_corner_radius));
        if (this.defWidthValue != 0)
            drawable.setStroke((int) defWidthValue, color);
        else
            drawable.setStroke((int) getDimension(R.dimen.inc_dec_counter_view_stroke_width), color);
        if (rootView != null)
            rootView.setBackgroundDrawable(drawable);
        return this;
    }

    private int getColor(@ColorRes int colorRes){
        return getContext().getResources().getColor(colorRes);
    }
    private float getDimension(@DimenRes int dimenID){
        return getContext().getResources().getDimension(dimenID);
    }
    private String getString(@StringRes int textResourceValue){
        return getContext().getString(textResourceValue);
    }
    private Drawable getDrawable(@DrawableRes int drawableResource){
        return getContext().getResources().getDrawable(drawableResource);
    }
    @Override
    public void onClick(View view) {
        int value = 0;
        value = Integer.parseInt(this.itemCounterValue.getText().toString());
        int i = view.getId();
        if (i == R.id.inc_button) {
            value++;
            this.itemCounterValue.setText(String.valueOf(value));
            if (this.listener != null)
                this.listener.onIncClick(this.itemCounterValue.getText().toString());
        }
        else if (i == R.id.dec_button) {
            value--;
            if (value < 1){
                value = 1;
            }
            this.itemCounterValue.setText(String.valueOf(value));
            if (this.listener != null)
                this.listener.onDecClick(this.itemCounterValue.getText().toString());
        }
    }
}
