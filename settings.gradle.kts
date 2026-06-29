pluginManagement {
  repositories {
    gradlePluginPortal()
    maven("https://files.minecraftforge.net/maven")
    maven("https://maven.aliyun.com/repository/central")
    maven("https://repo1.maven.org/maven2")
  }

  resolutionStrategy {
    eachPlugin {
      if ("net.minecraftforge.gradle" == requested.id.id) {
        useModule("net.minecraftforge.gradle:ForgeGradle:${requested.version}")
      }
    }
  }
}

rootProject.name = "IKnowWhatImDoing"
