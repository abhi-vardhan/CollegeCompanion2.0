package com.bhavansvivekananda.onboardingcompose.screen

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.bhavansvivekananda.onboardingcompose.R
import com.bhavansvivekananda.onboardingcompose.navigation.Screen
import com.bhavansvivekananda.onboardingcompose.ui.theme.Primary
import com.bhavansvivekananda.onboardingcompose.ui.theme.reko
import com.bhavansvivekananda.onboardingcompose.viewmodel.SplashViewModel
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout.RESIZE_MODE_ZOOM
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

@Composable
fun RegistrationScreen(navController: NavController, splashViewModel: SplashViewModel) {
    var buttonSize by remember { mutableStateOf(50.dp) }
    var rotationAngle by remember { mutableStateOf(360f) }
    val context = LocalContext.current
    val token = stringResource(id = R.string.client_id)

    var loading by remember { mutableStateOf(false) }

    val launcher = rememberFirebaseAuthLauncher(
        onAuthComplete = { result ->
            loading = false
            navController.navigate(Screen.HomeScreen.route)
        },
        onAuthError = {
            loading = false
            // Handle error if needed
        }
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            "WELCOME TO COLLEGE COMPANION!",
            fontFamily = reko,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 40.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(405.dp))
        Button(

            onClick = {
                loading = true

                val gso = GoogleSignInOptions
                    .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(token)
                    .requestEmail()
                    .build()
                val googleSignInClient = GoogleSignIn.getClient(context, gso)
                launcher.launch(googleSignInClient.signInIntent)

            },


            shape = CircleShape,
            modifier = Modifier
                .height(50.dp)
                .rotate(rotationAngle)

                ,
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black
            )
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                if (loading) {
                    Image(
                        painter = painterResource(id = R.drawable.googlelogo),
                        contentDescription = "",
                        modifier = Modifier.size(45.dp),
                        contentScale = ContentScale.Fit
                    )
                    CircularProgressIndicator() // Show loading indicator if loading is true
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.googlelogo),
                        contentDescription = "",
                        modifier = Modifier.size(45.dp),
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        "Sign in via Google",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 15.sp,
                        letterSpacing = 0.1.em
                    )
                }
            }
            if (loading) {
                Box(
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Text(
                        "Signing in...",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 15.sp,
                        letterSpacing = 0.1.em
                    )
                    LaunchedEffect(Unit) {
                        buttonSize = 50.dp
                        // Set the button size to the original size
                        rotationAngle += 360f // Rotate the button
                        delay(100)
                    }
                }
                }

            }
        }
    }


@Composable
fun rememberFirebaseAuthLauncher(
    onAuthComplete: (AuthResult) -> Unit,
    onAuthError: (ApiException) -> Unit
): ManagedActivityResultLauncher<Intent, ActivityResult> {
    val context = LocalContext.current
    val rawResourceResId = R.raw.course_video
    val videoUri = RawResourceDataSource.buildRawResourceUri(rawResourceResId)
    val mediaItem = com.google.android.exoplayer2.MediaItem.Builder()
        .setUri(videoUri)
        .build()

    val exoPlayer = remember(context, mediaItem) {
        com.google.android.exoplayer2.ExoPlayer.Builder(context).build().also { player ->
            player.setMediaItem(mediaItem)
            player.prepare()
            player.repeatMode = com.google.android.exoplayer2.Player.REPEAT_MODE_ONE // Loop video
            player.playWhenReady = true

        }
    }

    DisposableEffect(AndroidView(
        modifier = Modifier.fillMaxSize(), // Full screen
        factory = {
            StyledPlayerView(context).apply { player = exoPlayer
                layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
                useController = false
                resizeMode = RESIZE_MODE_ZOOM}
        }
    )) {
        onDispose { exoPlayer.release() }
    }

    val scope = rememberCoroutineScope()
    return rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)!!
            Log.d("GoogleAuth", "account $account")
            val credential = GoogleAuthProvider.getCredential(account.idToken!!, null)
            scope.launch {
                val authResult = Firebase.auth.signInWithCredential(credential).await()
                onAuthComplete(authResult)
            }
        } catch (e: ApiException) {
            Log.d("GoogleAuth", e.toString())
            onAuthError(e)
        }
    }
}
