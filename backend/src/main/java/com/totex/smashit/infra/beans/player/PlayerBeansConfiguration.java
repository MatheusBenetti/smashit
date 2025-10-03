package com.totex.smashit.infra.beans.player;

import com.totex.smashit.core.gateway.player.PlayerGateway;
import com.totex.smashit.core.usecases.player.CreatePlayerUseCase;
import com.totex.smashit.core.usecases.player.CreatePlayerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerBeansConfiguration {

    @Bean
    public CreatePlayerUseCase createPlayerUseCase(PlayerGateway playerGateway) {
        return new CreatePlayerUseCaseImpl(playerGateway);
    }
}
