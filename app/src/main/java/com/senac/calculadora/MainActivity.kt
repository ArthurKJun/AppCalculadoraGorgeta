package com.senac.calculadora

import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.senac.calculadora.components.MyTopBar
import com.senac.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Scaffold (
        topBar = {
            MyTopBar()
        }
    ) {
        Column (modifier = Modifier
            .padding(it)
            .padding(16.dp)) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){

                Text(
                    text = (stringResource(R.string.amount)),
                    textAlign = TextAlign.Right,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )

                TextField(
                    value = "",
                    onValueChange =  {},
                    modifier = Modifier.weight(3f)
                )

            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){

                Text(
                    text = ("Custom %"),
                    textAlign = TextAlign.Right,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )

                Slider(
                    value = 15f,
                    onValueChange = {},
                    valueRange = 0f..30f,
                    modifier = Modifier
                        .weight(3f)
                )
            }

            Row {

                Spacer(
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "15%",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1f)
                )

                Text(
                    text = "18%",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1f)
                )
            }

            Row {

            }
        }
    }
}