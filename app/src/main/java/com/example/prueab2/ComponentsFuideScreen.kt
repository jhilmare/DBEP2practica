package com.example.prueab2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentsGuideScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Guía de Componentes") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar"
                )
            }
        },
        bottomBar = {
            BottomAppBar {
                Text(
                    text = "Práctica de Laboratorio N° 5",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item { TextComponentGuide() }
            item { TextFieldComponentGuide() }
            item { OutlinedTextFieldComponentGuide() }
            item { ButtonComponentGuide() }
            item { OutlinedButtonComponentGuide() }
            item { TextButtonComponentGuide() }
            item { IconComponentGuide() }
            item { ProgressBarComponentGuide() }
            item { SwitchComponentGuide() }
            item { CheckBoxComponentGuide() }
            item { CardComponentGuide() }
            item { SurfaceComponentGuide() }
            item { BadgeBoxComponentGuide() }
            item { DividerComponentGuide() }
            item { DropdownMenuComponentGuide() }
            item { SliderComponentGuide() }
            item { AlertDialogComponentGuide() }
            item { ImageComponentGuide() }
            item { AdvancedProgressBarComponentGuide() }
            item { CheckBoxWithTextComponentGuide() }
            item { ScaffoldComponentGuide() }
            item { TopAppBarComponentGuide() }
            item { SnackBarComponentGuide() }
            item { BottomBarComponentGuide() }
            item { FloatingActionButtonComponentGuide() }
            item { ModalDrawerComponentGuide() }
        }
    }
}

@Composable
fun GuideCard(
    title: String,
    description: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
            content()
        }
    }
}

@Composable
fun TextComponentGuide() {
    GuideCard(
        title = "Text",
        description = "Sirve para mostrar texto en pantalla."
    ) {
        Text("Hola, esto es un componente Text.")
    }
}

@Composable
fun TextFieldComponentGuide() {
    var text by remember { mutableStateOf("") }

    GuideCard(
        title = "TextField",
        description = "Permite ingresar texto desde el teclado."
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Ingrese su nombre") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun OutlinedTextFieldComponentGuide() {
    var email by remember { mutableStateOf("") }

    GuideCard(
        title = "OutlinedTextField",
        description = "Es un campo de texto con borde."
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo electrónico") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ButtonComponentGuide() {
    GuideCard(
        title = "Button",
        description = "Botón principal para ejecutar una acción."
    ) {
        Button(onClick = {}) {
            Text("Aceptar")
        }
    }
}

@Composable
fun OutlinedButtonComponentGuide() {
    GuideCard(
        title = "OutlinedButton",
        description = "Botón con borde usado para acciones secundarias."
    ) {
        OutlinedButton(onClick = {}) {
            Text("Cancelar")
        }
    }
}

@Composable
fun TextButtonComponentGuide() {
    GuideCard(
        title = "TextButton",
        description = "Botón sin borde ni fondo, usado para acciones menos importantes."
    ) {
        TextButton(onClick = {}) {
            Text("Aprender más")
        }
    }
}

@Composable
fun IconComponentGuide() {
    GuideCard(
        title = "Icon",
        description = "Sirve para mostrar íconos dentro de la interfaz."
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Inicio"
            )
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorito"
            )
        }
    }
}

@Composable
fun ProgressBarComponentGuide() {
    GuideCard(
        title = "ProgressBar",
        description = "Indica que una tarea está cargando o avanzando."
    ) {
        LinearProgressIndicator(
            progress = { 0.6f },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        CircularProgressIndicator()
    }
}

@Composable
fun SwitchComponentGuide() {
    var checked by remember { mutableStateOf(false) }

    GuideCard(
        title = "Switch",
        description = "Permite activar o desactivar una opción."
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Modo oscuro")
            Spacer(modifier = Modifier.width(12.dp))
            Switch(
                checked = checked,
                onCheckedChange = { checked = it }
            )
        }
    }
}

@Composable
fun CheckBoxComponentGuide() {
    var checked by remember { mutableStateOf(false) }

    GuideCard(
        title = "CheckBox",
        description = "Permite marcar o desmarcar una opción."
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )
            Text("Acepto los términos y condiciones")
        }
    }
}

