package com.bhavansvivekananda.onboardingcompose.screen

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.bhavansvivekananda.onboardingcompose.MainActivity
import com.bhavansvivekananda.onboardingcompose.R
import com.bhavansvivekananda.onboardingcompose.navigation.Screen
import com.bhavansvivekananda.onboardingcompose.viewmodel.SplashViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    splashViewModel: SplashViewModel
) {

    val screen by splashViewModel.startDestination

    // variable to fetch registration status from the view model
    val registrationCheck by splashViewModel.registrationCheck

    if (registrationCheck) {
        LaunchedEffect(key1 = true) {
            delay(5500)
            navController.navigate(screen)
        }
    } else {
        LaunchedEffect(key1 = true) {
            delay(5500)
            navController.navigate(Screen.RegistrationScreen.route)
        }
    }

    val alpha = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        /*alpha.animateTo(
            1f,
            animationSpec = tween(2500)
        )*/
        delay(5500)
        navController.popBackStack()
        navController.navigate(Screen.RegistrationScreen.route)
        /*
                if (onBoardingIsFinished(context = context)) {
                    navController.popBackStack()
                    navController.navigate("Home")
                } else {
                    navController.popBackStack()
                    navController.navigate("Onboarding")

                }*/

    }
    /*
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(if (isSystemInDarkTheme()) Color.DarkGray else Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoaderAnimation(
                modifier = Modifier.size(400.dp), anim = R.raw.course_video
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "Let's Travel",
                modifier = Modifier.alpha(alpha.value),
                fontSize = 52.sp,
            )
        }*/

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        val rawResourceResId = R.raw.splashnew
        val videoUri = RawResourceDataSource.buildRawResourceUri(rawResourceResId)
        val mediaItem = com.google.android.exoplayer2.MediaItem.Builder()
            .setUri(videoUri)
            .build()

        val exoPlayer = remember(context, mediaItem) {
            ExoPlayer.Builder(context).build().also { player ->
                player.setMediaItem(mediaItem)
                player.prepare()
                player.repeatMode = Player.REPEAT_MODE_ONE // Loop video
                player.playWhenReady = true

            }
        }

        DisposableEffect(AndroidView(
            modifier = Modifier.fillMaxSize(), // Full screen
            factory = {
                StyledPlayerView(context).apply { player = exoPlayer
                    layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                    useController = false
                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                }
            }
        )) {
            onDispose { exoPlayer.release() }
        }
    }
}


@Composable
fun LoaderAnimation(modifier: Modifier, anim: Int) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(anim))

    LottieAnimation(
        composition = composition, iterations = LottieConstants.IterateForever,
        modifier = modifier
    )
}

@OptIn(ExperimentalAnimationApi::class, ExperimentalPagerApi::class)
private fun onBoardingIsFinished(context: MainActivity): Boolean {
    val sharedPreferences = context.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean("isFinished", false)

}
/*
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
/*
        Image(
            modifier = Modifier.size(300.dp),
            painter = painterResource(id = R.drawable.logo_overlay__12__removebg_preview),
            contentDescription = "logo",
            contentScale = ContentScale.FillBounds
        )

 */
        Image(
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            painter = painterResource(id = R.drawable.splashme),
            contentDescription = "logo",
            contentScale = ContentScale.FillBounds
        )

    }

}

 */