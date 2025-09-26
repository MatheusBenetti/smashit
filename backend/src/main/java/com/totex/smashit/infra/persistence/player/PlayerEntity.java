package com.totex.smashit.infra.persistence.player;

import com.totex.smashit.core.enums.PlayerLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "player")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    private PlayerLevel playerLevel;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String country;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
