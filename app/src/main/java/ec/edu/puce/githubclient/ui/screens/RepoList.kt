package ec.edu.puce.githubclient.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ec.edu.puce.githubclient.ui.components.RepoIt

@Composable
fun RepoList() {
    Column(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 48.dp)

    ) {
        RepoIt(
            name = "Repositorio Gitlab",
            description = "Proyecto de Gitlab de Santiago",
            avatarImg = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1H68VNPY1-511LG3ez_wktw6pwfkBelusYQ&s",
            language = "Github"
        )
        RepoIt(
            name = "Repositorio Proyecto Integrador",
            description = "Proyecto Integrador Final",
            avatarImg = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1H68VNPY1-511LG3ez_wktw6pwfkBelusYQ&s",
            language = "TypeScript"
        )
        RepoIt(
            name = "Repositorio Proof of Repair",
            description = "Proyecto Dev Challenge",
            avatarImg = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1H68VNPY1-511LG3ez_wktw6pwfkBelusYQ&s",
            language = "React"
        )
        RepoIt(
            name = "Repositorio DevChallenge Top1",
            description = "Proyecto Integrador de DevChallenge",
            avatarImg = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1H68VNPY1-511LG3ez_wktw6pwfkBelusYQ&s",
            language = "Django"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepoLsPreview() {
    RepoList()
}