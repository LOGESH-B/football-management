package com.football.football.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.football.entity.FootballEntity;
import com.football.football.repository.FootballRepo;

@Service
public class FootballService implements FootballServiceInter {

    @Autowired
    public FootballRepo frepo;

    public List<FootballEntity> getmembers() {
        List<FootballEntity> result = new ArrayList<FootballEntity>();
        try {
            result = (List<FootballEntity>) frepo.findAll();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    @Override
    public FootballEntity save(FootballEntity footballEntity) {
        FootballEntity newmatch = new FootballEntity();
        try {
            newmatch = frepo.save(footballEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return newmatch;
    }

    @Override
    public FootballEntity getById(Long id) {
        FootballEntity c = new FootballEntity();
        try {
            c = frepo.findById(id).get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return c;
    }

    @Override
    public FootballEntity updateMatch(Long id, FootballEntity footballEntity) {
        FootballEntity update;
        FootballEntity newupdated = null;

        try {
            if (id > 0) {
                update = frepo.findById(id).get();
                if (update != null) {
                    update.setMatch_no(footballEntity.getMatch_no());
                    update.setTeam1(footballEntity.getTeam1());
                    update.setTeam2(footballEntity.getTeam2());
                    newupdated = frepo.save(update);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return newupdated;
    }

    @Override
    public Boolean deleteMatch(Long id) {
        try {
            if (id > 0) {
                frepo.deleteById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // @Override
    // public List<CricketEntity> getPlayerGrtrThan10K(){
    // List<CricketEntity> cricketEntities = new ArrayList<CricketEntity>();
    // try {
    // cricketEntities = crepo.getPlayerGreaterThan10K();
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // return cricketEntities;
    // }

    // update
    // Pre-defined Methods
    // Save and update don't have separate ones
    // save method will act as Insert and Update
    // 1. need to check whether the id is present or not
    // 2. If id is present then assign the values in the requestBody to new Object
}
