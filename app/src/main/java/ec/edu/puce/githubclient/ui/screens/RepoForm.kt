package ec.edu.puce.githubclient.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ec.edu.puce.githubclient.models.Repository
import ec.edu.puce.githubclient.ui.theme.GithubClientTheme
import ec.edu.puce.githubclient.viewmodels.RepoFormViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepoForm(
    repository: Repository? = null,
    onBackClick: () -> Unit = {},
    viewModel: RepoFormViewModel = viewModel()
) {
    var name by remember { mutableStateOf(repository?.name ?: "") }
    var description by remember { mutableStateOf(repository?.description ?: "") }

    val isLoading by viewModel.isLoading.collectAsState()
    val isSuccess by viewModel.isSuccess.collectAsState()
    val errorMsg by viewModel.errorMsg.collectAsState()

    LaunchedEffect(isSuccess) {
        if (isSuccess) {
            onBackClick()
            viewModel.resetStatus()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(if (repository == null) "Nuevo Repositorio de GITHUB" else "Editar Repositorio") 
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(space = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                if (errorMsg != null) {
                    Text(text = errorMsg!!, color = MaterialTheme.colorScheme.error)
                }

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nombre del repositorio") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    enabled = repository == null && !isLoading
                )
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Descripción del repositorio") },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 5,
                    enabled = !isLoading
                )

                if (isLoading) {
                    CircularProgressIndicator()
                } else {
                    Button(
                        onClick = { 
                            viewModel.saveRepo(
                                name = name, 
                                description = description, 
                                owner = repository?.owner?.login,
                                isEdit = repository != null
                            ) 
                        },
                        enabled = name.isNotBlank(),
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = Color.White
                        )
                    ){
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Guardar",
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Guardar")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepoFormPreview() {
    GithubClientTheme {
        RepoForm()
    }
}
