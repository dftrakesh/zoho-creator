package io.github.dft.zohocreator.model.dataapi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class DeleteRecordRequest {
    private Result result;
    private String criteria;
    @JsonIgnore
    private String formLinkName;
}
