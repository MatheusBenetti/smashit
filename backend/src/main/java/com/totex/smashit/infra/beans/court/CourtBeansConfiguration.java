package com.totex.smashit.infra.beans.court;

import com.totex.smashit.core.gateway.court.CourtGateway;
import com.totex.smashit.core.usecases.court.CreateCourtUseCase;
import com.totex.smashit.core.usecases.court.CreateCourtUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourtBeansConfiguration {

    @Bean
    public CreateCourtUseCase createCourtUseCase(CourtGateway courtGateway) {
        return new CreateCourtUseCaseImpl(courtGateway);
    }
}
