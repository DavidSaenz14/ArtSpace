package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}
@Composable
fun ArtSpaceApp(modifier:Modifier= Modifier) {
    var result by remember { mutableStateOf(1) }
    var imageResource = when (result) {
        1 -> R.drawable.imagen1
        2 -> R.drawable.imagen2
        3 -> R.drawable.imagen3
        4 -> R.drawable.imagen4
        5 -> R.drawable.imagen5
        else -> R.drawable.imagen6

    }
    Column(
        modifier= Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = imageResource),
            modifier= Modifier
                .fillMaxWidth()
                .height(400.dp),
            contentScale = ContentScale.Crop,
            contentDescription = "1"

        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = stringResource(R.string.esta_es_mi_galeria_de_arte))

        Row(verticalAlignment = Alignment.CenterVertically) {

            Button(onClick = { result -=1
            if(result==0){
                result=6
            }}) {
                Text(text = stringResource(R.string.anterior))
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { result += 1
            if(result==7){
                result=1
            }}) {
                Text(text = stringResource(R.string.siguiente))
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ArtSpace() {
    ArtSpaceTheme() {
        ArtSpaceApp()
    }
}