package ru.kpfu.itis.models.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpDto {

    private String nickname;
    private String email;
    private String password;
    private String password2;
}
