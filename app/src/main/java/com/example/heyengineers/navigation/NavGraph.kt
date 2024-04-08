package com.example.heyengineers.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.heyengineers.admin.screens.AdminDashboard
import com.example.heyengineers.screens.AboutUs
import com.example.heyengineers.screens.Bottomnav
import com.example.heyengineers.screens.Faculty
import com.example.heyengineers.screens.Gallery
import com.example.heyengineers.screens.Home


@Composable
fun NavGraph(navController:NavHostController) {

    val isAdmin = true
  NavHost(
          navController = navController,
          startDestination = if (isAdmin) Routes.AdminDashboard.route else Routes.BottomNav.route
      ){

      composable(Routes.BottomNav.route){
          Bottomnav(navController)
      }
      composable(Routes.Home.route){
          Home()
      }
      composable(Routes.AboutUs.route){
          AboutUs()
      }
      composable(Routes.Faculty.route){
          Faculty()
      }
      composable(Routes.Gallery.route){
          Gallery()
      }
      composable(Routes.AdminDashboard.route){
          AdminDashboard(navController)
      }


       }

}