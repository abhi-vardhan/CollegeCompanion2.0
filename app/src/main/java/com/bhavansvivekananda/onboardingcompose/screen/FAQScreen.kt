package com.bhavansvivekananda.onboardingcompose.screen


import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bhavansvivekananda.onboardingcompose.R
import com.bhavansvivekananda.onboardingcompose.navigation.Screen
import com.bhavansvivekananda.onboardingcompose.screen.todo.ui.TodoActivity
import com.bhavansvivekananda.onboardingcompose.viewmodel.WelcomeViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth




@OptIn(ExperimentalMaterialApi::class)
val BottomSheetScaffoldState.isExpanded: Boolean
    get() = bottomSheetState.isExpanded

@OptIn(ExperimentalMaterialApi::class)
val BottomSheetScaffoldState.isCollapsed: Boolean
    get() = bottomSheetState.isCollapsed
@ExperimentalMaterialApi
@Composable
fun FAQScreen(navController: NavHostController,
              welcomeViewModel: WelcomeViewModel = hiltViewModel()
){

    val homefont = FontFamily(
        Font(R.font.home))
    var user by remember { mutableStateOf(Firebase.auth.currentUser) }
    var bottomSheetState by remember { mutableStateOf(BottomSheetState(BottomSheetValue.Collapsed)) }
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
/*
    val swipeableState = rememberSwipeableState(0)

    val anchors = mapOf(0f to 0, -300f to 1) // Adjust -300f according to the width of your screen

    val offsetX = swipeableState.offset.value.toInt()

    // Apply swipeable modifier to the content
    Box(
        modifier = Modifier
            .offset { IntOffset(offsetX.toInt(), 0) }
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                orientation = Orientation.Horizontal,
                enabled = true,
                thresholds = { _, _ -> FractionalThreshold(0.5f) },
                resistance = null
            )
    ) {*/

    BottomSheetScaffold(
      /*  scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = bottomSheetState),
      */
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {

            // Customize the BottomSheet content as needed
           Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                contentAlignment = Alignment.Center
            ) { 
               Column(modifier = Modifier.fillMaxSize()) {
                // Row 1
                   Row(
                       modifier = Modifier
                           .height(50.dp)
                           .width(800.dp)
                           .padding(6.dp),
                       horizontalArrangement = Arrangement.SpaceAround,
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Text(text = "━━━━━━━━",
                           fontSize = 20.sp,
                           fontWeight = FontWeight.Bold,
                           modifier = Modifier.padding(top = 0.dp),
                           color = Color(0xFF2A3942)
                       )

                   }
                Row(
                    modifier = Modifier
                        .height(60.dp)
                        .width(800.dp)
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.newnav2),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 0.dp, bottom =0.dp, start = 30.dp)
                            .height(30.dp)
                            .width(30.dp)
                            .weight(0.2f)
                            .clickable {
                                navController.navigate(Screen.navfinal.route)
                            }
                            .clip(RoundedCornerShape(50.dp)
                                )
                    )
                    Text(text = "Navigation",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = homefont,
                        letterSpacing = 2.5.sp,
                        modifier = Modifier.padding(top = 0.dp, start = 20.dp)
                            .weight(0.8f)
                            .clickable {
                                navController.navigate(Screen.navfinal.route)
                            },
                        color = Color(0xFF2A3942)
                    )


                }

                   Row(
                       modifier = Modifier
                           .height(60.dp)
                           .width(800.dp)
                           .padding(10.dp),
                       horizontalArrangement = Arrangement.SpaceAround,
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Image(
                           painter = painterResource(id = R.drawable.pdfcon2),
                           contentDescription = null,
                           modifier = Modifier
                               .padding(top = 0.dp, bottom =0.dp, start = 30.dp)
                               .height(40.dp)
                               .width(40.dp)
                               .weight(0.2f)
                               .clickable {
                                   navController.navigate(Screen.Pdfscr.route)
                               }
                               .clip(RoundedCornerShape(50.dp)
                               )
                       )
                       val handler = LocalUriHandler.current
                       Text(text = "PDF Converter",
                           fontSize = 20.sp,
                           fontWeight = FontWeight.Bold,
                           fontFamily = homefont,
                           letterSpacing = 2.5.sp,
                           modifier = Modifier.padding(top = 0.dp, start = 20.dp)
                               .clickable {
                                   handler.openUri("https://shelar1423.github.io/pdfff/")
                               }
                               .weight(0.8f),
                           color = Color(0xFF2A3942)
                       )


                   }
                   Row(
                       modifier = Modifier
                           .height(60.dp)
                           .width(800.dp)
                           .padding(10.dp),
                       horizontalArrangement = Arrangement.SpaceAround,
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Image(
                           painter = painterResource(id = R.drawable.feenew2),
                           contentDescription = null,
                           modifier = Modifier
                               .padding(top = 0.dp, bottom =0.dp, start = 30.dp)
                               .height(40.dp)
                               .width(40.dp)
                               .weight(0.2f)
                               .clickable {
                                   navController.navigate(Screen.payment.route)
                               }
                               .clip(RoundedCornerShape(50.dp)
                               )
                       )
                       Text(text = "Fee Payment",
                           fontSize = 20.sp,
                           fontWeight = FontWeight.Bold,
                           fontFamily = homefont,
                           letterSpacing = 2.5.sp,
                           modifier = Modifier.padding(top = 0.dp, start = 20.dp)
                               .weight(0.8f)
                               .clickable {
                                   navController.navigate(Screen.payment.route)
                               },
                           color = Color(0xFF2A3942)
                       )


                   }
                   Row(
                       modifier = Modifier
                           .height(60.dp)
                           .width(800.dp)
                           .padding(10.dp),
                       horizontalArrangement = Arrangement.SpaceAround,
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Image(
                           painter = painterResource(id = R.drawable.logoutnew2),
                           contentDescription = null,
                           modifier = Modifier
                               .padding(top = 0.dp, bottom =0.dp, start = 30.dp)
                               .height(40.dp)
                               .width(40.dp)
                               .weight(0.2f)
                               .clip(RoundedCornerShape(50.dp)
                               )
                       )
                       Text(text = "LogOut",
                           fontSize = 20.sp,
                           fontWeight = FontWeight.Bold,
                           letterSpacing = 2.5.sp,
                           fontFamily = homefont,
                           modifier = Modifier.padding(top = 0.dp, start = 20.dp)
                               .weight(0.8f)
                               .clickable {
                                   // Sign out logic...
                                   FirebaseAuth.getInstance().signOut()
                                   // Navigate back to the registration screen
                                   navController.navigate(Screen.RegistrationScreen.route) {
                                       popUpTo(Screen.RegistrationScreen.route) {
                                           inclusive = true
                                       }
                                   }
                               },
                           color = Color(0xFF2A3942)
                       )


                   }


             }
            }



        }
        ,
        sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        sheetBackgroundColor = Color.Transparent,
        sheetPeekHeight = 58.dp // Adjust this value as needed
    ) {
     /*   FullScreenCard(bottomSheetExpanded = bottomSheetScaffoldState.isExpanded)*/


        Newhome(navController=navController,webUrl = "https://shelar1423.github.io/to-do-listAPP/")



    }
}
    /*
LaunchedEffect(swipeableState.isAnimationRunning) {
    if (!swipeableState.isAnimationRunning) {
        if (swipeableState.currentValue == 1) {
           navController.navigate(Screen.Tbar.route)
        }
    }
}
}*/


