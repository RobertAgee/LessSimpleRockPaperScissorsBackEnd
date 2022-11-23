package org.example.controller;

import org.example.repo.UserRepo;
import org.example.model.User;
import org.example.model.UserChoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> userList = new ArrayList<>();
            userRepo.findAll().forEach(userList::add);

            if (userList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(userList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        Optional<User> userData = userRepo.findById(id);

        if(userData.isPresent()){
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User userObj = userRepo.save(user);

        return new ResponseEntity<>(userObj, HttpStatus.OK);
    }

    @PostMapping("/playGame/{id}")
    public ResponseEntity<UserChoice> playGame(@PathVariable Integer id, @RequestBody UserChoice userChoice){
        Optional<User> oldUserData = userRepo.findById(id);

        if(userChoice.getUserChoice().equals("Rock") || userChoice.getUserChoice().equals("Paper") || userChoice.getUserChoice().equals("Scissors")) {
            double compChose = Math.random();

            if (compChose <= 0.33) {
                userChoice.setCompChoice("Rock");
            } else if (compChose > 0.33 && compChose <= 0.66) {
                userChoice.setCompChoice("Paper");
            } else if (compChose > 0.66) {
                userChoice.setCompChoice("Scissors");

            }

            if (userChoice.getUserChoice().equals("Rock") && userChoice.getCompChoice().equals("Rock")) {
                if(oldUserData.isPresent()) {
                    User updatedUserData = oldUserData.get();
                    updatedUserData.setGamesTotal(updatedUserData.getGamesTotal() + 1);

                    updatedUserData.setGamesWon(updatedUserData.getGamesWon());
                    updatedUserData.setGamesTied(updatedUserData.getGamesTied() + 1);
                    updatedUserData.setGamesLost(updatedUserData.getGamesLost());

                    updatedUserData.setYouRock(updatedUserData.getYouRock() + 1);
                    updatedUserData.setYouPaper(updatedUserData.getYouPaper());
                    updatedUserData.setYouScissors(updatedUserData.getYouScissors());

                    updatedUserData.setCompRock(updatedUserData.getCompRock() + 1);
                    updatedUserData.setCompPaper(updatedUserData.getCompPaper());
                    updatedUserData.setCompScissors(updatedUserData.getCompScissors());
                    User userObj = userRepo.save(updatedUserData);
                }
                return new ResponseEntity<>(userChoice, HttpStatus.OK);
            } else if (userChoice.getUserChoice().equals("Rock") && userChoice.getCompChoice().equals("Paper")) {
                if(oldUserData.isPresent()) {
                    User updatedUserData = oldUserData.get();
                    updatedUserData.setGamesTotal(updatedUserData.getGamesTotal() + 1);

                    updatedUserData.setGamesWon(updatedUserData.getGamesWon());
                    updatedUserData.setGamesTied(updatedUserData.getGamesTied());
                    updatedUserData.setGamesLost(updatedUserData.getGamesLost() + 1);

                    updatedUserData.setYouRock(updatedUserData.getYouRock() + 1);
                    updatedUserData.setYouPaper(updatedUserData.getYouPaper());
                    updatedUserData.setYouScissors(updatedUserData.getYouScissors());

                    updatedUserData.setCompRock(updatedUserData.getCompRock());
                    updatedUserData.setCompPaper(updatedUserData.getCompPaper() + 1);
                    updatedUserData.setCompScissors(updatedUserData.getCompScissors());
                    User userObj = userRepo.save(updatedUserData);
                }
                return new ResponseEntity<>(userChoice, HttpStatus.OK);
            } else if (userChoice.getUserChoice().equals("Rock") && userChoice.getCompChoice().equals("Scissors")) {
                if(oldUserData.isPresent()) {
                    User updatedUserData = oldUserData.get();
                    updatedUserData.setGamesTotal(updatedUserData.getGamesTotal() + 1);

                    updatedUserData.setGamesWon(updatedUserData.getGamesWon() + 1);
                    updatedUserData.setGamesTied(updatedUserData.getGamesTied());
                    updatedUserData.setGamesLost(updatedUserData.getGamesLost());

                    updatedUserData.setYouRock(updatedUserData.getYouRock() + 1);
                    updatedUserData.setYouPaper(updatedUserData.getYouPaper());
                    updatedUserData.setYouScissors(updatedUserData.getYouScissors());

                    updatedUserData.setCompRock(updatedUserData.getCompRock());
                    updatedUserData.setCompPaper(updatedUserData.getCompPaper());
                    updatedUserData.setCompScissors(updatedUserData.getCompScissors() + 1);
                    User userObj = userRepo.save(updatedUserData);
                }
                return new ResponseEntity<>(userChoice, HttpStatus.OK);
            } else if (userChoice.getUserChoice().equals("Paper") && userChoice.getCompChoice().equals("Rock")) {
                if(oldUserData.isPresent()) {
                    User updatedUserData = oldUserData.get();
                    updatedUserData.setGamesTotal(updatedUserData.getGamesTotal() + 1);

                    updatedUserData.setGamesWon(updatedUserData.getGamesWon() + 1);
                    updatedUserData.setGamesTied(updatedUserData.getGamesTied());
                    updatedUserData.setGamesLost(updatedUserData.getGamesLost());

                    updatedUserData.setYouRock(updatedUserData.getYouRock());
                    updatedUserData.setYouPaper(updatedUserData.getYouPaper() + 1);
                    updatedUserData.setYouScissors(updatedUserData.getYouScissors());

                    updatedUserData.setCompRock(updatedUserData.getCompRock() + 1);
                    updatedUserData.setCompPaper(updatedUserData.getCompPaper());
                    updatedUserData.setCompScissors(updatedUserData.getCompScissors());
                    User userObj = userRepo.save(updatedUserData);
                }
                return new ResponseEntity<>(userChoice, HttpStatus.OK);
            } else if (userChoice.getUserChoice().equals("Paper") && userChoice.getCompChoice().equals("Paper")) {
                if(oldUserData.isPresent()) {
                    User updatedUserData = oldUserData.get();
                    updatedUserData.setGamesTotal(updatedUserData.getGamesTotal() + 1);

                    updatedUserData.setGamesWon(updatedUserData.getGamesWon());
                    updatedUserData.setGamesTied(updatedUserData.getGamesTied() + 1);
                    updatedUserData.setGamesLost(updatedUserData.getGamesLost());

                    updatedUserData.setYouRock(updatedUserData.getYouRock());
                    updatedUserData.setYouPaper(updatedUserData.getYouPaper() + 1);
                    updatedUserData.setYouScissors(updatedUserData.getYouScissors());

                    updatedUserData.setCompRock(updatedUserData.getCompRock());
                    updatedUserData.setCompPaper(updatedUserData.getCompPaper() + 1);
                    updatedUserData.setCompScissors(updatedUserData.getCompScissors());
                    User userObj = userRepo.save(updatedUserData);
                }
                return new ResponseEntity<>(userChoice, HttpStatus.OK);
            } else if (userChoice.getUserChoice().equals("Paper") && userChoice.getCompChoice().equals("Scissors")) {
                if(oldUserData.isPresent()) {
                    User updatedUserData = oldUserData.get();
                    updatedUserData.setGamesTotal(updatedUserData.getGamesTotal() + 1);

                    updatedUserData.setGamesWon(updatedUserData.getGamesWon());
                    updatedUserData.setGamesTied(updatedUserData.getGamesTied());
                    updatedUserData.setGamesLost(updatedUserData.getGamesLost() + 1);

                    updatedUserData.setYouRock(updatedUserData.getYouRock());
                    updatedUserData.setYouPaper(updatedUserData.getYouPaper() + 1);
                    updatedUserData.setYouScissors(updatedUserData.getYouScissors());

                    updatedUserData.setCompRock(updatedUserData.getCompRock());
                    updatedUserData.setCompPaper(updatedUserData.getCompPaper());
                    updatedUserData.setCompScissors(updatedUserData.getCompScissors() + 1);
                    User userObj = userRepo.save(updatedUserData);
                }
                return new ResponseEntity<>(userChoice, HttpStatus.OK);
            } else if (userChoice.getUserChoice().equals("Scissors") && userChoice.getCompChoice().equals("Rock")) {
                if(oldUserData.isPresent()) {
                    User updatedUserData = oldUserData.get();
                    updatedUserData.setGamesTotal(updatedUserData.getGamesTotal() + 1);

                    updatedUserData.setGamesWon(updatedUserData.getGamesWon());
                    updatedUserData.setGamesTied(updatedUserData.getGamesTied());
                    updatedUserData.setGamesLost(updatedUserData.getGamesLost() + 1);

                    updatedUserData.setYouRock(updatedUserData.getYouRock());
                    updatedUserData.setYouPaper(updatedUserData.getYouPaper());
                    updatedUserData.setYouScissors(updatedUserData.getYouScissors() + 1);

                    updatedUserData.setCompRock(updatedUserData.getCompRock() + 1);
                    updatedUserData.setCompPaper(updatedUserData.getCompPaper());
                    updatedUserData.setCompScissors(updatedUserData.getCompScissors());
                    User userObj = userRepo.save(updatedUserData);
                }
                return new ResponseEntity<>(userChoice, HttpStatus.OK);
            } else if (userChoice.getUserChoice().equals("Scissors") && userChoice.getCompChoice().equals("Paper")) {
                if(oldUserData.isPresent()) {
                    User updatedUserData = oldUserData.get();
                    updatedUserData.setGamesTotal(updatedUserData.getGamesTotal() + 1);

                    updatedUserData.setGamesWon(updatedUserData.getGamesWon() + 1);
                    updatedUserData.setGamesTied(updatedUserData.getGamesTied());
                    updatedUserData.setGamesLost(updatedUserData.getGamesLost());

                    updatedUserData.setYouRock(updatedUserData.getYouRock());
                    updatedUserData.setYouPaper(updatedUserData.getYouPaper());
                    updatedUserData.setYouScissors(updatedUserData.getYouScissors() + 1);

                    updatedUserData.setCompRock(updatedUserData.getCompRock());
                    updatedUserData.setCompPaper(updatedUserData.getCompPaper() + 1);
                    updatedUserData.setCompScissors(updatedUserData.getCompScissors());
                    User userObj = userRepo.save(updatedUserData);
                }
                return new ResponseEntity<>(userChoice, HttpStatus.OK);
            } else if (userChoice.getUserChoice().equals("Scissors") && userChoice.getCompChoice().equals("Scissors")) {
                if(oldUserData.isPresent()) {
                    User updatedUserData = oldUserData.get();
                    updatedUserData.setGamesTotal(updatedUserData.getGamesTotal() + 1);

                    updatedUserData.setGamesWon(updatedUserData.getGamesWon());
                    updatedUserData.setGamesTied(updatedUserData.getGamesTied() + 1);
                    updatedUserData.setGamesLost(updatedUserData.getGamesLost());

                    updatedUserData.setYouRock(updatedUserData.getYouRock());
                    updatedUserData.setYouPaper(updatedUserData.getYouPaper());
                    updatedUserData.setYouScissors(updatedUserData.getYouScissors() + 1);

                    updatedUserData.setCompRock(updatedUserData.getCompRock());
                    updatedUserData.setCompPaper(updatedUserData.getCompPaper());
                    updatedUserData.setCompScissors(updatedUserData.getCompScissors() + 1);
                    User userObj = userRepo.save(updatedUserData);
                }
                return new ResponseEntity<>(userChoice, HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(userChoice, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/updateUserById/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User newUserData){
        Optional<User> oldUserData = userRepo.findById(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/resetGame/{id}")
    public ResponseEntity<HttpStatus> resetGame(@PathVariable Integer id) {
        Optional<User> oldUserData = userRepo.findById(id);
        if(oldUserData.isPresent()) {
            User updatedUserData = oldUserData.get();
            updatedUserData.setGamesTotal(0);

            updatedUserData.setGamesWon(0);
            updatedUserData.setGamesTied(0);
            updatedUserData.setGamesLost(0);

            updatedUserData.setYouRock(0);
            updatedUserData.setYouPaper(0);
            updatedUserData.setYouScissors(0);

            updatedUserData.setCompRock(0);
            updatedUserData.setCompPaper(0);
            updatedUserData.setCompScissors(0);
            User userObj = userRepo.save(updatedUserData);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable Integer id) {
        userRepo.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
