package fr.hb.lacentrale.advisor;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonView()
public class CustomResponse {

    private int status;

    private String message;

}
