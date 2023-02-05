package world.rfch.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorResponseDto {

    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime localDateTime;

}
