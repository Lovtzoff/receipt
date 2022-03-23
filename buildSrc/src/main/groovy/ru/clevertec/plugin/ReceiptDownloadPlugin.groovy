package ru.clevertec.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.clevertec.task.ReceiptDownloadTask

class ReceiptDownloadPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.getTasks().create('receiptDownload', ReceiptDownloadTask) {
            imageUrl = "https://image.shutterstock.com" +
                    "/image-vector" +
                    "/receipt-bill-realistic-template-paper-600w-2075467852.jpg"
            receiptFile = new File("src/main/resources/receipt.jpg")
        }
    }
}
