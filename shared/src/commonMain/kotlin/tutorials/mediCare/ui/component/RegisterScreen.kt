package tutorials.mediCare.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import tutorials.mediCare.ui.kOnBoardBackground
import tutorials.mediCare.viewModel.MediCareViewModel

@Composable
fun RegisterScreen(viewModel: MediCareViewModel) {
    Scaffold(
        Modifier
            .fillMaxSize(),
        topBar = {RegisterAppBar(viewModel)}
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /**
             * text title
             */
            TitleTextBox(Modifier
                .fillMaxHeight(.08f))

            Spacer(modifier = Modifier.fillMaxHeight(.03f))

            /**
             * email box
             */
            FullNameBox()
            Spacer(modifier = Modifier.fillMaxHeight(.06f))
            EmailBox()
            Spacer(modifier = Modifier.fillMaxHeight(.06f))
            PasswordBox()

            /**
             * login button
             */
            Spacer(modifier = Modifier.fillMaxHeight(.2f))
            ElevatedButton(
                modifier = Modifier
                    .fillMaxWidth(.7f)
                    .height(50.dp),
                onClick = {},
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
fun FullNameBox() {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        Text("Full Name")
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
fun TitleTextBox(modifier: Modifier) {
   Box(modifier){
       Text("Create Account",
           modifier = Modifier
               .align(Alignment.Center),
           style = MaterialTheme.typography.titleLarge.copy(color = Color.Black, fontWeight = FontWeight.Bold)
       )
   }
}

@Composable
fun RegisterAppBar(viewModel: MediCareViewModel) {
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
                )
                .clickable {
                          viewModel.toLoginScreen()
                },
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
        ){
            Icon(
                Icons.Rounded.ArrowBack,contentDescription = null, tint = Color.Black,
                modifier = Modifier.padding(10.dp))
        }

        Text("Let Sign Up",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.Center))
    }
}
