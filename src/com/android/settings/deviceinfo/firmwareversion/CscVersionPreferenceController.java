/*
 * Copyright (C) 2022 Csc
 *
 * PDX-License-Identifier: Apache-2.0
 *
 */

package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class CscVersionPreferenceController extends BasePreferenceController {

    private static final String TAG = "CscVersionPreferenceController";

    private static final String KEY_CSC_BRANCH_PROP = "ro.csc.branch";

    private static final String KEY_CSC_GMS_TYPE_PROP = "ro.csc.gms.type";
    private static final String KEY_CSC_BUILD_TYPE_PROP = "ro.csc.build.type";

    public CscVersionPreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
        String version = SystemProperties.get(KEY_CSC_BRANCH_PROP, mContext.getString(R.string.unknown)).toUpperCase() + " | "
                + SystemProperties.get(KEY_CSC_GMS_TYPE_PROP, mContext.getString(R.string.unknown)).toUpperCase() + " | "
                + SystemProperties.get(KEY_CSC_BUILD_TYPE_PROP, mContext.getString(R.string.unknown)).toUpperCase();
        return version;
    }
}
