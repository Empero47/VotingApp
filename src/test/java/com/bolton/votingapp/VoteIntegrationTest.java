//package com.bolton.votingapp;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.springframework.test.web.servlet.MockMvc;
//import org.testcontainers.containers.MySQLContainer;
////import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
////@Testcontainers
//@AutoConfigureMockMvc
//class VoteIntegrationTest {
//
//    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8")
//            .withDatabaseName("testdb")
//            .withUsername("test")
//            .withPassword("test");
//
//    @DynamicPropertySource
//    static void props(DynamicPropertyRegistry reg) {
//        reg.add("spring.datasource.url", mysql::getJdbcUrl);
//        reg.add("spring.datasource.username", mysql::getUsername);
//        reg.add("spring.datasource.password", mysql::getPassword);
//    }
//
//    @Autowired
//    MockMvc mockMvc;
////    @Autowired
////    ObjectMapper mapper;
//
//    @Test
//    void fullVotingFlow() throws Exception {
//        // 1. Register voter
//        mockMvc.perform(post("/api/auth/register")
//                        .param("email","u@v.com").param("password","pwd"))
//                .andExpect(status().isOk())
//                .andReturn();
//
//        // 2. Login to get token
//        String token = mockMvc.perform(post("/api/auth/login")
//                        .param("email","u@v.com").param("password","pwd"))
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse().getContentAsString();
//
//        // 3. Create a candidate (would require admin setup)
//        // ... omitted for brevity
//
//        // 4. Cast vote
//        mockMvc.perform(post("/api/votes")
//                        .header("Authorization","Bearer "+token)
//                        .param("voterId","1").param("candidateId","1"))
//                .andExpect(status().isOk());
//
//        // 5. Assert result tally via GET /api/votes/results
//    }
//}
