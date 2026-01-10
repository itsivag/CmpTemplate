package wizard.files.composeApp.shared.navigation

import wizard.ProjectFile
import wizard.ProjectInfo
import wizard.packagePath

class ScreensKt(info : ProjectInfo) : ProjectFile {
    override val path: String = "${info.moduleName}/src/commonMain/kotlin/${info.packagePath}/navigation/Screens.kt"
    override val content: String = """
       package ${info.packageId}.navigation
       
       sealed class Screen(val route: String) {
           data class Product(val id: String) : Screen("product")
           data object Home : Screen("product")
       }
    """.trimIndent()
}