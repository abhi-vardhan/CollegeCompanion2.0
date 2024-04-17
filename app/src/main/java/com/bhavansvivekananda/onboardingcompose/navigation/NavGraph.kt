@file:OptIn(ExperimentalFoundationApi::class)

package com.bhavansvivekananda.onboardingcompose.navigation


import act
import view360
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bhavansvivekananda.onboardingcompose.screen.*
import com.bhavansvivekananda.onboardingcompose.screen.homescreen.*
import com.bhavansvivekananda.onboardingcompose.screen.quespaper.*
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalAnimationApi
@ExperimentalPagerApi
fun NavGraphBuilder.SetupNavGraph(
    navController: NavHostController
) {

    navigation(
        startDestination = Screen.Welcome.route,
        route = Graph.NavGraph
    ) {


        composable(route = Screen.Papers.route) {
            exam(navController = navController)
        }



        composable(route = Screen.acad1.route) {
            act(navController = navController)
        }
        composable(route=Screen.tsixty.route){
            view360(navController = navController)
        }


        composable(route = Screen.alumni.route)
        {
            alumni(navController=navController, url ="https://alumni.bhavansvc.ac.in/")
        }




        composable(route = Screen.itcom.route){
            itcom(navController = navController, url = "https://www.google.com/maps/@17.4895706,78.534892,3a,75y,322.98h,80.91t/data=!3m8!1e1!3m6!1sAF1QipOfWzQ6aK9I0qpUhNWd9y96MHMChRxxg9_pyN5F!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipOfWzQ6aK9I0qpUhNWd9y96MHMChRxxg9_pyN5F%3Dw203-h100-k-no-pi-0-ya294.26694-ro0-fo100!7i10240!8i5120")
        }
        composable(route = Screen.biosci.route){
            biosci(navController = navController, url = "https://momento360.com/e/u/f6f326683a0f4f4ebf258288d4a763b7?utm_campaign=embed&utm_source=other&utm_medium=other")
        }
        composable(route = Screen.vbmba.route){
            vbmba(navController = navController, url = "https://momento360.com/e/u/3c06ad66a83245afbd06d2d3019e351a?utm_campaign=embed&utm_source=other&utm_medium=other")
        }

        composable(route = Screen.libblock.route){
            libblock(navController = navController, url = "https://momento360.com/e/u/90960d2ff16a490b9f5e60307a048da2?utm_campaign=embed&utm_source=other&utm_medium=other")
        }
        composable(route = Screen.parking.route){
            parking(navController = navController, url = "https://momento360.com/e/u/c06eed43a45b458aa7ed19b75b9b3b20?utm_campaign=embed&utm_source=other&utm_medium=other")
        }
        composable(route = Screen.canteen.route){
            canteen(navController = navController, url = "https://momento360.com/e/u/cc9dd9a5ea0540b597dcab96006a4c21?utm_campaign=embed&utm_source=other&utm_medium=other")
        }
        composable(route = Screen.payment.route)
        {
            payment(navController=navController, url ="https://www.feepayr.com/")
        }
        //question papers
        composable(route = Screen.bcomg.route)
        {
            bcomg(navController=navController, url ="https://drive.google.com/drive/folders/1k2KAu9benSHdKF9QjA7--aoz_ot3JzP1?usp=share_link")
        }
        composable(route = Screen.bcomh.route)
        {
            bcomh(navController=navController, url ="https://drive.google.com/drive/folders/1TKp23MXOBcc2kIDR8mJyNVAFNyknttGc?usp=share_link")
        }
        composable(route = Screen.bcomc.route)
        {
            bcomc(navController=navController, url ="https://drive.google.com/drive/folders/18kCyUZT06oLcU3FvNZK6XqDNBcBWl01e?usp=share_link")
        }
        composable(route = Screen.bba.route)
        {
            bba(navController=navController, url ="https://drive.google.com/drive/folders/1wHcTMpFARsRB5QzfiPTNRMNdCgrNrXm1?usp=share_link")
        }
        composable(route = Screen.bca.route)
        {
            bca(navController=navController, url ="https://drive.google.com/drive/folders/1uorsnr-AcEIiAwuihTrtmPqNiGyY6V0O?usp=share_link")
        }
        composable(route = Screen.ba.route)
        {
            ba(navController=navController, url ="https://drive.google.com/drive/folders/1c9XUe_sf8LHrH3WTjHHT5ldelffeDVXw?usp=share_link")
        }
        composable(route = Screen.bscl.route)
        {
            bscl(navController=navController, url ="https://drive.google.com/drive/folders/1Dc2AovZ20L0pnisEbyZVnF3gpIjFvMiV?usp=share_link")
        }
        composable(route = Screen.bscp.route)
        {
            bscp(navController=navController, url ="https://drive.google.com/drive/folders/1XlpnMqF-ZUv0HKZ_Illm-xNd29BOc5go?usp=share_link")
        }
        composable(route = Screen.mscc.route)
        {
            mscc(navController=navController, url ="https://drive.google.com/drive/folders/1m6BLs02TmeblOFarhlfs0L6goZQ1Zu_h?usp=share_link")
        }
        composable(route = Screen.mba1.route)
        {
            mba1(navController=navController, url ="https://drive.google.com/drive/folders/1MJRv-C_148Nj-IX0Ovu80oaTm9UXbpeD?usp=share_link")
        }
        composable(route = Screen.mscm.route)
        {
            mscm(navController=navController, url ="https://drive.google.com/drive/folders/1QJ1mqCxaHlZOkoOF3hjnQ0RXBjVKD-pW?usp=share_link")
        }
        composable(route = Screen.mcom.route)
        {
            mcom(navController=navController, url ="https://drive.google.com/drive/folders/1W-47JYlLWZ73JM3oCBwsouEdj8KfylAk?usp=share_link")
        }
        composable(route = Screen.mscb.route)
        {
            mscb(navController=navController, url ="https://drive.google.com/drive/folders/1A-__w-0yuaNwT9J1CjbDKz902leLircn?usp=share_link")
        }
        composable(route = Screen.phdp.route)
        {
            phdp(navController=navController, url ="https://drive.google.com/drive/folders/1uxhq-xnmpxUrLEPZynk7xe7Td8DQjSXq?usp=share_link")
        }
        composable(route = Screen.phdm.route)
        {
            phdm(navController=navController, url ="https://drive.google.com/drive/folders/1-jW-QWYBYckCW16ZrCFjAv9bIfYHe9YV?usp=share_link")
        }
        composable(route = Screen.phdb.route)
        {
            phdb(navController=navController, url ="https://drive.google.com/drive/folders/1sDh9fF5_8sObLPwtMSap7oJh8hp_bWl1?usp=share_link")
        }
        composable(route = Screen.phdma.route)
        {
            phdma(navController=navController, url ="https://drive.google.com/drive/folders/1kYBCm_PEj1Kv_Be_G1WhPqZWG2C99yhK?usp=share_link")
        }
        composable(route = Screen.faq.route){
            FAQScreen(navController = navController)
        }




        composable(route = Screen.result.route)
        {
            result(navController=navController, url ="https://www.bvcexams.in/Examination%20Results.html")
        }
        composable(route = Screen.notification.route)
        {
            notification(navController=navController, url ="https://www.bvcexams.in/Examination%20Notifications.html")
        }
        composable(route = Screen.placement.route)
        {
            placement(navController=navController, url ="https://www.facebook.com/people/Bvcplacementcell/100064001289517/")
        }

        composable(route = Screen.almanac.route)
        {
            almanac(navController=navController, url ="https://www.bvcexams.in/Examination%20Almanac.html")
        }
        composable(route = Screen.syllabi.route)
        {
            almanac(navController=navController, url ="https://www.bhavansvc.ac.in/syllabi.html")
        }
        composable(route = Screen.website.route)
        {
            website(navController=navController, url ="https://www.bhavansvc.ac.in/")
        }


        composable(route = Screen.navfinal.route)
        {
            navfinal(navController = navController)
        }

        composable(route = Screen.navmid.route)
        {
            navmid(navController = navController)
        }


        composable(route = Screen.spnew.route)
        {
            NewSplash(navController = navController)
        }



        composable(route = Screen.Pdfscr.route)
        {
            Pdfscr(navController=navController, url ="https://shelar1423.github.io/pdfff/")
        }

        composable(route = Screen.feedback.route)
        {
            feedback(navController=navController, url ="https://docs.google.com/forms/d/e/1FAIpQLSczQKr1wN2bkvTHM8Nex2FYd36bvAga7b2QMoFkyQ5MIV_W3w/viewform?usp=sf_link")
        }

        composable(route = Screen.Mytodo.route)
        {
            mytodo(navController=navController, url ="https://abhi-vardhan.github.io/ToDo-List-App/")
        }


        }



    }
