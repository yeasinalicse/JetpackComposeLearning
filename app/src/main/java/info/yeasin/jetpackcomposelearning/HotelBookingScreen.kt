package info.yeasin.jetpackcomposelearning

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowWidthSizeClass
import kotlin.collections.component1
import kotlin.collections.component2

@Composable
fun HotelBookingScreen(modifier: Modifier = Modifier) {

    // Hotel tag list (used in AssistChip)
    val tags = listOf(
        "City Center",
        "Luxury",
        "Instant Book",
        "Exclusive deal",
        "Early Bird Discount",
        "Saraton",
        "City in",
    )

    // Map of icon resource and their labels (offer list)
    val offers = mapOf(
        R.drawable.bedroom to "2 Bed",
        R.drawable.breakfast to "Breakfast",
        R.drawable.cutlery to "Cutlery",
        R.drawable.pet to "Pet Friendly",
        R.drawable.dinner to "Dinner",
        R.drawable.air_conditioning to "Air Conditioning",
        R.drawable.wifi to "Wifi",
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //  Top image with fade banner overlay
        item {
            Box {
                Image(
                    painter = painterResource(R.drawable.image_data),
                    contentDescription = null
                )
                HotelFadeBanner(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                )
            }
        }

        //  Horizontal divider
        item {
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        // Tags using FlowRow + AssistChip
        item {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            ) {
                tags.forEach { tag ->
                    AssistChip(
                        onClick = {},
                        label = { Text(tag) }
                    )
                }

            }
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        //  Description Text
        item {
            Text(
                text = "The advertisement features a vibrant and inviting design showcasing the Hotel California Strawberry nestled in the heart of Los Angeles. Surrounded by the iconic Hollywood Sign, Griffith Park, and stunning beaches, the hotel is perfectly located for guests to explore LA's best.",
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        // Section heading: "What we offer"
        item {
            Text(
                text = "What we offer",
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }

        // LazyRow of offer icons and labels
        item {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
            ) {
                items(offers.entries.toList()) { (drawableResId, label) ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .background(Color.Gray.copy(alpha = 0.3f))
                            .padding(8.dp)
                    ) {
                        // Icon from vector drawable
                        Icon(
                            imageVector = ImageVector.vectorResource(drawableResId),
                            contentDescription = label,
                            modifier = Modifier.size(45.dp)
                        )
                        Text(label, fontSize = 13.sp)
                    }
                }
            }
        }

        // Book now button
        item {
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .widthIn(min = 300.dp, max = 400.dp)
                    .fillMaxWidth()
            ) {
                Text("Book Now")
            }
        }
    }
}

// Semi-transparent banner on top of the image
@Composable
fun HotelFadeBanner(modifier: Modifier = Modifier) {
    val windowClass = currentWindowAdaptiveInfo().windowSizeClass

    // Dynamic font size based on window width
    val fontSize = when (windowClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> 20.sp
        WindowWidthSizeClass.MEDIUM -> 24.sp
        WindowWidthSizeClass.EXPANDED -> 28.sp
        else -> 8.sp
    }

    Row(
        modifier = modifier
            .background(Color.White.copy(alpha = 0.7f))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Hotel California Strawberry",
                fontWeight = FontWeight.Bold,
                fontSize = fontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            //  Location Icon
            LabeledIcon(text = "Los Angeles, California", icon = {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = Color.DarkGray
                )
            })

            //  Rating part
            LabeledIcon(text = "4.9 (13K reviews)", icon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color.DarkGray
                )
            })
        }

        //  Price section using AnnotatedString
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            ) {
                append("420$/")
            }
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            ) {
                append("night")
            }
        })
    }
}

// Reusable component with icon and label text
@Composable
fun LabeledIcon(
    text: String,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon() // Passes composable icon from parent
        Spacer(modifier = Modifier.width(4.dp))
        Text(text)
    }
}
