package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Cases {
    private int id;
    private String title;
    private  int sectionId;
    private int suiteId;
    private Case[] cases;
}
