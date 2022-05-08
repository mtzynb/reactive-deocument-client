package com.arusha.documentreacticeservisclient.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author aglitchyy
 * @created 08/05/2022
 */

//@Component
public class DeleteDocumentRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        System.out.println("------ in DeleteDocumentRunner -------");

        Mono<String> mono = WebClient.create("http://localhost:8085")
                .delete()
                .uri("/documents/3")
                .retrieve()
                .bodyToMono(String.class);
        System.out.println("------ end  DeleteDocumentRunner -------");

        System.out.println("************* results *************");
        mono.subscribe(System.out::println);
        System.out.println("************* end results *************");

    }
}
