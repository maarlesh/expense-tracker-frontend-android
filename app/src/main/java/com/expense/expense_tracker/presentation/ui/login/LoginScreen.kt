package com.example.expense_tracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.expense.expense_tracker.domain.usecase.LoginUserUseCase
import com.expense.expense_tracker.presentation.ui.LoginButton
import com.expense.expense_tracker.presentation.ui.login.LoginViewModel
import com.expense.expense_tracker.presentation.ui.login.LoginViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    loginUserUseCase: LoginUserUseCase,
    onLoginClick: (String, String) -> Unit = { _, _ -> }
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val viewModel: LoginViewModel = viewModel(
        factory = LoginViewModelFactory(loginUserUseCase)
    )

    val isLoggedIn by viewModel.isLoggedIn.collectAsState()


    LaunchedEffect(isLoggedIn) {
        if (isLoggedIn) {
            navController.navigate("home")
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Expense Tracker", style = MaterialTheme.typography.titleLarge) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "Username")
                    },
                    singleLine = true,
                    textStyle = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = "Username")
                    },
                    singleLine = true,
                    textStyle = MaterialTheme.typography.titleSmall,
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                LoginButton(
                    onClick = {
                        viewModel.login(username, password)
                    },
                    modifier = Modifier.fillMaxWidth()
                );
            }
        }
    )
}
