package models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private String password;

    @ToString.Exclude
    private String email;

    private String code;
}
