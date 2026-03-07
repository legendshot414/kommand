rootProject.name = "kommand"

val prefix = rootProject.name

include("$prefix-api", "$prefix-core")


val dongle = "$prefix-dongle"
val dongleFile = file(dongle)
include(dongle)
file(dongle).listFiles()?.filter {
    it.isDirectory && it.name.startsWith("v")
}?.forEach { file ->
    include(":$dongle:${file.name}")
}

include("$prefix-plugin")
//include("$prefix-publish")