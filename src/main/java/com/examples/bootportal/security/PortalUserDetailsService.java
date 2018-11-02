package com.examples.bootportal.security;

import com.examples.bootportal.entity.Member;
import com.examples.bootportal.entity.Role;
import com.examples.bootportal.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class PortalUserDetailsService implements UserDetailsService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException {
        Member member = memberRepository.getMemberAndRoles(email);
        if (member == null) {
            throw new UsernameNotFoundException(email + " is not found");
        }

        String password = member.getPassword();
        Collection<GrantedAuthority> authorities = new HashSet<>();
        Set<Role> roles = member.getRoles();

        for (Role role: roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        }

        LoginUser loginUser = new LoginUser(email,password,authorities);
        loginUser.setId(member.getId());
        loginUser.setName(member.getName());

        return loginUser;
    }

}
