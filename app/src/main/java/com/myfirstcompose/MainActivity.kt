package com.myfirstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContent {
            val scaffoldState = rememberScaffoldState()
             val scope = rememberCoroutineScope()
           Scaffold(scaffoldState = scaffoldState) {
               var counter by remember {
                   mutableStateOf(0)
               }
               if(counter % 5 == 0 && counter > 0) {
                   LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
                       scaffoldState.snackbarHostState.showSnackbar("Hello")
                   }
               }
               Button(onClick = { counter++ }) {
                   Text(text = "Click me: $counter")
               }
           }
        }
    }

}

//var i = 0
//
//@Composable
//fun myComposable(backPressedDispatcher: OnBackPressedDispatcher) {
//
//    val callback = remember {
//        object : OnBackPressedCallback(true) {
//            override fun handleOnBackPressed() {
//                // Do something
//            }
//        }
//    }
//
//    DisposableEffect(key1 = backPressedDispatcher) {
//        backPressedDispatcher.addCallback(callback)
//        onDispose {
//            callback.remove()
//        }
//    }
//    Button(onClick = { /*TODO*/ }) {
//        Text(text = "Click me")
//    }
//}
