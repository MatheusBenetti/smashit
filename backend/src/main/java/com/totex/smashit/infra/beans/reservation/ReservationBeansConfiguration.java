package com.totex.smashit.infra.beans.reservation;

import com.totex.smashit.core.gateway.reservation.ReservationGateway;
import com.totex.smashit.core.usecases.reservation.CreateReservationUseCase;
import com.totex.smashit.core.usecases.reservation.CreateReservationUseCaseImpl;
import com.totex.smashit.core.usecases.reservation.FindReservationsUseCase;
import com.totex.smashit.core.usecases.reservation.FindReservationsUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservationBeansConfiguration {

    @Bean
    public CreateReservationUseCase createReservationUseCase(ReservationGateway reservationGateway) {
        return new CreateReservationUseCaseImpl(reservationGateway);
    }

    @Bean
    public FindReservationsUseCase findReservationsUseCase(ReservationGateway reservationGateway) {
        return new FindReservationsUseCaseImpl(reservationGateway);
    }
}
