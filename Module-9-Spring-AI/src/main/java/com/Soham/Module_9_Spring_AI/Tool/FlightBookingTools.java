package com.Soham.Module_9_Spring_AI.Tool;


import com.Soham.Module_9_Spring_AI.Service.FlightBookingService;
import com.Soham.Module_9_Spring_AI.dto.BookingResponse;
import com.Soham.Module_9_Spring_AI.dto.BookingsListResponse;
import com.Soham.Module_9_Spring_AI.entity.BookingStatus;
import com.Soham.Module_9_Spring_AI.entity.FlightBooking;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FlightBookingTools {

    private final FlightBookingService flightBookingService;


    @Tool(
            name = "flight_booking_tool",
            description = "Create a new flight booking for a user"
    )
    public BookingResponse createBooking(
            @ToolParam(description = "The unique user id (e.g. userId is user123)")
            String userId,

            @ToolParam(description = "The destination for the flight booking (e.g. city like Delhi, London, etc.)")
            String destination,

            @ToolParam(description = "Departure date and time in ISO-8601 format (e.g., 2025-12-25T14:30:00Z)")
            Instant departureTime) {

        var flightBooking = flightBookingService.createBooking(userId, destination, departureTime);
        return new BookingResponse(
                flightBooking.getId(),
                flightBooking.getDestination(),
                flightBooking.getDepartureTime(),
                flightBooking.getBookingStatus());
    }



    @Tool(
            name = "get_user_bookings",
            description = "Retrieve all flight bookings for the current user, sorted by departure time (most recent first). " +
                    "Returns an empty list message if none exist."
    )
    public BookingsListResponse getUserBookings(
            @ToolParam(description = "The unique user ID")
            String userId
    ) {
        List<FlightBooking> bookings = flightBookingService.getUserBookings(userId);

        List<BookingResponse> responses = bookings.stream()
                .map(b -> new BookingResponse(
                        b.getId(),
                        b.getDestination(),
                        b.getDepartureTime(),
                        b.getBookingStatus()
                ))
                .toList();

        String message = bookings.isEmpty()
                ? "You have no upcoming flight bookings."
                : "Here are your current flight bookings:";

        return new BookingsListResponse(responses, message);
    }

    @Tool(
            name = "update_booking_status",
            description = "Update the status of an existing flight booking (e.g., cancel it). " +
                    "Only the owner of the booking can modify it. " +
                    "Common use: set status to CANCELLED."
    )
    public BookingResponse updateBookingStatus(
            @ToolParam(description = "The booking ID returned from create or get bookings", required = true)
            Long bookingId,

            @ToolParam(description = "The user ID who owns the booking", required = true)
            String userId,

            @ToolParam(description = "New status: CONFIRMED, CANCELLED, or PENDING", required = true)
            BookingStatus newStatus
    ) {
        FlightBooking updated = flightBookingService.updateBookingStatus(bookingId, userId, newStatus);
        return new BookingResponse(
                updated.getId(),
                updated.getDestination(),
                updated.getDepartureTime(),
                updated.getBookingStatus()
        );
    }


}
