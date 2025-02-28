package com.example.pam_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pam_2.ui.theme.PAM_2Theme
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.example.pam_2.ui.theme.Pink10
import com.example.pam_2.ui.theme.Purple40
import com.example.pam_2.ui.theme.PurpleGrey40
import com.example.pam_2.ui.theme.White10

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Chama o projeto
        setContent {
            PAM_2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                        ProdutoItem()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProdutoItem() {

    Column(
        Modifier
            .height(250.dp)
            .width(200.dp)
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Pink10, Purple40
                        )
                    )
                )
                .fillMaxWidth()
        )

        {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Descrição da imagem",
                modifier = Modifier
                    .offset(y = (50).dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.BottomCenter)
            )
        }
        Spacer(modifier = Modifier.height(50.dp))

        // Dessa forma o modifier.padding servirá para todos os componentes dentro da coluna
        Column (Modifier.padding(16.dp))
        {
            Text(
                text = LoremIpsum(50).values.first(),
                fontSize = 14.sp, fontWeight = FontWeight(700),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Text (
                text = "Texto 2",
                Modifier.padding(top=8.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}