package info.yeasin.jetpackcomposelearning

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.window.core.layout.WindowWidthSizeClass
import info.yeasin.jetpackcomposelearning.ui.theme.JetpackComposeLearningTheme
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeLearningTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

//
//@OptIn(ExperimentalLayoutApi::class)
//@Composable
//fun ExpandableFlowRowDemo(modifier: Modifier = Modifier) {
//    var expanded by remember { mutableStateOf(false) }
//
//    FlowRow(
//        modifier = Modifier.fillMaxSize(),
//        horizontalArrangement = Arrangement.Absolute.SpaceAround,
//        maxLines = if (expanded) Int.MAX_VALUE else 4,
//        overflow = FlowRowOverflow.expandOrCollapseIndicator(
//            expandIndicator = {
//                IconButton(onClick = { expanded = true }) {
//                    Icon(
//                        imageVector = Icons.Default.KeyboardArrowDown,
//                        contentDescription = "Expand"
//                    )
//                }
//            },
//            collapseIndicator = {
//                IconButton(onClick = { expanded = false }) {
//                    Icon(
//                        imageVector = Icons.Default.KeyboardArrowUp,
//                        contentDescription = "Collapse"
//                    )
//                }
//            }
//        )
//    ) {
//        for (i in 1..60) {
//            AssistChip(
//                onClick = {},
//                label = { Text("Yeasin $i") }
//            )
//        }
//    }
//}

