package ir.iraniancyber.khaneshyar.dto;

import ir.iraniancyber.khaneshyar.model.Role;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class UserDto {


    private int id;
    private String fullName;
    private String password;
    private String username;
    private String email;
    private Role role;
    private LocalDateTime createdAt;

    public UserDto(int id, String fullName, String password, String username, String email, Role role, LocalDateTime createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.username = username;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
    }

    @NotBlank(message = "user.username.null")
    public String getUsername() {
        return username;
    }

    @NotBlank(message = "user.password.null")
    public String getPassword() {
        return password;
    }

    @NotBlank(message = "user.id.null")
    public int getId() {
        return id;
    }

    @NotBlank(message = "user.fullName.null")
    public String getFullName() {
        return fullName;
    }

    @NotBlank(message = "user.email.null")
    public String getEmail() {
        return email;
    }

    @NotBlank(message = "user.roll.null")
    public Role getRole() {
        return role;
    }

    @NotBlank(message = "user.createdAt.null")
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
