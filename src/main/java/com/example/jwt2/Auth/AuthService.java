package com.example.jwt2.Auth;


import com.example.jwt2.Jwt.JwtService;
import com.example.jwt2.User.Rol;
import com.example.jwt2.User.User;
import com.example.jwt2.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    public AuthResponse login(LoginRequest request){
        return null;
    }
    public  AuthResponse register(RegisterRequest request) {

        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPasswarod())
                .firtsname(request.getFirtsname())
                .lasname(request.lasname)
                .country(request.getCountry())
                .rol(Rol.USER)
                .build();

        userRepository.save(user);
        return AuthResponse.builder().token(jwtService.getToken(user)).build();

    }


}
