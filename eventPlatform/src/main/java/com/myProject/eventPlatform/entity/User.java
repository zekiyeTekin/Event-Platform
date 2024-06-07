package com.myProject.eventPlatform.entity;

import com.myProject.eventPlatform.enumuration.role.RoleEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(unique = true)
    private String mail;
    private Integer age;
    private String visibility;
    private String location;
    private String password;

    @Column(name = "is_active")
    private Boolean isActive;


    @Enumerated(EnumType.STRING)
    private RoleEnum role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return mail;
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
        return isActive;
    }


    //@OneToMany(mappedBy = "user") // burada eğer bir kullanıcıların katıldığı tüm etkinlikleri görmek istersem diye
    //private List<EventUser> eventsAttended;



}
