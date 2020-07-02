package com.example.contracts;

import au.com.dius.pact.provider.junit.Consumer;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.TargetRequestFilter;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import au.com.dius.pact.provider.spring.target.MockMvcTarget;
import com.example.contracts.controllers.UserController;
import com.example.contracts.controllers.dto.UserDto;
import com.example.contracts.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRestPactRunner.class)
@Provider("UserProvider")
@PactBroker(scheme = "http", host = "localhost", port = "80")
@Consumer("UserProviderConsumer")
public class PactQueryParameterContractValidator {

    @MockBean
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @TestTarget
    public final MockMvcTarget target = new MockMvcTarget();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        userController = new UserController(userService);
        target.setControllers(userController);
    }

    @State("")
    public void userFound() {
        target.setMockMvc(MockMvcBuilders.standaloneSetup(userController)
                .defaultRequest(MockMvcRequestBuilders.get("/users/Name"))
                .build());

        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(UserDto.builder().name("Name").lastName("LastName").build());

        when(userService.getUserByName(anyString())).thenReturn(userDtoList);
        var props = System.getProperties();
        props.put("pact.verifier.publishResults", "true");
        System.setProperties(props);
    }

    @TargetRequestFilter
    public void requestFilter(MockHttpServletRequestBuilder request) {
        request.header("Content-Type", "application/json");
    }

}
