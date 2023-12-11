package com.ProjectFinalArhipovCalin.flyproject.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "password", columnDefinition = "TEXT", updatable = true, nullable = false)
    private String password;

    @Column(name = "first_name", columnDefinition = "TEXT", updatable = true, nullable = false)
    private String firstName;

    @Column(name = "last_name", columnDefinition = "TEXT", updatable = true, nullable = false)
    private String lastName;

    @Email   //pentru email avem nevoie de regex
    @Column(name = "email", columnDefinition = "TEXT", updatable = true, nullable = false,unique = true)
    private String email;

   // @ManyToMany()
//    List<User> flights;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
