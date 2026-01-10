package wizard.files.composeApp.shared.navigation

import wizard.ProjectFile
import wizard.ProjectInfo
import wizard.packagePath

class NavigationKt(info: ProjectInfo) : ProjectFile {
    override val path: String = "${info.moduleName}/src/commonMain/kotlin/${info.packagePath}/navigation/Navigation.kt"
    override val content: String = """
        package ${info.packageId}.navigation
                
        import androidx.compose.foundation.layout.Arrangement
        import androidx.compose.foundation.layout.Column
        import androidx.compose.foundation.layout.fillMaxSize
        import androidx.compose.foundation.layout.padding
        import androidx.compose.material3.Button
        import androidx.compose.material3.Text
        import androidx.compose.runtime.Composable
        import androidx.compose.runtime.snapshots.SnapshotStateList
        import androidx.compose.ui.Alignment
        import androidx.compose.ui.Modifier
        import androidx.compose.ui.unit.dp
        import androidx.navigation3.runtime.NavEntry
        import androidx.navigation3.ui.NavDisplay

        @Composable
        fun NavHost(backStack: SnapshotStateList<Any>) {
            NavDisplay(
                backStack = backStack,
                onBack = { backStack.removeLastOrNull() },
                entryProvider = { key ->
                    when (key) {
                        is Screen.Home -> NavEntry(key) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("Home")
                                Button(
                                    modifier = Modifier.padding(16.dp),
                                    onClick = {
                                        backStack.add(Screen.Product("abc123"))
                                    },
                                    content = {
                                        Text("navigate to product")
                                    }
                                )
                            }
                        }

                        is Screen.Product -> NavEntry(key) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("product" + key.id)
                            }
                        }

                        else -> NavEntry(Unit) { Text("Unknown route") }
                    }
                }
            )
        }
        
    """.trimIndent()
}