package helpers;

import com.google.gson.Gson;
import models.Project;

public class GsonHelper {
    private static Gson gson = new Gson();

    public static Project getProjectFromJson(String json) {
        return gson.fromJson(json, Project.class);
    }
}
