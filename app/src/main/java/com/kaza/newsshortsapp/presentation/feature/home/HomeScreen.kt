package com.kaza.newsshortsapp.presentation.feature.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaza.newsshortsapp.R
import com.kaza.newsshortsapp.ui.theme.Dimens

@Composable
fun HomeScreen(navigate: (String) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = Dimens.MediumPadding1)
            .statusBarsPadding()
    ) {
        Image(painter = painterResource(id = R.drawable.ic_icon),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = Dimens.MediumPadding1))
        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

    }
}

@Preview
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenView() {
    HomeScreen(navigate = {

    })
}