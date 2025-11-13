package io.github.onedeba7.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class MateButton extends AppCompatButton {

    private boolean touchStarted;
    private boolean canButtonScale;
    private float scale;
    private float elevation;

    public MateButton(@NonNull Context context) {
        this(context, null);
    }

    public MateButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MateButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(ButtonUtilities.applyTheme(context, attrs), attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        setBackgroundTintList(null);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MateButton, defStyleAttr, R.style.MateButton_Theme);
        TypedValue value = new TypedValue();
        typedArray.getValue(R.styleable.MateButton_rippleColor, value);
        int rippleColor = value.data;
        elevation = typedArray.getDimension(R.styleable.MateButton_elevation, 0);
        scale = typedArray.getFloat(R.styleable.MateButton_scale, 0.97f);
        canButtonScale = typedArray.getBoolean(R.styleable.MateButton_useScale, false);
        Drawable drawable = getBackground();
        if (!(drawable instanceof ColorDrawable)) {
            if (drawable != null) {
                typedArray.recycle();
                if (rippleColor != Color.TRANSPARENT) {
                    setBackground(drawable, ButtonBackground.RippleParams.newBuilder()
                            .setColor(rippleColor)
                            .build());
                }
                return;
            }
        }
        int backgroundTint = typedArray.getColor(R.styleable.MateButton_backgroundTint, Color.BLACK);
        int strokeColor = typedArray.getColor(R.styleable.MateButton_strokeColor, Color.TRANSPARENT);
        float strokeWidth = typedArray.getDimension(R.styleable.MateButton_strokeWidth, 0);
        float cornerTopStartRadius = typedArray.getDimension(R.styleable.MateButton_cornerRadius, -1);
        float cornerTopEndRadius, cornerBottomEndRadius, cornerBottomStartRadius;
        if (cornerTopStartRadius == -1) {
            cornerTopStartRadius = typedArray.getDimension(R.styleable.MateButton_cornerTopStartRadius, ButtonUtilities.dp(context, 2));
            cornerTopEndRadius = typedArray.getDimension(R.styleable.MateButton_cornerTopEndRadius, ButtonUtilities.dp(context, 2));
            cornerBottomEndRadius = typedArray.getDimension(R.styleable.MateButton_cornerBottomEndRadius, ButtonUtilities.dp(context, 2));
            cornerBottomStartRadius = typedArray.getDimension(R.styleable.MateButton_cornerBottomStartRadius, ButtonUtilities.dp(context, 2));
            cornerTopStartRadius = ButtonUtilities.px(context, cornerTopStartRadius);
            cornerTopEndRadius = ButtonUtilities.px(context, cornerTopEndRadius);
            cornerBottomEndRadius = ButtonUtilities.px(context, cornerBottomEndRadius);
            cornerBottomStartRadius = ButtonUtilities.px(context, cornerBottomStartRadius);
        } else {
            cornerTopEndRadius = cornerBottomStartRadius = cornerBottomEndRadius = cornerTopStartRadius = ButtonUtilities.px(context, cornerTopStartRadius);
        }
        typedArray.recycle();

        setBackgroundParams(ButtonBackground.DrawableParams.newBuilder()
                        .setColors(backgroundTint)
                        .setRadius(cornerTopStartRadius, cornerTopEndRadius, cornerBottomEndRadius, cornerBottomStartRadius)
                        .setStrokeColor(strokeColor)
                        .setStrokeWidth(ButtonUtilities.px(context, strokeWidth))
                        .build()
                , ButtonBackground.RippleParams.newBuilder()
                        .setColor(rippleColor)
                        .build());
    }

    public void setBackgroundParams(ButtonBackground.DrawableParams drawableParams) {
        setBackgroundParams(drawableParams, null);
    }

    public void setBackgroundParams(ButtonBackground.RippleParams rippleParams) {
        setBackgroundParams(null, rippleParams);
    }

    public void setBackgroundParams(ButtonBackground.DrawableParams drawableParams,
                                    ButtonBackground.RippleParams rippleParams) {
        List<ButtonBackground.DrawableParams> dp = null;
        if (drawableParams != null) {
            dp = new ArrayList<>(Collections.singleton(drawableParams));
        }
        List<ButtonBackground.RippleParams> rp = null;
        if (rippleParams != null) {
            rp = new ArrayList<>(Collections.singleton(rippleParams));
        }
        setBackgroundParamsList(dp, rp);
    }

    public void setBackgroundParamsList(List<ButtonBackground.DrawableParams> drawableParams) {
        setBackgroundParamsList(drawableParams, (List<ButtonBackground.RippleParams>) null);
    }

    public void setBackgroundParamsList(ArrayList<ButtonBackground.RippleParams> rippleParams) {
        setBackgroundParamsList((List<ButtonBackground.DrawableParams>) null, rippleParams);
    }

    public void setBackgroundParamsList(List<ButtonBackground.DrawableParams> drawableParams,
                                        ButtonBackground.RippleParams rippleParams) {
        List<ButtonBackground.RippleParams> rp = null;
        if (rippleParams != null) {
            rp = new ArrayList<>(Collections.singleton(rippleParams));
        }
        setBackgroundParamsList(drawableParams, rp);
    }

    public void setBackgroundParamsList(ButtonBackground.DrawableParams drawableParams,
                                        List<ButtonBackground.RippleParams> rippleParams) {
        List<ButtonBackground.DrawableParams> dp = null;
        if (drawableParams != null) {
            dp = new ArrayList<>(Collections.singleton(drawableParams));
        }
        setBackgroundParamsList(dp, rippleParams);
    }

    public void setBackgroundParamsList(List<ButtonBackground.DrawableParams> drawableParams,
                                        List<ButtonBackground.RippleParams> rippleParams) {
        ColorStateList colorStateList = null;
        StateListDrawable stateListDrawable = null;

        if (drawableParams != null && !drawableParams.isEmpty()) {
            stateListDrawable = ButtonUtilities.createStateListDrawable(getContext(), drawableParams);
        }

        if (rippleParams != null && !rippleParams.isEmpty()) {
            colorStateList = ButtonUtilities.createColorStateList(rippleParams);
        }

        if (colorStateList != null || stateListDrawable != null) {
            setBackground(ButtonUtilities.createBackground(stateListDrawable, colorStateList));
        } else {
            setBackground(null);
        }
        setElevation(elevation);
    }

    public void setBackground(Drawable background, ButtonBackground.RippleParams rippleParams) {
        ColorStateList colorStateList = null;
        if (rippleParams != null) {
            List<ButtonBackground.RippleParams> rp = new ArrayList<>(Collections.singleton(rippleParams));
            colorStateList = ButtonUtilities.createColorStateList(rp);
        }
        if (colorStateList != null || background != null) {
            setBackground(ButtonUtilities.createBackground(background, colorStateList));
        } else {
            setBackground(null);
        }
        setElevation(elevation);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!canButtonScale && !touchStarted) return super.onTouchEvent(motionEvent);
        if (getParent() != null && motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        super.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                if (!touchStarted) {
                    return false;
                }
                touchStarted = false;
                animate().scaleX(1f).scaleY(1f).setDuration(100).start();
                return false;
            case MotionEvent.ACTION_BUTTON_PRESS:
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                if (touchStarted) {
                    return true;
                }
                touchStarted = true;
                if (canButtonScale) animate().scaleX(scale).scaleY(scale).setDuration(200).start();
                return true;
        }
        return false;
    }

    @Override
    public void setElevation(float elevation) {
        this.elevation = ButtonUtilities.dp(getContext(), elevation);
        super.setElevation(this.elevation);
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void setCanButtonScale(boolean canButtonScale) {
        this.canButtonScale = canButtonScale;
    }
}