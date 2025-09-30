package com.totex.smashit.infra.persistence.court;

import com.totex.smashit.core.enums.CourtType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourtEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private CourtType courtType;

    private String address;

    private String city;

    private String state;

    private String club;

    // To let people discover courts by location (like tinder)
    // Finish MVP first then start looking for Google API
    // private double long
    // private double lat

}
