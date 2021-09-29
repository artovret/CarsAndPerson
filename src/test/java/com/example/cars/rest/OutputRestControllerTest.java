package com.example.cars.rest;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.cars.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {OutputRestController.class})
@ExtendWith(SpringExtension.class)
class OutputRestControllerTest {
    @Autowired
    private OutputRestController outputRestController;

    @MockBean
    private PersonService personService;

    @Test
    void testClearAll() throws Exception {
        doNothing().when(this.personService).delete();
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/clear");
        MockMvcBuilders.standaloneSetup(this.outputRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testClearAll2() throws Exception {
        doNothing().when(this.personService).delete();
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/clear");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.outputRestController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testClearAll3() throws Exception {
        doNothing().when(this.personService).delete();
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/clear");
        MockMvcBuilders.standaloneSetup(this.outputRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testClearAll4() throws Exception {
        doNothing().when(this.personService).delete();
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/clear");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.outputRestController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetPerson() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/personwithcars");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1L));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.outputRestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetPerson2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/personwithcars");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1L));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.outputRestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testGetStatistics() throws Exception {
        when(this.personService.getVendorCount()).thenReturn(3L);
        when(this.personService.getCarCount()).thenReturn(3L);
        when(this.personService.getPersonCount()).thenReturn(3L);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/statistics");
        MockMvcBuilders.standaloneSetup(this.outputRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"personcount\":3,\"carcount\":3,\"uniquevendorcount\":3}"));
    }

    @Test
    void testGetStatistics2() throws Exception {
        when(this.personService.getVendorCount()).thenReturn(3L);
        when(this.personService.getCarCount()).thenReturn(3L);
        when(this.personService.getPersonCount()).thenReturn(3L);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/statistics");
        MockMvcBuilders.standaloneSetup(this.outputRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"personcount\":3,\"carcount\":3,\"uniquevendorcount\":3}"));
    }
}

