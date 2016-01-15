package com.neptune.business;

import java.util.List;

import com.neptune.entities.Activity;

public interface ActivityBusiness {
	
	public Activity saveActivity(Activity a);

	public List<Activity> getAllActivities();

	public Activity updateActivity(Long id);

	public Activity findActivity(Long id);

	public void deleteActivity(Long id);
	
	public List<Activity>getActivityByOwner();

}
