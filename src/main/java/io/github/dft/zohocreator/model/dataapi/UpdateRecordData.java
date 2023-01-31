package io.github.dft.zohocreator.model.dataapi;

import lombok.Data;

import java.util.HashMap;

@Data
public class UpdateRecordData {
    private Result result;
    private HashMap<String, Object> data;
}