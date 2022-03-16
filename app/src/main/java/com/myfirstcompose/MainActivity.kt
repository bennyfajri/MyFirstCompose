package com.myfirstcompose

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var panjangState by remember {
                mutableStateOf("")
            }
            var lebarState by remember {
                mutableStateOf("")
            }
            var hasilState by remember {
                mutableStateOf(0)
            }
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Persegi Panjang")
                        }
                    )
                }
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    TextField(
                        value = panjangState,
                        label = {
                            Text(text = "Panjang")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        onValueChange = {
                            panjangState = it
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    TextField(
                        value = lebarState,
                        label = {
                            Text(text = "Lebar")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        onValueChange = {
                            lebarState = it
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.padding(16.dp))
                    Button(
                        onClick = {
                            hasilState = panjangState.toInt() * lebarState.toInt()
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Hitung")
                    }
                    Spacer(modifier = Modifier.padding(16.dp))
                    Text(
                        text = hasilState.toString(), style = TextStyle(
                            fontSize = 22.sp,
                            color = Color.Black
                        )
                    )
                }
            }
        }
    }
}

