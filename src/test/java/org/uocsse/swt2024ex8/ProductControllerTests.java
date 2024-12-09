package org.uocsse.swt2024ex8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Swt2024Ex8Application.class
)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties"
)
public class ProductControllerTests {
    @Autowired
    private MockMvc mvc;

    @Test
    void whenGetExistingProduct_returnsProduct() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/product?id=3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.description").exists())
                .andExpect(jsonPath("$.price").exists())
                .andReturn();
    }

    @Test
    void whenGetNonExistingProduct_status404() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/product?id=99999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void whenAddProduct_returnsProduct() throws Exception {
        var productJson = """
                {
                    "name": "Test",
                    "description": "Test",
                    "price": 12345
                }""";

        mvc.perform(MockMvcRequestBuilders.post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Test"))
                .andExpect(jsonPath("$.description").value("Test"))
                .andExpect(jsonPath("$.price").value(12345))
                .andReturn();
    }

    @Test
    void whenDeleteExistingProduct_status200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/product?id=2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void whenDeleteNonExistingProduct_status404() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/product?id=99999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }
}
