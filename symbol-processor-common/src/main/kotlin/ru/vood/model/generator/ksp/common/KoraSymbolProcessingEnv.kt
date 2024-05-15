package ru.vood.model.generator.ksp.common

import com.google.devtools.ksp.processing.KSPLogger

object KoraSymbolProcessingEnv {
    private val loggerLocal = ThreadLocal<KSPLogger>()

    var logger: KSPLogger
        get() = loggerLocal.get()
        set(value) {
            loggerLocal.set(value)
        }

    fun resetLogger() {
        loggerLocal.set(null)
    }
}
