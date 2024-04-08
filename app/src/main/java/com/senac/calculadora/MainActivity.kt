package com.senac.calculadora

import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.senac.calculadora.components.LabelComponent
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
    Scaffold(
        topBar = {
            MyTopBar()
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
        ) {

            val amount = remember {
                mutableStateOf(0.0)
            }

            val custom = remember {
                mutableStateOf(15)
            }

            val tip15 = remember {
                mutableStateOf(0.0)
            }

            val totalTip15 = remember {
                mutableStateOf(0.0)
            }

            val tipCustom = remember {
                mutableStateOf(0.0)
            }

            val totalTipCustom = remember {
                mutableStateOf(0.0)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                LabelComponent(labelResource = R.string.amount)

                TextField(
                    value = amount.value.toString(),
                    onValueChange = {amount.value = it.toDouble()},
                    modifier = Modifier.weight(3f)
                )

            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                LabelComponent(labelResource = R.string.custom)

                Slider(
                    value = custom.value.toFloat(),
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
                        .weight(1.5f)
                )

                Text(
                    text = "${custom.value}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1.5f)
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
            ) {

                LabelComponent(labelResource = R.string.tips)

                Text(
                    text = "R$ ${tip15.value}",
                    modifier = Modifier
                        .weight(1.5f)
                        .background(color = Color.LightGray),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "R$ ${tipCustom.value}",
                    modifier = Modifier
                        .weight(1.5f)
                        .background(color = Color.LightGray),
                    textAlign = TextAlign.Center
                )

            }

            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
            ) {

                LabelComponent(labelResource = R.string.total)

                Text(
                    text = "R$ ${totalTip15.value}",
                    modifier = Modifier
                        .weight(1.5f)
                        .background(color = Color.LightGray),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "R$ ${totalTipCustom.value}",
                    modifier = Modifier
                        .weight(1.5f)
                        .background(color = Color.LightGray),
                    textAlign = TextAlign.Center
                )

            }
        }
    }
}