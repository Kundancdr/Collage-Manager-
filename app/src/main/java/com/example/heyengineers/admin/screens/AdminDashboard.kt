package com.example.heyengineers.admin.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.heyengineers.ui.theme.Title_size


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminDashboard(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Admin Dashboard")
            },
                colors = TopAppBarDefaults.largeTopAppBarColors()
                )
        },
        content = {padding ->
            Column( modifier = Modifier.padding(padding)) {
                Card (modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {

                    }){
                    Text(text = "Manage banner",
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp

                        )
                }
            }
        }
    )
}



@Preview(showSystemUi = true)
@Composable
fun AdminDashboardPreview() {
    AdminDashboard(navController = rememberNavController())

}