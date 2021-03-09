package com.rasa.customfontviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;


public class CustomFontEditText extends EditText {


    public CustomFontEditText(Context context) {
        super(context);
        setupViews(null);
    }

    public CustomFontEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupViews(attrs);
    }

    public CustomFontEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupViews(attrs);
    }

    public CustomFontEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setupViews(attrs);
    }


    public void setupViews(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.CustomFontEditText);
            try {
                int font = attributes.getInteger(R.styleable.CustomFontEditText_fonts_EditText, 0);
                switch (font) {
                    case 0:
                        setTypeface(CustomFontProvider.getBNazanin(getContext()));
                        break;
                    case 1:
                        setTypeface(CustomFontProvider.getTrafic(getContext()));
                        break;
                    case 2:
                        setTypeface(CustomFontProvider.getYagut(getContext()));
                        break;
                    case 3:
                        setTypeface(CustomFontProvider.getHoliday(getContext()));
                        break;
                    case 4:
                        setTypeface(CustomFontProvider.getModesta(getContext()));
                        break;
                    case 5:
                        setTypeface(CustomFontProvider.getIranSans(getContext()));
                        break;
                    case 6:
                        setTypeface(CustomFontProvider.getIranSansBold(getContext()));
                        break;
                    case 7:
                        setTypeface(CustomFontProvider.getBMitra(getContext()));
                        break;
                }

            } finally {
                invalidate();
                requestLayout();
                attributes.recycle();
            }
        }


    }
}
