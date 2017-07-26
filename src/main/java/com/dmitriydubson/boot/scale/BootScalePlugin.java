package com.dmitriydubson.boot.scale;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class BootScalePlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getExtensions().create("bootScaleSettings", BootScalePluginExtension.class);
        project.getTasks().create("bootScaleTask", BootScaleTask.class);
    }
}
