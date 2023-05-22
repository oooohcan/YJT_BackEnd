package edu.web.yjt_backend.model.domain.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddProblemRequest implements Serializable {
    private static final long serialVersionUID = -3196336584956826600L;
    private String title;
    private String author;
    private String content;
    private String answer;
    private int label;
}
