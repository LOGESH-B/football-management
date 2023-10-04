package com.football.football.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.football.service.FootballService;
import com.football.football.entity.FootballEntity;

@RestController
@RequestMapping(value = "/football")
public class FootballController {

    @Autowired
    public FootballService fs;

    @GetMapping
    public String welcome() {
        return "Welcome to IPL Cricket";
    }

    @GetMapping(value = "/getallmatches")
    public ResponseEntity<FootballRes<List<FootballEntity>>> getmembers() {
        FootballRes<List<FootballEntity>> response;
        try {
            List<FootballEntity> res = fs.getmembers();
            if (res != null) {
                response = new FootballRes<List<FootballEntity>>("Fetched Successfully", res);
            } else {
                response = new FootballRes<List<FootballEntity>>("Error Occured", new ArrayList<FootballEntity>());
            }
            return ResponseEntity.status(200).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            response = new FootballRes<List<FootballEntity>>("Error Occured/Server Error",
                    new ArrayList<FootballEntity>());
            return ResponseEntity.status(500).body(response);
        }

    }

    @PostMapping(value = "/insert")
    public ResponseEntity<FootballRes<FootballEntity>> insert(@RequestBody FootballEntity footballentity) {
        FootballEntity res;
        FootballRes<FootballEntity> response;
        try {
            res = fs.save(footballentity);
            if (res != null) {
                response = new FootballRes<FootballEntity>("Inserted Successfully", res);
            } else {
                response = new FootballRes<FootballEntity>("Error Occured", new FootballEntity());
            }
            return ResponseEntity.status(200).body(response);

        } catch (Exception e) {
            e.printStackTrace();
            response = new FootballRes<FootballEntity>("Error Occured/Server Error", new FootballEntity());
            return ResponseEntity.status(500).body(response);
        }
    }

    // //GET BY ID
    @GetMapping(value = "/getMatchById/{id}")
    public ResponseEntity<FootballRes<FootballEntity>> getById(@PathVariable Long id) {
        FootballEntity res;
        FootballRes<FootballEntity> response;
        try {
            res = fs.getById(id);
            if (res != null) {
                response = new FootballRes<FootballEntity>("Featched Successfully", res);
            } else {
                response = new FootballRes<FootballEntity>("Error Occured", new FootballEntity());
            }
            return ResponseEntity.status(200).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            response = new FootballRes<FootballEntity>("Error Occured/Server Error", new FootballEntity());
            return ResponseEntity.status(500).body(response);
        }

    }

    // //UPDATE BY ID
    @PutMapping(value = "/updateMatch/{id}")
    public ResponseEntity<FootballRes<FootballEntity>> updatePlayer(@PathVariable Long id,
            @RequestBody FootballEntity footballbody) {
        FootballEntity res;
        FootballRes<FootballEntity> response;
        try {
            res = fs.updateMatch(id, footballbody);

            if (res != null) {
                response = new FootballRes<FootballEntity>("Updated Successfully", res);
            } else {
                response = new FootballRes<FootballEntity>("Error Occured", new FootballEntity());
            }
            return ResponseEntity.status(200).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            response = new FootballRes<FootballEntity>("Error Occured/Server Error", new FootballEntity());
            return ResponseEntity.status(500).body(response);
        }
    }

    // //DELETE BY ID
    @DeleteMapping(value = "/deleteMatch/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable Long id) {
        Boolean res;
        String response;
        try {
            res = fs.deleteMatch(id);
            if (res != null && res) {
                response = "Deleted Successfully";
            } else {
                response = "Error Occured";
            }
            return ResponseEntity.status(200).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            response = "Error Occured/Server Error";
            return ResponseEntity.status(500).body(response);
        }
    }

    // //Customised Query
    // @GetMapping(value = "/getPlayerGreaterThan10K")
    // public List<CricketEntity> getPlayersGrtrThanTenK(){
    // List<CricketEntity> cricketEntities = new ArrayList<CricketEntity>();
    // try {
    // cricketEntities = cs.getPlayerGrtrThan10K();
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // return cricketEntities;
    // }

}
