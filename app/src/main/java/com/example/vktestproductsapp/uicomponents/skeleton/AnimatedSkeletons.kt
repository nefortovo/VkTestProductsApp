package com.example.vktestproductsapp.uicomponents.skeleton

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.example.vktestproductsapp.uicomponents.skeleton.SkeletonAnimations.animationDuration
import com.example.vktestproductsapp.uicomponents.skeleton.SkeletonAnimations.initialValue
import com.example.vktestproductsapp.uicomponents.skeleton.SkeletonAnimations.targetValue

/**
 * Стандартный элемент для отображения скелетонов
 * @param shape - для нестандартных форм скелетонов
 * @param skeletonStyle для отображения нужного цвета скелетона(GreyStyle, RedStyle)
 */
@Composable
fun AnimatedSkeletons(
    modifier: Modifier = Modifier,
    shape : Shape? = null,
) {
    val shimmerColors = listOf(
            Color(0xFF58595B),
            Color(0xFF8A8D8F),
            Color(0xFF58595B)
        )

    val transition = rememberInfiniteTransition(label = "")

    val translateAnim = transition.animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = animationDuration,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )


    if(shape != null){
        Spacer(
            modifier = modifier
                .background(
                    brush,
                    shape
                )
        )
    }else{
        Spacer(
            modifier = modifier
                .background(
                    brush
                )
        )
    }

}

object SkeletonAnimations {
    const val animationDuration = 1400

    const val initialValue = 0f
    const val targetValue = 1000f
}

@Composable
fun SkeletonWithContent(
    modifier: Modifier = Modifier,
    shape: Shape? = null,
    showSkeleton: Boolean,
    screenContent: @Composable () -> Unit
) {
    if (showSkeleton) {
        AnimatedSkeletons(
            modifier = modifier,
            shape = shape,
        )
    }else{
        screenContent()
    }

}

