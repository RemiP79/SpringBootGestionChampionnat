package com.example.tpgestionchampionnat.controllers;

import com.example.tpgestionchampionnat.models.*;

import com.example.tpgestionchampionnat.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UserRepository userRepository,
                                      TeamRepository teamRepository,
                                      StadiumRepository stadiumRepository,
                                      GameRepository gameRepository,
                                      BCryptPasswordEncoder passwordEncoder,
                                      CountryRepository countryRepository,
                                      DayRepository dayRepository) {

        userRepository.deleteAll();
        teamRepository.deleteAll();
        stadiumRepository.deleteAll();
        countryRepository.deleteAll();
        System.out.println("🟢 Suppression de la base existante.");


        return args -> {
            System.out.println("🟢 Création de la base de données.");

            if (userRepository.findByEmail("admin").isEmpty()) {
                User admin = new User();
                admin.setFirstName("admin");
                admin.setLastName("admin");
                admin.setEmail("admin");
                admin.setPassword(passwordEncoder.encode("admin"));
                admin.setCreationDate((LocalDate.now()));
               // admin.setRole("ADMIN");
                userRepository.save(admin);

                System.out.println("🟢 Membre 'admin' créé.");
            }

            // Stades
            Stadium stadium1 = new Stadium("Stade Rouge", "1 rue des Tigres, Paris", 20000, "0100000001");
            Stadium stadium2 = new Stadium("Stade Bleu", "2 avenue des Panthères, Lyon", 18000, "0100000002");
            Stadium stadium3 = new Stadium("Stade Doré", "3 boulevard des Lynx, Marseille", 22000, "0100000003");
            Stadium stadium4 = new Stadium("Stade Noir", "4 chemin des Dragons, Lille", 15000, "0100000004");
            Stadium stadium5 = new Stadium("Stade Vert", "5 impasse des Aigles, Toulouse", 17000, "0100000005");
            Stadium stadium6 = new Stadium("Stade Blanc", "6 allée des Loups, Nice", 21000, "0100000006");
            Stadium stadium7 = new Stadium("Stade Gris", "7 place des Requins, Bordeaux", 19000, "0100000007");
            Stadium stadium8 = new Stadium("Stade Argenté", "8 route des Faucons, Nantes", 23000, "0100000008");

            stadiumRepository.save(stadium1);
            stadiumRepository.save(stadium2);
            stadiumRepository.save(stadium3);
            stadiumRepository.save(stadium4);
            stadiumRepository.save(stadium5);
            stadiumRepository.save(stadium6);
            stadiumRepository.save(stadium7);
            stadiumRepository.save(stadium8);
            System.out.println("🟢 Stades créés.");


           Country country1 = new Country("France", "LogoCountry.png");
           countryRepository.save(country1);
           System.out.println("🟢 Country créée.");



            if (teamRepository.count() == 0) {
                Team team1 = new Team("Tigres Rouges", LocalDate.of(2015, 3, 12), "logo1.png", "Jean Dupont", "Claire Martin", "Actif", "Paris", "0102030405", "https://tigresrouges.fr");
                team1.setStadium(stadium1);
                team1.setCountry(country1);

                Team team2 = new Team("Panthères Bleues", LocalDate.of(2010, 7, 20), "logo2.png", "Luc Morel", "Sophie Bernard", "Actif", "Lyon", "0607080910", "https://pantheresbleues.fr");
                team2.setStadium(stadium2);
                team2.setCountry(country1);

                Team team3 = new Team("Lynx d'Or", LocalDate.of(2012, 11, 5), "logo3.png", "Hugo Lefevre", "Elise Dubois", "Actif", "Marseille", "0123456789", "https://lynxdor.fr");
                team3.setStadium(stadium3);
                team3.setCountry(country1);

                Team team4 = new Team("Dragons Noirs", LocalDate.of(2008, 1, 25), "logo4.png", "Marc Petit", "Isabelle Noel", "Actif", "Lille", "0987654321", "https://dragonsnoirs.fr");
                team4.setStadium(stadium4);
                team4.setCountry(country1);

                Team team5 = new Team("Aigles Verts", LocalDate.of(2013, 6, 15), "logo5.png", "Julien Roux", "Nathalie Faure", "Actif", "Toulouse", "0555121212", "https://aiglesverts.fr");
                team5.setStadium(stadium5);
                team5.setCountry(country1);

                Team team6 = new Team("Loups Blancs", LocalDate.of(2017, 9, 30), "logo6.png", "Pierre Girard", "Camille Laurent", "Actif", "Nice", "0678123412", "https://loupsblancs.fr");
                team6.setStadium(stadium6);
                team6.setCountry(country1);

                Team team7 = new Team("Requins Gris", LocalDate.of(2011, 4, 18), "logo7.png", "Antoine Colin", "Laura Millet", "Actif", "Bordeaux", "0611223344", "https://requinsgris.fr");
                team7.setStadium(stadium7);
                team7.setCountry(country1);

                Team team8 = new Team("Faucons d'Argent", LocalDate.of(2014, 12, 10), "logo8.png", "Etienne Barret", "Marine Lefebvre", "Actif", "Nantes", "0699887766", "https://fauconsargent.fr");
                team8.setStadium(stadium8);
                team8.setCountry(country1);

                teamRepository.save(team1);
                teamRepository.save(team2);
                teamRepository.save(team3);
                teamRepository.save(team4);
                teamRepository.save(team5);
                teamRepository.save(team6);
                teamRepository.save(team7);
                teamRepository.save(team8);
                System.out.println("🟢 8 équipes créées.");


                Day day1 = new Day("1");
                dayRepository.save(day1);

                Day day2 = new Day("2");
                dayRepository.save(day2);

                Day day3 = new Day("3");
                dayRepository.save(day3);

                Day day4= new Day("4");
                dayRepository.save(day4);

                Day day5 = new Day("5");
                dayRepository.save(day5);

                Day day6 = new Day("6");
                dayRepository.save(day6);

                Day day7 = new Day("7");
                dayRepository.save(day7);

                Day day8 = new Day("8");
                dayRepository.save(day8);
                System.out.println("🟢 dAY créée.");

                Game game1 = new Game(2,1,team1,team2,day7);
                gameRepository.save(game1);

                Game game2 = new Game(4,3,team1,team3,day6);
                gameRepository.save(game2);

                Game game3 = new Game(0,2,team1,team4,day5);
                gameRepository.save(game3);

                Game game4 = new Game(3,5,team1,team5,day4);
                gameRepository.save(game4);

                Game game5 = new Game(2,1,team1,team6,day3);
                gameRepository.save(game5);

                Game game6 = new Game(5,1,team1,team7,day2);
                gameRepository.save(game6);

                Game game7 = new Game(0,0,team1,team8,day1);
                gameRepository.save(game7);

                Game game8 = new Game(3,3,team2,team3,day3);
                gameRepository.save(game8);

                Game game9 = new Game(3,0,team2,team4,day6);
                gameRepository.save(game9);

                Game game10 = new Game(1,1,team2,team5,day2);
                gameRepository.save(game10);

                Game game11 = new Game(1,2,team2,team6,day5);
                gameRepository.save(game11);

                Game game12 = new Game(2,3,team2,team7,day7);
                gameRepository.save(game12);

                Game game13 = new Game(1,1,team2,team8,day4);
                gameRepository.save(game13);

                Game game14 = new Game(3,2,team3,team4,day2);
                gameRepository.save(game14);

                Game game15 = new Game(2,1,team3,team5,day5);
                gameRepository.save(game15);

                Game game16 = new Game(1,3,team3,team6,day1);
                gameRepository.save(game16);

                Game game17 = new Game(3,5,team3,team7,day4);
                gameRepository.save(game17);

                Game game18 = new Game(4,3,team3,team8,day7);
                gameRepository.save(game18);

                Game game19 = new Game(1,2,team4,team5,day1);
                gameRepository.save(game19);

                Game game20 = new Game(0,0,team4,team6,day4);
                gameRepository.save(game20);

                Game game21 = new Game(1,0,team4,team7,day7);
                gameRepository.save(game21);

                Game game22 = new Game(0,1,team4,team8,day3);
                gameRepository.save(game22);

                Game game23 = new Game(4,3,team5,team6,day7);
                gameRepository.save(game23);

                Game game24 = new Game(1,1,team5,team7,day3);
                gameRepository.save(game24);

                Game game25 = new Game(6,2,team5,team8,day6);
                gameRepository.save(game25);

                Game game26 = new Game(2,2,team6,team7,day6);
                gameRepository.save(game26);

                Game game27 = new Game(1,4,team6,team8,day2);
                gameRepository.save(game27);

                Game game28 = new Game(4,4,team7,team8,day5);
                gameRepository.save(game28);




                System.out.println("🟢 Games créées");





            }
        };
    }
}

