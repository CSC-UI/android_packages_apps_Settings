/*
 * Copyright (C) 2022 Acme
 *
 * PDX-License-Identifier: Apache-2.0
 *
 */

package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class AcmeVersionPreferenceController extends BasePreferenceController {

    private static final String TAG = "AcmeVersionPreferenceController";

    private static final String KEY_ACME_BRANCH_PROP = "ro.acme.branch";

    private static final String KEY_ACME_GMS_TYPE_PROP = "ro.acme.gms.type";

    private static final String KEY_ACME_BUILD_TYPE_PROP = "ro.acme.build.type";

    public AcmeVersionPreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
        String version = SystemProperties.get(KEY_ACME_BRANCH_PROP, mContext.getString(R.string.unknown)).toUpperCase() + " | "
                + SystemProperties.get(KEY_ACME_GMS_TYPE_PROP, mContext.getString(R.string.unknown)).toUpperCase() + " | "
                + SystemProperties.get(KEY_ACME_BUILD_TYPE_PROP, mContext.getString(R.string.unknown)).toUpperCase();
        return version;
    }
}
