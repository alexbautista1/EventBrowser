package com.fall16.csc413.team12.eventbrowser;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.UUID;

//public class EventBrowserActivity extends AppCompatActivity {
public class EventBrowserActivity extends SingleFragmentActivity {

    public static final String EXTRA_STORY_ID = "eventbroswer.story_id";

    public static Intent newIntent(Context packageContext, UUID storyId) {
        Intent intent = new Intent(packageContext, EventBrowserActivity.class);
        intent.putExtra(EXTRA_STORY_ID, storyId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new EventBrowserFragment();
    }
}
