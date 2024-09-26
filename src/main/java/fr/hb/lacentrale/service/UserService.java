package fr.hb.lacentrale.service;

import fr.hb.lacentrale.configuration.PasswordEncoderConfig;
import fr.hb.lacentrale.entity.Address;
import fr.hb.lacentrale.exceptions.AlreadyActiveException;
import fr.hb.lacentrale.exceptions.ExpiredCodeException;
import fr.hb.lacentrale.repository.AddressRepository;
import fr.hb.lacentrale.service.interfaces.DtoMapperInterface;
import fr.hb.lacentrale.service.interfaces.ServiceListInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.hb.lacentrale.dto.UserCreateDto;
import fr.hb.lacentrale.dto.UserUpdateDto;
import fr.hb.lacentrale.entity.User;
import fr.hb.lacentrale.service.interfaces.ServiceInterface;
import fr.hb.lacentrale.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class UserService implements ServiceListInterface<User, String, UserCreateDto, UserUpdateDto>, DtoMapperInterface<User,UserCreateDto> {

    private final UserRepository userRepository;
    private final PasswordEncoderConfig encoder;
    private AddressRepository addressRepository;

    @Override
    public User create(UserCreateDto userDto) {
        User user = toEntity(userDto);
        user.setCreatedAt(LocalDateTime.now());
        user.setRoles("[\"ROLE_USER\"]");
        user.setActivationCode(UUID.randomUUID().toString());
        user.setActivationCodeSentAt(LocalDateTime.now());
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(User user) {

    }


    public Boolean delete(String uuid) {
        try {
            User user = findById(uuid);
            user.setPhone(null);
            user.setBirthAt(null);
            user.setPhoto(null);
            user.setSiret(null);
            user.setLastName(null);
            user.setFirstName(null);
            user.setEmail("Utilisateur supprimé");
            Address address = user.getAddress();
            if (address!= null) {
                address.setUser(null);
                addressRepository.save(address);
            }
            userRepository.saveAndFlush(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User update(UserUpdateDto userDto, String id) {
        return null;
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    @Override
    public User toEntity(UserCreateDto userCreateDto) {
        User user = new User();
        user.setEmail(userCreateDto.getEmail());
        user.setPassword(encoder.passwordEncoder().encode(userCreateDto.getPassword()));
        user.setPhone(userCreateDto.getPhone());
        user.setPhoto(userCreateDto.getPhoto());
        user.setSiret(userCreateDto.getSiret());
        user.setBirthAt(userCreateDto.getBirthAt());

        return user;
    }

    @Override
    public UserCreateDto toDto(User entity) {
        return null;
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    public User activate(String code) {
        User user = userRepository.findUserByActivationCode(code)
                .orElseThrow(() -> new AlreadyActiveException("Ce code d'activation n'existe pas !"));

        LocalDateTime current = LocalDateTime.now();
        if (current.isAfter(user.getActivationCodeSentAt().plusMinutes(15))) {
            throw new ExpiredCodeException("La durée du code a expiré");
        }
        user.setActivationCode(null);
        user.setActivationCodeSentAt(null);
        return userRepository.saveAndFlush(user);
    }
}