@Composable
fun CardComponentGuide() {
    GuideCard(
        title = "Card",
        description = "Sirve para agrupar información dentro de una tarjeta."
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Text(
                text = "Contenido dentro de una Card",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun SurfaceComponentGuide() {
    GuideCard(
        title = "Surface",
        description = "Componente base que proporciona una superficie con elevación y color de fondo."
    ) {
        Surface(
            modifier = Modifier.size(120.dp, 60.dp),
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.secondaryContainer,
            shadowElevation = 4.dp
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text("Surface")
            }
        }
    }
}

@Composable
fun BadgeBoxComponentGuide() {
    var notificationCount by remember { mutableIntStateOf(3) }

    GuideCard(
        title = "BadgedBox",
        description = "Muestra una insignia interactiva para notificaciones."
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BadgedBox(
                badge = {
                    if (notificationCount > 0) {
                        Badge {
                            Text(notificationCount.toString())
                        }
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "$notificationCount notificaciones"
                )
            }

            Button(onClick = { notificationCount++ }) {
                Text("Añadir")
            }

            TextButton(onClick = { notificationCount = 0 }) {
                Text("Limpiar")
            }
        }
    }
}

@Composable
fun DividerComponentGuide() {
    GuideCard(
        title = "Divider",
        description = "Sirve para separar visualmente contenido."
    ) {
        Text("Elemento superior")
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text("Elemento inferior")
    }
}

@Composable
fun DropdownMenuComponentGuide() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Seleccione una opción") }

    GuideCard(
        title = "DropdownMenu",
        description = "Muestra una lista desplegable de opciones."
    ) {
        Box {
            Button(onClick = { expanded = true }) {
                Text(selectedOption)
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Opción 1") },
                    onClick = {
                        selectedOption = "Opción 1"
                        expanded = false
                    }
                )

                DropdownMenuItem(
                    text = { Text("Opción 2") },
                    onClick = {
                        selectedOption = "Opción 2"
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun SliderComponentGuide() {
    var value by remember { mutableFloatStateOf(0.5f) }

    GuideCard(
        title = "Slider",
        description = "Permite seleccionar un valor deslizando una barra."
    ) {
        Text("Valor: ${(value * 100).toInt()}")
        Slider(
            value = value,
            onValueChange = { value = it }
        )
    }
}

@Composable
fun AlertDialogComponentGuide() {
    var showDialog by remember { mutableStateOf(false) }

    GuideCard(
        title = "AlertDialog",
        description = "Muestra una ventana emergente para confirmar o informar algo."
    ) {
        Button(onClick = { showDialog = true }) {
            Text("Mostrar diálogo")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Confirmación") },
                text = { Text("Este es un mensaje dentro de un AlertDialog.") },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Aceptar")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }
    }
}

@Composable
fun ImageComponentGuide() {
    GuideCard(
        title = "Image",
        description = "El componente Image permite mostrar imágenes dentro de la interfaz."
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Imagen de ejemplo",
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun AdvancedProgressBarComponentGuide() {
    var progress by remember { mutableFloatStateOf(0.3f) }

    GuideCard(
        title = "ProgressBar avanzado",
        description = "Permite mostrar el avance de una tarea usando un valor dinámico."
    ) {
        Text(
            text = "Progreso actual: ${(progress * 100).toInt()} %"
        )

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    progress += 0.1f
                    if (progress > 1f) {
                        progress = 1f
                    }
                }
            ) {
                Text("Aumentar")
            }

            OutlinedButton(
                onClick = {
                    progress = 0f
                }
            ) {
                Text("Reiniciar")
            }
        }
    }
}

@Composable
fun CheckBoxWithTextComponentGuide() {
    var checked by remember { mutableStateOf(false) }

    GuideCard(
        title = "CheckBox con texto",
        description = "Combina un CheckBox con un texto descriptivo para representar una opción seleccionable."
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = {
                    checked = it
                }
            )

            Text(
                text = if (checked) {
                    "Opción seleccionada"
                } else {
                    "Opción no seleccionada"
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldComponentGuide() {
    GuideCard(
        title = "Scaffold",
        description = "Scaffold proporciona una estructura básica para una pantalla con TopAppBar, BottomBar, FloatingActionButton y contenido."
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            shape = RoundedCornerShape(12.dp),
            tonalElevation = 4.dp
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text("TopAppBar")
                        }
                    )
                },
                bottomBar = {
                    BottomAppBar {
                        Text(
                            text = "BottomBar",
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Agregar"
                        )
                    }
                }
            ) { paddingValues ->
                Box(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Contenido del Scaffold")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponentGuide() {
    GuideCard(
        title = "TopAppBar",
        description = "TopAppBar muestra una barra superior con título, botón de navegación y acciones."
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            tonalElevation = 4.dp,
            shape = RoundedCornerShape(12.dp)
        ) {
            TopAppBar(
                title = {
                    Text("Mi aplicación")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menú"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Configuración"
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun SnackBarComponentGuide() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    GuideCard(
        title = "SnackBar",
        description = "SnackBar muestra mensajes breves para informar al usuario sobre una acción."
    ) {
        Button(
            onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = "Este es un mensaje SnackBar",
                        actionLabel = "Aceptar"
                    )
                }
            }
        ) {
            Text("Mostrar SnackBar")
        }

        SnackbarHost(
            hostState = snackbarHostState
        )
    }
}

@Composable
fun BottomBarComponentGuide() {
    GuideCard(
        title = "BottomBar",
        description = "BottomBar representa una barra inferior usada para navegación o información dentro de una pantalla."
    ) {
        BottomAppBar(
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Inicio"
                )
            }

            Text(
                text = "Inicio",
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun FloatingActionButtonComponentGuide() {
    GuideCard(
        title = "FloatingActionButton",
        description = "Es un botón flotante usado para representar la acción principal de una pantalla."
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            FloatingActionButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar"
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalDrawerComponentGuide() {
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    val scope = rememberCoroutineScope()

    GuideCard(
        title = "ModalDrawer",
        description = "ModalDrawer muestra un menú lateral deslizable con opciones de navegación."
    ) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    Text(
                        text = "Menú principal",
                        modifier = Modifier.padding(16.dp)
                    )

                    NavigationDrawerItem(
                        label = {
                            Text("Inicio")
                        },
                        selected = false,
                        onClick = {}
                    )

                    NavigationDrawerItem(
                        label = {
                            Text("Perfil")
                        },
                        selected = false,
                        onClick = {}
                    )

                    NavigationDrawerItem(
                        label = {
                            Text("Configuración")
                        },
                        selected = false,
                        onClick = {}
                    )
                }
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                ) {
                    Text("Abrir menú lateral")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComponentsGuideScreenPreview() {
    MaterialTheme {
        ComponentsGuideScreen()
    }
}
