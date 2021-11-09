package org.example.domain.productcatalog.application.rest;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.example.domain.productcatalog.application.rest.input.Products;
import org.example.domain.productcatalog.core.model.AssociatedArticle;
import org.example.domain.productcatalog.core.model.Product;
import org.example.domain.productcatalog.core.ports.incoming.AddNewProducts;
import org.example.domain.productcatalog.core.ports.incoming.GetProduct;
import org.example.domain.productcatalog.core.ports.incoming.SellProduct;
import org.example.kernel.JsonConverter;
import org.example.test.support.ControllerTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Tag("integration-test")
@Ignore
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
        , properties = "server.port=0")
@DirtiesContext
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:test.properties")
public class ProductCatalogControllerTest extends ControllerTest {

    @MockBean
    private AddNewProducts addNewProducts;
    @MockBean
    private GetProduct getProduct;
    @MockBean
    private SellProduct sellProduct;

    @MockBean
    private JsonConverter<Products> productParser;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getProductWhenDataisThere() throws Exception {

        when(this.getProduct.handle(any(String.class)))
                .thenReturn(Optional.of(Product.initializeWithStock("name", new HashSet<>(Arrays.asList(
                        new AssociatedArticle("1", 4),
                        new AssociatedArticle("2", 40),
                        new AssociatedArticle("8", 14)
                )), 3)));
        this.mockMvc.perform(get("/productcatalog/{name}", "tttttt")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.name").value("name"))
                .andExpect(jsonPath("$.count").exists())
                .andExpect(jsonPath("$.count").value(3))
                .andReturn();

    }

    @Test
    public void getProductWhenDataisNotThere() {

    }


    @Test
    public void testGetPlayerWhenErrorThrown() throws Exception {

//        when(this.getPlayer.get(any(GetPlayerCommand.class)))
//                .thenThrow(new IllegalArgumentException("Invalid player"));
//
//        this.mockMvc.perform(get("/player/{id}", "tttttt")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().is5xxServerError())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.message").exists())
//                .andExpect(jsonPath("$.errorTime").exists())
//                .andReturn();

    }

}