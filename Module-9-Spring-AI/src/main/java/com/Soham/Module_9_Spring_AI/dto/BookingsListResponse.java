package com.Soham.Module_9_Spring_AI.dto;

import java.util.List;

public record BookingsListResponse(List<BookingResponse> bookings, String message) {}
