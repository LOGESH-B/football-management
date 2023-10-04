package com.football.football.service;


import java.util.List;

import com.football.football.entity.FootballEntity;

public interface FootballServiceInter {

//	CricketEntity insert(CricketEntity cricketEntity);
//	
//	List<CricketEntity> getAllPlayers();
	
	FootballEntity save(FootballEntity footballEntity);
	
	List<FootballEntity> getmembers();
	
	FootballEntity getById(Long id);
	
	FootballEntity updateMatch(Long id,FootballEntity footballEntity);
	
	Boolean deleteMatch(Long id);

	// List<CricketEntity> getPlayerGrtrThan10K();
}
