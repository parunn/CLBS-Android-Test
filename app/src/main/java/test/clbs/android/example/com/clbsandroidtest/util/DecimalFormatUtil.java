package test.clbs.android.example.com.clbsandroidtest.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;

import java.text.DecimalFormat;

/**
 * Created by parunpichaiwong on 5/27/2017 AD.
 */

public class DecimalFormatUtil {

    public String convertDecimalFormat(String text) {

        if(!text.equals(null)) {
            DecimalFormat decimal = new DecimalFormat("0.00");
            Double result = Double.parseDouble(decimal.format(text));

            return String.valueOf(result);
        }

        return null;
    }
}
