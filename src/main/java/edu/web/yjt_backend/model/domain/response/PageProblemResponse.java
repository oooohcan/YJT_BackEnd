package edu.web.yjt_backend.model.domain.response;

import edu.web.yjt_backend.model.domain.Problem;

import java.util.List;

public class PageProblemResponse {
    public List<Problem> problems;
    public long total;

    public PageProblemResponse(List<Problem> problems, long size) {
        this.problems = problems;
        this.total = size;
    }
}
