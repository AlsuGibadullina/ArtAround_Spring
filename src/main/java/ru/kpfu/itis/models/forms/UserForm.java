package ru.kpfu.itis.models.forms;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserForm {
    private String nickname;
    private String email;
    private String password;
}
