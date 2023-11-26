package com.tui.ordering.pilotes.security;


import com.tui.ordering.pilotes.out.jpa.model.security.AuthorityEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final AuthorityEntity authority;

    @Override
    public String getAuthority() {
        return authority.getName().toString();
    }
}
