package com.totex.smashit.infra.beans.match_player;

import com.totex.smashit.core.gateway.match_player.MatchPlayerGateway;
import com.totex.smashit.core.usecases.match_player.CreateMatchPlayerUseCase;
import com.totex.smashit.core.usecases.match_player.CreateMatchPlayerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MatchPlayerBeansConfiguration {

    @Bean
    public CreateMatchPlayerUseCase createMatchPlayerUseCase(MatchPlayerGateway matchPlayerGateway) {
        return new CreateMatchPlayerUseCaseImpl(matchPlayerGateway);
    }
}
