package com.example.vktestproductsapp.uicomponents.listItems

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.base.entities.ProductFullEntity
import com.example.vktestproductsapp.R

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    product: ProductFullEntity,
) {
    Card(
        modifier = modifier
            .height(300.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            AsyncImage(
                modifier = Modifier
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.thumbnail)
                    .decoderFactory(SvgDecoder.Factory())
                    .build(),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(horizontal = 18.dp)
            ) {
                product.price?.let {
                    Text(
                        text = stringResource(id = R.string.price, it.toString()),
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        textAlign = TextAlign.Start,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

                product.title?.let {
                    Text(
                        text = it,
                        style = TextStyle(fontSize = 15.sp),
                        textAlign = TextAlign.Start,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                product.description?.let {
                    Text(
                        text = it,
                        style = TextStyle(fontSize = 10.sp),
                        textAlign = TextAlign.Start,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }

    }
}