package org.tasafo.tasafoconf.util;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by ramonrabello on 13/11/15.
 */
public class Utils {

    private static final String THE_DAY = "21/11/2015";

    public static void loadCustomFont(Resources resources, TextView textView, String fontPath){
        textView.setTypeface(Typeface.createFromAsset(resources.getAssets(), fontPath));
    }

    public static boolean todayIsTheDay() {
        String theDay = "21/11/2015"; // (DD/MM/YYYY)
        int today_d = today().get(Calendar.DAY_OF_MONTH);
        int today_m = (today().get(Calendar.MONTH) + 1);
        int today_y = today().get(Calendar.YEAR);
        int today_h = today().get(Calendar.HOUR_OF_DAY);

        if ((today_d + "/" + today_m + "/" + today_y).equals(theDay)) {
            if (today_h > 8 && today_h < 19) {
                return true;
            }
        }
        return false;
    }

    private static Calendar today(){
        return Calendar.getInstance(TimeZone.getTimeZone("GMT-2"));
    }

    public static boolean beforeTheDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date strDate = null;
        try {
            strDate = sdf.parse(THE_DAY);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (strDate != null && today().getTime().before(strDate));

    }

    public static boolean afterTheDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date strDate = null;
        try {
            strDate = sdf.parse(THE_DAY);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (strDate != null && today().getTime().after(strDate));
    }
}
