package com.example.loginformthemes

import android.os.Bundle
import androidx.compose.runtime.remember
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginformthemes.ui.theme.LoginformThemesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginformThemesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginformThemes()
                }
            }
        }
    }
}

@Composable
fun LoginformThemes() {
    var username: String by remember { mutableStateOf("")}
    var password: String by remember { mutableStateOf("")}

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Title",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp,bottom = 16.dp),
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username")},
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "Username Icon")
            }
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it},
            label = { Text("Password")},
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Lock, contentDescription = "Password Icon")
            }
        )

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text(text = "Submit")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginformThemesTheme {
        LoginformThemes()
    }
}