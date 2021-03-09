package com.rasa.customfontviews;

import android.content.Context;
import android.graphics.Typeface;

public class CustomFontProvider {

    private static Typeface BNazanin;
    private static Typeface trafic;
    private static Typeface yagut;
    private static Typeface holiday;
    private static Typeface modesta;
    private static Typeface iranSans;
    private static Typeface iranSansBold;
    private static Typeface BMitra;

    public static Typeface getBNazanin(Context context){
        if (BNazanin==null){
            BNazanin=Typeface.createFromAsset(context.getAssets(),"fonts/b_nazanin.ttf");
        }
        return BNazanin;

    }

    public static Typeface getTrafic(Context context){
        if (trafic==null){
            trafic=Typeface.createFromAsset(context.getAssets(),"fonts/trafic_bold.ttf");
        }
        return trafic;

    }

    public static Typeface getYagut(Context context){
        if (yagut==null){
            yagut=Typeface.createFromAsset(context.getAssets(),"fonts/yagut.ttf");
        }
        return yagut;

    }

    public static Typeface getHoliday(Context context){
        if (holiday==null){
            holiday=Typeface.createFromAsset(context.getAssets(),"fonts/holiday.ttf");
        }
        return holiday;

    }

    public static Typeface getModesta(Context context){
        if (modesta==null){
            modesta=Typeface.createFromAsset(context.getAssets(),"fonts/modesta.ttf");
        }
        return modesta;

    }

    public static Typeface getIranSans(Context context){
        if (iranSans==null){
            iranSans=Typeface.createFromAsset(context.getAssets(),"fonts/iran_sans.ttf");
        }
        return iranSans;

    }

    public static Typeface getIranSansBold(Context context){
        if (iranSansBold==null){
            iranSansBold=Typeface.createFromAsset(context.getAssets(),"fonts/iran_sans_bold.ttf");
        }
        return iranSansBold;

    }

    public static Typeface getBMitra(Context context){
        if (BMitra==null){
            BMitra=Typeface.createFromAsset(context.getAssets(),"fonts/b_mitra.ttf");
        }
        return BMitra;

    }

}
