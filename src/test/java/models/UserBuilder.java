package models;

import lombok.*;

@Builder
@ToString
public class UserBuilder {
    private String username;
    private String password;
    private String email;
    private String code;
}
