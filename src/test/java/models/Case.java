package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class Case {
    @EqualsAndHashCode.Exclude
    private int id;

    private String title;

    @EqualsAndHashCode.Exclude
    private int sectionId;

    private int templateId;
    private int typeId;
    private int priorityId;
    private int suiteId;

    @SerializedName(value = "case_ids")
    @JsonProperty("case_ids")
    private int[] casesIds;
}
