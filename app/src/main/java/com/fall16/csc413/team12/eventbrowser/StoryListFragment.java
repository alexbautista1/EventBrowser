package com.fall16.csc413.team12.eventbrowser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by AmandaNikkole on 11/27/16.
 */

public class StoryListFragment extends Fragment {
    //RECYCLER VIEW which is a subclass of ViewGroup
    //it displays a list of child View Objects, one for ea. item in list
    //RV --> ViewHolders --> Views
    //lives in StoryListFragment's layout file

    //only responsibility is recycling and positioning TextViews
    //in order to get TextViews-- you need an adapter and ViewHolder class





    private RecyclerView mStoryRecyclerView;
    private StoryAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_story_list, container, false);

        mStoryRecyclerView = (RecyclerView) view.findViewById(R.id.story_recycler_view);
        mStoryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    //ViewHolder holds onto a View
    private class StoryHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        private TextView mNameTextView;
        private TextView mDescriptionTextView;
        private TextView mNameTextView2;
        private ImageView mImageView;

        private Story mStory;

        public StoryHolder(View itemView){
            super(itemView);
            //for TOAST
            itemView.setOnClickListener(this);

            mNameTextView = (TextView) itemView.findViewById(R.id.list_item_story_name);
            mDescriptionTextView = (TextView) itemView.findViewById(R.id.list_item_story_description);
            mImageView = (ImageView) itemView.findViewById(R.id.list_item_story_card);
            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO
//                    Toast.makeText(getActivity(),
//                            "Touching " + mStory.getName(), Toast.LENGTH_SHORT)
//                            .show();
                    //INTENT TO GO TO DETAILS

                    //Intent intent = new Intent(getActivity(), EventBrowserActivity.class);
                    Intent intent = EventBrowserActivity.newIntent(getActivity(), mStory.getUuid());
                    startActivity(intent);
                }
            });
        }

        public void bindStory(Story story){
            mStory = story;
            mNameTextView.setText(mStory.getName());
            mDescriptionTextView.setText(mStory.getDescription());

        }
        //forToast
        @Override
        public void onClick(View v){
            Toast.makeText(getActivity(),
                    mStory.getName() + " clicked!", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    //Adapter is controller object, RV asks the adapter for Viewholders
    private class StoryAdapter extends RecyclerView.Adapter<StoryHolder>{
        private List<Story> mStories;

        public StoryAdapter(List<Story> stories){
            mStories = stories;
        }

        @Override
        public StoryHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_story,
                    parent, false);
            return new StoryHolder(view);
        }

        @Override
        public void onBindViewHolder(StoryHolder holder, int position){
            Story story = mStories.get(position);
            holder.bindStory(story);
        }

        @Override
        public int getItemCount(){
            return mStories.size();
        }
    }

    private void updateUI(){
        StoryLab storyLab = StoryLab.get(getActivity());
        List<Story> stories = storyLab.getStories();

        mAdapter = new StoryAdapter(stories);
        mStoryRecyclerView.setAdapter(mAdapter);
    }
}
