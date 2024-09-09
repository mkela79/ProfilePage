package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

val robotoFamily = FontFamily.Serif

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Greeting()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var profileName by remember { mutableStateOf("Dora British") }
    var verified by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            IconButton(onClick = { }, modifier = Modifier.size(24.dp).padding(end = 16.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.chevron_backward),
                    contentDescription = "Back"
                )
            }
            Text(
                "Profile", fontFamily = robotoFamily, fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
            )
        }

        Column(
            modifier = Modifier.padding(top = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_default_pic),
                contentDescription = "default profile picture",
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = profileName,
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 8.dp)
            )

            FilledTonalButton(
                onClick = {},
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = Color(0xFFFAFAFA)
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
//                    .width(65.dp)
//                    .height(25.dp)
                    .padding(top = 8.dp),
//                    .fillMaxWidth()

            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.yellow_star),
                        contentDescription = "yellow star",
                        modifier = Modifier
                            .size(16.dp)
                            .padding(end = 4.5.dp)
                    )
                    Text(
                        text = "5.0",
                        fontSize = 12.sp,
                        color = Color(0xFF000000),
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center
                    )
                }
            }
            OutlinedButton(
                onClick = {},
                border = BorderStroke(width = 1.dp, color = Color(0xFFF7F7F7)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
//                    .width(112.dp)
//                    .height(32.dp)
                    .padding(top = 12.dp),
//                    .fillMaxWidth()

            ) {
                var verificationText = if (verified) "Verified" else "Get verified"
                var verificationIconId =
                    if (verified) R.drawable.new_releases else R.drawable.add_circle
                var verificationTextColor = if (verified) Color(0xFF34A853) else Color(0xFF000000)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = verificationIconId),
                        contentDescription = null,
                        modifier = Modifier
                            .size(16.dp)
                            .padding(end = 4.5.dp)
                    )
                    Text(
                        text = verificationText,
                        fontSize = 14.sp,
                        color = verificationTextColor,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) { //es unda??
            DetailsItem(R.drawable.account_circle, 17.2, 17.2, "Profile Info") {}
            DetailsItem(R.drawable.settings, 16.95, 18.0, "Settings") {}
            DetailsItem(R.drawable.reviews, 18.0, 15.95, "Review") {}
            DetailsItem(R.drawable.leaderboard, 18.0, 16.0, "Leaderboard") {}
            DetailsItem(R.drawable.history, 15.82, 16.0, "History") {}
            DetailsItem(R.drawable.info, 17.2, 17.2, "About Us") {}
            DetailsItem(R.drawable.support_agent, 17.2, 14.8, "Support") {}

        }
        FilledTonalButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.filledTonalButtonColors(Color(0xFFFFDBDA)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Log Out",
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    color = Color(0xFFE53935),
                    modifier = Modifier.padding(end = 10.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.move_item),
                    contentDescription = "log out",
                    modifier = Modifier
                        .size(24.dp)
                )

            }

        }

    }

}

@Composable
fun DetailsItem(id: Int, iconWidth: Double, iconHeight: Double, text: String, onClick: () -> Unit) {
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 8.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row() {
                Box(modifier = Modifier.size(24.dp), contentAlignment = Alignment.Center) {
                    Icon(
                        painter = painterResource(id = id),
                        contentDescription = null,
                        modifier = Modifier
                            .width(iconWidth.dp)
                            .height(iconHeight.dp)
                            .size(24.dp)
                    )
                }


                Text(
                    text = text,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 18.dp)
                )
            }

            Image(
                painter = painterResource(id = R.drawable.chevron_forward),
                contentDescription = "forward icon",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onClick() }
            )
        }
        HorizontalDivider(
            color = Color(0xFFF3F3F3), modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting()
    }
}