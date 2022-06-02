package com.amplifier.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.amplifier.models.ImgPost;
import com.amplifier.services.ImgPostService;
import com.amplifier.util.ClientMessageUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author Patrick Yaeger based on the work of Calvin Raines and Levi Choi
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(ImgPostController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ImgPostControllerIntTest {

        private static ImgPost mockImgPost1;
        // private static ImgPost mockImgPostCreation;
        // private static ImgPost mockImgPostModification;
        private static ImgPost mockImgPostDeletion;
        private static List<ImgPost> mockDb;

        public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
                        MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

        // User this is you do not have a LocalDate
        // ObjectMapper om = new ObjectMapper();

        // Use this if you get an error about package not being default in jax
        private static ObjectMapper om = JsonMapper.builder().addModule(new JavaTimeModule()).build();

        @Autowired
        ImgPostController imgPostController;

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        ImgPostService imgPostService;

        @BeforeAll
        static void setUpBeforeClass() throws Exception {
                // mockAuthor = new User();
                mockImgPost1 = new ImgPost();
                mockDb = new ArrayList<>();
                mockDb.add(mockImgPost1);

        }

        @Test
        @Order(1)
        @DisplayName("1. AppContext")
        public void contextLoads() {
                assertThat(imgPostController).isNotNull();
        }

        @Test
        @Order(2)
        @DisplayName("2. Get all Img Posts.")
        public void getImgPosts_ShouldReturnImgPosts() throws Exception {
                //
                when(imgPostService.getAll()).thenReturn(mockDb);

                //
                RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/imgposts");
                MvcResult result = mockMvc.perform(request).andReturn();

                //
                assertEquals(om.writeValueAsString(mockDb), result.getResponse().getContentAsString());
        }

        @Test
        @Order(3)
        @DisplayName("3. Attempt to pull invalid Img Post")
        public void getImgPost_ShouldReturnInvalid() throws Exception {
                //
                when(imgPostService.getById(1)).thenReturn(mockImgPost1);

                //
                RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/user?id=1");
                MvcResult result = mockMvc.perform(request).andReturn();

                //
                assertEquals(om.writeValueAsString(mockImgPost1), result.getResponse().getContentAsString());
        }

        @Test
        @Order(4)
        @DisplayName("4. Attempt to pull valid Img Post")
        public void getUser_ShouldReturnUser() throws Exception {
                //
                when(imgPostService.getById(1)).thenReturn(mockImgPost1);

                //
                RequestBuilder request = MockMvcRequestBuilders
                                .get("/api/imgpost?id=1");
                MvcResult result = mockMvc.perform(request).andReturn();

                //
                assertEquals(om.writeValueAsString(mockImgPost1), result.getResponse().getContentAsString());
        }

        @Test
        @Order(5)
        @DisplayName("5. Delete Img Post")
        public void testDeleteImgPost() throws Exception {

                //
                when(imgPostService.remove(mockImgPostDeletion.getId())).thenReturn(true);

                //
                RequestBuilder request = MockMvcRequestBuilders
                                .delete("/api/v1/imgpost?id=1")
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .content(om.writeValueAsString(mockImgPostDeletion))
                                .contentType(MediaType.APPLICATION_JSON);
                MvcResult result = mockMvc.perform(request).andReturn();

                //
                assertEquals(om.writeValueAsString(ClientMessageUtil.DELETION_SUCCESSFUL),
                                result.getResponse().getContentAsString());
        }

        @Test
        @Order(6)
        @DisplayName("6. Delete Img Post - fail")
        public void testDeleteImgPostFail() throws Exception {

                //
                when(imgPostService.remove(mockImgPostDeletion.getId())).thenReturn(true);

                //
                RequestBuilder request = MockMvcRequestBuilders
                                .delete("/api/v1/imgpost?id=1")
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .content(om.writeValueAsString(mockImgPostDeletion))
                                .contentType(MediaType.APPLICATION_JSON);
                MvcResult result = mockMvc.perform(request).andReturn();

                //
                assertEquals(om.writeValueAsString(ClientMessageUtil.DELETION_FAILED),
                                result.getResponse().getContentAsString());
        }

}
