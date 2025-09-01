package com.example.profiles;


/**
 * Assembles profiles with scattered, inconsistent validation.
 */
public class ProfileService {

    // returns a fully built immutable profile
    public UserProfile createMinimal(String id, String email) {
        return new UserProfile.Builder(id, email).build();
    }

    public UserProfile createFullProfile(String id, String email, String phone, String displayName, String address,
                                         boolean marketingOptIn, String twitter, String github) {
        return new UserProfile.Builder(id, email)
                .phone(phone)
                .displayName(displayName)
                .address(address)
                .marketingOptIn(marketingOptIn)
                .twitter(twitter)
                .github(github)
                .build();
    }
}
