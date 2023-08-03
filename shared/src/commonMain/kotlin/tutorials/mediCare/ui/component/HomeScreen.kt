package tutorials.mediCare.ui.component

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import tutorials.mediCare.viewModel.MediCareViewModel

@Composable
fun HomeScreen(viewModel: MediCareViewModel) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .draggable(
                orientation = Orientation.Horizontal,
                enabled = true,
                state = rememberDraggableState{
                   if(it >= 20.0){
                       viewModel.toLoginScreen()
                   }
                }
            ),
        topBar = {HomeAppBar()}
    ) {

    }
}

@Composable
fun HomeAppBar() {
   Row(
       modifier = Modifier
           .fillMaxWidth()
           .padding(horizontal = 16.dp)
   ) {
       Card(
           modifier = Modifier
               .size(50.dp)
               .shadow(
                   elevation = 8.dp,
                   shape = CircleShape,
                   spotColor = Color.White,
                   ambientColor = Color.Gray
               ),
           shape = CircleShape,
           colors = CardDefaults.cardColors(containerColor = Color.White)
       ) {
           KamelImage(
               asyncPainterResource("https://easydrawingguides.com/wp-content/uploads/2022/08/male-face-from-the-side-profile-11.png"),
               contentDescription = null,
               onLoading = { CircularProgressIndicator() },
               modifier = Modifier
                   .size(50.dp)
                   .clip(CircleShape)
           )
       }
       Column(
           modifier = Modifier
               .padding(vertical = 6.dp)
               .padding(start = 8.dp),
           verticalArrangement = Arrangement.Center
       ) {
           Text("Naked Snake",
               style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, color = Color.Black))
           Text("How is your health",
               style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray))
       }

       Box(
           modifier = Modifier
               .fillMaxWidth()
       ){
           Row(
               modifier = Modifier
                   .align(Alignment.CenterEnd),
               verticalAlignment = Alignment.CenterVertically
           ) {
               Icon(Icons.Default.Search,contentDescription = null)
               Icon(Icons.Default.Notifications,contentDescription = null,
                   modifier = Modifier
                       .padding(start = 12.dp))
           }
       }
   }
}
