package main.web;

import main.service.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@EnableJpaRepositories(basePackageClasses = PersonRepository.class, basePackages = {"main.service.repository"})
@ComponentScan(basePackages = {"main.web" ,"main.model"})
@PropertySource("classpath:application.properties")
//@WebMvcTest(PerformanceBondResource.class)
@SpringBootTest
@AutoConfigureMockMvc
@DataJpaTest
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)

//@ComponentScan(basePackages = {"web" ,"main.model"})
public class PerformanceBondTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void hello() throws Exception {
        this.mockMvc.perform(get("/PerformanceBond")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());
                //.andExpect(content().contentType("application/json"));
    }

}