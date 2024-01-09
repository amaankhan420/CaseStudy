import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.foodzz.R


@Composable
fun Voucher(vouchersCount: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(top = 10.dp, bottom = 5.dp, start = 15.dp, end = 40.dp)
            .background(
                color = Color(0xFFF0CF91),
                shape = RoundedCornerShape(2.dp)
            ).border(1.dp, Color(0xFF8B4513), shape = RoundedCornerShape(2.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .align(Alignment.CenterStart),
        ) {
            Image(
                painter = painterResource(id = R.drawable.gift),
                contentDescription = "Your Image",
                modifier = Modifier
                    .size(24.dp, 24.dp)
                    .padding(end = 5.dp),
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(Color(0xFF8B4513))
            )
            Text(
                text = "You have $vouchersCount voucher here",
                modifier = Modifier.weight(1f),
                color = Color(0xFF8B4513)
            )
        }

        Image(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 5.dp),
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.tint(Color(0xFF8B4513))
        )
    }
}
