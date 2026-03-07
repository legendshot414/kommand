rootProject.name = "kommand"

val prefix = rootProject.name

include("$prefix-api", "$prefix-core", "$prefix-plugin")


val dongle = "$prefix-dongle"
val dongleFile = file(dongle)
include(dongle)
file(dongle).listFiles()?.filter {
    it.isDirectory && it.name.startsWith("v")
}?.forEach { file ->
    include(":$dongle:${file.name}")
}

val publish = "$prefix-publish"
if (file(publish).exists()) include(publish)