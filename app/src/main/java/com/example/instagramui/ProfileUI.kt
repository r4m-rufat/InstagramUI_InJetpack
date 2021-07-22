package com.example.instagramui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileUI() {

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(name = "r.nesirov__", modifier = Modifier.padding(vertical = 10.dp))
        Spacer(modifier = Modifier.height(5.dp))
        ProfileContainer()

    }

}

@Composable
fun TopAppBar(name: String, modifier: Modifier = Modifier) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {

        Row (verticalAlignment = Alignment.CenterVertically){
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back_button",
                tint = Color.Black,
                modifier = Modifier.padding(end = 15.dp).size(24.dp)
            )

            Text(
                text = name,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "notification",
                tint = Color.Black,
                modifier = Modifier.padding(end = 15.dp).size(24.dp)
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_more),
                contentDescription = "menu",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }

    }

}

@Composable
fun ProfileContainer(
    modifier: Modifier = Modifier
) {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }


    Column(modifier = modifier.fillMaxWidth()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.profile), contentDescription = "profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .aspectRatio(1f, matchHeightConstraintsFirst = true)
                    .weight(3f)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape),
            )

            Spacer(modifier = Modifier.width(10.dp))
            ProfileUnits(modifier = Modifier.weight(7f))


        }
        Spacer(modifier = Modifier.height(20.dp))

        ProfileDescription(
            profileName = "Rufat Nasirov",
            description = "Move on with your life! \nBEU 4/5 course Computer Engineering \nAndroid Developer",
            url = "https://play.google.com/store/apps/details?id=com.kivitool.openweatherchannel",
            followedBy = listOf("ulvi.nesirov99", "ilkin.aslanli"),
            otherCount = 20
        )

        Spacer(modifier = Modifier.height(20.dp))
        ButtonSection(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            tabImages = listOf(
                TabImages(painterResource(id = R.drawable.ic_grid), "Posts"),
                TabImages(painterResource(id = R.drawable.igtv), "IGTV")
            )
        ){
            selectedTabIndex = it
        }

        when(selectedTabIndex){
            0 -> {
                GridImages(imageList = listOf(
                    painterResource(id = R.drawable.profile),
                    painterResource(id = R.drawable.image_1),
                    painterResource(id = R.drawable.image_2),
                    painterResource(id = R.drawable.image_3),
                    painterResource(id = R.drawable.image_4),
                    painterResource(id = R.drawable.image_5),
                    painterResource(id = R.drawable.image_6)
                ), modifier = Modifier.fillMaxWidth())
            }
        }

    }

}

@Composable
fun ProfileUnits(
    modifier: Modifier = Modifier
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {

        ProfileStat(numberText = "21", text = "Posts")
        ProfileStat(numberText = "470", text = "Followers")
        ProfileStat(numberText = "358", text = "Following")

    }

}

@Composable
fun ProfileStat(
    modifier: Modifier = Modifier,
    numberText: String,
    text: String
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Text(text = numberText, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = text)

    }

}

@Composable
fun ProfileDescription(
    profileName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {

        Text(
            text = profileName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        Text(
            text = url,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
            color = Color.Blue,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )

        Text(text = buildAnnotatedString {

            val boldStyle = SpanStyle(
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            append("Followed by ")
            followedBy.forEachIndexed { index, name ->
                pushStyle(boldStyle)
                append(name)
                pop() // pop deletes pushStyle
                if (index < followedBy.size - 1) {
                    append(", ")
                }
            }

            if (otherCount > 2) {
                append(" and ")
                pushStyle(boldStyle)
                append("$otherCount others")
            }

        }, letterSpacing = letterSpacing, lineHeight = lineHeight)

    }

}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {

    val minWidth = 95.dp
    val height = 30.dp

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {

        ActionButton(
            text = "Following", icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )

        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )

        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .height(height)
        )

    }

}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5)
            )
            .padding(5.dp)
    ) {

        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }

        if (icon != null) {
            Icon(imageVector = icon, contentDescription = null, tint = Color.Black)
        }

    }

}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    tabImages: List<TabImages>,
    onTabSelected: (selectedListener: Int) -> Unit
) {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    val inActiveColor = Color.LightGray

    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        tabImages.forEachIndexed { index, item ->

            Tab(selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inActiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {

                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) {
                        Color.Black
                    } else {
                        Color.LightGray
                    }, modifier = modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }

        }

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridImages(
    imageList: List<Painter>,
    modifier: Modifier = Modifier
) {

    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier.scale(1.01f)
    ) {

        items(imageList.size) {
            Image(
                painter = imageList[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(1.dp, Color.White)
            )
        }

    }

}