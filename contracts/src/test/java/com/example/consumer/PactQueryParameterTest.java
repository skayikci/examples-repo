package com.example.consumer;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.PactTestExecutionContext;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit.ConsumerPactTest;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.example.contracts.controllers.dto.UserDto;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class PactQueryParameterTest extends ConsumerPactTest {

    @Override
    @Pact(provider = "UserProvider", consumer = "UserProviderConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");

        return builder
                .given("")
                .uponReceiving("Pact JVM example Pact interaction")
                .path("/users/Name")
                .method("GET")
                .willRespondWith()
                .headers(headers)
                .status(200)
                .body("[{\n" +
                        "    \"name\": \"Name\",\n" +
                        "    \"lastName\": \"LastName\"\n" +
                        "}]")

                .toPact();
    }

    @Override
    protected String providerName() {
        return "UserProvider";
    }

    @Override
    protected String consumerName() {
        return "UserProviderConsumer";
    }

    @Override
    protected void runTest(MockServer mockServer, PactTestExecutionContext context) {
        UserDto[] result = (new UserClient(mockServer.getUrl() + "/users/Name").callProducer());
        for (UserDto userDto :
                result) {
            assertEquals(userDto.getName(), "Name");
        }
    }
}
