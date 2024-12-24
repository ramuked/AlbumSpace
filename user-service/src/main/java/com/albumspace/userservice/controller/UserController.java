    package com.albumspace.userservice.controller;

    import com.albumspace.userservice.dto.StandardResponse;
    import com.albumspace.userservice.dto.UserDTO;
    import com.albumspace.userservice.service.UserService;
    import org.springframework.http.MediaType;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.multipart.MultipartFile;

    import java.io.File;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.time.LocalDateTime;

    import java.time.LocalDateTime;

    @RestController
    @RequestMapping("/api/v1/users")
    public class UserController {

        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }
        private static final String UPLOAD_DIR = "/Users/sushantkumar/uploads/";

        @GetMapping("/helloWorld")
        public String helloWorld(){
            return "helloWorld";
        }


        @PostMapping(value = "/register",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public ResponseEntity<StandardResponse<UserDTO>> registerUser(@RequestPart UserDTO userDTO,
                                                                      @RequestPart(required = false)MultipartFile profilePicture)throws IOException  {

            if (profilePicture != null && !profilePicture.isEmpty()) {
                String fileName = saveProfilePicture(profilePicture);
                userDTO.setProfilePictureUrl(fileName);  // Set the file path or URL to the DTO
            }

            UserDTO registeredUser = userService.registerUser(userDTO);

            StandardResponse<UserDTO> response = StandardResponse.<UserDTO>builder()
                    .status("success")
                    .message("User registered successfully")
                    .data(registeredUser)
                    .timestamp(LocalDateTime.now())
                    .build();

            return ResponseEntity.ok(response);
        }
        private String saveProfilePicture(MultipartFile file) throws IOException {
            // Ensure the upload directory exists
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdirs();  // Create directories if not present
            }

            // Generate a unique filename
            String fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();

            // Path to store the file
            Path path = Paths.get(UPLOAD_DIR + fileName);

            // Save the file locally
            Files.copy(file.getInputStream(), path);

            return fileName;  // You can return the file path or URL based on your use case
        }
    }
