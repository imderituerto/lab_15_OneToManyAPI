package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ChocolateRepository chocolateRepository;
    @Autowired
    EstateRepository estateRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Estate estate1 = new Estate("BNTA Estate", "UK");
        Estate estate2 = new Estate("Madrid Estate", "Spain");

        estateRepository.save(estate1);
        estateRepository.save(estate2);

        Chocolate chocolate1 = new Chocolate("Bounty", 50, estate1);
        Chocolate chocolate2 = new Chocolate("Snickers", 70, estate1);
        Chocolate chocolate3 = new Chocolate("Cadburys", 80, estate2);
        Chocolate chocolate4 = new Chocolate("Mars", 60, estate2);

        chocolateRepository.saveAll(Arrays.asList(chocolate1, chocolate2, chocolate3, chocolate4));

    }

}
