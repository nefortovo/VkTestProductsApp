package com.example.vktestproductsapp.screens.product

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.vktestproductsapp.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductScreen(
    modifier: Modifier,
    onBack: () -> Unit,
    id: Int,
    viewModel: ProductViewModel  =  hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    val pagerState = rememberPagerState(pageCount = {
        uiState.productFullEntity?.images?.size ?: 1
    })

    LaunchedEffect(Unit){
        viewModel.getData(id)
    }

    Column(
        modifier = modifier
    ) {
        HorizontalPager(state = pagerState,
            contentPadding = PaddingValues(30.dp),
            pageSize = PageSize.Fill,
            pageSpacing = 30.dp,
        ) {
            uiState.productFullEntity?.images?.forEach { image ->
                AsyncImage(
                    modifier = Modifier
//                        .height(350.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop,
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(image)
                        .decoderFactory(SvgDecoder.Factory())
                        .build(),
                    contentDescription = null
                )
            }

        }
        Column(
            modifier = Modifier
                .padding(top = 10.dp)
                .padding(horizontal = 18.dp)
        ) {
            uiState.productFullEntity?.price?.let {
                Text(
                    text = stringResource(id = R.string.price, it.toString()),
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            uiState.productFullEntity?.title?.let {
                Text(
                    text = it,
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis
                )
            }

            uiState.productFullEntity?.description?.let {
                Text(
                    text = it,
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            uiState.productFullEntity?.brand?.let {
                Text(
                    text = it,
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            uiState.productFullEntity?.rating?.let {
                Text(
                    text = stringResource(id = R.string.rating, it.toString()) ,
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }

    }

}