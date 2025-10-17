package com.totex.smashit.infra.beans.match;

import com.totex.smashit.core.gateway.match.MatchGateway;
import com.totex.smashit.core.usecases.match.CreateMatchUseCase;
import com.totex.smashit.core.usecases.match.CreateMatchUseCaseImpl;
import com.totex.smashit.core.usecases.match.FindMatchUseCase;
import com.totex.smashit.core.usecases.match.FindMatchUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MatchBeansConfiguration {

    @Bean
    public CreateMatchUseCase createMatchUseCase(MatchGateway matchGateway) {
        return new CreateMatchUseCaseImpl(matchGateway);
    }

    @Bean
    public FindMatchUseCase findMatchUseCase(MatchGateway matchGateway) {
        return new FindMatchUseCaseImpl(matchGateway);
    }
}
