package org.example.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int gamesTotal;
    private int gamesWon;
    private int gamesTied;
    private int gamesLost;
    private int youRock;
    private int youPaper;
    private int youScissors;
    private int compRock;
    private int compPaper;
    private int compScissors;
}
