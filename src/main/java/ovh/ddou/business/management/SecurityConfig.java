/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ovh.ddou.business.management;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Spring Security Configuration.
 *
 * @author Marcelo Fernandes
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) {
        try {
            http.csrf().disable();
            http
                    .userDetailsService(userDetailsService())
                    .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/views/index.xhtml").permitAll()
                    .antMatchers("/javax.faces.resource/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/views/login.xhtml")
                    .permitAll()
                    .failureUrl("/views/login.xhtml?error=true")
                    .defaultSuccessUrl("/views/index.xhtml")
                    .and()
                    .logout()
                    .logoutSuccessUrl("/views/login.xhtml");

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails admin = new User("admin", "password", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
        UserDetails user = new User("user", "password", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        return new InMemoryUserDetailsManager(Arrays.asList(admin, user));
    }
}
