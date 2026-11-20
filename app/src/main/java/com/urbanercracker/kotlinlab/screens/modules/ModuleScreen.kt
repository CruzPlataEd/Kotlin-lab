package com.urbanercracker.kotlinlab.screens.modules

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.urbanercracker.kotlinlab.model.dto.ModuloDTO
import com.urbanercracker.kotlinlab.screens.modules.components.ComponentListView
import com.urbanercracker.kotlinlab.ui.theme.ColorsApp
import com.urbanercracker.kotlinlab.ui.theme.FigTree
import com.urbanercracker.kotlinlab.ui.theme.KotlinLabTheme

@Composable
fun ModuleScreen(moduleViewModel: ModuleViewModel){
    Body(
        modules = emptyList()
    )
}

@Composable
private fun Body(
    modules: List<ModuloDTO>
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorsApp.colors.fondo)
    ){
        Column(modifier = Modifier.padding(16.dp)){
            Text(
                text = "Módulos",
                fontFamily = FigTree,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 35.sp,
                color = ColorsApp.colors.titulo
            )
            ModulesCompleted(totalCount = 12, completed = 3)
            ListOfModules(modules = modules)
        }
    }
}

@Composable
private fun ModulesCompleted(totalCount: Int, completed: Int){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "$completed de $totalCount completados",
            fontFamily = FigTree,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = ColorsApp.colors.textoSecundario)

        Spacer(modifier = Modifier.weight(weight = 1f))
        Box(
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .size(14.dp)
                .clip(CircleShape)
                .background(ColorsApp.colors.completado))
        Text(
            text = "Completado",
            fontFamily = FigTree,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = ColorsApp.colors.textoSecundario)
        Box(
            modifier = Modifier
                .padding(end = 5.dp, start = 15.dp)
                .size(14.dp)
                .clip(CircleShape)
                .background(ColorsApp.colors.faltaFondo)
                .border(width = 2.dp, color = ColorsApp.colors.faltaBorde, shape = CircleShape))
        Text(
            text = "Falta",
            fontFamily = FigTree,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = ColorsApp.colors.textoSecundario)
    }
}

@Composable
fun ListOfModules(modules: List<ModuloDTO>){
    LazyColumn(
        modifier = Modifier.padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(modules) { module ->
            ComponentListView(
                isCompleted = false,
                titleModule = "Modulo ${module.numero} - ${module.nivel}",
                subtitleModule = module.nombre,
                numModule = "${module.numero}",
                progress = "Completado"
            )
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun PreviewModules(){
    KotlinLabTheme {
        Body()
    }
}*/

@Preview(name = "Light")
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewModulesTheme(){

    val mockModules = listOf(
        ModuloDTO(
            numero = 1,
            nivel = "Básico",
            nombre = "Introducción a Kotlin",
            id = "",
            duracionHoras = 0.0,
            objetivo = "",
            nombreCorto = ""
        ),
        ModuloDTO(
            numero = 2,
            nivel = "Intermedio",
            nombre = "POO",
            id = "",
            duracionHoras = 0.0,
            objetivo = "",
            nombreCorto = ""
        ),
        ModuloDTO(
            numero = 3,
            nivel = "Avanzado",
            nombre = "Corrutinas",
            id = "",
            duracionHoras = 0.0,
            objetivo = "",
            nombreCorto = ""
        )
    )

    KotlinLabTheme {
        Body(
            modules = mockModules
        )
    }
}
