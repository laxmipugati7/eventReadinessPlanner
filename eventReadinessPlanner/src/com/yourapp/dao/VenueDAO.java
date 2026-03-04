package com.yourapp.dao;

import com.yourapp.bean.Venue;

public interface VenueDAO {

    void addVenue(Venue venue);

    void viewVenues();

    void updateVenue(int venueId, String venueName);

    void deleteVenue(int venueId);

    Venue getVenueById(int venueId);
}