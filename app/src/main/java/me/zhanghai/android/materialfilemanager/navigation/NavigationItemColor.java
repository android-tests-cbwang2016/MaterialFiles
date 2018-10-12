/*
 * Copyright (c) 2018 Zhang Hai <Dreaming.in.Code.ZH@Gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.android.materialfilemanager.navigation;

import android.content.Context;
import android.content.res.ColorStateList;

import me.zhanghai.android.materialfilemanager.R;
import me.zhanghai.android.materialfilemanager.util.ViewUtils;

// We cannot reference disabled text color in XML resource, so we have to do this in Java.
public class NavigationItemColor {

    private static final int[] CHECKED_STATE_SET = { android.R.attr.state_checked };
    private static final int[] DISABLED_STATE_SET = { -android.R.attr.state_enabled };
    private static final int[] EMPTY_STATE_SET = {};

    private NavigationItemColor() {}

    public static ColorStateList create(ColorStateList color, Context context) {
        int primaryColor = ViewUtils.getColorFromAttrRes(R.attr.colorPrimary, 0, context);
        int defaultColor = color.getDefaultColor();
        int disabledColor = color.getColorForState(DISABLED_STATE_SET, defaultColor);
        return new ColorStateList(new int[][] {
                DISABLED_STATE_SET,
                CHECKED_STATE_SET,
                EMPTY_STATE_SET
        }, new int[] {
                disabledColor,
                primaryColor,
                defaultColor
        });
    }
}