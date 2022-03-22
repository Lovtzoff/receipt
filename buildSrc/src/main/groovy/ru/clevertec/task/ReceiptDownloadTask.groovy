package ru.clevertec.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

import java.nio.file.Files

class ReceiptDownloadTask extends DefaultTask {

    @Input
    String imageUrl =
            "https://image.shutterstock.com/image-vector/receipt-bill-realistic-template-paper-600w-2075467852.jpg"

    @OutputFile
    File receiptFile = new File("src/main/resources/receipt.jpg")

    @TaskAction
    void runTask() throws IOException {
        URL url = new URL(imageUrl)
        InputStream inputStream = url.openStream()
        Files.copy(inputStream, new File(receiptFile.getAbsolutePath()).toPath())
        println("Receipt downloaded.")
    }
}
