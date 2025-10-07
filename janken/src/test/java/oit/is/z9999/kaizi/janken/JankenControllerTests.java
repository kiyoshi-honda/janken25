package oit.is.z9999.kaizi.janken;

import oit.is.z9999.kaizi.janken.model.JankenResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.*;

@WebMvcTest(JankenController.class)
class JankenControllerTests {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private JankenService jankenService;

  @Test
  void testShowJankenForm() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/janken"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.view().name("janken"));
  }

  @Test
  void testPlayJanken() throws Exception {
    JankenResult mockResult = new JankenResult("グー", "チョキ", "勝ち");
    when(jankenService.play("グー")).thenReturn(mockResult);

    mockMvc.perform(MockMvcRequestBuilders.post("/janken/result")
        .param("userHand", "グー"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.view().name("result"))
        .andExpect(MockMvcResultMatchers.model().attributeExists("result"));
  }
}
