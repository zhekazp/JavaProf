package org.task4.DTO.user;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserWithIdDTO {
    @Min(0)
    @NotNull
    private Integer id;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 15)
    private String name;
    @Size(min = 4, max = 20)
    @NotNull
    private String password;
    @Email
    @NotNull
    private String email;
    @Pattern(regexp = "^0[0-9]{5,}$")
    @NotNull
    private String phone;
}