@OptIn(
    ExperimentalLayoutApi::class, ExperimentalFoundationApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun Greeting(modifier: Modifier = Modifier) {
//    -----------------Row/Column---------------------
//    Row(modifier = Modifier.fillMaxWidth().background(colorResource(id = R.color.purple_700)).height(200.dp)) {
//
//        Box(modifier= Modifier.size(100.dp).background(Color.Red).weight(1f))
//        Column(modifier = Modifier.weight(1f)) {
//            Box(modifier= Modifier.size(100.dp).background(Color.White))
//            Box(modifier= Modifier.size(100.dp).background(Color.Gray))
//        }
//        Box(modifier= Modifier.size(100.dp).background(Color.Green))
//    }

//    --------------------------Box -----------------------
//Box(modifier = Modifier,contentAlignment = Alignment.BottomCenter){
//
//    Image(painter = painterResource(R.drawable.ic_launcher_background),contentDescription = null)
//
//    Box(modifier = Modifier.matchParentSize().background(brush = Brush.verticalGradient(colors = listOf(
//        Color.Transparent,Color.Black
//    ))))
//
//    Text("Hellow World",modifier = Modifier.align(Alignment.TopStart))
//    Text("What's Up ?")
//    IconButton(onClick = {}
//        ,modifier = Modifier.align(Alignment.BottomEnd)
//    ) {
//        Icon(imageVector = Icons.Default.Star,contentDescription = null, tint = Color.Red)
//    }
//}

//--------------Lazi layout----------------------

    //    Column → Loads all items immediately (⚠️ bad for large lists)
//
//    LazyColumn → Loads only visible items (✅ best for long lists)


//    Column(modifier = Modifier.fillMaxSize()) {
    // Loop from 1 to 100 and show all items at once
//        for (i in 1..100){
//            Text("Item $i")
//        }
//
//    }
//LazyColumn and LazyRow as a same
//    🔹 LazyColumn
//    Displays a vertical scrollable list.
//    Only visible items are composed for better performance.
//
//    🔹 LazyRow
//    Displays a horizontal scrollable list.
//    Loads items lazily as they come into view.

//    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp), contentPadding = PaddingValues(16.dp) ) {
//        // Efficiently load and display only visible items
//        items(100){i->
//            Text("Item $i")// Display each item
//        }
//        stickyHeader {
//            Text("Sticky Header",modifier= Modifier.fillMaxWidth())
//        }
//        items(100){i->
//            Text("Item $i")// Display each item
//        }
//        item {
//            Box(modifier= Modifier.height(100.dp)){
//                Text(text = "Reached the end!",modifier = Modifier.fillMaxWidth().background(Color.Red))
//            }
//        }
//
//    }


//    🔹 GridCells.FixedSize(100.dp)
//    Each cell is exactly 100.dp wide.
//    The number of columns depends on screen width.
//
//    🔹 GridCells.Fixed(3)
//    Always shows 3 columns.
//    Cell width adjusts automatically to fit the screen.
//    LazyVerticalGrid/LazyVerticalStaggeredGrid
//    🔹 LazyVerticalGrid
//    Displays items in a regular vertical grid layout.
//    All cells are the same size (unless span is used).
//
//    🔹 LazyVerticalStaggeredGrid
//    Displays items in a staggered (masonry-style) vertical grid.
//    Cells can have different heights, creating a Pinterest-like layout.
//

//    LazyVerticalStaggeredGrid(
////        columns = GridCells.Adaptive(100.dp),
////        verticalArrangement = Arrangement.spacedBy(16.dp),
////        horizontalArrangement = Arrangement.spacedBy(16.dp)
//
//
//        columns = StaggeredGridCells.Fixed(5),
//        horizontalArrangement = Arrangement.spacedBy(16.dp),
//        verticalItemSpacing = 16.dp
//
//    ) {
//        items(100){
////            Box (modifier = Modifier.size(200.dp).background(Color((Random.nextInt()))))
//            Box (modifier = Modifier.height(height = Random.nextInt(1..200).dp).clip(
//                RoundedCornerShape(10.dp)).background(Color((Random.nextInt()))))
//        }
//    }


    //   --------------- Scaffold,TopAppBar,floatingActionButton,snackbarHost,bottomBar--------

//    Scaffold in Jetpack Compose is a layout structure that helps you easily set up common UI elements like:
//    *TopAppBar
//    *BottomBar
//    *FloatingActionButton
//    *Drawer
//    *Snackbar

//    val sanackBarState = remember {
//       SnackbarHostState()
//    }
//val scope = rememberCoroutineScope()
//
//Scaffold(
//    topBar = {
//        TopAppBar(
//            title = {
//                Text("sdfsdf")
//            },
//            navigationIcon = {
//                IconButton(onClick = {}) {
//                    Icon(
//                        imageVector = Icons.AutoMirrored.Default.ArrowBack,contentDescription = "Go Back"
//                    )
//                }
//            }
//        )
//    },
//    floatingActionButton = {
//        FloatingActionButton(
//            onClick = {
//                scope.launch {
//                    sanackBarState.showSnackbar(
//                        message = "Clicked Fab"
//                    )
//                }
//
//            }
//        ) {Icon(
//            imageVector = Icons.Default.Add,
//            contentDescription = null
//        ) }
//    },
//    snackbarHost = {
//        SnackbarHost (
//            sanackBarState
//        )
//    },
//    bottomBar = {
//        BottomAppBar {
//            NavigationBarItem(selected = true, onClick = {},
//                icon = {
//                 Icon(
//                     imageVector = Icons.Default.Star,
//                     contentDescription = null
//                 )
//                }, label = {Text("Favorites")}
//                )
//            NavigationBarItem(selected = false, onClick = {},
//                icon = {
//                    Icon(
//                        imageVector = Icons.Default.Search,
//                        contentDescription = null
//                    )
//                }, label = {Text("Search")}
//            )
//        }
//    }
//) { padding->
//Box(modifier = Modifier.fillMaxSize()
//    .padding(padding)
//    .background(Color.Red)){
//    Text("Hellow World")
//}
//}


//  --------------------  Hotel Booking UI pactice  -------------------

    val tags = listOf(
        "City Center",
        "Luxury",
        "Instant Book",
        "Exclusive deal",
        "Early Bird Discount",
        "Saraton",
        "City in",
    )
    val offers = mapOf(
        R.drawable.bedroom to "2 Bed",
        R.drawable.breakfast to "Breakfast",
        R.drawable.cutlery to "Cutlery",
        R.drawable.pet to "Pet Friendly",
        R.drawable.dinner to "Dinner",
        R.drawable.air_conditioning to "Air Conditioning",
        R.drawable.wifi to "Wifi",
    )
//
//    LazyColumn(
//        modifier = modifier
//            .fillMaxSize()
//            .background(Color.White),
//        verticalArrangement = Arrangement.spacedBy(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        item {
//            Box {
//                Image(painter = painterResource(R.drawable.image_data), contentDescription = null)
//
//                HotelFadeBanner(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .align(Alignment.BottomCenter)
//                )
//            }
//
//        }
//
//        item {
//            HorizontalDivider(
//                modifier = Modifier.padding(horizontal = 16.dp)
//            )
//        }
//        item {
//            FlowRow(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
//            ) {
//                tags.forEach { tag ->
//                    AssistChip(
//                        onClick = {},
//                        label = { Text(tag) }
//                    )
//                }
//                HorizontalDivider(
//                    modifier = Modifier.padding(horizontal = 16.dp)
//                )
//            }
//        }
//        item {
//            Text(text = "The adventisemewnt features a vibrant and invitiing design showcasing the hotel california strawberr nestled in the heart of los angeles . Surrounded by the iconic Hollywood Sign Griffith Park and stunniung beaches the hotel is perfect locatde for guest to explore la best".trimIndent(), fontSize = 16.sp,
//                textAlign = TextAlign.Justify,
//
//modifier = Modifier.fillMaxWidth()
//    .padding(horizontal = 16.dp)
//                )
//
//        }
//        item {
//            Text(text = "Waht we offer".trimIndent(), fontSize = 16.sp,
//                modifier = Modifier.fillMaxWidth()
//                    .padding(horizontal = 18.dp),
//                textAlign = TextAlign.Center,
//                fontWeight = FontWeight.Bold
//            )
//
//        }
//        item {
//            LazyRow(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
//            ) {
//                items(offers.entries.toList()){
//                    (drawbleResId,label)->
//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Center,
//                        modifier = Modifier .
//                        background(Color.Gray.copy(alpha = 0.3f))
//                            .padding(8.dp)
//                    ) {
//                        Icon(
//                            imageVector = ImageVector.vectorResource(drawbleResId),contentDescription = label,modifier= Modifier.size(45.dp)
//                        )
//                        Text(label, fontSize = 13.sp)
//
//                    }
//                }
//
//
//            }
//        }
//
//        item {
//            Button(onClick = {},modifier= Modifier.padding(horizontal = 16.dp).widthIn(min=300.dp,max = 400.dp).fillMaxWidth()) {
//                Text("Book Now ")
//            }
//        }
//
//    }


    HotelBookingScreen(modifier)

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeLearningTheme {
        Greeting()
    }
}