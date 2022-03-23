package ru.clevertec.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

import java.nio.file.Files

class ReceiptDownloadTask extends DefaultTask {

    @Input
    String imageUrl

    @OutputFile
    File receiptFile

    @TaskAction
    void runTask() throws IOException {
        URL url = new URL(imageUrl)
        InputStream inputStream = url.openStream()
        Files.copy(inputStream, new File(receiptFile.getAbsolutePath()).toPath())
        println("Receipt downloaded.")
    }
}
