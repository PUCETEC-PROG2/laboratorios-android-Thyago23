package ec.edu.puce.githubclient.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun RepoIt(
    name: String,
    description: String,
    avatarImg: String,
    language: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
        ) {
            AsyncImage(
                model = avatarImg,
                contentDescription = "Imagen de $name",
                modifier = Modifier.size(size = 60.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(width = 16.dp))
            Column {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(height = 4.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3
                )
                Spacer(modifier = Modifier.height(height = 4.dp))
                Text(
                    text = language,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepoItPreview() {
    RepoIt(
        name = "Repositorio de Santiago",
        description = "Proyecto de Desarrollo Movil",
        avatarImg = "https://www.google.com/url?sa=t&source=web&rct=j&url=https%3A%2F%2Funiversidadeuropea.com%2Fblog%2Fmecanico-formula-1%2F&ved=0CBYQjRxqFwoTCJj9mPzVtJQDFQAAAAAdAAAAABAf&opi=89978449",
        language = "React"
    )
}