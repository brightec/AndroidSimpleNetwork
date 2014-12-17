package uk.co.brightec.androidsimplenetwork.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chris on 17/12/14.
 */
public class Person {
    @SerializedName("FirstName")
    private String firstName;

    @SerializedName("LastName")
    private String lastName;

    @SerializedName("EmailAddress")
    private String emailAddress;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
