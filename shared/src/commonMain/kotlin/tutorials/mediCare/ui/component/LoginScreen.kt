package tutorials.mediCare.ui.component

import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import tutorials.mediCare.ui.kOnBoardBackground
import tutorials.mediCare.viewModel.MediCareViewModel

@Composable
fun LoginScreen(viewModel: MediCareViewModel) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { LoginAppBar()},
    ) {
       Column(
           modifier = Modifier
               .padding(top = it.calculateTopPadding())
               .fillMaxSize(),
           horizontalAlignment = Alignment.CenterHorizontally
       ) {

           MediCareLogo()

           Spacer(modifier = Modifier.height(32.dp))

           /**
            * email box
            */
           EmailBox()
           Spacer(modifier = Modifier.fillMaxHeight(.06f))
           PasswordBox()

           Spacer(modifier = Modifier.fillMaxHeight(.2f))

           ElevatedButton(
               modifier = Modifier
                   .fillMaxWidth(.7f)
                   .height(50.dp),
               onClick = {
                         viewModel.toHomeScreen()
               },
               shape = RoundedCornerShape(12.dp),
               colors = ButtonDefaults.buttonColors(containerColor = kOnBoardBackground)
           ){
               Text("Log In")
           }
           Box(modifier = Modifier
               .padding(vertical = 32.dp)
               .fillMaxWidth()){
               Text("or continue with",
                   modifier = Modifier.align(Alignment.Center))
           }

           Spacer(Modifier.fillMaxHeight(.4f))
           /**
            * social login
            */
           SocialLoginButton(viewModel)

           Spacer(Modifier.fillMaxHeight(.2f))

           Row {
               Text("Already have an account",
                   modifier = Modifier)
               Text("sign in",
                   style = TextStyle(color = Color.Blue),
                   modifier = Modifier
                       .padding(start = 4.dp)
                       .clickable {
                       viewModel.toRegisterScreen()
                   }
               )
           }
       }
    }
}

@Composable
fun SocialLoginButton(viewModel: MediCareViewModel) {
   Row(
       modifier = Modifier
           .fillMaxWidth()
           .padding(horizontal = 16.dp),
       horizontalArrangement = Arrangement.Center
   ) {


       ElevatedButton(
           onClick = {
               viewModel.toHomeScreen()
           },
           shape = RoundedCornerShape(12.dp),
           modifier = Modifier
               .padding(end = 4.dp)
               .shadow(
                   elevation = 10.dp,
                   RoundedCornerShape(12.dp),
                   ambientColor = Color.White,
                   spotColor = Color.Gray
               ),
           colors = ButtonDefaults.buttonColors(containerColor = Color.White)
       ){
           Icon(Icons.Default.ShoppingCart,contentDescription = null, tint = Color.Black)
           Text("Google", style = MaterialTheme.typography.titleLarge.copy(color = Color.Black))
       }

       ElevatedButton(
           onClick = {
               viewModel.toHomeScreen()
           },
           shape = RoundedCornerShape(12.dp),
           modifier = Modifier
               .padding(start = 4.dp)
               .shadow(
                   elevation = 10.dp,
                   RoundedCornerShape(12.dp),
                   ambientColor = Color.White,
                   spotColor = Color.Gray
               ),
           colors = ButtonDefaults.buttonColors(containerColor = Color.White)
       ){
           Icon(Icons.Rounded.Add,contentDescription = null, tint = Color.Black)
           Text("Apple", style = MaterialTheme.typography.titleLarge.copy(color = Color.Black))
       }
   }
}

@Composable
fun PasswordBox() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text("Password")
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(12.dp),
                    spotColor = Color.Gray.copy(.23f),
                    ambientColor = Color.White
                ),
            colors = CardDefaults.cardColors(Color.White)
        ){
            Box(modifier = Modifier
                .padding(vertical = 12.dp)
                .fillMaxWidth()) {
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth(.86f)
                        .align(Alignment.CenterStart)
                        .padding(start = 8.dp),
                    value = "Password",
                    singleLine = true,
                    onValueChange = {})

                Card(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 8.dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(containerColor = Color.Blue.copy(alpha = .56f))
                ) {
                    Icon(
                        Icons.Rounded.Search,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }

        Text("Forgot Password",
            modifier = Modifier.align(Alignment.End),
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray))
    }
}

@Composable
fun EmailBox() {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        Text("Email")
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(12.dp),
                    spotColor = Color.Gray.copy(.23f),
                    ambientColor = Color.White
                ),
            colors = CardDefaults.cardColors(Color.White)
        ){
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                value = "txtSearch.value" ,
                singleLine = true,
                onValueChange = {})
        }
    }
}

@Composable
fun LoginAppBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp)
                .padding(vertical = 16.dp)
                .shadow(
                    elevation = 12.dp,
                    shape = RoundedCornerShape(8.dp),
                    ambientColor = Color.White,
                    spotColor = Color.Gray
                ),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
        ){
            Icon(Icons.Rounded.ArrowBack,contentDescription = null, tint = Color.Black,
                modifier = Modifier.padding(10.dp))
        }

        Text("Login",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.Center))
    }
}
