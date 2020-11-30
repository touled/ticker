package ru.tulokhonov.ticker.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenUrl_whenGetAll_thenOk() throws Exception {
        this.mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(16)))
                .andExpect(jsonPath("$[0].ticker", is("B")))
                .andExpect(jsonPath("$[0].datePay", is("2018-11-26")))
                .andExpect(jsonPath("$[0].amount", is(0.16)))
                .andExpect(jsonPath("$[0].dateEx", is("2018-12-10")));
    }

    @Test
    void givenTicker_whenGetSearch_thenOk() throws Exception {
        this.mockMvc.perform(get("/search")
                .param("by", "ticker")
                .param("value", "B"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void givenPayDate_whenGetSearch_thenOk() throws Exception {
        this.mockMvc.perform(get("/search")
                .param("by", "datePay")
                .param("value", "2018-11-26"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(16)));
    }

    @Test
    void givenExDate_whenGetSearch_thenOk() throws Exception {
        this.mockMvc.perform(get("/search")
                .param("by", "dateEx")
                .param("value", "2018-12-14"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));
    }

    @Test
    void givenAmount_whenGetSearch_thenOk() throws Exception {
        this.mockMvc.perform(get("/search")
                .param("by", "amount")
                .param("value", "0.9"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}