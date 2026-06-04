package ec.edu.puce.githubclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ec.edu.puce.githubclient.models.Repository
import ec.edu.puce.githubclient.ui.screens.RepoForm
import ec.edu.puce.githubclient.ui.screens.RepoLs
import ec.edu.puce.githubclient.ui.theme.GithubClientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var currentScreen by remember { mutableStateOf("repolist") }
            var selectedRepo by remember { mutableStateOf<Repository?>(null) }

            GithubClientTheme {
                when (currentScreen) {
                    "repolist" -> RepoLs(
                        onNavigateToForm = { repo ->
                            selectedRepo = repo
                            currentScreen = "repoForm"
                        }
                    )
                    "repoForm" -> RepoForm(
                        repository = selectedRepo,
                        onBackClick = {
                            selectedRepo = null
                            currentScreen = "repolist"
                        }
                    )
                }
            }
        }
    }
}
