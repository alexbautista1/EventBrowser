package com.fall16.csc413.team12.eventbrowser;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by AmandaNikkole on 11/26/16.
 */

public class StoryLab {
    //singleton for stories
    private static StoryLab sStoryLab;

    private ArrayList<Story> mStories;


    public static StoryLab get(Context context){
        if(sStoryLab == null){
            sStoryLab = new StoryLab(context);
        }
        return sStoryLab;
    }

    private StoryLab(Context context){
        mStories = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Story story = new Story();
            story.setName("Card " + i);
            story.setDescription("Description");
            mStories.add(story);
        }
    }

    public List<Story> getStories() {
        return mStories;
    }

    public Story getStory(UUID id) {
        for (Story story : mStories) {
            if (story.getUuid().equals(id)) {
                return story;
            }
        }
        return null;
    }
}

