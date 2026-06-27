package Handlers;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OauthSuccessHandler  extends SimpleUrlAuthenticationSuccessHandler {

    private  final com.Soham.Module_5_Spring_Security_Fundamentals.Services.UserService userService;
    private final com.Soham.Module_5_Spring_Security_Fundamentals.Services.JWTSerivce jwtSerivce;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, IOException {
        OAuth2AuthenticationToken token= (OAuth2AuthenticationToken) authentication;
        DefaultOAuth2User oAuth2User= (DefaultOAuth2User) token.getPrincipal();

        String email=oAuth2User.getAttribute("email");

//        com.Soham.Module_5_Spring_Security_Fundamentals.Entities.User user=userService.getUserByEmail(email);
//        if(user==null){
//            com.Soham.Module_5_Spring_Security_Fundamentals.Entities.User user = User.builder().name(oAuth2User.getAttribute("name")).email(email).build();
//
//            user=userService.save(user);
//        }
//        String accessToken = jwtSerivce.generateAccessToken(user);
//        String refreshToken = jwtSerivce.generateRefreshToken(user);
//        Cookie cookie= new Cookie("refreshToken",refreshToken);
//        cookie.setHttpOnly(true);
//        cookie.setSecure(true);
//        response.addCookie(cookie);
//
//        String frontend= "http://localhost:8080/home.html?token="+accessToken;
//
//        getRedirectStrategy().sendRedirect(request,response,frontend);



    }


}
