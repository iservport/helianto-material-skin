package org.helianto.root;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;


public interface HeliantoResourceServerConfigurer {

    /**
     * Extension hook to configure the resource server.
     *
     * @param http
     * @throws Exception
     */
    void configure(HttpSecurity http) throws Exception;

}
