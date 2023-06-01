package edu.web.yjt_backend.model.domain.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Optional;

@Data
public class GetProblemRequest implements Serializable {
    private static final long serialVersionUID = 5894280542314451634L;

    private Optional<Integer> id;
    private Optional<String> title;
}
