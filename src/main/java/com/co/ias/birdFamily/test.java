package com.co.ias.birdFamily;

import com.co.ias.birdFamily.birds.application.domain.BirdFamily;
import com.co.ias.birdFamily.birds.application.domain.valueObjs.*;

public class test {
    public static void main(String[] args) {
        try {
            BirdFamily birdFamily = new BirdFamily(
                    new BirdFamilyId(1L),
                    new BirdFamilyName("Gorrions"),
                    new BirdScientificName("gur"),
                    new BirdZoneName("tree"),
                    new BirdConfirmedQuantity(null)
            );
            System.out.println(birdFamily);
        }catch (NullPointerException | IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


    }
}
