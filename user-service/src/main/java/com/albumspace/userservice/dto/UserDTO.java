    package com.albumspace.userservice.dto;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.util.UUID;

    @Data
    @Builder
    public class UserDTO {

        private String userId;
        private String username;
        private String email;
        private String firstName;
        private String lastName;
        private String profilePictureUrl;
        private String password;
    }
