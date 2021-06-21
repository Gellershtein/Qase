package adapters;

import models.Project;
import models.ResponseProject;
import models.ResponseStatus;

public class ProjectAdapter extends BaseAdapter {
    public ResponseStatus create(Project project, int status) {
        String response = post(gson.toJson(project), status, "https://api.qase.io/v1/project/");
        return gson.fromJson(response, ResponseStatus.class);
    }
    public ResponseProject getProject(String code){
        String response = get(200,"https://api.qase.io/v1/project/" + code);
        return gson.fromJson(response, ResponseProject.class);
    }
}
