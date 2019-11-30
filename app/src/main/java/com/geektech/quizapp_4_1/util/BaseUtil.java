package com.geektech.quizapp_4_1.util;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;

import androidx.core.content.ContextCompat;

import com.geektech.quizapp_4_1.R;

public class BaseUtil {
    public static Spanned fromHtml(String html) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(html);
        }
    }

    public static Integer getColor(Context context) {
        return ContextCompat.getColor(context, R.color.black);
    }
}