@Composable
fun FullScreenCard(bottomSheetExpanded: Boolean) {
    var user by remember { mutableStateOf(Firebase.auth.currentUser) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.ccbg), contentDescription = null,
            modifier = Modifier
                .padding(top = 0.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            /*.background(
                Color.White
            )*/
            contentScale = ContentScale.FillBounds,

            )


        Card(
            shape = RoundedCornerShape(0.dp),
            elevation = 5.dp,
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                // Main content
                Column(
                    horizontalAlignment = if (bottomSheetExpanded) Alignment.Start else Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxHeight()
                        .align(Alignment.TopStart)
                        .padding(
                            start = if (bottomSheetExpanded) 6.dp else 100.dp,
                            top = if (bottomSheetExpanded) 2.dp else 160.dp
                        )
                ) {
                    Spacer(modifier = Modifier.height(if (bottomSheetExpanded) 10.dp else 120.dp))

                    Image(
                        painter = painterResource(id = R.drawable.github),
                        contentDescription = "Profile Image",
                        modifier = Modifier.size(if (bottomSheetExpanded) 100.dp else 200.dp)
                    )
                    Spacer(modifier = Modifier.height(if (bottomSheetExpanded) 4.dp else 40.dp))
                    Text(
                        text = "Student Name",
                        style = TextStyle(fontSize = if (bottomSheetExpanded) 20.sp else 28.sp),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Box(modifier = Modifier.weight(1f)) // Pushes content above it upwards
                    Box(modifier = Modifier.weight(0.5f)) // Adjust the weight for vertical spacing
                }

                // Top-right sign-out icon
                Image(
                    painter = painterResource(id = R.drawable.iicon),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 10.dp, end = 5.dp)
                        .height(35.dp)
                        .width(60.dp)
                    /*.clickable {
                        // Sign out logic...
                        FirebaseAuth.getInstance().signOut()
                        // Navigate back to the registration screen
                        navController.navigate(Screen.RegistrationScreen.route) {
                            popUpTo(Screen.RegistrationScreen.route) {
                                inclusive = true
                            }
                        }
                    }*/
                )
            }
        }
    }

}

