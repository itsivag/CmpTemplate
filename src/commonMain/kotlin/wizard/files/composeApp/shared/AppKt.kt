package wizard.files.composeApp.shared

import wizard.*

class AppKt(info: ProjectInfo) : ProjectFile {
    override val path = "${info.moduleName}/src/commonMain/kotlin/${info.packagePath}/App.kt"
    override val content = """
      package ${info.packageId}
        
      import androidx.compose.runtime.Composable
      import androidx.compose.runtime.mutableStateListOf
      import androidx.compose.runtime.remember
      import androidx.compose.ui.tooling.preview.Preview
      import org.company.app.navigation.NavHost
      import org.company.app.navigation.Screen
      import org.company.app.theme.AppTheme


      @Preview
      @Composable
      fun App(
          onThemeChanged: @Composable (isDark: Boolean) -> Unit = {}
      ) = AppTheme(onThemeChanged) {
          val backStack = remember { mutableStateListOf<Any>(Screen.Home) }
          NavHost(backStack)
      }

    """.trimIndent()
}
