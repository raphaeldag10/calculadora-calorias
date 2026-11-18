package com.example.calccalorias.controller;

import com.example.calccalorias.model.Alimento;
import com.example.calccalorias.repository.AlimentoRepository;
import com.example.calccalorias.service.AlimentoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AlimentoController.class)
@Import(AlimentoService.class)
class AlimentoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private AlimentoRepository alimentoRepository;

    @Test
    void cadastraAlimentoComCarboidratoECalculaCalorias() throws Exception {
        when(alimentoRepository.save(any(Alimento.class)))
                .thenAnswer(invocacao -> invocacao.getArgument(0));

        mvc.perform(post("/api/alimentos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "nome": "Aveia",
                                    "porcao": "30 g",
                                    "quantidadeProteina": 4,
                                    "quantidadeCarboidrato": 18,
                                    "quantidadeGorduras": 2
                                }
                                """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.quantidadeCarboidrato").value(18))
                .andExpect(jsonPath("$.totalCalorias").value(106));
    }

    @Test
    void rejeitaCadastroSemCarboidrato() throws Exception {
        mvc.perform(post("/api/alimentos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "nome": "Aveia",
                                    "porcao": "30 g",
                                    "quantidadeProteina": 4,
                                    "quantidadeGorduras": 2
                                }
                                """))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(alimentoRepository);
    }
}
