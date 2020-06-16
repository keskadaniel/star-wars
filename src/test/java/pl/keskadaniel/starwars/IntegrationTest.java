package pl.keskadaniel.starwars;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class IntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldFindOne() throws Exception {

        mvc.perform(MockMvcRequestBuilders
        .get("/characters"))
                .andExpect(status().isOk());


//        mvc.perform(get("/tasks")
//                .accept(MediaType.APPLICATION_JSON)
//                .param("operation.id", operation.getId().toString()))
//
//                //then
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.content[0].id").value(task.getId().toString()))
//                .andExpect(jsonPath("$.content[0].executors[0].id").value(employee.getId()))
//                .andExpect(jsonPath("$.content[0].operation.id").value(operation.getId()))
//                .andExpect(jsonPath("$.content[0].name").value(task.getName()));

    }

}
