package spring.boot.rest.api.alunos.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String s) {
        super(s);
    }
}
