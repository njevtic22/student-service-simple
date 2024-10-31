package com.example.studentservice.security;

import com.example.studentservice.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SimpleAuthenticationService implements AuthenticationService {
    private final AuthenticationManager authManager;

    public SimpleAuthenticationService(AuthenticationManager authManager) {
        this.authManager = authManager;
    }


    @Override
    public UserDetails authenticate(String username, String password) {
        Authentication userAuth = authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(userAuth);
        return getPrincipal(userAuth);
    }

//    To read about authenticate
//    https://stackoverflow.com/questions/29434209/change-username-in-spring-security-when-logged-in
//    https://stackoverflow.com/questions/14010326/how-to-change-the-login-name-for-the-current-user-with-spring-security-3-1/14174404#14174404
//    search: spring security change security context after username change
//
//    Possible problem with chosen solution 1:
//    previousAuth is not retrieved from database, but from SecurityContext and therefore its data
//    can be outdated after profile update, but if username, password and authorities are up to date
//    does it really matter? (Spring security uses UserDetails and not User directly)
//
//    That could be another reason why model.User class should not implement UserDetails interface
//    because it could contain significantly more data than needed for Spring security
//
//    Solution 2
//    userService.getByUsername(...) can be used instead of copying previousAuth
//    but it requires another query to database and all of that just to keep
//    all User data up to date even though Spring security uses just UserDetails
    @Override
    public UserDetails reauthenticate(String changedUsername) {
//        Solution 1
        User previousAuth = (User) getAuthenticated();

        User currentAuth = new User(
                previousAuth.getId(),
                previousAuth.getName(),
                previousAuth.getSurname(),
                changedUsername,
                previousAuth.getPassword(),
                previousAuth.getRole()
        );

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(currentAuth, currentAuth.getPassword(), currentAuth.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return currentAuth;
    }


    @Override
    public void invalidateAuthentication() {
        SecurityContextHolder.clearContext();
    }

    @Override
    public UserDetails getAuthenticated() {
        Authentication userAuth = SecurityContextHolder.getContext().getAuthentication();
        return getPrincipal(userAuth);
    }

    private UserDetails getPrincipal(Authentication authentication) {
        return (UserDetails) authentication.getPrincipal();
//        return userService.getByUsername(principal.getUsername());
    }
}
