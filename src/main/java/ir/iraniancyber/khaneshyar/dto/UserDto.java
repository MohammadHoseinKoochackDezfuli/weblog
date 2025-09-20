package ir.iraniancyber.khaneshyar.dto;

import ir.iraniancyber.khaneshyar.model.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class UserDto {

    private final String fullName;
    private final String password;
    private final String username;
    private final String email;

    public UserDto( String fullName, String password, String username, String email) {
        this.fullName = fullName;
        this.password = password;
        this.username = username;
        this.email = email;
    }

    @NotBlank(message = "user.username.null")
    public String getUsername() {
        return username;
    }

    @NotBlank(message = "user.password.null")
    public String getPassword() {
        return password;
    }

    @NotBlank(message = "user.fullName.null")
    public String getFullName() {
        return fullName;
    }

    @NotBlank(message = "user.email.null")
    public String getEmail() {
        return email;
    }

}
