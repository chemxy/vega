package com.uvic.venus;

import com.uvic.venus.config.SecurityConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootDemoApplicationTests {

    SecurityConfiguration securityConfigTest = new SecurityConfiguration();

    ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withUserConfiguration(SecurityConfiguration.class);

    @Test
    public void passwordEncoderTest() {
        PasswordEncoder encoder = securityConfigTest.passwordEncoder();
        assert(encoder != null);
    }
}
