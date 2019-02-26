package com.ToDoApp.service.impl;

import com.ToDoApp.exception.InternalServerErrorException;
import com.ToDoApp.model.User;
import com.ToDoApp.repository.UserRepository;
import com.ToDoApp.service.TokenQueryService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import static com.ToDoApp.security.SecurityConstants.SECRET;
import static com.ToDoApp.security.SecurityConstants.TOKEN_PREFIX;

@Service
public class TokenQueryServiceImpl implements TokenQueryService {

    private UserRepository userRepository;

    public TokenQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Integer getUserId(HttpServletRequest request) {
        String header = request.getHeader("authorization");
        if (header != null) {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET.getBytes())
                    .parseClaimsJws(header.replace(TOKEN_PREFIX, ""))
                    .getBody();
            String userLogin = claims.getSubject();
            try {
                User user = userRepository.findByLogin(userLogin);
                return user.getId();
            } catch (Exception e) {
                throw new InternalServerErrorException(e);
            }
        } else {
            throw new InternalServerErrorException("Error occurred when handling request ");
        }
    }
}
