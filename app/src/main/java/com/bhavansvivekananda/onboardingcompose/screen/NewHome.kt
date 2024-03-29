package com.bhavansvivekananda.onboardingcompose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bhavansvivekananda.onboardingcompose.R
import com.bhavansvivekananda.onboardingcompose.navigation.Screen
import com.bhavansvivekananda.onboardingcompose.viewmodel.WelcomeViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun Newhome(navController: NavHostController,
            welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {

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
                    .height(140.dp)
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

                var user by remember { mutableStateOf(Firebase.auth.currentUser) }
                Text(
                    text = "${user!!.displayName}",
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
                .padding(top = 14.dp, start = 24.dp, end = 24.dp)
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
                    .width(90.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.acadnew1),
                    contentDescription = null,
                    Modifier.padding(top = 0.dp, bottom = 0.dp)
                        .height(75.dp)
                        .clickable {
                            navController.navigate(Screen.Tbar.route)
                        }
                        .clip(
                            RoundedCornerShape(20.dp)
                        )
                )

                Text(
                    text = "Academics",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    color = Color.Black
                )


            }
            Column(
                modifier = Modifier
                    .padding(top = 12.dp, bottom = 12.dp, end = 8.dp, start = 8.dp)
                    .height(90.dp)
                    .width(90.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val handler = LocalUriHandler.current
                Image(
                    painter = painterResource(id = R.drawable.websitenew),
                    contentDescription = null,
                    Modifier.padding(top = 0.dp, bottom = 0.dp)
                        .height(75.dp)
                        .clickable {
                            handler.openUri("https://www.bhavansvc.ac.in/")
                        }
                        .clip(
                            RoundedCornerShape(20.dp)
                        )
                )

                Text(
                    text = "Website",
                    fontSize = 13.sp,
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
                        color = Color.White,
                        shape = RoundedCornerShape(28.dp)
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.qpbut1),
                    contentDescription = null,
                    Modifier.padding(top = 0.dp, bottom = 0.dp)
                        .height(75.dp)
                        .clickable {
                            navController.navigate(Screen.Papers.route)
                        }
                        .clip(
                            RoundedCornerShape(20.dp)
                        )
                )

                Text(
                    text = "Papers",
                    fontSize = 13.sp,
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
            .padding(start = 16.dp, end = 16.dp, top = 34.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.25f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.alumninew),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 530.dp, bottom = 4.dp)
                    .height(90.dp)
                    .width(90.dp)
                    .clickable {
                        navController.navigate(Screen.alumni.route)
                    }
                    .clip(RoundedCornerShape(20.dp))
            )
            Text(
                text = "Alumni",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp),
                color = Color.Black
            )
        }
        Column(
            modifier = Modifier.weight(0.25f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.placenew),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 530.dp, bottom = 4.dp)
                    .height(80.dp)
                    .width(80.dp)
                    .clickable {
                        navController.navigate(Screen.placement.route)
                    }
                    .clip(RoundedCornerShape(20.dp))
            )
            Text(
                text = "Placements",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp),
                color = Color.Black
            )
        }
        Column(
            modifier = Modifier.weight(0.25f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.feedbacknew),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 530.dp, bottom = 4.dp)
                    .height(90.dp)
                    .width(90.dp)
                    .clickable {
                        navController.navigate(Screen.feedbackmain.route)
                    }
                    .clip(RoundedCornerShape(20.dp))
            )
            Text(
                text = "Feedback",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp),
                color = Color.Black
            )
        }
    }
}

}

