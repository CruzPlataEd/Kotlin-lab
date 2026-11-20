package com.urbanercracker.kotlinlab.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.urbanercracker.kotlinlab.R

val FigTree = FontFamily(
    Font(R.font.figtree_regular, FontWeight.Normal),
    Font(R.font.figtree_medium, FontWeight.Medium),
    Font(R.font.figtree_bold, FontWeight.Bold),
    Font(R.font.figtree_semi_bold, FontWeight.SemiBold),
    Font(R.font.figtree_extra_bold, FontWeight.ExtraBold),
    Font(R.font.figtree_black, FontWeight.Black)
)

val Mono = FontFamily(
    Font(R.font.jet_regular, FontWeight.Normal),
    Font(R.font.jet_medium, FontWeight.Medium),
    Font(R.font.jet_semi_bold, FontWeight.SemiBold),
    Font(R.font.jet_bold, FontWeight.Bold),
    Font(R.font.jet_extra_bold, FontWeight.ExtraBold)
)