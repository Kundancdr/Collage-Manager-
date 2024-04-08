package com.example.heyengineers.navigation

 sealed class Routes (val route:String){

     object Home:Routes("Home")

     object Faculty:Routes("faculty")

     object Gallery:Routes("gallery")

     object AboutUs:Routes("about_us")

     object BottomNav:Routes("bottom_nav")

     object AdminDashboard:Routes("admin_dashboard")
}