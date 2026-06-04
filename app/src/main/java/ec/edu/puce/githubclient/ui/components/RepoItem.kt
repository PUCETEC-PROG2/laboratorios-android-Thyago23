package ec.edu.puce.githubclient.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ec.edu.puce.githubclient.models.GithubUser
import ec.edu.puce.githubclient.models.Repository

@Composable
fun RepoIt(
    repository: Repository,
    onEdit: (Repository) -> Unit = {},
    onDelete: (Repository) -> Unit = {}
) {
    var showDeleteDialog by remember { mutableStateOf(false) }

    if (showDeleteDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },
            title = { Text("Eliminar Repositorio") },
            text = { Text("¿Estás seguro de que deseas eliminar el repositorio '${repository.name}'? Esta acción no se puede deshacer.") },
            confirmButton = {
                TextButton(
                    onClick = {
                        onDelete(repository)
                        showDeleteDialog = false
                    }
                ) {
                    Text("Eliminar", color = Color(0xFFEF5350))
                }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(70.dp)
            ) {
                AsyncImage(
                    model = repository.owner.avatarUrl,
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Editar",
                        tint = Color(0xFF42A5F5),
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { onEdit(repository) }
                    )
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Eliminar",
                        tint = Color(0xFFEF5350),
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { showDeleteDialog = true }
                    )
                }
            }

            Spacer(modifier = Modifier.width(20.dp))

            Column(modifier = Modifier.weight(1f)) {
                RepoDetailRow(label = "Nombre del repositorio", value = repository.name)
                Spacer(modifier = Modifier.height(12.dp))
                RepoDetailRow(label = "Descripción del repositorio", value = repository.description ?: "Sin descripción")
                Spacer(modifier = Modifier.height(12.dp))
                RepoDetailRow(label = "Lenguaje", value = repository.language ?: "No especificado")
            }
        }
    }
}

@Composable
fun RepoDetailRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            modifier = Modifier.weight(0.45f),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                lineHeight = 16.sp
            ),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = value,
            modifier = Modifier.weight(0.55f),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 13.sp,
                lineHeight = 16.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepoItPreview() {
    val repository = Repository(
        id = "1",
        name = "ejemplo-repo",
        description = "Descripción del repo",
        language = "Kotlin",
        owner = GithubUser(
            id = "1",
            login = "user",
            avatarUrl = ""
        )
    )
    RepoIt(repository)
}
