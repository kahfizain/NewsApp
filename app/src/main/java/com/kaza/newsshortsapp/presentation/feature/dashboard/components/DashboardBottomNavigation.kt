package com.kaza.newsshortsapp.presentation.feature.dashboard.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaza.newsshortsapp.R
import com.kaza.newsshortsapp.presentation.feature.dashboard.data.BottomNavigationItem
import com.kaza.newsshortsapp.ui.theme.Dimens
import com.kaza.newsshortsapp.ui.theme.Dimens.ExtraSmallPadding2
import com.kaza.newsshortsapp.ui.theme.Dimens.IconSize
import com.kaza.newsshortsapp.ui.theme.NewsShortsAppTheme

@Composable
fun DashboardBottomNavigation(
    items: List<BottomNavigationItem>,
    selectedItem: Int,
    onItemClick: (Int) -> Unit
) {

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 10.dp
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selectedItem,
                onClick = { onItemClick(index) },
                icon = {
                    Column (
                        horizontalAlignment = CenterHorizontally
                    ){
                        Icon(painter = painterResource(id = item.icon) ,
                            contentDescription = null,
                            modifier = Modifier.size(IconSize))
                        Spacer(modifier = Modifier.height(ExtraSmallPadding2))
                        Text(text = item.text,
                            style = MaterialTheme.typography.labelSmall)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = colorResource(id = R.color.body),
                    unselectedTextColor = colorResource(id = R.color.body),
                    indicatorColor = MaterialTheme.colorScheme.background
                )
            )
        }
    }
}


@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun NewsBottomNavigationPreview() {
    NewsShortsAppTheme(dynamicColor = false) {
        DashboardBottomNavigation(items = listOf(
            BottomNavigationItem(icon = R.drawable.ic_home, text = "Home"),
            BottomNavigationItem(icon = R.drawable.ic_search, text = "Search"),
            BottomNavigationItem(icon = R.drawable.ic_bookmark, text = "Bookmark"),
        ), selectedItem = 0, onItemClick = {})
    }
}
