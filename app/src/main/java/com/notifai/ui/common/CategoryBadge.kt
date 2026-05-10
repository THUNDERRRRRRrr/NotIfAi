package com.notifai.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.notifai.data.model.Category
import com.notifai.ui.theme.DeliveryGreen
import com.notifai.ui.theme.ImportantPurple
import com.notifai.ui.theme.NotifAITheme
import com.notifai.ui.theme.OtpBlue
import com.notifai.ui.theme.PhishingDarkRed
import com.notifai.ui.theme.PromotionalOrange
import com.notifai.ui.theme.SpamRed
import com.notifai.ui.theme.UnknownGray

/** Returns the semantic color for a [Category]. */
fun Category.color(): Color = when (this) {
    Category.OTP         -> OtpBlue
    Category.DELIVERY    -> DeliveryGreen
    Category.SPAM        -> SpamRed
    Category.PHISHING    -> PhishingDarkRed
    Category.PROMOTIONAL -> PromotionalOrange
    Category.IMPORTANT   -> ImportantPurple
    Category.UNKNOWN     -> UnknownGray
}

/**
 * Small colored pill displaying a notification [category] label.
 */
@Composable
fun CategoryBadge(
    category: Category,
    modifier: Modifier = Modifier,
) {
    val color = category.color()
    Text(
        text = category.name,
        style = MaterialTheme.typography.labelSmall,
        color = Color.White,
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(color)
            .padding(horizontal = 8.dp, vertical = 3.dp),
    )
}

@Preview(showBackground = true)
@Composable
private fun CategoryBadgePreview() {
    NotifAITheme {
        CategoryBadge(category = Category.OTP)
    }
}
