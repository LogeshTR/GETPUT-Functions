package com.getput.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional
public class UserService
{

    @Autowired
    private UserRepository userRepository;

    public Optional<UserDTO> getUserById(long id)
    {
    Optional<User> userOptional = userRepository.findById(id);

    if (userOptional.isPresent())
    {
        User user = userOptional.get();
        return Optional.of(mapToWalletDTO(user));
    }
    else
    {
        return Optional.empty();
    }
    }
    public UserDTO createUser(@RequestBody UserDTO userDTO)
    {
        
        User user = mapToWalletModel(userDTO);
            userRepository.save(user);
            return mapToWalletDTO(user);
    }
    
    


    private UserDTO mapToWalletDTO(User user)
    {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());
        
        return userDTO;
    }
    
    private User mapToWalletModel(UserDTO userDTO)
    {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());

        return user;
    }


    public Object convertToDTO(ResponseEntity<User> u) {
        return null;
    }

    
    // List<User> getAllUsers();

    // User getUserById(Long userId);

    // User createUser(User user);

    // User updateUser(Long userId, User user);

    // void deleteUser(Long userId);
}
