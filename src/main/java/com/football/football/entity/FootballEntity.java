package com.football.football.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

//it is used to create a table in the database
@Entity

// It is used to define getter and setter methods.
@Data
public class FootballEntity {

    // It acts as a primary key
    @Id
    // It helps Id as an auto Incremented value
    @GeneratedValue
    private Long id;
    private String match_no;
    private String team1;
    private String team2;
    // private List<Players> Team1Members;
    // private List<Players> Team2Members;
    // private List<Players> Team1Sub;
    // private List<Players> Team2Sub;
    // private String T1C;
    // private String T2C;
    // private String venue;

}

@Data
class Players {
    private String name;
    private int jno;
}

// Step 1: Create spring boot project with dependencies such as MYSQL driver,
// Spring boot web, Lombok, Spring data JPA
// Step 2: Create a packaging structure
// Step 3: Define database credentials in application.properties.
// Step 4: Add the below three lines in application.properties
// spring.jpa.show-sql=true
// spring.jpa.hibernate.ddl-auto=update
// spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
// Step 5: Run your spring boot project.
// Step 6: Verify the database whether the table is created or not.
