package com.urbanercracker.kotlinlab.screens.modules.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.urbanercracker.kotlinlab.R
import com.urbanercracker.kotlinlab.ui.theme.ColorsApp
import com.urbanercracker.kotlinlab.ui.theme.FigTree
import com.urbanercracker.kotlinlab.ui.theme.KotlinLabTheme

@Composable
fun ComponentListView(
    isCompleted: Boolean,
    numModule: String,
    titleModule: String,
    subtitleModule: String,
    progress: String
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(84.dp)
            .background(
                color = if (isCompleted) ColorsApp.colors.completadoFondo else ColorsApp.colors.faltaFondo,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = if(!isCompleted) 1.dp else 0.dp,
                color = ColorsApp.colors.faltaBorde,
                shape = RoundedCornerShape(16.dp),
            ),
        verticalAlignment = Alignment.CenterVertically
    ){
        if (isCompleted){
            Box(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(ColorsApp.colors.completado),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    painter = painterResource(R.drawable.ic_check),
                    contentDescription = "Inicio",
                    tint = ColorsApp.colors.sobreCompletado
                )
            }
        }else{
            Box(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(ColorsApp.colors.faltaIndicador),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = numModule,
                    fontFamily = FigTree,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 16.sp,
                    color = ColorsApp.colors.sobreFaltaIndicador
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(0.75f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = titleModule,
                fontFamily = FigTree,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                color = ColorsApp.colors.texto
            )
            Text(
                text = subtitleModule,
                fontFamily = FigTree,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 14.sp,
                color = ColorsApp.colors.texto,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }

        Text(
            modifier = Modifier.weight(0.25f),
            text = progress,
            fontFamily = FigTree,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 11.sp,
            color = if(isCompleted) ColorsApp.colors.completado else ColorsApp.colors.sobreFaltaIndicador
        )
    }
}

@Preview(name = "Light")
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponentListView(){
    KotlinLabTheme {
        ComponentListView(
            isCompleted = false,
            numModule = "1",
            titleModule = "Módulo 1 - Repaso",
            subtitleModule = "Introducción, entorno y primer programa",
            progress = "Completado"
        )
    }
}