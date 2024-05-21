package com.example.b11109007_hw02

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val attractions = listOf(
                Attraction("花蓮遠雄海洋公園", "台灣第一座海洋主題公園，擁有豐富的海洋生物展示、精彩表演和遊樂設施。", R.drawable.farglory_ocean_park, "遠雄海洋公園"),
                Attraction("台北101", "曾是世界最高樓，現仍為台灣地標，擁有觀景台和購物中心。", R.drawable.taipei101, "台北101"),
                Attraction("九份老街", "充滿懷舊氛圍的山城老街，以茶館、小吃和迷人夜景聞名。", R.drawable.jiufen_old_street, "九份老街"),
                Attraction("國立故宮博物院", "收藏豐富的中華文物，是世界四大博物館之一。", R.drawable.national_palace_museum, "國立故宮博物院"),
                Attraction("淡水老街", "歷史悠久的老街，可欣賞夕陽、品嚐美食，並搭乘渡輪遊覽淡水河。", R.drawable.tamsui_old_street, "淡水老街"),
                Attraction("太魯閣國家公園", "以峽谷、斷崖和清澈溪流等壯麗景色聞名，是台灣著名的自然景點。", R.drawable.taroko_national_park, "太魯閣國家公園"),
                Attraction("高雄愛河", "貫穿高雄市區的愛河，河畔夜景浪漫，可搭乘愛之船遊覽。", R.drawable.love_river, "愛河"),
                Attraction("臺中彩虹眷村", "充滿繽紛色彩和可愛塗鴉的眷村，是熱門的拍照景點。", R.drawable.rainbow_village, "彩虹眷村"),
                Attraction("台南安平古堡", "台灣最古老的城堡，見證了荷蘭殖民時期的歷史。", R.drawable.anping_fort, "安平古堡"),
                Attraction("宜蘭太平山國家森林遊樂區", "擁有豐富的森林資源和多條登山步道，可欣賞雲海、日出和壯麗山景。", R.drawable.taiping_mountain, "太平山國家森林遊樂區")
            )

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "attractionList") {
                composable("attractionList") {
                    AttractionListScreen(attractions) { attraction ->
                        navController.navigate("attractionDetail/${attraction.name}")
                    }
                }
                composable("attractionDetail/{name}") { backStackEntry ->
                    val attractionName = backStackEntry.arguments?.getString("name")
                    val attraction = attractions.find { it.name == attractionName }
                    if (attraction != null) {
                        AttractionDetailScreen(attraction, navController)
                    }
                }
            }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        val attractions = listOf(
            Attraction("花蓮遠雄海洋公園", "台灣第一座海洋主題公園，擁有豐富的海洋生物展示、精彩表演和遊樂設施。", R.drawable.farglory_ocean_park, "遠雄海洋公園"),
            Attraction("台北101", "曾是世界最高樓，現仍為台灣地標，擁有觀景台和購物中心。", R.drawable.taipei101, "台北101"),
            Attraction("九份老街", "充滿懷舊氛圍的山城老街，以茶館、小吃和迷人夜景聞名。", R.drawable.jiufen_old_street, "九份老街"),
            Attraction("國立故宮博物院", "收藏豐富的中華文物，是世界四大博物館之一。", R.drawable.national_palace_museum, "國立故宮博物院"),
            Attraction("淡水老街", "歷史悠久的老街，可欣賞夕陽、品嚐美食，並搭乘渡輪遊覽淡水河。", R.drawable.tamsui_old_street, "淡水老街"),
            Attraction("太魯閣國家公園", "以峽谷、斷崖和清澈溪流等壯麗景色聞名，是台灣著名的自然景點。", R.drawable.taroko_national_park, "太魯閣國家公園"),
            Attraction("高雄愛河", "貫穿高雄市區的愛河，河畔夜景浪漫，可搭乘愛之船遊覽。", R.drawable.love_river, "愛河"),
            Attraction("臺中彩虹眷村", "充滿繽紛色彩和可愛塗鴉的眷村，是熱門的拍照景點。", R.drawable.rainbow_village, "彩虹眷村"),
            Attraction("台南安平古堡", "台灣最古老的城堡，見證了荷蘭殖民時期的歷史。", R.drawable.anping_fort, "安平古堡"),
            Attraction("宜蘭太平山國家森林遊樂區", "擁有豐富的森林資源和多條登山步道，可欣賞雲海、日出和壯麗山景。", R.drawable.taiping_mountain, "太平山國家森林遊樂區")
        )
        AttractionListScreen(attractions) { /* onClick handler */ }
    }

    @Composable
    fun AttractionListScreen(attractions: List<Attraction>, onClick: (Attraction) -> Unit) {
        LazyColumn {
            items(attractions) { attraction ->
                AttractionListItem(attraction, onClick)
            }
        }
    }

    @Composable
    fun AttractionListItem(attraction: Attraction, onClick: (Attraction) -> Unit) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable(onClick = { onClick(attraction) }),
        )
        {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = attraction.imageResourceId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = attraction.name,
                )
            }
        }
    }


    @SuppressLint("QueryPermissionsNeeded")
    @Composable
    fun AttractionDetailScreen(attraction: Attraction, navController: NavController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Button(
                onClick = { navController.navigateUp() },
                modifier = Modifier.align(Alignment.Start)
            ) {
                Text(text = "Back")
            }
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = attraction.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                style = androidx.compose.ui.text.TextStyle(fontSize = 24.sp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = attraction.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = attraction.description,
            )
            Spacer(modifier = Modifier.height(100.dp))
            val context = LocalContext.current
            Button(
                onClick = {
                    val gmmIntentUri = Uri.parse("geo:0,0?q=${attraction.location}")
                    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                    mapIntent.setPackage("com.google.android.apps.maps")
                    context.startActivity(mapIntent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
            ) {
                Text(text = "View on Google Maps")
            }
        }
    }

}
private fun showGoogleMapsUnavailableDialog(context: Context) {
    AlertDialog.Builder(context)
        .setTitle("Google Maps 不可用")
        .setMessage("您的設備上未安裝Google Maps應用，無法顯示地圖。請安裝Google Maps或使用其他地圖應用。")
        .setPositiveButton("確定") { dialog, _ ->
            dialog.dismiss()
        }
        .show()
}