package com.Soham.Module_9_Spring_AI.dto;




import com.Soham.Module_9_Spring_AI.entity.BookingStatus;

import java.time.Instant;

public record BookingResponse(Long id, String destination, Instant departureTime, BookingStatus status) {}