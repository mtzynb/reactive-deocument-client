package com.arusha.documentreacticeservisclient.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @author aglitchyy
 * @created 08/05/2022
 */

//@Component
public class SaveOrUpdateDocumentRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("------ in SaveOrUpdateDocumentRunner -------");

        String addOrUpdateRequest = "{\n" +
                "    \"id\": 4,\n" +
                "    \"name\": \"a new document\"\n" +
                "}";

        Mono<String> mono = WebClient.create("http://localhost:8085")
                .post()
                .uri("/documents")
                .contentType(MediaType.APPLICATION_JSON)
                .acceptCharset(StandardCharsets.UTF_8)
                .body(Mono.just(addOrUpdateRequest), String.class)
                .retrieve()
                .bodyToMono(String.class);
        System.out.println("------ end SaveOrUpdateDocumentRunner -------");


        System.out.println("************* results *************");
        mono.subscribe(System.out::println);
        System.out.println("************* end results *************");
    }
}
