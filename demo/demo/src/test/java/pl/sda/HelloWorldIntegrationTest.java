package pl.sda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.regex.Matcher;

import static org.assertj.core.api.Assertions.contentOf;
import static org.assertj.core.api.Assertions.fail;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class HelloWorldIntegrationTest {
    // test integracyjny end-to-end
    // wartyw prezentacji,gdzie siedza kontrollery


    // mock
    @Autowired
    private MockMvc mockMvc;


    @DisplayName("when call GET on/greetings, then 200 status is retuned")
    @Test
    void test() throws Exception {
        // given

        // when  // metody statyczne//statyczny import
        mockMvc.perform(get("/greetings"))
                //then
                .andExpect(status().isOk())
        // fail("Write your test");
        //   .andExcept(content().string("[]"));
    }

    // @formatter : on
    @DisplayName(
            "given one message in the system," +
                    "when call GET on greetings, " +
                    "then 20 status and json array of size 1 is returned"
    )

    @Test
    void test1() throws Exception {
        // given
        String greeting = "{\"msg\":\"hello\"}";
        mockMvc.perform(
                post("/greetings") // na greetings chemy postem wyslac cos
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(greeting)  // json
                //@formatter:on
        ).andExpect(status().isOk());


        //when
        mockMvc.perform(get("/greetings"))
                .andDo(MockMvcResultHandlers.print())
                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))               //$ caly obiekt zwrucony
                .andExpect((ResultMatcher) jsonPath("$[0].msg",is("hello")));    // $[0]-pierwszy element tej tablicy
        fail("Write our test");

    }
}


