package ec.edu.puce.githubclient.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ec.edu.puce.githubclient.ui.components.RepoIt

@Composable
fun RepoLs() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        RepoIt(
            name = "Repositorio Gitlab",
            description = "Proyecto de Gitlab de Santiago",
            avatarImg = "https://www.google.com/url?sa=t&source=web&rct=j&url=https%3A%2F%2Funiversidadeuropea.com%2Fblog%2Fmecanico-formula-1%2F&ved=0CBYQjRxqFwoTCJj9mPzVtJQDFQAAAAAdAAAAABAf&opi=89978449",
            language = "Github"
        )
        RepoIt(
            name = "Repositorio Proyecto Integrador",
            description = "Proyecto Integrador Final",
            avatarImg = "https://www.google.com/url?sa=t&source=web&rct=j&url=https%3A%2F%2Funiversidadeuropea.com%2Fblog%2Fmecanico-formula-1%2F&ved=0CBYQjRxqFwoTCJj9mPzVtJQDFQAAAAAdAAAAABAf&opi=89978449",
            language = "TypeScript"
        )
        RepoIt(
            name = "Repositorio Ecoguide",
            description = "Proyecto Dev Challenge",
            avatarImg = "https://www.google.com/url?sa=t&source=web&rct=j&url=https%3A%2F%2Funiversidadeuropea.com%2Fblog%2Fmecanico-formula-1%2F&ved=0CBYQjRxqFwoTCJj9mPzVtJQDFQAAAAAdAAAAABAf&opi=89978449",
            language = "React"
        )
        RepoIt(
            name = "Repositorio AuraSong",
            description = "Proyecto Integrador de DevChallenge",
            avatarImg = "https://www.wearetriple.com/media/5v0o4wuh/max-verstappen-lion.jpg?width=1240&v=1d6f3436c839750",
            language = "Django"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepoLsPreview() {
    RepoLs()
}