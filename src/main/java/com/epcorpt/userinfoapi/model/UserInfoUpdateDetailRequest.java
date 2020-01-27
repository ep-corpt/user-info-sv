package com.epcorpt.userinfoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoUpdateDetailRequest {

    @NotNull(message = "Firstname is required")
    @Size(max = 30, message = "Firstname cannot more than thirty")
    private String firstName;
    @NotNull(message = "Lastname is requried")
    @Size(max = 30, message = "Lastname cannot more than thirty")
    private String lastName;
    @Size(max = 1, message = "Gender cannot more than one")
    private String gender;
    @Size(max = 3, message = "Age cannot more than three")
    @Pattern(regexp = "[0-9]*", message = "Age must be numeric only")
    private String age;
    @Size(max = 10, message = "Mobile No cannot more than ten")
    @Pattern(regexp = "[0-9]*", message = "Mobile No must be numeric only")
    private String mobileNo;
    @Size(max = 100, message = "Address cannot more than one-hundred")
    private String address;

}
