> Under active development, not ready for use!

# Boot Scale Plugin for Gradle

Spring Boot horizontal scaling plugin meant to address the issue
of testing or using multiple instances of a Spring Boot application.

# Installing to local repo

```
./gradlew clean build install
```

This will install to `~/.m2/repository/com/dmitriydubson/boot/scale` directory.

# Usage

Add the following to your `build.gradle` file:

```
buildscript {
    repositories {
        mavenLocal()
    }
    dependencies {
        classpath 'com.dmitriydubson.boot.scale:boot-scale-plugin:0.1'
    }
}

apply plugin: 'com.dmitriydubson.boot.scale'

bootScaleSettings {
	numberOfInstances = 1
}
```

## Available Tasks

`bootScaleTask` -- describes number of instances to scale Boot to.