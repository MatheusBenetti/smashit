package com.totex.smashit.infra.beans.court;

import com.totex.smashit.core.gateway.court.CourtGateway;
import com.totex.smashit.core.usecases.court.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourtBeansConfiguration {

    @Bean
    public CreateCourtUseCase createCourtUseCase(CourtGateway courtGateway) {
        return new CreateCourtUseCaseImpl(courtGateway);
    }

    @Bean
    public FindCourtUseCase findCourtUseCase(CourtGateway courtGateway) {
        return new FindCourtUseCaseImpl(courtGateway);
    }

    @Bean
    public UpdateCourtUseCase updateCourtUseCase(CourtGateway courtGateway) {
        return new UpdateCourtUseCaseImpl(courtGateway);
    }

    @Bean
    public FindCourtByIdUseCase findCourtByIdUseCase(CourtGateway courtGateway) {
        return new FindCourtByIdUseCaseImpl(courtGateway);
    }
}
