package ru.vood.ksp.doccheck

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSFile
import com.google.devtools.ksp.symbol.KSNode
import ru.vood.ksp.doccheck.properties.FilterName

class CheckFun(
    private val filterName: FilterName,
    private val ruleName: String,
    private val checkFun: (KSFile) -> List<KSNode>
) {

    fun checkRun(ksFile: KSFile, kSPLogger: KSPLogger) {
        checkFun(ksFile)
            .forEach { ksNode ->
                kSPLogger.error("Java doc needed by filter ${filterName.value} and rule $ruleName", ksNode)
            }
    }
}
