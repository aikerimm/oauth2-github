package kz.aikerimm.oauth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class MainControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturnGreetingContainingName() throws Exception {
        mockMvc
                .perform(
                        get("/hello")
                                .with(user("Maya")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello, Maya@Github!")));
    }
}
