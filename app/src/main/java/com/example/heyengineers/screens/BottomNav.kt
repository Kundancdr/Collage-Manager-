package com.example.heyengineers.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.heyengineers.R
import com.example.heyengineers.models.BottomNavItem
import com.example.heyengineers.models.NavItem
import com.example.heyengineers.navigation.Routes
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bottomnav( navHostController: NavHostController) {

     val navHostController1 = rememberNavController()

    val context = LocalContext.current

    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val selectdItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    val list = listOf(
        NavItem(
            "Website",
            R.drawable.website
        ),
        NavItem(
            "Notice",
            R.drawable.notice
        ),
        NavItem(
            "Notes",
            R.drawable.notes
        ),
        NavItem(
            "Contact us",
            R.drawable.contact
        )
    )


    ModalNavigationDrawer(drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Image(painter = painterResource(id = R.drawable.kundan) , contentDescription =null,
                    modifier = Modifier.height(250.dp),
                    contentScale = ContentScale.Crop)
                Divider()
                Text(text = "")

                list.forEachIndexed{index, items->
                    NavigationDrawerItem(label = {
                                                 Text(text = items.title)
                    }, selected = index == selectdItemIndex , onClick = {
                        Toast.makeText(context,items.title,Toast.LENGTH_SHORT).show()

                        scope.launch {
                            drawerState.close()
                        }
                    },
                        icon = {
                           Icon(painter = painterResource(id = items.icon), contentDescription = null,
                               modifier = Modifier.size(24.dp))
                        })
                }
            }
        },
        content = {
            Scaffold (
                
                topBar = { TopAppBar(title = { Text(text = "College App") },
                    navigationIcon = {
                        IconButton(onClick = {scope.launch { drawerState.open() }}) {
                           Icon(imageVector = Icons.Rounded.Menu  , contentDescription = null)

                        }
                    })
                },
                bottomBar = {
                    MyBottomNav(navHostController = navHostController1)
                }

            ){ padding ->
              NavHost(navController = navHostController1,
                  startDestination = Routes.Home.route,
                  modifier = Modifier.padding(padding)){
                  composable(route = Routes.Home.route){
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

                }
            }
        })
}

@Composable
fun MyBottomNav(navHostController: NavHostController) {
    val backStackEntry = navHostController.currentBackStackEntryAsState()

    val list = listOf(
        BottomNavItem(
            "Home",
            R.drawable.home,
            Routes.Home.route
        ),
        BottomNavItem(
            "Faculty",
            R.drawable.faculty,
            Routes.Faculty.route
        ),
        BottomNavItem(
            "Gallery",
            R.drawable.gallery,
            Routes.Gallery.route
        ),
        BottomNavItem(
            "About us",
            R.drawable.about,
            Routes.AboutUs.route
        )


    )
    
    BottomAppBar {
        list.forEach{
            val curRoute = it.route
            val othetRoute = 
                try {
                    backStackEntry.value!!.destination.route
                }catch (e:Exception){
                    Routes.Home.route
                }
               val selected = curRoute == othetRoute
            
            NavigationBarItem(selected = selected ,
                onClick = {navHostController.navigate(it.route){
                    popUpTo(navHostController.graph.findStartDestination().id){
                        saveState=true
                    }
                    launchSingleTop = true
                } },
                icon = { 
                   Icon(painterResource(id = it.icon) , contentDescription = it.title,
                       modifier = Modifier.size(24.dp))
                })
        } 
    }

}