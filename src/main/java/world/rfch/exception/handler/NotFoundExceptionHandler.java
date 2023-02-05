package world.rfch.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import world.rfch.dto.ErrorResponseDto;
import world.rfch.exception.SupportArticleNotFoundException;
import world.rfch.exception.UserNotFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleUserNotFoundException(UserNotFoundException e){
        ErrorResponseDto errorResponseDto =
                ErrorResponseDto.builder().
                        message(e.getMessage()).httpStatus(HttpStatus.NOT_FOUND).localDateTime(LocalDateTime.now()).
                        build();
        return new ResponseEntity<>(errorResponseDto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SupportArticleNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleUserNotFoundException(SupportArticleNotFoundException e){
        ErrorResponseDto errorResponseDto =
                ErrorResponseDto.builder().
                        message(e.getMessage()).httpStatus(HttpStatus.NOT_FOUND).localDateTime(LocalDateTime.now()).
                        build();
        return new ResponseEntity<>(errorResponseDto,HttpStatus.NOT_FOUND);
    }
}
