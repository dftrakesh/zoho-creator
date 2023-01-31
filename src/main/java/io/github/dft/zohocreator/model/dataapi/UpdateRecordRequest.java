package io.github.dft.zohocreator.model.dataapi;

import lombok.Data;

@Data
public class UpdateRecordRequest {
    private UpdateRecordData data;
    private String recordId;
    private String formLinkName;
}