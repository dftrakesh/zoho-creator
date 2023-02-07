package io.github.dft.zohocreator.model.dataapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteRecordResponse {
    private DataId data;
    private Integer code;
    private String message;
    private List<String> error;
}