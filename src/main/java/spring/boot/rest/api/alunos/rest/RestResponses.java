package spring.boot.rest.api.alunos.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestResponses<T> {

    public ResponseEntity<T> created(T element) {
        return ResponseEntity.status(HttpStatus.CREATED).body(element);
    }

}
