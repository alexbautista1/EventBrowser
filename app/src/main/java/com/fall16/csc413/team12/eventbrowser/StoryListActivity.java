package com.fall16.csc413.team12.eventbrowser;

import android.support.v4.app.Fragment;

/**
 * Created by AmandaNikkole on 11/27/16.
 */

public class StoryListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new StoryListFragment();
    }
}
