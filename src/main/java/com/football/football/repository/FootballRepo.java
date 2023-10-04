package com.football.football.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.football.football.entity.FootballEntity;


@Repository
public interface FootballRepo extends JpaRepository<FootballEntity, Long>{
	
	
}
