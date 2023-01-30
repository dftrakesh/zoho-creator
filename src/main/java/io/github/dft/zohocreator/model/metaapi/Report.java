package io.github.dft.zohocreator.model.metaapi;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Report {
    public Integer type;
    public String linkName;
    public String displayName;
}