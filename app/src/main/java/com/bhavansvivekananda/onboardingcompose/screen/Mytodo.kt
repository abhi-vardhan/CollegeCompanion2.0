package com.bhavansvivekananda.onboardingcompose.screen

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bhavansvivekananda.onboardingcompose.navigation.Screen
import com.bhavansvivekananda.onboardingcompose.viewmodel.WelcomeViewModel



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun mytodo(navController: NavHostController,
           welcomeViewModel: WelcomeViewModel = hiltViewModel(),
           url: String) {

    val swipeableState = rememberSwipeableState(initialValue = 0)
   /* val anchors = mapOf(0f to 0, -300f to 1) // Adjust -300f according to the width of your screen*/
    val anchors = mapOf(0f to 0, 300f to 1)
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
    ) {

        AndroidView(factory = {
            WebView(it).apply {

                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = WebViewClient()
                loadUrl(url)
                settings.javaScriptEnabled = true
                settings.loadWithOverviewMode = true;
                settings.useWideViewPort = true;
                settings.builtInZoomControls = true;
                this.setDownloadListener {
                        url, userAgent,
                        contentDisposition, mimetype,
                        contentLength
                    ->

                    val downloadManager =
                        context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                    val request = DownloadManager.Request(Uri.parse(url.toString() + ""))
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                    val reference = downloadManager.enqueue(request)
                    val filename = url.split("/").toTypedArray().last().split(".").first()
                    request.setMimeType("application/pdf")
                    request.allowScanningByMediaScanner()
                    request.setAllowedOverMetered(true)
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                    request.setDestinationInExternalPublicDir(
                        Environment.DIRECTORY_DOWNLOADS,
                        "MyFiles/$filename"
                    )
                    downloadManager.enqueue(request)
                }


            }
        }, update = {
            it.loadUrl(url)

        })


        LaunchedEffect(swipeableState.isAnimationRunning) {
            if (!swipeableState.isAnimationRunning) {
                if (swipeableState.currentValue == 1) {
                    navController.navigate(Screen.faq.route)
                }
            }
        }
    }
}


