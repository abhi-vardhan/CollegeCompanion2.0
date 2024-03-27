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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bhavansvivekananda.onboardingcompose.R

@Composable
fun Newhome() {

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


    Column (
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
        Row (
            modifier = Modifier
                .padding(top = 18.dp, start = 24.dp)
                .fillMaxWidth()
        ) {
            Column (
                modifier = Modifier
                    .height(100.dp)
                    .padding(start = 14.dp)
                    .weight(0.7f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Hello",
                    color = Color.White,
                    fontSize = 20.sp
                )


                Text(text = "Abhinav Vardhan",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 20.dp))



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
                Image(painter = painterResource(id = R.drawable.alamancicon),
                    contentDescription = null,
                    Modifier.padding(top = 8.dp, bottom = 4.dp))
                Text(text = "Fee Payment",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(top=28.dp),
                    color = Color.Black)
                

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
                Image(painter = painterResource(id = R.drawable.feepayment),
                    contentDescription = null,
                    Modifier.padding(top = 8.dp, bottom = 4.dp))
                Text(text = "Fee Payment",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    color = Color.Black)


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
                Image(painter = painterResource(id = R.drawable.feepayment),
                    contentDescription = null,
                    Modifier.padding(top = 8.dp, bottom = 4.dp))
                Text(text = "Fee Payment",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    color = Color.Black
                )


            }

        }

    }

Box(modifier = Modifier
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
    ))
{

}

    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 24.dp)
    ){
        Column (
            modifier = Modifier.weight(0.25f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.alamancicon),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 530.dp, bottom = 4.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            )
            Text(text = "Inbox",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top=8.dp),
                color = Color(0xFF8B5BE0))
        }
        Column (
            modifier = Modifier.weight(0.25f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.alamancicon),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 530.dp, bottom = 4.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            )
            Text(text = "Inbox",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top=8.dp),
                color = Color(0xFF8B5BE0))
        }
        Column (
            modifier = Modifier.weight(0.25f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.alamancicon),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 530.dp, bottom = 4.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            )
            Text(text = "Inbox",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top=8.dp),
                color = Color(0xFF8B5BE0))
        }
    }

}

@Preview
@Composable
fun Dashboard() {
    Newhome()
}