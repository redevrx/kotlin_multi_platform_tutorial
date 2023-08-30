package tutorials.mediCare.ui.component

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import tutorials.mediCare.ui.kOnBoardBackground
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
        ){
            Spacer(Modifier.fillMaxHeight(.04f))
            TitleUpComingBox(modifier = Modifier)

            Spacer(Modifier.fillMaxHeight(.01f))
            PreviewCardBox()

            /**
             * categories title box
             */
            Spacer(Modifier.fillMaxHeight(.06f))
            CategoriesBox()
        }
    }
}

@Composable
fun CategoriesBox() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text("Categories",
            style = MaterialTheme.typography
                .titleMedium.copy(color = Color.Black, fontWeight = FontWeight.Bold))
        Text("See All",
            style = MaterialTheme.typography
                .bodySmall.copy(color = Color.Blue))
    }
}

@Composable
fun PreviewCardBox() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.4f)
            .padding(horizontal = 32.dp)
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(12.dp),
                ambientColor = Color.Blue,
                spotColor = MaterialTheme.colorScheme.kOnBoardBackground()
            ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.kOnBoardBackground())
    ){
   Box(Modifier.fillMaxSize()){
       Column(
           modifier = Modifier
               .fillMaxWidth(),
           verticalArrangement = Arrangement.Center
       ) {
           Spacer(Modifier.fillMaxHeight(.2f))
           Row(
               Modifier
                   .padding(horizontal = 16.dp),
               horizontalArrangement = Arrangement.Start
           ) {
               Text("Dr. Naked Snake",
                   style = MaterialTheme.typography.titleMedium
                       .copy(color = Color.White, fontWeight = FontWeight.Bold))
               Icon(Icons.Default.AccountBox,contentDescription = null,
                   modifier = Modifier.padding(start = 8.dp))
           }
           Text("Cadi",
               style = MaterialTheme.typography.titleSmall
                   .copy(color = Color.White, fontWeight = FontWeight.Bold),
               modifier = Modifier.padding(start = 16.dp)
           )

           Spacer(Modifier.fillMaxHeight(.5f))

           Card(
               modifier = Modifier
                   .padding(horizontal = 16.dp)
                   .shadow(
                       elevation = 16.dp,
                       shape = RoundedCornerShape(12.dp),
                       ambientColor = MaterialTheme.colorScheme.kOnBoardBackground(),
                       spotColor = Color.Blue
                   ),
               shape = RoundedCornerShape(12.dp),
               colors = CardDefaults.cardColors(containerColor = Color.Blue)
           ){
               Row(
                   Modifier.padding(12.dp)
               ) {
                   Icon(Icons.Default.ThumbUp,contentDescription = null)
                   Text("Feb 24, 09:00am")
               }
           }

           /**
            * align to end
            */
       }

       /**
        * image doctor
        */
       KamelImage(
           asyncPainterResource("https://www.pngall.com/wp-content/uploads/2018/05/Doctor-PNG-Clipart.png"),
           onLoading = { CircularProgressIndicator() },
           modifier = Modifier
               .align(Alignment.CenterEnd)
               .height(200.dp)
               .width(100.dp),
           contentDescription = null,
       )
   }
    }
}

@Composable
fun TitleUpComingBox(modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text("Upcoming",
            style = MaterialTheme.typography
                .titleMedium.copy(color = Color.Black, fontWeight = FontWeight.Bold))
        Text("See All",
            style = MaterialTheme.typography
                .bodySmall.copy(color = Color.Blue))
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
