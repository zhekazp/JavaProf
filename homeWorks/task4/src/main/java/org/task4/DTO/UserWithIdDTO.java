package org.task4.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserWithIdDTO {
    private int id;
    private String name;
    private String password;
    private String email;
    private String phone;
}
