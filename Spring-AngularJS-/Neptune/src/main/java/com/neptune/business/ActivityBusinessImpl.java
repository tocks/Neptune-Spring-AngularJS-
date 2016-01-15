package com.neptune.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.neptune.dao.ActivityReposiroty;
import com.neptune.entities.Activity;

public class ActivityBusinessImpl implements ActivityBusiness {

	@Autowired
	private ActivityReposiroty activityReposiroty;
	
	@Override
	public Activity saveActivity(Activity a) {
		return activityReposiroty.save(a);
	}

	@Override
	public List<Activity> getAllActivities() {
		return activityReposiroty.findAll();
	}

	@Override
	public Activity updateActivity(Long id) {
		return null;
	}

	@Override
	public Activity findActivity(Long id) {
		return activityReposiroty.findOne(id);
	}

	@Override
	public void deleteActivity(Long id) {
		activityReposiroty.delete(id);
	}

	@Override
	public List<Activity> getActivityByOwner() {
		// TODO Auto-generated method stub
		return null;
	}

}
