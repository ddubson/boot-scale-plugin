package com.dmitriydubson.boot.scale;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class BootScaleTask extends DefaultTask {
    @TaskAction
    public void run() {
        BootScalePluginExtension extension = getProject().getExtensions()
                .findByType(BootScalePluginExtension.class);
        if (extension == null) {
            extension = new BootScalePluginExtension();
        }

        System.out.format("BootScale scaling to %d instances.\n",
                extension.getNumberOfInstances());
    }
}