@Composable
fun abcd1234() {

    Box {


        Image(
            painter = painterResource(id = R.drawable.ccbgnew), contentDescription = null,
            modifier = Modifier
                .padding(top = 0.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            /*.background(
            Color.White
        )*/
            contentScale = ContentScale.FillBounds,

            )


        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /*Box(
            Modifier
                .fillMaxWidth()
                .height(245.dp)
                .padding(top = 0.dp, start = 0.dp)
                .background(
                    color = Color.Blue,
                    shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp)

                )
        )*/
            Row(
                modifier = Modifier
                    .padding(top = 18.dp, start = 24.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .height(100.dp)
                        .padding(start = 14.dp)
                        .weight(0.7f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Hello",
                        color = Color.White,
                        fontSize = 20.sp
                    )


                    Text(
                        text = "Abhinav Vardhan",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 20.dp)
                    )


                }

                Image(painter = painterResource(id = R.drawable.github),
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clickable { }
                        .padding(end = 20.dp)
                )

            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 54.dp, start = 24.dp, end = 24.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(28.dp))
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(28.dp)
                    )


            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, end = 12.dp)
                        .height(90.dp)
                        .width(90.dp)
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(28.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.alamancicon),
                        contentDescription = null,
                        Modifier.padding(top = 8.dp, bottom = 4.dp)
                    )
                    Text(
                        text = "Fee Payment",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier.padding(top = 28.dp),
                        color = Color.Black
                    )


                }
                Column(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, end = 8.dp, start = 8.dp)
                        .height(90.dp)
                        .width(90.dp)
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(28.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.feepayment),
                        contentDescription = null,
                        Modifier.padding(top = 8.dp, bottom = 4.dp)
                    )
                    Text(
                        text = "Fee Payment",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color.Black
                    )


                }
                Column(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp)
                        .height(90.dp)
                        .width(90.dp)
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(28.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.feepayment),
                        contentDescription = null,
                        Modifier.padding(top = 8.dp, bottom = 4.dp)
                    )
                    Text(
                        text = "Fee Payment",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color.Black
                    )


                }

            }

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 324.dp, end = 24.dp, start = 24.dp)
                .shadow(3.dp, shape = RoundedCornerShape(25.dp))
                .height(210.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF8B5BE0),
                            Color(0xFFF3C744)
                        )
                    ), shape = RoundedCornerShape(25.dp)
                )
        )
        {

        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 24.dp)
        ) {
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.alamancicon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 530.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                )
                Text(
                    text = "Inbox",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(0xFF8B5BE0)
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.alamancicon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 530.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                )
                Text(
                    text = "Inbox",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(0xFF8B5BE0)
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.alamancicon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 530.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                )
                Text(
                    text = "Inbox",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(0xFF8B5BE0)
                )
            }
        }


    }

}

