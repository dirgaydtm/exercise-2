package com.example.pam3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pam3.ui.theme.Pam3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pam3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    // Identitas mahasiswa (NIM dan Nama)
    val nim = "245150400111034"
    val nama = "Dirga Yuditama"

    NavHost(
        navController = navController,
        startDestination = "screen1",
        modifier = modifier
    ) {
        composable("screen1") {
            Screen1(
                nim = nim,
                nama = nama,
                onNavigateToScreen2 = {
                    navController.navigate("screen2")
                }
            )
        }
        composable("screen2") {
            Screen2(
                nim = nim,
                nama = nama,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun Screen1(
    nim: String,
    nama: String,
    onNavigateToScreen2: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "NIM: $nim", fontSize = 16.sp, fontWeight = FontWeight.Medium)
        Text(text = "Nama: $nama", fontSize = 16.sp, fontWeight = FontWeight.Medium)

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Screen 1", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onNavigateToScreen2) {
            Text(text = "Ke Halaman 2")
        }
    }
}

@Composable
fun Screen2(
    nim: String,
    nama: String,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "NIM: $nim", fontSize = 16.sp, fontWeight = FontWeight.Medium)
        Text(text = "Nama: $nama", fontSize = 16.sp, fontWeight = FontWeight.Medium)

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Screen 2", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onBack) {
            Text(text = "Kembali ke Screen 1")
        }
    }
}
