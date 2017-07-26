package com.dmitriydubson.boot.scale;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BootScaleTask extends DefaultTask {
    @TaskAction
    public void run() {
        BootScalePluginExtension settings = loadPluginSettings();
        scalingTo(settings.getNumberOfInstances());

        try {
            Process process = Runtime.getRuntime().exec("gradle bootRun -Dserver.port=9000");
            try(BufferedReader reader = new BufferedReader (new InputStreamReader(process.getInputStream()))) {
                String line = null;
                while((line = reader.readLine()) != null) {
                    System.out.println("[PROCESS] " + line);
                }
            }
            System.out.println("Process started! Info: " + process.toString());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void scalingTo(int instances) {
        System.out.format("BootScale scaling to %d instances.\n", instances);
    }

    private BootScalePluginExtension loadPluginSettings() {
        BootScalePluginExtension extension = getProject().getExtensions()
                .findByType(BootScalePluginExtension.class);
        if (extension == null) {
            extension = new BootScalePluginExtension();
        }
        return extension;
    }
}
