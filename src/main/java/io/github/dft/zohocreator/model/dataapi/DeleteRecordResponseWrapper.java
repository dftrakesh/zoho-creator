package io.github.dft.zohocreator.model.dataapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteRecordResponseWrapper {
    private String code;
    private String message;
    private List<DeleteRecordResponse> result;
}