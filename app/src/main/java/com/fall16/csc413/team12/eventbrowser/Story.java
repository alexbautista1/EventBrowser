package com.fall16.csc413.team12.eventbrowser;

import android.widget.ImageView;

import java.util.UUID;

/**
 * Created by wgalan on 11/22/16.
 */

public class Story {

	private UUID mUuid;
	private String mName;
	private String mDescription;
	private ImageView mImageView;

	public Story(){mUuid = UUID.randomUUID();}

	public UUID getUuid() {return mUuid;}

	public String getName() {return mName;}

	public void setName(String name) {mName = name;}

	public String getDescription() {return mDescription;}

	public void setDescription(String description) {mDescription = description;}

	public ImageView getImageView() {return mImageView;}

	public void setImageView(ImageView imageView) {mImageView = imageView;}
}
