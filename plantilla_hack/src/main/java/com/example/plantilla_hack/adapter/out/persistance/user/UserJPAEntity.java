package com.example.plantilla_hack.adapter.out.persistance.user;

import com.example.plantilla_hack.adapter.out.persistance.consum.ConsumJPA;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Table(name = "users")
@Entity
public class UserJPAEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Getter
    @Setter
    private long id;

    @Setter
    @Getter
    @Column(nullable = false)
    private String fullName;

    @Setter
    @Getter
    @Column(unique = true, length = 100, nullable = false)
    private String email;

    @Setter
    @Getter
    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @Setter
    @Getter
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Setter
    @Getter
    @Column(name = "updated_at")
    private Date updatedAt;

    @Setter
    @Getter
    @Column(name = "racha")
    private int racha;

    @Setter
    @Getter
    @Column(name = "poblacio")
    private String poblacio;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<ConsumJPA> consums;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
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


// Getters and setters
}