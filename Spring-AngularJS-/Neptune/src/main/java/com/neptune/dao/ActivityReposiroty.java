package com.neptune.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neptune.entities.Activity;

public interface ActivityReposiroty  extends JpaRepository<Activity,Long> {

}
