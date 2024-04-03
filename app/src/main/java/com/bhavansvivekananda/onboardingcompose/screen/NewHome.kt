package com.bhavansvivekananda.onboardingcompose.screen

import android.webkit.WebView
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
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bhavansvivekananda.onboardingcompose.R
import com.bhavansvivekananda.onboardingcompose.navigation.NavigationItem
import com.bhavansvivekananda.onboardingcompose.navigation.Screen
import com.bhavansvivekananda.onboardingcompose.viewmodel.WelcomeViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.view.ViewGroup

import android.webkit.WebViewClient
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest


@Composable
fun Newhome(navController: NavHostController,
                welcomeViewModel: WelcomeViewModel = hiltViewModel(),webUrl: String
    ) {

        Box {
            Image(
                painter = painterResource(id = R.drawable.newhomebg), contentDescription = null,
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
                        .padding(top = 9.dp, start = 18.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .height(140.dp)
                            .padding(start = 24.dp)
                            .weight(0.7f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        var userImageUrl by remember { mutableStateOf<String?>(null) }
                        val context = LocalContext.current

                        val googleSignInAccount = GoogleSignIn.getLastSignedInAccount(context)

                        if (googleSignInAccount != null) {
                            userImageUrl = googleSignInAccount.photoUrl.toString()
                        }
                        userImageUrl?.let { imageUrl ->
                            Image(
                                painter = // You can specify placeholder, error, transformations, etc. here
                                rememberAsyncImagePainter(ImageRequest.Builder // Placeholder image while loading
                                // Error image if loading fails
                                    (LocalContext.current).data(data = imageUrl).apply(block = fun ImageRequest.Builder.() {
                                    // You can specify placeholder, error, transformations, etc. here
                                    placeholder(R.drawable.newuserlogo) // Placeholder image while loading
                                    error(R.drawable.newuserlogo) // Error image if loading fails
                                }).build()
                                ),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(50.dp)
                                    .clickable { /* Handle click if necessary */ }
                                    .clip(RoundedCornerShape(50.dp))
                            )
                        } ?: run {
                            // If user image URL is not available, display a default image
                            Image(
                                painter = painterResource(id = R.drawable.newuserlogo),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(50.dp)
                                    .clickable { /* Handle click if necessary */ }
                            )
                        }/*
                        Image(painter = painterResource(id = R.drawable.newuserlogo),
                            contentDescription = null,
                            modifier = Modifier
                                .width(50.dp)
                                .height(50.dp)
                                .clickable { }

                        )*/
                        Spacer(modifier = Modifier.height(5.dp))

                        var user by remember { mutableStateOf(Firebase.auth.currentUser) }
                        Text(
                            text = "Hi, ${user!!.displayName}",
                            color = Color.White,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 10.dp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Welcome to College Companion",
                            color = Color.White,
                            fontSize = 20.sp
                        )


                    }



                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp)
                        .padding(top = 18.dp, start = 24.dp, end = 24.dp)
                        .shadow(5.dp, shape = RoundedCornerShape(28.dp))
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(28.dp)
                        )


                ){

                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 14.dp, start = 24.dp, end = 24.dp)

                        .background(
                            color =  Color(0xFFF7FBFF)
                        )


                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 12.dp, bottom = 12.dp, end = 12.dp)
                            .height(110.dp)
                            .width(110.dp)
                            .shadow(5.dp, shape = RoundedCornerShape(18.dp))
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(18.dp)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.finacad),
                            contentDescription = null,
                            Modifier
                                .padding(top = 0.dp, bottom = 7.dp)
                                .height(70.dp)
                                .width(70.dp)
                                .clickable {
                                    navController.navigate(Screen.acad1.route)
                                }

                        )

                        Text(
                            text = "Academics",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Italic,
                            color = Color.Black

                        )


                    }
                    Column(
                        modifier = Modifier
                            .padding(top = 12.dp, bottom = 12.dp, end = 8.dp, start = 8.dp)
                            .height(110.dp)
                            .width(110.dp)
                            .shadow(5.dp, shape = RoundedCornerShape(18.dp))
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(18.dp)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val handler = LocalUriHandler.current
                        Image(
                            painter = painterResource(id = R.drawable.finweb),
                            contentDescription = null,
                            Modifier
                                .padding(top = 0.dp, bottom = 7.dp)
                                .height(70.dp)
                                .width(70.dp)
                                .clickable {
                                    handler.openUri("https://www.bhavansvc.ac.in/")
                                }

                        )

                        Text(
                            text = "Website",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Italic,
                            color = Color.Black
                        )


                    }
                    Column(
                        modifier = Modifier
                            .padding(top = 12.dp, bottom = 12.dp, start = 8.dp)
                            .height(110.dp)
                            .width(110.dp)
                            .shadow(5.dp, shape = RoundedCornerShape(18.dp))
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(18.dp)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.finpaper),
                            contentDescription = null,
                            Modifier
                                .padding(top = 0.dp, bottom = 7.dp)
                                .height(70.dp)
                                .width(70.dp)
                                .clickable {
                                    navController.navigate(Screen.Papers.route)
                                }

                        )

                        Text(
                            text = "Papers",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Italic,
                            color = Color.Black
                        )


                    }

                }

            }


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 375.dp, end = 24.dp, start = 24.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(25.dp))
                    .height(185.dp)
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
                AndroidView(
                    factory = { context ->
                        WebView(context).apply {
                            settings.javaScriptEnabled = true
                            webViewClient = WebViewClient()
                            loadUrl(webUrl)
                            settings.javaScriptEnabled = true
                            settings.loadWithOverviewMode = true;
                            settings.useWideViewPort = true;

                        }
                    }
                )

            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp, end = 2.dp, top = 540.dp, bottom = 2.dp)
                    .background(
                       /* color =  Color(0xFFF7FBFF)*/
                        color = Color.Transparent
                    )


            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 32.dp, bottom = 12.dp, end = 12.dp)
                        .height(110.dp)
                        .width(110.dp)
                        .shadow(5.dp, shape = RoundedCornerShape(18.dp))
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(18.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(id = R.drawable.finjob),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 10.dp, bottom = 1.dp)
                            .height(60.dp)
                            .width(60.dp)
                            .clickable {
                                navController.navigate(Screen.placement.route)

                            }


                    )
                    Text(
                        text = "Placements",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(top = 8.dp),
                        color = Color.Black
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(top = 32.dp, bottom = 12.dp, end = 12.dp)
                        .height(110.dp)
                        .width(110.dp)
                        .shadow(5.dp, shape = RoundedCornerShape(18.dp))
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(18.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(id = R.drawable.finalumni),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 10.dp, bottom = 1.dp)
                            .height(60.dp)
                            .width(60.dp)
                            .clickable {
                                navController.navigate(Screen.alumni.route)
                            }


                    )
                    Text(
                        text = "Alumni",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(top = 8.dp),
                        color = Color.Black
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(top = 32.dp, bottom = 12.dp, end = 12.dp)
                        .height(110.dp)
                        .width(110.dp)
                        .shadow(5.dp, shape = RoundedCornerShape(18.dp))
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(18.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.finfeedback),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 10.dp, bottom = 1.dp)
                            .height(60.dp)
                            .width(60.dp)
                            .clickable {
                                navController.navigate(Screen.feedback.route)
                            }

                    )
                    Text(
                        text = "Feedback",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(top = 8.dp),
                        color = Color.Black
                    )
                }
            }
        }

    }



