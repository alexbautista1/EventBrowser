package com.fall16.csc413.team12.eventbrowser;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import java.util.UUID;

/**
 * Created by AmandaNikkole on 11/27/16.
 */

public class EventBrowserFragment extends Fragment {
    //this is a controller to interact with the model and the view
    //     presents the details of a specific story and
    //updates the details if the user changes them


    //without adding this Fragment to the matching Activity, you will not see
    //this on the phone screen
    private Story mStory;
    private EditText mNameField;
    private EditText mDescriptionField;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //mStory = new Story();
        UUID storyId = (UUID) getActivity().getIntent()
                .getSerializableExtra(EventBrowserActivity.EXTRA_STORY_ID);
        mStory = StoryLab.get(getActivity()).getStory(storyId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        //explicitly inflate the fragment's view
        View v = inflater.inflate(R.layout.fragment_event_browser, container, false);
        mNameField = (EditText) v.findViewById(R.id.story_name);
        //mNameField.setText(mStory.getName());
        mNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mStory.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDescriptionField = (EditText) v.findViewById(R.id.story_description);
        mDescriptionField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mStory.setDescription(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return v;
    }

}
