package com.Soham.Module_9_Spring_AI.entity;

import com.Soham.Module_9_Spring_AI.entity.BookingStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;//

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "bookins")
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    String destination;

    Instant departureTime;

    @Enumerated(EnumType.STRING)
    BookingStatus bookingStatus;

    @CreationTimestamp
    Instant bookedAt;

}


