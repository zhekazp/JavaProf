package org.task4.DTO.user;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    @NotBlank
    @NotNull
    @Size(min = 2, max = 15)
    private String name;
    @NotBlank
    @NotNull
    @Size(min = 4, max = 20)
    private String password;
    @Email
    @NotNull
    private String email;
    @Pattern(regexp = "^0[0-9]{5,}$")
    @NotNull
    private String phone;
}
