package org.example.security;

import org.example.entity.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GloLogisticsCustomerDetails implements UserDetailsService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //database interaction
        Customer customer = customerRepository.findByCustomerEmail(username).get();
        // Converting the roles to set of roles with type String
        Set<String> roles = new HashSet<>();
        roles.add(customer.getRole());
        //converting the roles to authorities
        Set<GrantedAuthority> authorities =
                roles.stream().map(r->new
                         SimpleGrantedAuthority(r.describeConstable().get())).collect(Collectors.toSet(
                ));
        //returning the user object of security framework with email, passwordand roles in the form of authorities
        return new org.springframework.security.core.userdetails.User(customer.getCustomerEmail()
                ,customer.getCustomerPassword(),authorities);
    }
}