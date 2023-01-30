package io.github.dft.zohocreator.model.dataapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Records {
    private String code;
    private String description;
    private List<HashMap<String, String>> data;
}